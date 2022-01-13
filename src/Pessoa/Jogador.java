package Pessoa;

import java.util.List;

public class Jogador extends Player {
    public Jogador(String name, List<int[]> ships) {
        super(name, ships);
    }

    public Jogador(String name){
        super(name);
    }
}
