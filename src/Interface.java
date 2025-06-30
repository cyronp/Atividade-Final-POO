import java.io.IOException;

public class Interface {

    public static String inicio(){
        return "***************************\nBem-vindo ao jogo da forca!\n***************************";
    }
    public static void limparConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }



}
