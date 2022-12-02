package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Humano extends Jogador {
    private Scanner scanner = new Scanner(System.in);
    private Cartas c;

    @Override
    public void msg() {
        super.msg();
    }

    @Override
    public int valorJogador() {
        return super.valorJogador();
    }

    public Humano(int jogador) {
        super(jogador);
        System.out.println("\nJogador " + jogador + " iniciado");
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
        int escolha = 0;
        boolean verifica = true;
        do {
            try {
                msg();
                System.out.print("Digite a opção desejada: ");
                escolha = scanner.nextInt();
                if (escolha == 1 || escolha == 2) {
                    return escolha;
                } else {
                    System.out.println("\nOpção invalida! Insira um dos valores apresentados na tela: ");
                    verifica = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nOpção invalida! Insira um dos valores apresentados na tela: ");
                scanner.nextLine();
                verifica = false;
            }
        } while (verifica == false);
        return 0;
    }

}
