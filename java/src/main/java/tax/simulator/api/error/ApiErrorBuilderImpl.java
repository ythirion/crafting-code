package tax.simulator.api.error;

import java.time.LocalDateTime;

/**
 * Monteur concret pour construire un {@link ApiError} étape par étape.
 * Implémente l'interface {@link ApiErrorBuilder}.
 * <p>
 * Après chaque appel à {@link #build()}, le monteur est remis à zéro
 * et prêt à construire un nouvel objet.
 */
public class ApiErrorBuilderImpl implements ApiErrorBuilder {

    private ApiError apiError;

    public ApiErrorBuilderImpl() {
        this.reset();
    }

    @Override
    public void reset() {
        this.apiError = new ApiError();
    }

    @Override
    public void setTimestamp(LocalDateTime timestamp) {
        this.apiError.setTimestamp(timestamp);
    }

    @Override
    public void setStatus(int status) {
        this.apiError.setStatus(status);
    }

    @Override
    public void setError(String error) {
        this.apiError.setError(error);
    }

    @Override
    public void setMessage(String message) {
        this.apiError.setMessage(message);
    }

    @Override
    public ApiError build() {
        ApiError product = this.apiError;
        this.reset();
        return product;
    }
}
