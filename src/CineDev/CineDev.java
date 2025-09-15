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
    
   public static void exibirMenu() {
    System.out.println("1.Exibir Mapa.");
    System.out.println("2.Compra de Ingressos.");
    System.out.println("3.Cancelar Compra.");
    System.out.println("4.Exibir Relatorio.");
    System.out.println("5.Sair.");

    }

    public static void exibirMapa() {
    System.out.print("Assentos: ");
    
    for (int i = 1; i <= 20; i++) {
    System.out.printf("%2d ", i);
    }
    
    System.out.println();

    for (int i = 0; i < 10; i++) {
    System.out.printf("Fileira %2d: ", i + 1);
    
    for (int j = 0; j < 20; j++) {
    System.out.print("[" + salaDeCinema[i][j] + "]");
    }
    
    System.out.println();
            
    }
    
    }
    
    public static void comprarIngresso(Scanner scanner) {
    System.out.print("Digite o número da fileira (1 a 10): ");
    int fileira = scanner.nextInt();
    
    System.out.print("Digite o número do assento (1 a 20): ");
    int assento = scanner.nextInt();

    if (validarAssento(fileira, assento)) {
    if (salaDeCinema[fileira - 1][assento - 1].equals("L")) {
    salaDeCinema[fileira - 1][assento - 1] = "X";
    System.out.println("Ingresso comprado com sucesso!");
    
    } else {
    System.out.println("Assento já está ocupado.");
    
    }
        
    } else {
    System.out.println("Número de fileira ou assento inválido.");
    
    }
    
    }

    public static void cancelarIngresso(Scanner scanner) {
    System.out.print("Digite o número da fileira (1 a 10): ");
    int fileira = scanner.nextInt();

    System.out.print("Digite o número do assento (1 a 20): ");
    int assento = scanner.nextInt();

    if (validarAssento(fileira, assento)) {
    if (salaDeCinema[fileira - 1][assento - 1].equals("X")) {
            salaDeCinema[fileira - 1][assento - 1] = "L";
    System.out.println("Compra cancelada com sucesso!");
            
    } else {
    System.out.println("O assento já está livre.");
    }
        
    } else {
        System.out.println("Número de fileira ou assento inválido.");
    }
    
    }

    public static void exibirRelatorio() {
    int total = 10 * 20;
    int ocupados = 0;

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 20; j++) {
            if (salaDeCinema[i][j].equals("X")) {
                ocupados++;
            }
        }
    }

    int livres = total - ocupados;
    double percentual = (ocupados * 100.0) / total;

    System.out.println("\n===== RELATÓRIO DE OCUPAÇÃO =====");
    System.out.println("Total de assentos: " + total);
    System.out.println("Assentos ocupados: " + ocupados);
    System.out.println("Assentos livres: " + livres);
    System.out.printf("Percentual de ocupação: %.2f%%\n", percentual);
    
    } 

    public static boolean validarAssento(int fileira, int assento) {
    return fileira >= 1 && fileira <= 10 && assento >= 1 && assento <= 20;

    }
 
}