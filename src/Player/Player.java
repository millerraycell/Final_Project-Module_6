package Player;

import Board.Board;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Board board;
    private List<int[]> attacks = new ArrayList<>();

    public Player(String name, List<int[]> ships){
        this.name = name;
        board = new Board(name, ships);
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
