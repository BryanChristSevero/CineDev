package CineDev;
    import java.util.Scanner;
    public class CineDev {
        
    static String[][] salaDeCinema = new String[10][20];

    public static void main(String[] args) {
         
    Scanner scanner = new Scanner(System.in);
    int opcao;
    
    inicializarSala();
    
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMapa();
                    break;
                case 2:
                    comprarIngresso(scanner);
                    break;
                case 3:
                    cancelarIngresso(scanner);
                    break;
                case 4:
                    exibirRelatorio();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    public static void inicializarSala() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                salaDeCinema[i][j] = "L";
            }
        }
    }
    
  