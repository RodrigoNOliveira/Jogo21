import classes.Baralho;


public class App {
    public static void main(String[] args) throws Exception {
        Baralho b1 = new Baralho();
        //b1.criaBaralho();
        b1.criaCartas();
        
        b1.tamanho(); 
        b1.tiraCartas();
        b1.tamanho();
        b1.tiraCartas();
        b1.tiraCartas();
        b1.tiraCartas();
        b1.tamanho();
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(b1);
    }
}
