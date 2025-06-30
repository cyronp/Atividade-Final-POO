import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Palavra {

    private static String palavra;

    static {
        try {
            palavra = sortearPalavra();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static String sortearPalavra() throws IOException {
        List<String> linhas;

        try (InputStream is = Palavra.class.getResourceAsStream("/palavras_forca.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            linhas = br.lines().toList();

        } catch (NullPointerException e) {
            throw new FileNotFoundException("Arquivo palavras_forca.txt não encontrado no JAR.");
        }

        if (!linhas.isEmpty()) {
            Random random = new Random();
            palavra = linhas.get(random.nextInt(linhas.size()));
            return palavra;
        } else {
            System.out.println("Arquivo palavras_forca.txt está vazio.");
            return null;
        }
    }



    public static String getPalavra() throws IOException {
        return palavra;
    }

    public static ArrayList<Character> getEstado() throws IOException {
        String palavra = getPalavra();
        ArrayList<Character> estadoPalavra = new ArrayList<>();

        if (palavra == null) {
            System.out.println("Não foi possível obter uma palavra.");
            return estadoPalavra;
        }

        for (int i = 0; i < palavra.length(); i++) {
            estadoPalavra.add('_');
        }
        return estadoPalavra;
    }


    }










