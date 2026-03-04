package tax.simulator.repository;

import org.springframework.stereotype.Repository;
import tax.simulator.model.BaremeFiscal;
import tax.simulator.service.BaremeRepository;

/**
 * Implémentation du dépôt de barème fiscal.
 * Source unique des données fiscales : les tranches et les taux sont définis ici
 * et nulle part ailleurs dans l'application.
 */
@Repository
public class BaremeRepositoryImpl implements BaremeRepository {

    private static final double[] TRANCHES_IMPOSITION = {10225, 26070, 74545, 160336, 500000};
    private static final double[] TAUX_IMPOSITION = {0.0, 0.11, 0.30, 0.41, 0.45, 0.48};

    @Override
    public BaremeFiscal getBareme() {
        return new BaremeFiscal(TRANCHES_IMPOSITION, TAUX_IMPOSITION);
    }
}
