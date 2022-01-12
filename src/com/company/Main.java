package com.company;

import Player.Player;
import Player.Enemy;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Player.Enemy.generateRandomNumbers;

public class Main {

    static List<int[]> ships = new ArrayList<>(10);

    public static void method1() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.printf("\nINSIRA AS COORDENADAS DO NAVIO %d\n", i+1);
            ships.add(transformLetterToInt());
        }
    }

    public static void method2() {
        generateRandomNumbers();
        ships.add(generateRandomNumbers());

        for (int i = 1; i < 10; i++) {
            int[] aux = generateRandomNumbers();

            while(ships.contains(aux)){
                aux = generateRandomNumbers();
            }
            ships.add(aux);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                method1();
                break;

            case 2:
                method2();
                break;

            default:
                throw new IllegalArgumentException("Invalid method: " + method);
        }

        Player player = new Player(playerName, ships);
        Enemy enemy = new Enemy();

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
