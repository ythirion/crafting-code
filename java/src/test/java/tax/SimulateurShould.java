package tax;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tax.simulator.repository.IBaremeRepositoryImpl;
import tax.simulator.service.Simulateur;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Classe de tests unitaires de l'API de calcul des impôts
 */
public class SimulateurShould {
    private final Simulateur simulateur = new Simulateur(new IBaremeRepositoryImpl());

    /**
     * Teste que la tranche d'imposition à 48% n'est pas appliquée pour les revenus inférieurs
     * au seuil de 500 000 EUR, et que le calcul des impôts est correct dans ce cas.
     */
    @Test
    void revenus_inferieurs_au_seuil() {
        String situationFamiliale = "Célibataire";
        double salaireMensuel = 20000;
        double salaireMensuelConjoint = 0;
        int nombreEnfants = 0;

        double impot = simulateur.calculerImpotsAnnuel(situationFamiliale, salaireMensuel, salaireMensuelConjoint, nombreEnfants);

        // Calcul manuel pour 240 000 sans la tranche de 48% (qui commence à 500 000)
        // Le code existant utilise déjà le taux de 45% jusqu'à 500 000.
        // Résultat attendu : 87 308.56
        assertThat(impot).isEqualTo(87308.56);
    }

    /**
     * Teste que la tranche d'imposition à 48% est correctement appliquée pour les revenus supérieurs
     * au seuil de 500 000 EUR, et que le calcul des impôts est correct dans ce cas.
     */
    @Test
    void revenus_superieurs_au_seuil() {
        String situationFamiliale = "Célibataire";
        double salaireMensuel = 45000; // 540 000 annuels
        double salaireMensuelConjoint = 0;
        int nombreEnfants = 0;

        double impot = simulateur.calculerImpotsAnnuel(situationFamiliale, salaireMensuel, salaireMensuelConjoint, nombreEnfants);

        // Résultat attendu : 223 508.56 EUR
        assertThat(impot).isEqualTo(223508.56);
    }

    /**
     * Teste que le quotient familial est correctement appliqué pour une situation familiale avec enfants,
     * et que le calcul des impôts est correct dans ce cas.
     */
    @Test
    void quotient_familial_avec_enfants() {
        String situationFamiliale = "Marié/Pacsé";
        double salaireMensuel = 30000;
        double salaireMensuelConjoint = 25000;
        int nombreEnfants = 2;

        // Revenu total : (30000 + 25000) * 12 = 660 000
        // Parts : 2 (marié) + 1 (2 enfants) = 3
        // Revenu par part : 220 000
        double impot = simulateur.calculerImpotsAnnuel(situationFamiliale, salaireMensuel, salaireMensuelConjoint, nombreEnfants);

        // Résultat attendu : 234 925.68 EUR
        assertThat(impot).isEqualTo(234925.68);
    }

    /**
     * Teste que les entrées invalides (situation familiale non reconnue, salaires négatifs, nombre d'enfants négatif)
     * sont rejetées avec des exceptions appropriées.
     */
    @Nested
    class Validation {

        /**
         * Teste que les situations familiales non reconnues (ex : "Divorcé") sont rejetées
         * avec une exception indiquant que la situation familiale est invalide.
         */
        @Test
        void rejeter_situation_familiale_invalide() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Divorcé", 3000, 0, 0)
            ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Situation familiale invalide");
        }

        /**
         * Teste que les situations familiales nulles sont rejetées
         * avec une exception indiquant que la situation familiale est invalide.
         */
        @Test
        void rejeter_situation_familiale_null() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel(null, 3000, 0, 0)
            ).isInstanceOf(Exception.class);
        }

        /**
         * Teste que les salaires négatifs ou nuls sont rejetés
         * avec une exception indiquant que le salaire doit être positif.
         */
        @Test
        void rejeter_salaire_negatif_celibataire() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Célibataire", -1000, 0, 0)
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("positif");
        }

        /**
         * Teste que les salaires nuls sont rejetés pour les célibataires
         * avec une exception indiquant que le salaire doit être positif.
         */
        @Test
        void rejeter_salaire_zero_celibataire() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Célibataire", 0, 0, 0)
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("positif");
        }

        /**
         * Teste que les salaires négatifs ou nuls sont rejetés pour les mariés/pacsés
         * avec une exception indiquant que le salaire doit être positif.
         */
        @Test
        void rejeter_salaire_negatif_marie() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Marié/Pacsé", -500, 3000, 0)
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("positif");
        }

        /**
         * Test que les salaires négatifs ou nuls du conjoint sont rejetés pour les mariés/pacsés
         * avec une exception indiquant que le salaire doit être positif.
         */
        @Test
        void rejeter_salaire_conjoint_negatif_marie() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Marié/Pacsé", 3000, -500, 0)
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("positif");
        }

        /**
         * Teste que les nombres d'enfants négatifs sont rejetés
         * avec une exception indiquant que le nombre d'enfants ne peut pas être négatif
         */
        @Test
        void rejeter_nombre_enfants_negatif() {
            assertThatThrownBy(() ->
                    simulateur.calculerImpotsAnnuel("Célibataire", 3000, 0, -1)
            ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("négatif");
        }
    }

}
