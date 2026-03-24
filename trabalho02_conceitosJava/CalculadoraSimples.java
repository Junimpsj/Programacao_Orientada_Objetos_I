package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Calculadora simples que realiza operações matemáticas básicas.
 * Suporta adição, subtração, multiplicação e divisão com tratamento de exceções.
 */
public class CalculadoraSimples {

    /**
     * Realiza uma operação matemática entre dois números.
     * Trata exceção em caso de divisão por zero.
     * @param numero1 Primeiro número da operação
     * @param numero2 Segundo número da operação
     * @param operador Operação a ser realizada (+, -, *, /)
     * @return Resultado da operação ou 0 em caso de erro
     * @throws ArithmeticException Se houver divisão por zero
     */
    public static float calcular(float numero1, float numero2, String operador) {

        switch(operador) {

            case "+":
                return numero1 + numero2;

            case "-":
                return numero1 - numero2;

            case "*":
                return numero1 * numero2;

            case "/":
                try {
                    if(numero2 == 0) {
                        throw new ArithmeticException("Divisão por zero!");
                    }
                    return numero1 / numero2;
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                    return 0;
                }

            default:
                System.out.println("Insira uma operação válida! (+, -, *, /)");
                return 0;

        }

    }
    
    /**
     * Método principal que executa a calculadora.
     * Lê dois números e uma operação do usuário, calcula e exibe o resultado.
     * Trata exceções de entrada inválida e garante fechamento do Scanner.
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("------ Calculadora Básica ------\n");

        try {
            System.out.print("Insira o primeiro número: ");
            float numero1 = Float.parseFloat(entrada.nextLine());

            System.out.print("Qual a operação? (+, -, *, /) | ");
            String operador = entrada.nextLine();

            System.out.print("Insira o segundo número: ");
            float numero2 = Float.parseFloat(entrada.nextLine());

            float resultado = calcular(numero1, numero2, operador);

            System.out.println();
            System.out.println("O resultado da operação foi: " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro: insira números válidos!");
        } catch (Exception e) {
            System.out.println("Erro: operação inválida!");
        } finally {
            entrada.close();
        }

    }

}