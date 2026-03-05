package tax.simulator.service.strategy;

/**
 * Stratégie de calcul pour une personne célibataire.
 * <ul>
 *     <li>Revenu annuel = salaire × 12</li>
 *     <li>Quotient de base = 1</li>
 *     <li>Le salaire du conjoint est ignoré</li>
 * </ul>
 */
public class CelibataireStrategy implements ICalculFamilialStrategy {

    private static final int NOMBRE_MOIS = 12;

    @Override
    public void validerSalaires(double salaireMensuel, double salaireMensuelConjoint) {
        if (salaireMensuel <= 0) {
            throw new IllegalArgumentException("Les salaires doivent être positifs.");
        }
    }

    @Override
    public double calculerRevenuAnnuel(double salaireMensuel, double salaireMensuelConjoint) {
        return salaireMensuel * NOMBRE_MOIS;
    }

    @Override
    public int getBaseQuotient() {
        return 1;
    }
}
