# Order Management
## Contexte

Le système **Danub** est aujourd’hui fortement utilisé au quotidien.
Il supporte une part importante de notre activité et constitue un élément central du fonctionnement global.

Au fil des évolutions successives, le code de Danub est devenu difficile à faire évoluer.
Chaque nouvelle fonctionnalité, modification métier ou correction de bug demande un effort conséquent et augmente le risque de régression sur un système déjà très sollicité.

Plusieurs signes montrent que la maintenabilité s’est dégradée :

* Complexité croissante
* Duplication de logique
* Responsabilités mal réparties
* Couplage important entre composants
* Difficulté à comprendre rapidement certaines parties du code

Dans un contexte où Danub est critique et intensément utilisé, il devient indispensable d’améliorer la qualité du code afin de sécuriser les futures évolutions.

---

## Étape 1 – Phase d’analyse (15 minutes)
Avant toute modification, commencer par une phase d’analyse rapide :

* Prendre **15 minutes** pour parcourir le code.
* Identifier un maximum de **code smells**, tels que :
    * Méthodes trop longues
    * Classes trop volumineuses
    * Duplication de code
    * Couplage excessif
    * ...

L’objectif de cette étape est de :

* Prendre du recul
* Mettre en lumière les principaux points de friction
* Identifier une zone pertinente pour démarrer un refactoring

---

## Étape 2 – Refactoring en Mob Programming

En **mob programming** (toute l’équipe travaillant ensemble sur le même code), sélectionner **un Use Case** et le refactorer afin de le rendre :

* Plus lisible
* Plus modulaire
* Plus testable
* Moins couplé
* Plus robuste
* Plus simple à faire évoluer

L’objectif n’est pas de refondre tout Danub, mais de démontrer concrètement, à travers un cas réel, comment améliorer la qualité du code tout en sécurisant un système fortement utilisé.

## Ressources
- [Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)
- [Feature Envy](https://wiki.c2.com/?FeatureEnvySmell)
- [Clean Architecture](https://xtrem-tdd.netlify.app/Flavours/Architecture/clean-architecture)

"Correction" disponible [ici](https://github.com/les-tontons-crafters/refactoring-by-example). 