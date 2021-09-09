# TP - Bulletin Simple

<p align="center">
  <img width="460" height="300" src="https://media.istockphoto.com/photos/man-using-calculator-accounting-calculating-cost-economic-bills-with-picture-id1163111044?k=20&m=1163111044&s=612x612&w=0&h=136jhKHWy9FMMWFvv0HAEamfudzQFLXwG8A8ME2gk0M=">
</p>
<p align="center" ><em>image source : Pixabay</em></p>

<p align="center">
  <a href="https://java.com/"><img height="30" src="https://img.shields.io/badge/Java-lightgrey?style=flat&logo=java&logoColor=white&labelColor=red&link=http://left&link=http://right"></a>
</p>

## Énoncé

Rédiger le programme qui permet de calculer et d’afficher le bulletin de salaire simplifié d’un employé.

Les nom, prénom et statut (cadre, agent de maîtrise, employé de bureau) sont des informations obligatoirement mentionnées sur le bulletin de salaire d’un employé. 

L’utilisateur doit saisir le nom, le prénom, le statut ainsi que le nombre d’heures effectuées par un employé.

### Calcul du salaire de base :
Le salaire de base dépend du nombre d’heures travaillées en tenant compte des critères suivants :
- de 0 à 169 heures : le salaire mensuel est égal au nombre d’heures travaillées multiplié par le taux horaire

- de 169 à 180 heures : le taux horaire est majoré de 50 %

- au-delà de 180 heures : le taux horaire est majoré de 60 %

### Calcul des cotisations :
![alt text](https://github.com/christanvt/BulletinSimple/blob/98429a2c5c3acf372cd59b80606fc7de915113d2/images/Cotisations.png?raw=true)

### Calcul du salaire à verser :
La prime est calculée en fonction du nombre d’enfants selon les règles suivantes : - 0 enfant : pas de prime
- 1 enfant : 20€ de prime
- 2 enfants: 50€ de prime
- Plus de 2 enfants : 70€ + 20€ par enfants au-dessus de 2

Le calcul du montant net à payer s’effectue suivant la règle suivante :

Net à payer = Salaire de base – Total des cotisations salariales + Prime

## Clone packages :

    git clone https://github.com/christanvt/BulletinSimple.git

