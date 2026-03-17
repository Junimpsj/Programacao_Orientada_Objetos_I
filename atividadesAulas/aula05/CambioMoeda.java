package atividadesAulas.aula05;
import java.util.Scanner;

public class CambioMoeda {
    
    public static double obterValor(Scanner entrada) {

        System.out.print("Insira o valor $$ que será convertido - R$");
        return entrada.nextDouble();

    }

    public static double obterTaxaCambio(Scanner entrada) {

        System.out.print("Insira a taxa de câmbio para o cálculo - R$");
        return entrada.nextDouble();

    }

    public static double converter(double valor, double taxa) {

        //o cálculo de conversão deve ser feito multiplicando o valor pela taxa de câmbio
        return valor * taxa;

    }

    public static void mostrarResultado(double valor, double taxa, double resultado) {

        //aprendi aqui que temos o system.out.printf(); que tem a sintaxe igual o print que utilizamos em C
        //utilizei ele aqui pois ele tem a possiblidade de controlar a exibição de pontos flutuante com %.2f
        System.out.printf("O valor R$%.2f convertido pela taxa x%.2f resulta em R$%.2f %n%n", valor, taxa, resultado);

    }
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        char condicao;

        do {

            double valor = obterValor(entrada);
            double taxa = obterTaxaCambio(entrada);

            double resultado = converter(valor, taxa);

            mostrarResultado(valor, taxa, resultado);

            System.out.print("Deseja converter outro valor? (s/n) | ");
            condicao = entrada.next().charAt(0);

        } while (condicao == 's' || condicao == 'S');

        entrada.close();

        System.out.println("Encerrando... Obrigado por utilizar!");

    }

}
