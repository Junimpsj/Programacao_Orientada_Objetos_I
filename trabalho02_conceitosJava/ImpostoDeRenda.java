package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Sistema de cálculo de imposto de renda.
 * Calcula o imposto bruto, taxa e salário líquido de um grupo de colaboradores.
 */
public class ImpostoDeRenda {

    /**
     * Lê os salários brutos de cada colaborador.
     * @param entrada Scanner para ler entrada do usuário
     * @param salarioBruto Vetor para armazenar os salários brutos
     */
    public static void inserirSalarios(Scanner entrada, double[] salarioBruto) {
        for(int i = 0 ; i < salarioBruto.length ; i++) {
            System.out.print("Insira o salário da " + (i+1) + "° pessoa: R$ ");
            salarioBruto[i] = entrada.nextDouble();
        }
    }
    
    /**
     * Calcula a taxa de imposto conforme faixa salarial.
     * @param salarioBruto Vetor com salários brutos
     * @param taxaImposto Vetor para armazenar a taxa de cada colaborador
     */
    public static void calcularFaixaImposto(double[] salarioBruto, double[] taxaImposto) {
        for(int i = 0 ; i < taxaImposto.length ; i++) {
            if(salarioBruto[i] >= 2000.01 && salarioBruto[i] <= 3500) {
                taxaImposto[i] = 0.08;
            } else if(salarioBruto[i] >= 3500.01 && salarioBruto[i] <= 5000) {
                taxaImposto[i] = 0.15;
            } else if(salarioBruto[i] > 5000) {
                taxaImposto[i] = 0.22;
            } else {
                taxaImposto[i] = 0.0;
            }
        }
    }

    /**
     * Calcula o valor absoluto do imposto (salário bruto * taxa).
     * @param salarioBruto Vetor com salários brutos
     * @param taxaImposto Vetor com as taxas de imposto
     * @param valorImposto Vetor para armazenar o valor do imposto calculado
     */
    public static void calcularImposto(double[] salarioBruto, double[] taxaImposto, double[] valorImposto) {
        for(int i = 0 ; i < valorImposto.length ; i++) {
            valorImposto[i] = salarioBruto[i] * taxaImposto[i];
        }
    }

    /**
     * Calcula o salário líquido (salário bruto - valor do imposto).
     * @param salarioBruto Vetor com salários brutos
     * @param valorImposto Vetor com valores do imposto calculado
     * @param salarioLiquido Vetor para armazenar os salários líquidos
     */
    public static void calcularLiquido(double[] salarioBruto, double[] valorImposto, double[] salarioLiquido) {
        for(int i = 0 ; i < salarioLiquido.length ; i++) {
            salarioLiquido[i] = salarioBruto[i] - valorImposto[i];
        }
    }

    /**
     * Exibe o resultado do cálculo para cada colaborador.
     * @param valorImposto Vetor com valores do imposto
     * @param salarioLiquido Vetor com salários líquidos
     * @param taxaImposto Vetor com as taxas de imposto aplicadas
     */
    public static void exibirResultados(double[] valorImposto, double[] salarioLiquido, double[] taxaImposto) {
        System.out.println("Cálculo do imposto feito! Verifique as informações abaixo:");
        for(int i = 0 ; i < salarioLiquido.length ; i++) {
            System.out.println("Funcionário " + (i+1) + ": Salário Liquido - R$" + salarioLiquido[i] + 
            " | Valor Pago em Imposto - R$" + valorImposto[i] + " | Taxa Aplicada: " + taxaImposto[i]);
        }
    }

    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("------ Sistema de Cálculo de Impostos ------\n");

        System.out.print("Insira a quantidade de pessoas/colaboradores: ");
        int qtdPessoas = entrada.nextInt();
        if(qtdPessoas < 1) {
            System.out.println("Insira um número válido maior que zero!");
            return;
        }

        //criei vários vetores pois quero armazenar separadamente cada uma das informações, pra mim fica mais fácil de manipular assim
        double[] salarioLiquido = new double[qtdPessoas];
        double[] salarioBruto = new double[qtdPessoas];
        double[] valorImposto = new double[qtdPessoas];
        double[] taxaImposto = new double[qtdPessoas];

        inserirSalarios(entrada, salarioBruto);
        calcularFaixaImposto(salarioBruto, taxaImposto);
        calcularImposto(salarioBruto, taxaImposto, valorImposto);

        System.out.println();

        calcularLiquido(salarioBruto, valorImposto, salarioLiquido);

        exibirResultados(valorImposto, salarioLiquido, taxaImposto);

        entrada.close();
    }

}