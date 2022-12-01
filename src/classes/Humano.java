package classes;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Humano extends Jogador {
    private Scanner scanner = new Scanner(System.in);
    private Cartas c;

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
        do {
            try {
                System.out.println("Opções");
                System.out.println("1- Comprar Carta");
                System.out.println("2- Não comprar carta");
                System.out.print("Digite a opção desejada: ");
                escolha = scanner.nextInt();
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("\nOpção invalida! Insira um dos valores apresentados na tela! ");
                scanner.nextLine();
            }
        } while (escolha != 1 && escolha != 2);
        return 0;
    }



}
