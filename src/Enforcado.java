public class Enforcado {
    public static String getEnforcado(int erros) {
        return switch (erros) {
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                     0
                    
                    
                    """;
            case 2 -> """
                     0
                     |
                    
                    """;
            case 3 -> """
                     0
                    /|
                    
                    """;
            case 4 -> """
                     0
                    /|\\
                    
                    """;
            case 5 -> """
                     0
                    /|\\
                    /
                    """;
            case 6 -> """
                     0
                    /|\\
                    / \\
                    """;
            default -> "";
        };
    }
}
