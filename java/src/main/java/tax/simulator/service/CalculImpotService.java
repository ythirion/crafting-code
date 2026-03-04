package tax.simulator.service;

/**
 * Contrat métier pour le calcul des impôts annuels.
 * Respecte le principe DIP : le contrôleur dépend de cette interface,
 * pas de l'implémentation concrète {@link Simulateur}.
 */
public interface CalculImpotService {

    /**
     * Calcule les impôts annuels d'une personne.
     *
     * @param situationFamiliale     situation familiale ("Célibataire" ou "Marié/Pacsé")
     * @param salaireMensuel         salaire mensuel brut de la personne
     * @param salaireMensuelConjoint salaire mensuel brut du conjoint (ignoré si célibataire)
     * @param nombreEnfants          nombre d'enfants fiscalement à charge
     * @return montant total des impôts annuels en EUR
     */
    double calculerImpotsAnnuel(
            String situationFamiliale,
            double salaireMensuel,
            double salaireMensuelConjoint,
            int nombreEnfants
    );
}
