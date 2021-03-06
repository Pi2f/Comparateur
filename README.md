Franc/Gibassier

# Comparateur de bières

Ce comparateur a pour but de ravir les amateurs de bières.

**Buts** :
Comparer les bières entre elles selon :

Grands concepts :
* Bière
* Total point / Structure de données sous forme d'arbre
* Recherche
* Classement

Admin : Ajouter Modifier Supprimer Consulter BDD
Utilisateur :

# Spécifications

  - Choix des technos
    - Java multiplateforme (Connaissance + consigne du professeur)
    - MariaDB
    - Swing
  - Détermination des critères.
    - Style
    - Couleur
    - Marque
    - Degré d'alcool
    - 
    - Avis des consommateurs
  - Détermination de l'affichage.
    - Une barre latérale à gauche pour la sélection des critèbières
    - Un panneau à droite pour l'affichage des bières
  - Détermination de l'approximation du résultat de la recherche (niveau de complexité)
    - Priorité sous forme d'arbre (- prioritaire vers le +)

  ```
    
    └─── Avis
    └─────── Marque
    └────────────── Couleur
    └────────────────────── Degré
    └──────────────────────────── Style

   ```


  Inconvénient scoring : Sur de petits volumes de données ca va sinon c'est la cata.

# Backlogs

### Fonctionnalités attendues

###### Administrateur
  - Ajouter une bière
  - Supprimer une bière
  - Modifier une bière
  - Lancer une recherche
  - Noter une bière

###### Utilisateur
  - Lancer une recherche
  - Noter une bière
  - Réserver une bière

### Contraintes

###### Sécurité
  - Distinguer un admin d'un user

###### Performance
  - Temps de la recherche en ms
  - Résultat proche de la recherche

# Cahier de conception
  - diagramme état
  - diagramme de classe
  - classes et leurs intéractions


**Travailler sur les données, le traitement en sera faciliter.**

** Critères trop strictes **

Comparateurs :
-  (+-25cts)
- Couleur à voir comment implémenter le comparateur
- Marque
- Degré + ou - légères (mettre des seuils + ou - 1)
- Pays (regrouper par région, BENELUX, îles brittaniques, Pays de l'Est)
- Style à définir les styles qui se ressemble le +
- goût douce, amère, acide, liquoreuse, saugrenues
- bière de saison
- Trappiste
- d'abbaye
- Fermière, artisanale, industrielle, traditionnelles
- Régions
- Type de fermentation (basse, haute, spontanée, mixte)

But additionner, fusionner les comparateurs

Sélection en singleton ? Sûrement

Utiliser la réflexivité pour le tri.
