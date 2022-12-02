package classes;

public class Cartas {

    private String simbolo;
    private String naipe;
    private int valor;

    public Cartas() {
    }

    public Cartas(String simbolo, String naipe, int valor) {
        this.simbolo = simbolo;
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {

        if ((naipe.equals("copas") || naipe.equals("ouros")) && simbolo.equals("10")) {
            return "\n----------\n" + "| " + simbolo + "     |\n" + "|        |\n" + "|        |\n" + "| " + naipe
                    + "  |\n" + "|        |\n" + "|        |\n" + "|     " + simbolo + " |\n" + "----------\n";
        } else if ((naipe.equals("paus")) && simbolo.equals("10")) {
            return "\n----------\n" + "| " + simbolo + "     |\n" + "|        |\n" + "|        |\n" + "|  " + naipe
                    + "  |\n" + "|        |\n" + "|        |\n" + "|     " + simbolo + " |\n" + "----------\n";
        } else if ((naipe.equals("espadas")) && simbolo.equals("10")) {
            return "\n----------\n" + "| " + simbolo + "     |\n" + "|        |\n" + "|        |\n" + "| " + naipe
                    + "|\n" + "|        |\n" + "|        |\n" + "|     " + simbolo + " |\n" + "----------\n";
        } else if ((naipe.equals("espadas"))) {
            return "\n----------\n" + "| " + simbolo + "      |\n" + "|        |\n" + "|        |\n" + "| " + naipe
                    + "|\n" + "|        |\n" + "|        |\n" + "|      " + simbolo + " |\n" + "----------\n";
        } else if (naipe.equals("copas") || naipe.equals("ouros")) {
            return "\n----------\n" + "| " + simbolo + "      |\n" + "|        |\n" + "|        |\n" + "| " + naipe
                    + "  |\n" + "|        |\n" + "|        |\n" + "|      " + simbolo + " |\n" + "----------\n";
        } else {
            return "\n----------\n" + "| " + simbolo + "      |\n" + "|        |\n" + "|        |\n" + "|  " + naipe
                    + "  |\n" + "|        |\n" + "|        |\n" + "|      " + simbolo + " |\n" + "----------\n";
        }
    }

}
