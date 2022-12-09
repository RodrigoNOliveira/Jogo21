package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private Scanner scanner;
    private Baralho baralho;
    private Humano humano;
    private Cartas c;
    private boolean valida = true;
    private boolean valida1 = true;

    private Cartas c1;
    private int jogada = 0;
    private Computador computador;
    private ArrayList<Jogador> listaJogador = new ArrayList<>();

    public Jogo() {
        baralho = new Baralho();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int novamente = 0;
        boolean verifica = true;
        do{
        System.out.println();
        System.out.println();
        System.out.println("+------------------+");
        System.out.println("|      JOGO 21     |");
        System.out.println("+------------------+");
        System.out.println();
        baralho.criaCartas();
        defineModo();
        for (int i = 0; i < listaJogador.size(); i++) {
            for (int e = 0; e < 2; e++) {
                c = baralho.tiraCartas();
                listaJogador.get(i).getListaCartas().add(c);
            }
        }
        while (jogar());
        
        System.out.println("Deseja Jogar Novamente?(1-Sim - 2Não)");
        do {
            verifica = true;
            try {
                novamente = scanner.nextInt();
                if (novamente != 1 && novamente != 2) {
                    System.out.println("\nOpção invalida! Insira um dos valores apresentados na tela: ");
                    verifica = false;
                }
            }catch (InputMismatchException e) {
                System.out.println("\nOpção invalida! Insira um dos valores apresentados na tela: ");
                scanner.nextLine();
                verifica = false;
            }
        } while (verifica == false);
        }while(novamente!=2);  
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
        System.out.println();
        System.out.println();
        System.out.println("--------------------");
        System.out.println("|                  |");
        System.out.println("|    Versus I.A.   |");
        System.out.println("|                  |");
        System.out.println("|    Iniciando     |");
        System.out.println("|                  |");
        System.out.println("--------------------");
        humano = new Humano(1);
        this.listaJogador.add(humano);
        computador = new Computador(2);
        this.listaJogador.add(computador);
    }

    public void defineModo() {
        int opcao = 0;
        boolean verifica = true;
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
            verifica = true;
            try {
                opcao = scanner.nextInt();
                if (opcao == 1) {
                    cadastroMultiplayer();
                } else if (opcao == 2) {
                    cadastroIA();
                } else {
                    System.out.print("\nOpção inválida! Digite um dos valores apresentados na tela: ");
                    verifica = false;
                }
            } catch (InputMismatchException e) {
                System.out.print("\nOpção inválida! Digite um dos valores apresentados na tela: ");
                scanner.nextLine();
                verifica = false;
            }
        } while (verifica == false);

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
            } else {
                valida = false;
            }
        } else {
            System.out.println(listaJogador.get(1));
            c1 = listaJogador.get(1).jogar(baralho);
            if (c1 != null) {
                listaJogador.get(1).getListaCartas().add(c1);
                valida1 = true;
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
                parteMsgResultJgd(0);
                System.out.println("| Resultado jogador 2: |");
                parteMsgResultJgd(1);
                System.out.println("| O jogador 2 ganhou!  |");
                System.out.println("+----------------------+");
            } else if (listaJogador.get(0).valorJogador() > listaJogador.get(1).valorJogador()) {
                System.out.println("+----------------------+");
                System.out.println("| Resultado jogador 1: |");
                parteMsgResultJgd(0);
                System.out.println("| Resultado jogador 2: |");
                parteMsgResultJgd(1);
                System.out.println("|  O jogador 1 ganhou! |");
                System.out.println("+----------------------+");
            } else {
                System.out.println("+----------------------+");
                System.out.println("| Resultado jogador 1: |");
                parteMsgResultJgd(0);
                System.out.println("| Resultado jogador 2: |");
                parteMsgResultJgd(1);
                System.out.println("|        EMPATE        |");
                System.out.println("+----------------------+");
            }
            return false;
        } else if (estourou(listaJogador.get(0).valorJogador()) == true) {
            System.out.println("+----------------------+");
            System.out.println("|  Jogador 1 estourou  |");
            parteMsgResultJgd(0);
            System.out.println("| O jogador 2 ganhou!  |");
            System.out.println("+----------------------+");
            return false;
        } else if (estourou(listaJogador.get(1).valorJogador()) == true) {
            System.out.println("+----------------------+");
            System.out.println("|  Jogador 2 estourou  |");
            parteMsgResultJgd(1);
            System.out.println("| O jogador 1 ganhou!  |");
            System.out.println("+----------------------+");
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

    public void parteMsgResultJgd(int i) {
        if (listaJogador.get(i).valorJogador() >= 10) {
            System.out.println("|    Soma: " + listaJogador.get(i).valorJogador() + "          |");
        } else {
            System.out.println("|    Soma:  " + listaJogador.get(i).valorJogador() + "         |");
        }
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
