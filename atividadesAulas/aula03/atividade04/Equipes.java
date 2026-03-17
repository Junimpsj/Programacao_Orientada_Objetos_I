package atividadesAulas.aula03.atividade04;
import java.util.Scanner;

public class Equipes {

    public static int dividirEquipes(int numEstudantes, int tamEquipes) {
        return numEstudantes / tamEquipes;
    }

    public static int calcularResto(int numEstudantes, int tamEquipes) {
        return numEstudantes % tamEquipes;
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Vamos dividir as equipes para o trabalho!\n");

        System.out.println("Insira o numero de estudantes:");
        int numEstudantes = entrada.nextInt();

        System.out.println("Insira o tamanho das equipes:");
        int tamEquipes = entrada.nextInt();

        entrada.close();

        System.out.println("Calculando...");
        Thread.sleep(1800);

        System.out.println("Perfeito! Com " + numEstudantes + " estudantes e equipes de " + tamEquipes + " alunos teremos:");
        System.out.println(dividirEquipes(numEstudantes, tamEquipes) + " equipes e " + calcularResto(numEstudantes, tamEquipes) + " estudantes que ficarao de fora");

    }

}