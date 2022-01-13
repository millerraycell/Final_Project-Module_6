package Pessoa;

import Board.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private Board board;
    private List<int[]> attacks = new ArrayList<>();
    private static List<int[]> ships = new ArrayList<>(10);

    public Player(String name, List<int[]> ships){
        this.name = name;
        this.ships = ships;
        board = new Board(name, ships);
    }

    public Player(String name){
        this.name = name;
        this.ships = generateShips();
        board = new Board(name, ships);
    }

    public static int[] generateRandomNumbers(){
        Random rand = new Random();

        int valueX = rand.nextInt(10);
        int valueY = rand.nextInt(10);

        return new int[]{valueX, valueY};
    }

    public static List<int[]> generateShips(){
        ships.add(generateRandomNumbers());

        for (int i = 1; i < 10; i++) {
            int[] aux = generateRandomNumbers();

            while(ships.contains(aux)){
                aux = generateRandomNumbers();
            }

            ships.add(aux);
        }
        return ships;
    }

    public void showBoard(){
        board.showBoard();
    }

    public void receiveAttack(int[] coordinates){
        board.attack(coordinates);
    }

    public int end(){
        return board.gameFinished();
    }
}
