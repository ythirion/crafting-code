package tax.simulator.api.error;

import java.time.LocalDateTime;

/**
 * Interface du monteur (Builder) pour construire un {@link ApiError}.
 * Définit toutes les étapes possibles de la construction.
 */
public interface ApiErrorBuilder {

    /**
     * Remet à zéro le monteur pour construire un nouveau produit.
     */
    void reset();

    /**
     * Définit la date et l'heure de l'erreur.
     *
     * @param timestamp date et heure
     */
    void setTimestamp(LocalDateTime timestamp);

    /**
     * Définit le code HTTP de l'erreur.
     *
     * @param status code HTTP
     */
    void setStatus(int status);

    /**
     * Définit le libellé du statut HTTP.
     *
     * @param error libellé
     */
    void setError(String error);

    /**
     * Définit le message d'erreur détaillé.
     *
     * @param message message
     */
    void setMessage(String message);

    /**
     * Retourne le produit construit et remet à zéro le monteur.
     *
     * @return l'objet {@link ApiError} construit
     */
    ApiError build();
}
