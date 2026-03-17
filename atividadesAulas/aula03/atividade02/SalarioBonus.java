package atividadesAulas.aula03.atividade02;

public class SalarioBonus {

    static double calcularBonus(double salario, double bonus) {
        return salario + (salario * bonus);
    }

    public static void main(String[] args) {

        double salario = 2500.00;
        double bonus = 0.15;

        System.out.println("Calculando salario com bonus...");

        System.out.print("O valor do salario + bonus eh: R$ ");
        System.out.println(calcularBonus(salario, bonus));

    }

}