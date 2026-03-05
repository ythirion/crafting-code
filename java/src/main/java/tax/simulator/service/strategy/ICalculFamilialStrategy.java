package tax.simulator.service.strategy;

/**
 * Stratégie de calcul familial.
 * Encapsule les règles qui varient selon la situation familiale :
 * revenu annuel, quotient de base, et validation des salaires.
 */
public interface ICalculFamilialStrategy {

    /**
     * Valide les salaires selon la situation familiale.
     *
     * @param salaireMensuel         salaire mensuel de la personne
     * @param salaireMensuelConjoint salaire mensuel du conjoint
     */
    void validerSalaires(double salaireMensuel, double salaireMensuelConjoint);

    /**
     * Calcule le revenu annuel du foyer.
     *
     * @param salaireMensuel         salaire mensuel de la personne
     * @param salaireMensuelConjoint salaire mensuel du conjoint
     * @return revenu annuel total
     */
    double calculerRevenuAnnuel(double salaireMensuel, double salaireMensuelConjoint);

    /**
     * Retourne le quotient de base (avant ajout des parts enfants).
     *
     * @return quotient de base (1 pour célibataire, 2 pour marié/pacsé)
     */
    int getBaseQuotient();
}
