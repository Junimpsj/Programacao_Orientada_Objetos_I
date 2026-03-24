package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Classe que calcula tarifas de estacionamento baseado no tipo de veículo,
 * número de horas estacionadas e se é fim de semana.
 * 
 * Preços: Carro R$ 8/hora, Moto R$ 5/hora
 * Desconto de 10% se passou de 5 horas
 * Acrescimo de 5% se for fim de semana
 */
public class TarifasEstacionamento {

    /**
     * Calcula a tarifa do estacionamento de acordo com o tipo de veículo,
     * número de horas e se é final de semana.
     * 
     * @param horas o número de horas estacionadas (deve ser maior que 0)
     * @param tipoVeiculo o tipo de veículo ('C' para carro ou 'M' para moto)
     * @param finalDeSemana 'S' ou 's' se for fim de semana, 'N' ou 'n' caso contrário
     * @return o valor da tarifa a pagar em reais
     */
    public static double calcularTarifa(double horas, char tipoVeiculo, char finalDeSemana) {

        double valorFinal;

        switch(tipoVeiculo) {

            case 'C':
            case 'c':
                if(horas <= 0) {
                    return 0.0;
                }

                valorFinal = horas * 8;

                if(horas > 5) {
                    valorFinal = valorFinal * 0.9;
                }

                if(finalDeSemana == 'S' || finalDeSemana == 's') {
                    valorFinal = valorFinal * 1.05;
                }

                return valorFinal;

            case 'M':
            case 'm':
                if(horas <= 0) {
                    return 0.0;
                }

                valorFinal = horas * 5;

                if(horas > 5) {
                    valorFinal = valorFinal * 0.9;
                }

                if(finalDeSemana == 'S' || finalDeSemana == 's') {
                    valorFinal = valorFinal * 1.05;
                }

                return valorFinal;

            default:
                System.out.println("Tipo de Veiculo Invalido!");
                return 0.0;

        }

    }
    
    /**
     * Método principal que inicia o programa de cálculo de tarifas de estacionamento.
     * Interage com o usuário para coletar informações sobre o estacionamento
     * e exibe o valor final a pagar.
     * 
     * @param args argumentos da linha de comando (não utilizado)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------ Tarifas do Estacionamento ------");
        System.out.println("OBS: Utilize 'C' para Carros e 'M' para Motos \n");

        System.out.print("Tempo de horas estacionadas: ");
        double horas = Double.parseDouble(sc.nextLine());
        if(horas <= 0) {System.out.println("Quantidade de horas invalidas!"); sc.close(); return;}

        System.out.print("Qual o tipo do veiculo? (C ou M): ");
        char tipoVeiculo = sc.next().charAt(0);
        if(tipoVeiculo != 'C' && tipoVeiculo != 'c' && tipoVeiculo != 'M' && tipoVeiculo != 'm') {System.out.println("Tipo de veiculo invalido!"); sc.close(); return;}

        System.out.print("É final de semana? (S ou N): ");
        char finalDeSemana = sc.next().charAt(0);
        if(finalDeSemana != 'S' && finalDeSemana != 's' && finalDeSemana != 'N' && finalDeSemana != 'n') {System.out.println("Entrada invalida!"); sc.close(); return;}

        double tarifa = calcularTarifa(horas, tipoVeiculo, finalDeSemana);

        System.out.println();
        System.out.println("Calculando...");
        System.out.println("Sua tarifa do estacionamento ficou no valor de R$" + tarifa);

        sc.close();

     }
    
}