package Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Inimigo extends Player {
    private List<int[]> attacks = new ArrayList<>();
    private final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public char transformIntToChar(int num){
        return letters[num];
    }

    public Inimigo() {
        super("enemy", generateShips());
    }

    public int[] attack() {
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
