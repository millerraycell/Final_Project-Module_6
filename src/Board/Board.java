package Board;

public class Board {
    private char[][] board = new char[10][10];
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public Board(){
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                board[i][j] = 'a';
            }
        }
    }

    private char letter(int i){
        if(i == 3){
            return 'A';
        }if(i == 5){
            return 'B';
        }if(i == 7){
            return 'C';
        }if(i == 9){
            return 'D';
        }if(i == 11){
            return 'E';
        }if(i == 13){
            return 'F';
        }if(i == 15){
            return 'G';
        }if(i == 17){
            return 'H';
        }if(i == 19){
            return 'I';
        }if(i == 21){
            return 'J';
        }
        return ' ';
    }

    public void showBoard(){
        System.out.println("\t\t\t\t\tJogador");
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
}
