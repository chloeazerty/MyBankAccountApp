package com.company;

import java.util.Scanner;

public class Account {
    // Déclaration des variables de la classe
    int solde;
    int derniereTransaction;
    String nomClient;
    String numeroClient;

    //Class constructor
    Account(String nclient, String noClient) {
        nomClient = nclient;
        numeroClient = noClient;
    }

    // Fonction pour Dépôt de l'argent
    void depot(int montant) {
        if (montant != 0) {
            solde = solde + montant;
            derniereTransaction = montant;
        }
    }

    // Fonction pour Retrait de l'argent
    void retrait(int montant) {
        if (montant != 0) {
            solde = solde - montant;
            derniereTransaction = -montant;
        }
    }

    // Fonction qui affiche la dernière transaction
    void getDerniereTransaction() {
        if (derniereTransaction > 0) {
            System.out.println("Vous venez de déposer : " + derniereTransaction);
        } else if (derniereTransaction < 0) {
            System.out.println("Vous venez de retirer: " + Math.abs(derniereTransaction));
        } else {
            System.out.println("Aucune transaction effectuée");
        }
    }

    // Fonction qui calcule l'intérêt des prêts actuels après un certain numéro d'années
    void calculInteret(int ans) {
        double interetTaux = .0025;
        double nouveauSolde = (solde * interetTaux * ans) + solde;
        System.out.println("Le taux actuel d'intérêt est " + (100 * interetTaux) + "%");
        System.out.println("Après " + ans + " ans, votre solde aura un montant de: " + nouveauSolde);
    }

    // Fonction qui affiche le menu
    void afficheMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour, " + nomClient + "!");
        System.out.println("Client n° " + numeroClient);
        System.out.println();
        System.out.println("Que aimeriez-vous faire?");
        System.out.println();
        System.out.println("A. Vérifiez votre compte");
        System.out.println("B. Effectuez un dépôt");
        System.out.println("C. Effectuez un retrait");
        System.out.println("D. Visualisez votre dernière transaction");
        System.out.println("E.  Calculez le taux d’intérêt");
        System.out.println("F. Déconnexion");

        do {
            System.out.println();
            System.out.println("Choissisez une opération");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Case A=> opération A.Vérifiez votre compte
                case 'A':
                    System.out.println("*******************************");
                    System.out.println("Votre solde est de " + solde + "€");
                    System.out.println("*******************************");
                    System.out.println();
                    break;

                //Case B=> opération B.Effectuez un dépôt
                case 'B':
                    System.out.println("Insérez un montant pour effectuer un dépôt");
                    int montant = scanner.nextInt();
                    depot(montant);
                    System.out.println();
                    break;

                //Case C=> opération C.Effectuez un retrait
                case 'C':
                    System.out.println("Insérez un montant pour effectuer un retrait");
                    int montant2 = scanner.nextInt();
                    retrait(montant2);
                    System.out.println();
                    break;

                //Case D=> opération D.Visualisez votre dernière transaction
                case 'D':
                    System.out.println("::::::::::::::::::::::::::::::::::::::::");
                    getDerniereTransaction();
                    System.out.println("::::::::::::::::::::::::::::::::::::::::");
                    System.out.println();
                    break;

                //Case E=> opération E.Calculez le taux d’intérêt
                case 'E':
                    System.out.println("Insérez la durée du prêt");
                    int ans = scanner.nextInt();
                    calculInteret(ans);
                    break;

                //Case F=> opération F.Déconnexion
                case 'F' :
                System.out.println("::::::::::::::::::::::::::::::::::::::::");
                break;

                //La case default informe si le client a inséré un caractère invalide
                default:
                    System.out.println("Erreur: opération invalide. Veuillez entrer A, B, C, D, E ou F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Nous vous remercions pour votre visite");
    }
}


