package atividadesAulas.aula03.atividade03;
import java.util.Scanner;

public class Imposto {
    
    static double precoFinal(double preco, double taxa) {
        return preco * (1 + taxa / 100);
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Insira aqui o valor do produto:");
        double preco = entrada.nextDouble();

        System.out.println("Insira agora o valor da taxa (porcentagem):");
        double taxa = entrada.nextDouble();

        entrada.close();

        System.out.println("Calculando.....");
        Thread.sleep(1800);
        System.out.println("--------------- O valor final do produto com sua taxa de imposto aplicada foi calculado ---------------");
        System.out.println("R$" + precoFinal(preco, taxa));

    }

}