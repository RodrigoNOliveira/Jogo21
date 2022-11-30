package classes;

public abstract class Jogador {

    private int jogador;
    private int escolha;

    public Jogador(int jogador) {
        this.jogador = jogador;
    }

    public abstract void jogar();
    public abstract void Escolha();

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }
    


}

