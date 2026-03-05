package tax.simulator.service.strategy;

/**
 * Stratégie de calcul pour une personne mariée ou pacsée.
 * <ul>
 *     <li>Revenu annuel = (salaire + salaire conjoint) × 12</li>
 *     <li>Quotient de base = 2</li>
 *     <li>Le salaire du conjoint doit être positif ou nul</li>
 * </ul>
 */
public class MariePacseStrategy implements ICalculFamilialStrategy {

    private static final int NOMBRE_MOIS = 12;

    @Override
    public void validerSalaires(double salaireMensuel, double salaireMensuelConjoint) {
        if (salaireMensuel <= 0) {
            throw new IllegalArgumentException("Les salaires doivent être positifs.");
        }
        if (salaireMensuelConjoint < 0) {
            throw new IllegalArgumentException("Les salaires doivent être positifs.");
        }
    }

    @Override
    public double calculerRevenuAnnuel(double salaireMensuel, double salaireMensuelConjoint) {
        return (salaireMensuel + salaireMensuelConjoint) * NOMBRE_MOIS;
    }

    @Override
    public int getBaseQuotient() {
        return 2;
    }
}
