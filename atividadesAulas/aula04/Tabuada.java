package atividadesAulas.aula04;
import java.util.Scanner;

public class Tabuada {
    
    public static void calcularTabuada (int numero) {

        for(int i = 1 ; i <= 12 ; i++) {
            if (i == 12) { System.out.println(i + " x " + numero + " = " + (i * numero) + "\n"); continue;}
            System.out.println(i + " x " + numero + " = " + (i * numero));
        }   

    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------- Calculadora de Tabuada! --------\n");

        char condicao;
        int numero;

        Scanner entrada = new Scanner(System.in);

        do {



            System.out.print("Deseja visualizar a tabuada de qual número? ->| ");
            numero = entrada.nextInt();

            while (numero < 2) {
                System.out.println("\nValor não suportado! O numero deve ser >= 2");
                System.out.print("Digite outro valor: ");
                numero = entrada.nextInt();
                System.out.println("\n");

                continue;
            }

            System.out.println("Calculando...\n");
            Thread.sleep(1800);
            calcularTabuada(numero);

            System.out.println("Deseja executar novamente? (Y or N)");
            condicao = entrada.next().charAt(0);
            if(condicao == 'n' || condicao == 'N') {System.out.println("\nEncerrando..."); Thread.sleep(1500);}

            System.out.println("\n");

        } while (condicao == 'y' || condicao == 'Y');

        entrada.close();

    }

}
