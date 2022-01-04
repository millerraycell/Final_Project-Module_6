package Board;

import java.util.List;

public class Board {
    private char[][] board = new char[10][10];
    private final String name;
    private final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private int hits = 0;

    public Board(String name, List<int[]> ships){
        this.name = name;

        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                board[i][j] = 'a';
            }
        }

        for(int[] k : ships){
            board[k[0]][k[1]] = 'N';
        }
    }

    public void showBoard(){
        System.out.println("---------------------------------------------");
        System.out.printf("\t\t\t\t\t%S\n",this.name);
        System.out.println("---------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("---------------------------------------------");

        for(int k = 0; k < 10; k++){
            System.out.printf("| %c |", letters[k]);

            for (int j = 0; j < 10; j++){
                if(board[k][j] == 'a'){
                    System.out.print("   |");
                }
                else {
                    System.out.printf(" %c |", board[k][j]);
                }
            }
            System.out.println("");
            System.out.println("---------------------------------------------");
        }
    }

    public void attack(int[] coordinates){
        if(board[coordinates[0]][coordinates[1]] == 'a'){
            System.out.println("TIRO NA AGUA\n");
            board[coordinates[0]][coordinates[1]] = '-';
        }
        if(board[coordinates[0]][coordinates[1]] == 'N'){
            System.out.println("TIRO CERTEIRO");
            board[coordinates[0]][coordinates[1]] = '*';
            hits++;
        }
    }

    public int gameFinished(){
        if(hits == 9){
            return 1;
        }
        return 0;
    }
}
