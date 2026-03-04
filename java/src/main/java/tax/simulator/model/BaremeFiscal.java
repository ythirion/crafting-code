package tax.simulator.model;

/**
 * Représente un barème fiscal avec ses tranches et ses taux d'imposition.
 * Immuable par conception (record).
 *
 * @param tranches seuils de chaque tranche en EUR
 * @param taux     taux associé à chaque tranche (taux[0] s'applique sous tranches[0], etc.)
 */
public record BaremeFiscal(double[] tranches, double[] taux) {
}
