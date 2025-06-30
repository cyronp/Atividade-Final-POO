import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Logica extends Palavra {

    static int erros = 0;
    static String palavra;
    static ArrayList<Character> estadoPalavra;
    static ArrayList<Character> letrasUsadas = new ArrayList<>();

    static {
        try {
            palavra = getPalavra();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            estadoPalavra = getEstado();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void jogo() {

        Scanner scanner = new Scanner(System.in);

        while (erros < 6) {


            System.out.print(Enforcado.getEnforcado(erros));

            System.out.println("Palavra: ");

            for (char c : estadoPalavra) {
                System.out.print(c + " ");
            }

            System.out.print("\nLetras já usadas: ");

            for (char letra : letrasUsadas) {
                System.out.print(letra + " ");
            }
            System.out.println();

            System.out.print("Adivnhe a próxima letra: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            Interface.limparConsole();

            if (letrasUsadas.contains(guess)) {
                System.out.println("Você já tentou essa letra!");
                continue;
            }

            letrasUsadas.add(guess);

            if (palavra.indexOf(guess) >= 0) {
                System.out.println("Letra correta!");

                for (int i = 0; i < palavra.length(); i++) {
                    if (palavra.charAt(i) == guess) {
                        estadoPalavra.set(i, guess);
                    }
                }
                if (!estadoPalavra.contains('_')) {
                    Interface.limparConsole();
                    System.out.print(Enforcado.getEnforcado(erros));
                    System.out.println("Você venceu!");
                    System.out.println("A palavra era: " + palavra);
                    break;
                }

            } else {
                erros++;
                System.out.println("Palavra errada!");
            }
        }

        if (erros >= 6) {
            Interface.limparConsole();
            System.out.println(Enforcado.getEnforcado(erros));
            System.out.println("O jogo acabou!");
            System.out.println("A palavra correta era: " + palavra);
        }
        scanner.close();
    }
}
