package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Simulador de Empréstimo Bancário.
 * Calcula o valor total a pagar e o valor de cada parcela baseado no tipo de cliente,
 * valor do empréstimo e número de parcelas.
 * 
 * Cliente Comum: 2,5% de juros ao mês, máximo 24 parcelas
 * Cliente Premium: 1,5% de juros ao mês, máximo 36 parcelas
 */
public class EmprestimoBancario {
    
    /**
     * Lê os dados do empréstimo do usuário.
     * @param sc Scanner para ler entrada do usuário
     * @return Vetor contendo [valorEmprestimo, numParcelas, tipoCliente]
     */
    public static Object[] inserirDados(Scanner sc) {
        
        System.out.print("Valor do empréstimo: R$ ");
        double valorEmprestimo = Double.parseDouble(sc.nextLine());
        
        System.out.print("Número de parcelas: ");
        int numParcelas = Integer.parseInt(sc.nextLine());
        
        System.out.print("Tipo de cliente (C para Comum, P para Premium): ");
        char tipoCliente = sc.next().charAt(0);
        
        return new Object[] { valorEmprestimo, numParcelas, tipoCliente };
    }
    
    /**
     * Valida se os dados inseridos estão corretos.
     * @param valorEmprestimo Valor do empréstimo
     * @param numParcelas Número de parcelas desejadas
     * @param tipoCliente Tipo de cliente
     * @return true se os dados são válidos, false caso contrário
     */
    public static boolean validarDados(double valorEmprestimo, int numParcelas, char tipoCliente) {
        
        if(valorEmprestimo <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }
        
        if(numParcelas <= 0) {
            System.out.println("Número de parcelas inválido!");
            return false;
        }
        
        if(tipoCliente != 'C' && tipoCliente != 'c' && tipoCliente != 'P' && tipoCliente != 'p') {
            System.out.println("Tipo inválido!");
            return false;
        }
        
        int limiteParcelas;
        
        if(tipoCliente == 'C' || tipoCliente == 'c') {
            limiteParcelas = 24;
        } else {
            limiteParcelas = 36;
        }
        
        if(numParcelas > limiteParcelas) {
            System.out.println("Número de parcelas excede o limite permitido!");
            return false;
        }
        
        return true;
    }
    
    /**
     * Calcula o valor total a pagar e o valor de cada parcela.
     * @param valorEmprestimo Valor do empréstimo
     * @param numParcelas Número de parcelas
     * @param tipoCliente Tipo de cliente
     * @return Vetor contendo [valorTotalAPagar, valorParcela]
     */
    public static double[] calcularEmprestimo(double valorEmprestimo, int numParcelas, char tipoCliente) {
        
        double taxaJuros;
        
        if(tipoCliente == 'C' || tipoCliente == 'c') {
            taxaJuros = 0.025;
        } else {
            taxaJuros = 0.015;
        }
        
        double valorJuros = valorEmprestimo * taxaJuros * numParcelas;
        double valorTotalAPagar = valorEmprestimo + valorJuros;
        double valorParcela = valorTotalAPagar / numParcelas;
        
        return new double[] { valorTotalAPagar, valorParcela };
    }
    
    /**
     * Exibe o resultado do cálculo do empréstimo.
     * @param valorEmprestimo Valor do empréstimo
     * @param numParcelas Número de parcelas
     * @param tipoCliente Tipo de cliente
     * @param valorTotalAPagar Valor total a pagar
     * @param valorParcela Valor de cada parcela
     */
    public static void exibirResultados(double valorEmprestimo, int numParcelas, char tipoCliente,
                                         double valorTotalAPagar, double valorParcela) {
        
        String nomeCliente;
        
        if(tipoCliente == 'C' || tipoCliente == 'c') {
            nomeCliente = "Comum";
        } else {
            nomeCliente = "Premium";
        }
        
        System.out.println();
        System.out.println("------ Resultado do Empréstimo ------");
        System.out.println("Tipo de Cliente: " + nomeCliente);
        System.out.println("Valor do Empréstimo: R$ " + valorEmprestimo);
        System.out.println("Número de Parcelas: " + numParcelas);
        System.out.println("Valor Total a Pagar: R$ " + String.format("%.2f", valorTotalAPagar));
        System.out.println("Valor de Cada Parcela: R$ " + String.format("%.2f", valorParcela));
    }
    
    /**
     * Método principal que executa o simulador de empréstimo bancário.
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------ Simulador de Empréstimo Bancário ------\n");

        Object[] dadosEmprestimo = inserirDados(sc);
        double valorEmprestimo = (double) dadosEmprestimo[0];
        int numParcelas = (int) dadosEmprestimo[1];
        char tipoCliente = (char) dadosEmprestimo[2];
        
        System.out.println();
        
        if(!validarDados(valorEmprestimo, numParcelas, tipoCliente)) {
            sc.close();
            return;
        }
        
        System.out.println("\nCalculando...");
        
        double[] resultado = calcularEmprestimo(valorEmprestimo, numParcelas, tipoCliente);
        double valorTotalAPagar = resultado[0];
        double valorParcela = resultado[1];
        
        exibirResultados(valorEmprestimo, numParcelas, tipoCliente, valorTotalAPagar, valorParcela);
        
        sc.close();

    }

}