package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Programa para verificar se anos são bissextos.
 * Um ano é bissexto se é divisível por 400, ou se é divisível por 4 e não divisível por 100.
 */
public class AnoBissexto {

    /**
     * Lê anos do usuário e armazena no vetor.
     * @param sc Scanner para ler entrada do usuário
     * @param anos Vetor para armazenar os anos
     */
    public static void inserirDados(Scanner sc, int[] anos) {

        for( int i = 0 ; i < anos.length ; i++) {

            System.out.print("Insira o " + (i+1) + "° ano: ");
            anos[i] = Integer.parseInt(sc.nextLine());

        }

    }

    /**
     * Verifica e exibe se cada ano no vetor é bissexto ou não.
     * @param anos Vetor com os anos a serem verificados
     */
    public static void verificarBissexto(int[] anos) {

        for (int i = 0 ; i < anos.length ; i++) {

            if(( anos[i] % 400 == 0) || ((anos[i] % 4 == 0) && (anos[i] % 100 != 0))) {
                System.out.println("O ano " + anos[i] + " é bissexto!");
            } else {
                System.out.println("O ano " + anos[i] + " não é bissexto");
            }

        }

    }
    
    /**
     * Método principal que executa o programa de verificação de anos bissextos.
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------ Verificar Anos Bissextos ------\n");

        System.out.print("Quantos elementos (anos) deseja verificar ? | ");
        int tamanho = Integer.parseInt(sc.nextLine());

        System.out.println();

        int[] anos = new int[tamanho];

        inserirDados(sc, anos);

        System.out.println();
        System.out.println("Verificando...");

        verificarBissexto(anos);

        sc.close();

    }

}
