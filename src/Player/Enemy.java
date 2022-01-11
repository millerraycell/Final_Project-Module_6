package Player;

import Board.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy{
    private final String name = "enemy";
    private Board board;
    private List<int[]> attacks = new ArrayList<>();

    public static int[] generateRandomNumbers(){
        Random rand = new Random();

        int valueX = rand.nextInt(10);
        int valueY = rand.nextInt(10);

        return new int[]{valueX, valueY};
    }

    public Enemy() {
        List<int[]> ships = new ArrayList<>(10);

        ships.add(generateRandomNumbers());

        for (int i = 1; i < 10; i++) {
            int[] aux = generateRandomNumbers();

            while(ships.contains(aux)){
                aux = generateRandomNumbers();
            }

            ships.add(aux);
        }

        String name = "enemy";
        board = new Board(name, ships);
    }

    public int[] attack() {
        int[] aux = generateRandomNumbers();

        if(attacks.size() == 0){
            attacks.add(aux);

            return aux;
        }

        while(attacks.contains(aux)){
            aux = generateRandomNumbers();
        }

        System.out.printf("ATAQUE REALIZADO NAS COORDENADAS %d %d\n", aux[0], aux[1]);

        return aux;
    }

    public void receiveAttack(int[] coordinates){
        board.attack(coordinates);
    }

    public void showBoard(){
        board.showBoard();
    }

    public int end(){
        return board.gameFinished();
    }
}
