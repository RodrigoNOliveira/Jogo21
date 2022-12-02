package classes;

import java.util.ArrayList;

public abstract class Jogador {

    private int jogador;
    protected Jogo jogo;
    protected int valor;
    protected ArrayList<Cartas> listaCartas = new ArrayList<>();

    public Jogador(int jogador) {
        this.jogador = jogador;

    }

    public ArrayList<Cartas> getListaCartas() {
        return listaCartas;
    }

    public void msg() {
        System.out.println("\n\n\n--------------------");
        System.out.println("|                  |");
        System.out.println("|      Opções      |");
        System.out.println("|                  |");
        System.out.println("| 1- Comprar carta |");
        System.out.println("|                  |");
        System.out.println("| 2- Não comprar   |");
        System.out.println("|                  |");
        System.out.println("--------------------\n");
    }

    public void setListaCartas(ArrayList<Cartas> listaCartas) {
        this.listaCartas = listaCartas;
    }

    public int valorJogador() {
        int total = 0;

        for (int j = 0; j < listaCartas.size(); j++) {
            total = total + listaCartas.get(j).getValor();
        }
        return total;
    }

    public abstract Cartas jogar(Baralho b1);

    public abstract int Escolha();

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "" + listaCartas;
    }

}
