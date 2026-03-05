package tax.simulator.service;

import tax.simulator.model.BaremeFiscal;

/**
 * Contrat d'accès aux données du barème fiscal.
 * Respecte le principe DIP : les couches métier dépendent de cette abstraction,
 * pas d'une implémentation concrète.
 */
public interface IBaremeRepository {

    /**
     * Retourne le barème fiscal en vigueur.
     *
     * @return barème fiscal courant
     */
    BaremeFiscal getBareme();
}
