# Barème
### Compréhension du besoin & respect de la User Story (15 pts)

| Critère                                                               | Points |
| --------------------------------------------------------------------- | ------ |
| La nouvelle tranche (> 500 000 € à 48 %) est correctement implémentée | 5 pts  |
| Aucun impact sur les revenus < 500 000 €                              | 4 pts  |
| Respect strict des critères d’acceptation                             | 3 pts  |
| Bonne compréhension du quotient familial                              | 3 pts  |

**Pénalités possibles :**

* Mauvaise application du seuil
* Modification incorrecte des tranches existantes
* Non-respect du cas avec enfants

### Exactitude des calculs (20 pts)

| Critère                                             | Points |
| --------------------------------------------------- | ------ |
| Cas 1 validé (revenus < seuil)                      | 5 pts  |
| Cas 2 validé (540 000 €, 48 % sur 40 000 €)         | 7 pts  |
| Cas 3 validé (quotient familial + nouvelle tranche) | 8 pts  |

Toute erreur de calcul entraîne une perte proportionnelle des points.

### Qualité des tests (20 pts)

| Critère                                               | Points |
| ----------------------------------------------------- | ------ |
| Tests unitaires ajoutés pour la nouvelle tranche      | 6 pts  |
| Tests couvrant les cas limites.                       | 4 pts  |
| Non-régression vérifiée 					                | 5 pts  |
| Lisibilité et pertinence des tests                    | 5 pts  |

### Architecture & qualité du code (20 pts)

| Critère                                                      | Points |
| ------------------------------------------------------------ | ------ |
| Code clair, lisible, bien structuré                          | 5 pts  |
| Pas de duplication inutile                                   | 3 pts  |
| Respect des principes SOLID                                  | 5 pts  |
| Tranches centralisées (config/données plutôt que hardcodées) | 5 pts  |
| Refactoring pertinent si nécessaire                          | 2 pts  |

### Maintenabilité & évolutivité (10 pts)

| Critère                                                         | Points |
| --------------------------------------------------------------- | ------ |
| Ajout d’une tranche possible facilement à l’avenir              | 5 pts  |
| Données configurables (ex : tableau, fichier, structure dédiée) | 3 pts  |
| Code prêt à accueillir d’autres évolutions                      | 2 pts  |

### Respect des bonnes pratiques API REST (5 pts)

| Critère                             | Points |
| ----------------------------------- | ------ |
| Aucun changement cassant dans l’API | 3 pts  |
| Documentation/API contract claire   | 2 pts  |

### Démarche & professionnalisme (10 pts)

| Critère                          | Points |
| -------------------------------- | ------ |
| Commits clairs et atomiques (Conventional Commits)      | 3 pts  |
| Messages de commit explicites    | 2 pts  |
| Explication des choix techniques | 3 pts  |
| Code proprement formaté          | 2 pts  |

### Exemples de bonus (jusqu’à +5 pts)

* Mise en place d’un Design Pattern utile (Strategy, Factory, etc.)
* Documentation technique claire

### Barème synthétique

| Domaine                    | Points                 |
| -------------------------- | ---------------------- |
| Compréhension & respect US | 15                     |
| Exactitude des calculs     | 20                     |
| Tests                      | 20                     |
| Architecture & qualité     | 20                     |
| Maintenabilité             | 10                     |
| API REST                   | 5                      |
| Démarche pro               | 10                     |
| **Total**                  | **100 pts (+5 bonus)** |