package fr.eni.tp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Tp {
// Rédiger le programme qui permet de calculer et d'afficher le bulletin de salaire d'un employé
	
	
	public static void main(String[] args) {
		
		// TAUX en %:
		//Taux Majoré en % (de 169 à 180 heures):
		int increasedRate = 50;
		
		//Taux Majoré Plus en % (Audela de 180 heures):
		int increasedRatePlus = 60;
		
		
		// Cotisations en %:
		// Contribution pour le Remboursement de la Dette Sociale et Contribution Sociale Généralisée Imposable:
		float detteSociale = 3.49f;
		
		// Contribution Sociale Généralisée non imposable:
		float contribSociale = 6.15f;
		
		// Assurance maladie:
		float assuranceMaladie = 0.95f;
		
		// Assurance vieillesse :
		float assuranceVieillesse = 8.44f;
		
		// Assurance chômage :
		float assuranceChomage = 3.05f;
				
		// Retraite complémentaire:
		float retraiteComp = 3.81f;
		
		// Cotisation AGFF:
		float cotisAgff = 1.02f;
		
		
		
//----------------------------------------------------------------------------------------	
		
		Scanner scanner = new Scanner(System.in);
		
//----------------------------------------------------------------------------------------	
		
		// Demander le nom du salarié:
		System.out.println("Veuillez saisir le nom du salarié :");
		String salaryName = scanner.next();
		System.out.println(salaryName);
		
		// Demander le prénom du salarié:
		System.out.println("Veuillez saisir le prènom nom du salarié :");
		String salaryFirstName = scanner.next();
		System.out.println(salaryFirstName);
		
//----------------------------------------------------------------------------------------		
		
		
		// Demander le statut à l'utilisateur:
		System.out.println("Veuillez saisir le numéro lié au statut (1-Cadre , 2-Agent de maîtrise ou 3-Employé de bureau) :");
		int statusIndex = scanner.nextInt();
		
		//Initialisation du nom de statut:
		String statusName = "";
		
		//Initialisation du Taux Horraire:
		float hourlyRate = 0;
		
		// définir taux horraire selon choix du statut:
		switch(statusIndex)
		{
		case 1 :statusName = "Cadre";
				hourlyRate = 19.50f;
				
				break;
		
		case 2 :statusName = "Agent de maîtrise";
				hourlyRate = 16.50f;
				
				break;
				
		case 3 :statusName = "Employé de bureau";
				hourlyRate = 12.50f;
		
				break;
		
		default : System.out.println("Erreur");
		
		}
		
//----------------------------------------------------------------------------------------	
		
		// Demander le nombre d'enfants du salarié à l'utilisateur:
				System.out.println("Veuillez saisir le nombre d'enfants du salarié :");
				int childrenNbr = scanner.nextInt();
				int childrenPrime = 0;
				
				
				// définir la prime selon le nombre d'enfants du salarié:
				if(childrenNbr == 0) {
					childrenPrime = 0;
					
				}else if(childrenNbr == 1) {
					childrenPrime = 20;
					
				}else if(childrenNbr == 2) {
					childrenPrime = 50;
					
				}else if(childrenNbr > 2) {
					childrenPrime = 70+((childrenNbr-2)*20);
					
				}else {
					System.out.println("Erreure");
				}
				
//----------------------------------------------------------------------------------------				
				
		// Demander le nombre d'heures réalisées par le salarié:
		System.out.println("Veuillez saisir le nombre d'heures réalisées :");
		int uneValeur = scanner.nextInt();
		
		//Initialisation de la variable salaire majoré (50%):
		float increasedSalary = 0;
				
		//Initialisation de la variable salaire majoré Plus (60%):
		float increasedSalaryPlus = 0;
		
		//Initialisation de la variable salaire Total salaire de base:
		float baseSalary = 0;
				
		
		// Vérifie et décompose les heures pour calcul des majorations:
		if(uneValeur != 0 & uneValeur/uneValeur == 1) {
			
			
			if(uneValeur > 180) {
				 increasedSalary = 10*hourlyRate*(1+increasedRate/100);
				 increasedSalaryPlus = ((uneValeur-180)*hourlyRate*(1+increasedRatePlus/100));
				baseSalary = ((169*hourlyRate)+increasedSalary+increasedSalaryPlus);
			}else if(uneValeur <= 180 & uneValeur >= 170){
				increasedSalary = (uneValeur-170)*hourlyRate*(1+increasedRate/100);
				increasedSalaryPlus = 0;
				
				baseSalary = ((169*hourlyRate)+increasedSalary+increasedSalaryPlus);
			}else if(uneValeur < 170){
				System.out.println("La valeur est inférieure à 170");
				increasedSalary = 0;
				increasedSalaryPlus = 0;
				baseSalary = ((uneValeur*hourlyRate)+increasedSalary+increasedSalaryPlus);
			}
			
		}else{
			System.out.println("Merci de saisir une valeur correcte");
		}
		
//----------------------------------------------------------------------------------------	
		
		//Appliquer les cotisations salariales au salaire de base :
		
		BigDecimal cotisBrutes = new BigDecimal(baseSalary*detteSociale/100+baseSalary*contribSociale/100+baseSalary*assuranceMaladie/100+baseSalary*assuranceVieillesse/100+baseSalary*assuranceChomage/100+baseSalary*retraiteComp/100+baseSalary*cotisAgff/100).setScale(2, RoundingMode.HALF_UP);
		
		double cotisArrondis = cotisBrutes.doubleValue();
		
//----------------------------------------------------------------------------------------		
		
		// Calcul du montant net à payer:
		
		BigDecimal salaireBrut = new BigDecimal(baseSalary-cotisArrondis+childrenPrime).setScale(2, RoundingMode.HALF_UP);
		double salaireArrondis = salaireBrut.doubleValue();
		
//----------------------------------------------------------------------------------------	
		// Affichages des résultats :
		
		System.out.println("Bulletin de salaire de " + salaryName + " " + salaryFirstName);
		System.out.println("Statut : " + statusName);
		System.out.println("Heures réalisées sur la période : " + uneValeur + " heures");
		System.out.println("Salaire de base : " + baseSalary + " €");
		System.out.println("Total des cotisations salariales : " + cotisArrondis + " €");
		System.out.println("Prime : " + childrenPrime + " €");
		System.out.println("Net à payer : " + salaireArrondis + " €");
		
	}
	

	

}
