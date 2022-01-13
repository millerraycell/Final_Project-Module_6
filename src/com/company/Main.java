package com.company;

import Pessoa.Inimigo;
import Pessoa.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador player;
        Inimigo enemy;
        String playerName;
        int turn = 1;

        System.out.println("BEM VINDO(A) AO JOGO DE BATALHA NAVAL");
        System.out.println("INSIRA SEU NOME PARA DAR INICIO AO JOGO");
        playerName = sc.next();

        int method;
        do {
            System.out.println("DIGITE 1 SE VOCÊ QUER ESCOLHER ONDE POSICIONAR SEUS NAVIOS, OU 2 SE VOCÊ QUER QUE SEUS NAVIOS SEJAM POSICIONADOS ALEATORIAMENTE");
            method = sc.nextInt();
        } while ((method!=1) && (method!=2));

        switch(method) {
            case 1:
                List<int[]> ships = new ArrayList<>(10);
                for (int i = 0; i < 10; i++) {
                    System.out.printf("\nINSIRA AS COORDENADAS DO NAVIO %d\n", i+1);
                    ships.add(transformLetterToInt());
                }

                player = new Jogador(playerName, ships);
                break;

            case 2:
                player = new Jogador(playerName);
                break;

            default:
                throw new IllegalArgumentException("Invalid method: " + method);
        }

        do {
            System.out.println("1 - JOGO NORMAL\n2 - JOGO RÁPIDO");
            method = sc.nextInt();
        } while ((method!=1) && (method!=2));

        switch(method) {
            case 1:
                enemy = new Inimigo();
                break;

            case 2:
                enemy = new Inimigo(1);
                break;

            default:
                throw new IllegalArgumentException("Invalid method: " + method);
        }

        System.out.println("SEU TABULEIRO");
        player.showBoard();

        while(player.end() != 1 || enemy.end() != 1){
            // Player turn
            if(turn == 1){
                System.out.println("\nSUA VEZ DE ATACAR");
                System.out.printf("\nINSIRA AS COORDENADAS DO ATAQUE\n");
                enemy.receiveAttack(transformLetterToInt());
                turn = 0;
            }

            //Enemy turn
            if (turn == 0){
                System.out.println("\nVEZ DO INIMIGO");

                player.receiveAttack(enemy.attack());

                player.showBoard();
                turn = 1;
            }
        }
    }

    private static int[] transformLetterToInt(){
        Scanner sc = new Scanner(System.in);
        char[] listOfLetter = new char[2];
        for (int j = 0; j < 2; j++) {
            if(j == 0) System.out.println("LETRA (A, B, C, D, E, F, G, H, I, J): "); else System.out.println("Número (0, 1, 2, 3, 4, 5, 6, 7, 8, 9):");
            String word = sc.next().toUpperCase();
            listOfLetter[j] = word.charAt(0);
        }
        sc.nextLine();

        int countTry = 0;
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int[] coordinatesNumbers = new int[2];
        while (countTry < letters.length){
            if(letters[countTry] == listOfLetter[0]){
                coordinatesNumbers[0] = countTry;
                break;
            }
            countTry++;
        }
        int num = Character.getNumericValue(listOfLetter[1]);
        coordinatesNumbers[1] = num;
        return coordinatesNumbers;
    }

}
