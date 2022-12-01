package classes;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    private ArrayList<Cartas> listaCartas = new ArrayList<>();
    private Cartas cartas;

    public Baralho() {
    }

    public void criaCartas() {
        String naipe = "";
        String simbolo;
        for (int i = 0; i < 52; i++) {
            simbolo = verificaSimbolo(i);
            if (i <= 12) {
                naipe = "copas";
                cartas = new Cartas(simbolo, naipe, i+1);
                listaCartas.add(cartas);
            } else if (i > 12 && i <= 25) {
                naipe = "paus";
                cartas = new Cartas(simbolo, naipe, i+1-13);
                listaCartas.add(cartas);
            } else if (i > 25 && i <= 38) {
                naipe = "ouros";
                cartas = new Cartas(simbolo, naipe, i+1-26);
                listaCartas.add(cartas);
            } else {
                naipe = "espadas";
                cartas = new Cartas(simbolo, naipe, i+1-39);
                listaCartas.add(cartas);
            }

        }
        cartasBaralho();
    }


    public void cartasBaralho(){
        for (int i = 0; i < listaCartas.size(); i++) {
            if(listaCartas.get(i).getValor() > 10){
                listaCartas.get(i).setValor(10);
            }
        }
    }


    public String verificaSimbolo(int i) {
        if (i == 0 || i == 13 || i == 26 || i == 39) {       
                return "A";
            } else if (i == 10 || i == 23 || i == 36 || i == 49) {
                return "Q";
            } else if (i == 11 || i == 24 || i == 37 || i == 50) {
                return "J";
            } else if (i == 12 || i == 25 || i == 38 || i == 51) {
                return "K";
            } else if (i <= 12) {
               return Integer.toString(i + 1);
            } else if(i > 12 && i <= 25 ){
                return Integer.toString(i + 1 - 13);
            } else if (i > 25 && i <= 38) {
                return Integer.toString(i + 1 - 26);
            } else {
                return Integer.toString(i + 1 - 39);
            }
    }


    public Cartas tiraCartas() {
        Random gerador = new Random();
        int z = 0;
        do {
            z = gerador.nextInt(listaCartas.size());
            if (listaCartas.get(z) != null) {
                Cartas g = listaCartas.get(z);
                listaCartas.remove(z);
                return g;
                
            }
        } while (listaCartas.get(z) == null);
        return null;
        
    }

    public void tamanho() {
        System.out.println("Tamanho: " + listaCartas.size());
    }

    @Override
    public String toString() {
        return "Baralho [listaCartas=" + listaCartas + "]";
    }

}
