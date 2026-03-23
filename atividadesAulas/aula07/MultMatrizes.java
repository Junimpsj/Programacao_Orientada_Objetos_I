package atividadesAulas.aula07;
import java.util.Scanner;

public class MultMatrizes {

    static boolean verificarMultMatrizes(int[][] matrizA, int[][] matrizB) {

        if(matrizA[0].length == matrizB.length) {
            return true;
        } else {
            return false;
        }

    }
    
    static int[][] lerMatriz(Scanner entrada) {

        System.out.print("Insira o número de linhas: ");
        int linhas = entrada.nextInt();

        System.out.print("Insira o número de colunas: ");
        int colunas = entrada.nextInt();

        System.out.println();

        int[][] matriz = new int[linhas][colunas];

        for(int i = 0 ; i < matriz.length ; i++) {
            for(int j = 0 ; j < matriz[i].length ; j++) {
                System.out.print("Insira o elemento na posição [" + i + "][" + j + "]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        return matriz;

    }

    static void exibirMatriz(int[][] matriz) {

        for(int i = 0 ; i < matriz.length ; i++) {
            for(int j = 0 ; j < matriz[i].length ; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

    }


    static int[][] multMatrizes(int[][] matrizA, int[][] matrizB) {

        int[][] matrizResult = new int[matrizA.length][matrizB[0].length];

            for (int i = 0 ; i < matrizA.length ; i++) { // i = linhas de A

                for( int j = 0 ; j < matrizB[0].length ; j++) { // j = colunas de B

                    for(int k = 0 ; k < matrizA[0].length ; k++) { // k = colunas de A = linhas de B (o n-1 da somatória)

                        matrizResult[i][j] += matrizA[i][k] * matrizB[k][j];
                    }

                }

            }

        return matrizResult;

    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // .length vai retornar o tamanho da primeira dimensão (linhas)
        // para pegar o tamanho de colunas então, usamos matriz[0].length em alguma linha para verificar o tamanho da segunda dimensão

        System.out.println("------ Matriz A ------\n");
        int[][] matrizA = lerMatriz(entrada);

        System.out.println();
        System.out.println("------ Matriz B ------\n");
        int[][] matrizB = lerMatriz(entrada);

        if(verificarMultMatrizes(matrizA, matrizB)) {

            System.out.println();
            System.out.println("A multiplicação é possível!");
            System.out.println();

            System.out.println("Matriz A:");
            exibirMatriz(matrizA);

            System.out.println("Matriz B:");
            exibirMatriz(matrizB);

            int[][] resultado = multMatrizes(matrizA, matrizB);

            System.out.println("Matriz resultado:");
            exibirMatriz(resultado);

        } else {

            System.out.println();
            System.out.println("A multiplicação não é possível. Colunas de A != Linhas de B."); 
            System.out.println("Encerrando...");

        }

        entrada.close();

    }

}
