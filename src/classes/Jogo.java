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
        System.out.println();
        System.out.println();
        System.out.println("+------------------+");
        System.out.println("|      JOGO 21     |");
        System.out.println("+------------------+");
        System.out.println();

        baralho.criaCartas();
        // baralho.tamanho();
        // System.out.println(baralho);
        defineModo();
        for (int i = 0; i < listaJogador.size(); i++) {
            for (int e = 0; e < 2; e++) {
                c = baralho.tiraCartas();
                listaJogador.get(i).getListaCartas().add(c);
            }
        }
        // System.out.println();
        // System.out.println();
        // System.out.println("+-----------+");
        // System.out.println("| JOGO 21 |");
        // System.out.println("+-----------+");
        while (jogar())
            ;
    }

    public void cadastroMultiplayer() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------");
        System.out.println("|                  |");
        System.out.println("|    Multiplayer   |");
        System.out.println("|                  |");
        System.out.println("|    Iniciando     |");
        System.out.println("|                  |");
        System.out.println("--------------------");
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
        int opcao = 0;
        boolean verificaOpt = true, verificaErro;

        System.out.println("--------------------");
        System.out.println("|                  |");
        System.out.println("| Modos de jogo:   |");
        System.out.println("|                  |");
        System.out.println("| 1- Multiplayer   |");
        System.out.println("|                  |");
        System.out.println("| 2- Versus I.A    |");
        System.out.println("|                  |");
        System.out.println("--------------------");
        System.out.print("Modo desejado: ");
        do {
            do {
                try {
                    opcao = scanner.nextInt();
                    if (opcao == 1) {
                        cadastroMultiplayer();
                    } else if (opcao == 2) {
                        cadastroIA();
                    } else {
                        System.out.print("\nOpção inválida! Digite um dos valores apresentados na tela: ");
                        verificaOpt = false;
                    }
                    verificaErro = true;
                } catch (InputMismatchException e) {
                    System.out.print("\nOpção inválida! Digite um dos valores apresentados na tela: ");
                    scanner.nextLine();
                    verificaErro = false;
                }
            } while (verificaErro == false);
        } while (verificaOpt == false);

    }

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
            System.out.println();
            System.out.println("Ambos pararam, checando resultado...\n\n");
            System.out.println();
            if (listaJogador.get(0).valorJogador() < listaJogador.get(1).valorJogador()) {
                System.out.println("+----------------------+");
                System.out.println("| Resultado jogador 1: |");
                if (listaJogador.get(0).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "           |");
                }
                System.out.println("| Resultado jogador 2: |");
                if (listaJogador.get(1).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "           |");
                }
                System.out.println("| O jogador 2 ganhou!  |");
                System.out.println("+----------------------+");
            } else if (listaJogador.get(0).valorJogador() > listaJogador.get(1).valorJogador()) {
                System.out.println("+----------------------+");
                System.out.println("| Resultado jogador 1: |");
                if (listaJogador.get(0).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "           |");
                }
                System.out.println("| Resultado jogador 2: |");
                if (listaJogador.get(1).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "           |");
                }
                System.out.println("|  O jogador 1 ganhou! |");
                System.out.println("+---------------------+");
            } else {
                System.out.println("+----------------------+");
                System.out.println("| Resultado jogador 1: |");
                if (listaJogador.get(0).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(0).valorJogador() + "           |");
                }
                System.out.println("| Resultado jogador 2: |");
                if (listaJogador.get(1).valorJogador() > 9) {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "          |");
                } else {
                    System.out.println("|          " + listaJogador.get(1).valorJogador() + "           |");
                }
                System.out.println("|        EMPATE        |");
                System.out.println("+----------------------+");
            }
            return false;
        } else if (estourou(listaJogador.get(0).valorJogador()) == true) {
            System.out.println("+---------------------+");
            System.out.println("|  Jogador 1 estourou |");
            System.out.println("| O jogador 2 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        } else if (estourou(listaJogador.get(1).valorJogador()) == true) {
            System.out.println("+---------------------+");
            System.out.println("|  Jogador 2 estourou |");
            System.out.println("| O jogador 1 ganhou! |");
            System.out.println("+---------------------+");
            return false;
        } else if (ganhou(listaJogador.get(0).valorJogador())) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 1 ganhou  |");
            System.out.println("| completou a soma 21 |");
            System.out.println("+---------------------+");
            return false;
        } else if (ganhou(listaJogador.get(1).valorJogador())) {
            System.out.println("+---------------------+");
            System.out.println("| O jogador 2 ganhou  |");
            System.out.println("| completou a soma 21 |");
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
