package trabalho01_introJava;
/**
 * Classe Calculadora - Única e Principal da Aplicação <br>
 * 
 * Descrição: Classe calculadora que abriga métodos de operações básicas como:
 * somar, dividir, subtrair e multiplicar.
 * 
 * Autor: Paulo Celso
 * Data: 06_03_2026
 * Versão: v1_beta
 */

public class Calculadora {
    
    /**
     * Método Somar - Calcula a soma entre dois números inteiros
     * @param a Primeiro valor inteiro a ser somado
     * @param b Segundo valor inteiro inteiro a ser somado
     * @return Retorna o valor da soma dos dois inteiros recebidos pela função
     */
    public static int somar(int a, int b) {
        return a + b;
    }

     /**
      * Método Dividir - Calcula a divisão entre dois números inteiros <br>
      * Observação: Não inserir Zero (0) no divisor da operação, assim como na matemática comum é impossível dividir por zero <br>
      * Você receberá um erro de execução do programa "ArithmeticException" caso faça isso
      * @param a Valor inteiro inserido no dividendo da operação
      * @param b Valor inteiro inserido no divisor da operação
      * @return Retorna o valor proveniente da divisão entre os dois inteiros recebidos pela função (quociente)
      */
    public static int dividir(int a, int b) {
        return a / b;
    }

    /**
     * Método Subtrair - Calcula a subtração entre dois números inteiros
     * @param a Valor inteiro inserido no minuendo da operação
     * @param b Valor inteiro inserido no subtraendo da operação
     * @return Retorna o valor proveniente da subtração entre os dois inteiros (resto ou diferença)
     */
    public static int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Método Multiplicar - Calcula a multiplicação entre dois inteiros
     * @param a Primeiro valor inteiro inserido na multiplicação
     * @param b Segundo valor inteiro inserido na multiplicação
     * @return Retorna o valor proveniente da multiplicação entre os dois inteiros (produto)
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Método Principal da Aplicação <br>
     * Assim que o programa começar a rodar, esse é o método que vai ser procurado para iniciar a execução
     * @param args Recebe parametros pela linha de comando interna do programa Java
     */
    public static void main(String[] args) {
        int resultado1 = somar(10, 5);
        int resultado2 = dividir(10, 2);

        int resultado3 = subtrair(50, 30);
        int resultado4 = multiplicar(12, 12);

        System.out.println(resultado1);
        System.out.println(resultado2);
        System.out.println(resultado3);
        System.out.println(resultado4);
    }
}