package tax.simulator.service;

import org.springframework.stereotype.Service;

import tax.simulator.model.SituationFamiliale;
import tax.simulator.model.BaremeFiscal;

/**
 * Implémentation du service de calcul des impôts annuels.
 * Applique le barème progressif par tranche et le mécanisme du quotient familial.
 * <p>
 * La couche métier ne connaît pas la source des données fiscales : elle délègue
 * leur récupération au {@link BaremeRepository} (principe DIP).
 */
@Service
public class Simulateur implements CalculImpotService {

    private static final int NOMBRE_MOIS = 12;

    private final BaremeRepository baremeRepository;

    public Simulateur(BaremeRepository baremeRepository) {
        this.baremeRepository = baremeRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculerImpotsAnnuel(String situationFamilialeString, double salaireMensuel, double salaireMensuelConjoint, int nombreEnfants) {
        SituationFamiliale situationFamiliale = parseSituationFamiliale(situationFamilialeString);

        validerParametres(situationFamiliale, salaireMensuel, salaireMensuelConjoint, nombreEnfants);

        boolean isMariePacse = situationFamiliale == SituationFamiliale.MARIE_PACSE;

        double revenuAnnuel = isMariePacse
                ? (salaireMensuel + salaireMensuelConjoint) * NOMBRE_MOIS
                : salaireMensuel * NOMBRE_MOIS;

        double partsFiscales = calculerPartsFiscales(isMariePacse, nombreEnfants);
        double revenuImposableParPart = revenuAnnuel / partsFiscales;

        double impot = calculerImpotParPart(revenuImposableParPart);

        return Math.round(impot * partsFiscales * 100.0) / 100.0;
    }

    // --- Méthodes privées (SRP : chaque méthode a une seule responsabilité) ---

    private SituationFamiliale parseSituationFamiliale(String valeur) {
        return switch (valeur) {
            case "Célibataire" -> SituationFamiliale.CELIBATAIRE;
            case "Marié/Pacsé" -> SituationFamiliale.MARIE_PACSE;
            default -> throw new IllegalArgumentException("Situation familiale invalide.");
        };
    }

    private void validerParametres(SituationFamiliale situation, double salaireMensuel, double salaireMensuelConjoint, int nombreEnfants) {
        if (salaireMensuel <= 0) {
            throw new IllegalArgumentException("Les salaires doivent être positifs.");
        }
        if (situation == SituationFamiliale.MARIE_PACSE && salaireMensuelConjoint < 0) {
            throw new IllegalArgumentException("Les salaires doivent être positifs.");
        }
        if (nombreEnfants < 0) {
            throw new IllegalArgumentException("Le nombre d'enfants ne peut pas être négatif.");
        }
    }

    private double calculerPartsFiscales(boolean isMariePacse, int nombreEnfants) {
        int baseQuotient = isMariePacse ? 2 : 1;
        double quotientEnfants = nombreEnfants * 0.5;
        return baseQuotient + quotientEnfants;
    }

    private double calculerImpotParPart(double revenuImposableParPart) {
        BaremeFiscal bareme = baremeRepository.getBareme();
        double[] tranches = bareme.tranches();
        double[] taux = bareme.taux();

        double impot = 0;
        for (int i = 0; i < tranches.length; i++) {
            double montantTranche = Math.min(revenuImposableParPart, tranches[i]) - (i > 0 ? tranches[i - 1] : 0);
            if (montantTranche > 0) {
                impot += montantTranche * taux[i];
            }
        }

        if (revenuImposableParPart > tranches[tranches.length - 1]) {
            impot += (revenuImposableParPart - tranches[tranches.length - 1]) * taux[taux.length - 1];
        }

        return impot;
    }
}

