package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private Scanner scanner;
    private Baralho baralho;
    private Humano humano;
    private Cartas c;
    boolean valida = true;
    boolean valida1 = true;

    private Cartas c1;
    private int jogada = 0;
    private Computador computador;
    private ArrayList<Jogador> listaJogador = new ArrayList<>();

    public Jogo() {
        baralho = new Baralho();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        baralho.criaCartas();
        baralho.tamanho();
        defineModo();
        for (int i = 0; i < listaJogador.size(); i++) {
            for (int e = 0; e < 2; e++) {
                c = baralho.tiraCartas();
                listaJogador.get(i).getListaCartas().add(c);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("+-----------+");
        System.out.println("|  JOGO 21  |");
        System.out.println("+-----------+");
        while (jogar())
            ;
    }

    public void cadastroMultiplayer() {
        System.out.println();
        System.out.print("Modo multiplayer - 2 jogadores");
        for (int i = 0; i < 2; i++) {
            humano = new Humano(i + 1);
            this.listaJogador.add(humano);
        }
    }

    public void cadastroIA() {
        humano = new Humano(1);
        this.listaJogador.add(humano);
        computador = new Computador(2);
        this.listaJogador.add(computador);
    }

    public void defineModo() {
        int opcao;
        boolean verifica = true;
        System.out.println("--------------------");
        System.out.println("\nModos de jogo:");
        System.out.println("1- Multiplayer \n2- Versus I.A\n");
        System.out.print("Insira o modo desejado: ");
        do {
            try {
                opcao = scanner.nextInt();
                if (opcao == 1) {
                    cadastroMultiplayer();
                } else {
                    cadastroIA();
                }
            } catch (InputMismatchException e) {
                System.out.print("\nOpção inválida! Digite um dos valores apresentados na tela: ");
                verifica = false;
            }
        } while (verifica == false);
    }

    // public int Escolha() {
    // int escolha = 0;
    // do {
    // try {
    // System.out.println("Opções");
    // System.out.println("1- Comprar Carta");
    // System.out.println("2- Não comprar carta");
    // System.out.print("Digite a opção desejada: ");
    // escolha = scanner.nextInt();
    // return escolha;
    // } catch (InputMismatchException e) {
    // System.out.println("\nOpção invalida! Insira um dos valores apresentados na
    // tela! ");
    // scanner.nextLine();
    // }
    // } while (escolha != 1 && escolha != 2);
    // return 0;
    // }

    // public Cartas jogada() {
    // if (Escolha() == 1) {
    // c = baralho.tiraCartas();
    // System.out.println(c);
    // return c;
    // }
    // return null;
    // }

    public boolean jogar() {
        jogada++;
        System.out.println();
        System.out.println("\n***** Rodada: " + jogada + " *****\n");
        System.out.println("Vez do jogador: " + jogadorVez() + "\n");

        if (jogadorVez() == 1) {
            System.out.println(listaJogador.get(0));
            c = listaJogador.get(0).jogar(baralho);
            if (c != null) {
                listaJogador.get(0).getListaCartas().add(c);
                valida = true;
                baralho.tamanho();
            } else {
                valida = false;
            }
        } else {
            System.out.println(listaJogador.get(1));
            c1 = listaJogador.get(1).jogar(baralho);
            if (c1 != null) {
                listaJogador.get(1).getListaCartas().add(c1);
                valida1 = true;
                baralho.tamanho();
            } else {
                valida1 = false;
            }

        }
        if (valida == false && valida1 == false) {
            System.out.println("Ambos pararam, chegando resultado...\n\n");
            if (listaJogador.get(0).valorJogador() < listaJogador.get(1).valorJogador()) {
                System.out.println("+---------------------+");
                System.out.println("| O jogador 2 ganhou! |");
                System.out.println("+---------------------+");
            } else if (listaJogador.get(0).valorJogador() > listaJogador.get(1).valorJogador()) {
                System.out.println("+---------------------+");
                System.out.println("| O jogador 1 ganhou! |");
                System.out.println("+---------------------+");
            } else {
                System.out.println("+---------------------+");
                System.out.println("|       EMPATE        |");
                System.out.println("+---------------------+");
            }
            return false;
        } else if (estourou(listaJogador.get(0).valorJogador()) == true) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 2 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        } else if (estourou(listaJogador.get(1).valorJogador()) == true) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 1 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        } else if (ganhou(listaJogador.get(0).valorJogador())) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 1 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        } else if (ganhou(listaJogador.get(1).valorJogador())) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 2 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        }

        return true;

    }

    public boolean estourou(int valor) {
        if (valor > 21) {
            return true;
        }
        return false;
    }

    public boolean ganhou(int valor) {
        if (valor == 21) {
            return true;
        }
        return false;
    }

    public int jogadorVez() {
        if (jogada % 2 != 0) {
            return 1;
        } else
            return 2;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
}
