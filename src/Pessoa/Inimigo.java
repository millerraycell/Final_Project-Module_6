package Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo extends Player {
    private List<int[]> attacks = new ArrayList<>();
    private final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private int easyGame = 0;

    public char transformIntToChar(int num){
        return letters[num];
    }

    public Inimigo() {
        super("enemy", generateShips());
    }

    public Inimigo(int easyGame){
        super("enemy", generateShips());
        this.easyGame = easyGame;
    }

    public int[] attack() {
        if(easyGame == 1){
            Random rand = new Random();

            List<int[]> enemyShips = Jogador.loseGame();

            int attackIndex = rand.nextInt(enemyShips.size());

            while(attacks.contains(enemyShips.get(attackIndex)) && attacks.size() != 0){
                attackIndex = rand.nextInt(enemyShips.size());
            }

            attacks.add(enemyShips.get(attackIndex));

            System.out.printf("ATAQUE REALIZADO NAS COORDENADAS %s %d\n", transformIntToChar(enemyShips.get(attackIndex)[0]), enemyShips.get(attackIndex)[1]);

            return enemyShips.get(attackIndex);
        }

        int[] aux = generateRandomNumbers();

        if(attacks.size() == 0){
            attacks.add(aux);
        }

        while(attacks.contains(aux) && attacks.size() != 0){
            aux = generateRandomNumbers();
        }

        System.out.printf("ATAQUE REALIZADO NAS COORDENADAS %s %d\n", transformIntToChar(aux[0]), aux[1]);

        return aux;
    }
}
