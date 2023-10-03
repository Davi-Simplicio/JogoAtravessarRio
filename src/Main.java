import java.util.Scanner;

public class Main {
    static Jogo jogo = new Jogo();
    static Scanner sc = new Scanner(System.in);
    static boolean vitoria;

    public static void main(String[] args) {
        System.out.println(Regras.mostrarRegras());
        menuInicial();
        System.out.println("Você Ganhou");
    }

    private static void menuInicial() {
        do {
            mostrarMargens();
            System.out.println("""
                    [1]Escolher alguém para colocar na jangada
                    [2]Tirar alguem da Jangada
                    [3]Atravessar o rio""");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    colocarNaJangada();
                    System.out.println(jogo.mostrarJangada());
                    break;
                case 2:
                    tirarDaJangada();
                    System.out.println(jogo.mostrarMargemAtual());
                    break;
                case 3:
                    atravessar();
                    mostrarMargens();
                    break;

            }
        } while (!vitoria);
    }

    private static void atravessar() {
        try {
             if (jogo.atravessar()){
                 vitoria = true;
             }
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
    }

    private static void tirarDaJangada() {
        System.out.println("Escolha alguém para tirar da jangada");
        System.out.println(jogo.mostrarJangada());
        int opcao = sc.nextInt();
        try {
            jogo.tiraDaJangadaColocaNaMargem(jogo.procurarPersonagemNaJangada(opcao));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void mostrarMargens() {
        System.out.println("-------MARGEM A-------");
        System.out.println(jogo.mostrarMargemA());
        System.out.println("-------JANGADA-------");
        System.out.println(jogo.mostrarJangada());
        System.out.println("-------MARGEM B-------");
        System.out.println(jogo.mostrarMargemB());
    }

    private static void colocarNaJangada() {
        System.out.println("Escolha alguém para colocar na jangada");
        System.out.println(jogo.mostrarMargemAtual());
        int opcao = sc.nextInt();
        try {
            jogo.tiraDaMargemColocaNaJangada(jogo.procurarPersonagemNaMargem(opcao));
        } catch (PersonagemNaoExisteException exception) {
            System.out.println(exception.getMessage());
        }catch (JangadaCheiaException exception){
            System.out.println(exception.getMessage());
        }
    }
}
