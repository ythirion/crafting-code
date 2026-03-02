# Barème
### Compréhension du besoin et respect de la User Story (10 pts)

| Critère                                                               | Points |
|-----------------------------------------------------------------------|--------|
| La nouvelle tranche (> 500 000 € à 48 %) est correctement implémentée | 3 pts  |
| Aucun impact sur les revenus < 500 000 €                              | 2 pts  |
| Respect strict des critères d’acceptation                             | 3 pts  |
| Bonne compréhension du quotient familial                              | 2 pts  |

**Pénalités possibles :**

* Mauvaise application du seuil
* Modification incorrecte des tranches existantes
* Non-respect du cas avec enfants

### Qualité des tests (25 pts)

| Critère                                          | Points |
|--------------------------------------------------|--------|
| Tests unitaires ajoutés pour la nouvelle tranche | 6 pts  |
| Tests couvrant les cas limites.                  | 4 pts  |
| Non-régression vérifiée 					                    | 10 pts |
| Lisibilité et pertinence des tests               | 5 pts  |

### Architecture & qualité du code (20 pts)

| Critère                                      | Points |
|----------------------------------------------|--------|
| Code clair, lisible, bien structuré          | 5 pts  |
| Pas de duplication inutile                   | 3 pts  |
| Tranches injectables (plutôt que hardcodées) | 5 pts  |
| Refactorings réalisés pertinents             | 7 pts  |

### Maintenabilité & évolutivité (10 pts)

| Critère                                            | Points |
|----------------------------------------------------|--------|
| Ajout d’une tranche possible facilement à l’avenir | 5 pts  |
| Données configurables facilement                   | 3 pts  |
| Code prêt à accueillir d’autres évolutions         | 2 pts  |

### Respect des bonnes pratiques API REST (10 pts)

| Critère                             | Points |
|-------------------------------------|--------|
| Aucun changement cassant dans l’API | 7 pts  |
| Documentation/API contrat claire    | 3 pts  |

### Démarche et professionnalisme (20 pts)

| Critère                                            | Points |
|----------------------------------------------------|--------|
| Commits clairs et atomiques (Conventional Commits) | 6 pts  |
| Messages de commit explicites                      | 4 pts  |
| Explication des choix techniques (README)          | 6 pts  |
| Code proprement formaté                            | 4 pts  |

Pour l'explication de vos choix techniques, vous pouvez par exemple, utiliser le format [ADR](https://xtrem-tdd.netlify.app/Flavours/Architecture/adr).

### Amélioration continue (5 pts)
La partie `Reflect` est disponible et les éléments renseignés sont tangibles.
A minima, une action cohérente a été identifiée.

* Qu’est-ce qui a bien fonctionné ?
* Qu’est-ce qu’on a appris ensemble ?
* Comment on pourrait être encore plus efficient la prochaine fois ?
* Quoi d'autre ?

### Exemples de bonus (jusqu’à +10 pts)

* Mise en place d’un Design Pattern utile (Strategy, Factory, etc.)
* Documentation technique claire
* Mise en place d’un `pipeline d’intégration continue` (CI) fournissant un feedback automatique et continu (tests, qualité, build, etc.) : **+5 pts**

### Barème synthétique

| Domaine                                             | Points                  |
|-----------------------------------------------------|-------------------------|
| Compréhension du besoin et respect de la User Story | 10                      |
| Tests                                               | 25                      |
| Architecture & qualité                              | 20                      |
| Maintenabilité                                      | 10                      |
| API REST                                            | 10                      |
| Démarche pro                                        | 20                      |
| Amélioration continue                               | 5                       |
| **Total**                                           | **100 pts (+10 bonus)** |
