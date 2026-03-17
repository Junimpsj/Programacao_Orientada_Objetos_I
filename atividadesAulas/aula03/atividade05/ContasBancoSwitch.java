package atividadesAulas.aula03.atividade05;
import java.util.Scanner;

public class ContasBancoSwitch {
    
    static void calcularJuros(double valor, char tipoConta) {

        double tipoA = 0.015;
        double tipoB = 0.02;
        double tipoC = 0.015;
        double tipoX = 0.05;

        switch(tipoConta) {

            case 'A':
            case 'a':
                System.out.println(valor * tipoA);
                break;

            case 'B':
            case 'b':
                System.out.println(valor * tipoB);
                break;

            case 'C':
            case 'c':
                System.out.println(valor * tipoC);
                break;

            case 'X':
            case 'x':
                System.out.println(valor * tipoX);
                break;
            
            default:
                System.out.println("Ocorreu um erro com o calculo dos juros!");
        }

    }

    public static void main(String[] args) throws InterruptedException{

        Scanner entrada = new Scanner(System.in);

        System.out.println("-------- Bem-vindo ao simulador de investimentos! -------- \n");
        System.out.println("Para simular, insira as seguintes informações...");

        System.out.print("Valor a investir: R$ ");
        double valor = entrada.nextDouble();

        System.out.print("Tipo da conta (A, B, C ou X): ");
        char tipoConta = entrada.next().charAt(0);

        entrada.close();
    
        switch(tipoConta) {

            case 'A': case 'a':
            case 'B': case 'b':
            case 'C': case 'c':
            case 'X': case 'x':
                System.out.println("Calculando...");
                Thread.sleep(1800);
                System.out.print("Após um (01) ano você haverá ganho em juros R$");
                calcularJuros(valor, tipoConta);
                
             break;

            default:
                System.out.println("Insira um tipo válido de conta! Apenas A, B, C ou X");

        }

    }

}