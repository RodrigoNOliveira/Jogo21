package classes;

import java.util.Random;

public class Computador extends Jogador {
    Random gerador = new Random();
    private int escolha;
    private Cartas c;

    public Computador(int jogador) {
        super(jogador);
        System.out.println("Computador iniciado");
    }


    @Override
    public void msg() {
        super.msg();
    }

    @Override
    public int valorJogador() {
        return super.valorJogador();
    }


    @Override
    public Cartas jogar(Baralho b1) {
        if (Escolha() == 1) {
            c = b1.tiraCartas();
            System.out.println(c);
            return c;
        }
        return null;
    }

    @Override
    public int Escolha() {
        do {
            msg();
            if (valorJogador() <= 10) {
                escolha = 1;
            } else {
                escolha = gerador.nextInt(2) + 1;
            }
            System.out.println("Opção selecionada pela maquina: " + escolha);
            return escolha;
        } while (escolha != 1 || escolha != 2);

    }

}
