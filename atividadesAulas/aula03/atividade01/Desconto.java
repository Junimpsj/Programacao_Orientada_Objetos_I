package atividadesAulas.aula03.atividade01;

public class Desconto {

    public static double aplicarDesconto(double preco, double desconto) {
        return preco - (preco * desconto);
    }

    public static void main(String[] args) {

        double preco = 800.00;
        double desconto = 0.10;

        System.out.println("Calculando Desconto....");
        System.out.print("O valor final com desconto eh: R$");
        System.out.println(aplicarDesconto(preco, desconto));

    }

}