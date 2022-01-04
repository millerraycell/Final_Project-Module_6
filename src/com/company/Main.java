package com.company;

import Player.Player;
import Player.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerName;
        List<int[]> ships = new ArrayList<>(10);
        int turn = 1;

        System.out.println("BEM VINDO(A) AO JOGO DE BATALHA NAVAL");
        System.out.println("INSIRA SEU NOME PARA DAR INICIO AO JOGO");
        playerName = sc.next();

        for (int i = 0; i < 2; i++) {
            System.out.printf("INSIRA AS COORDENADAS (0,9) (0,9) DO NAVIO %d\n", i+1);
            int[] aux = new int[2];
            for (int j = 0; j < 2; j++) {
                aux[j] = sc.nextInt();
            }
            ships.add(aux);
            sc.nextLine();
        }

        Player player = new Player(playerName, ships);
        Enemy enemy = new Enemy();

        System.out.println("SEU TABULEIRO");
        player.showBoard();

        while(player.end() != 1 || enemy.end() != 1){
            // Player turn
            if(turn == 1){
                System.out.println("\nSUA VEZ DE ATACAR");
                System.out.println("INSIRA AS COORDENADAS (0,9) (0,9) QUE DESEJA REALIZAR O ATAQUE");

                int[] aux = new int[2];

                for (int i = 0; i < 2; i++) {
                    aux[i] = sc.nextInt();
                }

                enemy.receiveAttack(aux);
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
}
