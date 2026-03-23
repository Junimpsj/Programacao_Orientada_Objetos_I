package atividadesAulas.aula09;
import java.util.Scanner;

public class CalcularIMC {

    static void inserirDados(Scanner entrada, String[] dados) {
        System.out.print("Nome completo: ");
        dados[0] = entrada.nextLine();

        boolean pesoValido = false;
        while (!pesoValido) {
            try {
                System.out.print("Peso (kg): ");
                dados[1] = entrada.nextLine();
                Float.parseFloat(dados[1]);
                pesoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: informe um número válido para o peso.");
            }
        }

        boolean alturaValida = false;
        while (!alturaValida) {
            try {
                System.out.print("Altura (m): ");
                dados[2] = entrada.nextLine();
                float altura = Float.parseFloat(dados[2]);
                if (altura == 0) {
                    System.out.println("Erro: a altura não pode ser zero.");
                } else {
                    alturaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: informe um número válido para a altura.");
            }
        }
    }

    static float calcularIMC(float peso, float altura) {
        try {
            if (altura == 0) throw new ArithmeticException("Altura não pode ser zero.");
            return peso / (altura * altura);
        } catch (ArithmeticException e) {
            System.out.println("Erro no cálculo: " + e.getMessage());
            return -1;
        }
    }

    static void exibirDados(String nome, float peso, float altura, float imc) {
        System.out.println("\n------ Resultado ------");
        System.out.println("Nome   : " + nome);
        System.out.printf("Peso   : %.1f kg%n", peso);
        System.out.printf("Altura : %.2f m%n", altura);
        System.out.printf("IMC    : %.2f%n", imc);
        System.out.println("Status : " + classificarIMC(imc));
    }

    static String classificarIMC(float imc) {
        if      (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25.0) return "Peso normal";
        else if (imc < 30.0) return "Sobrepeso";
        else if (imc < 35.0) return "Obesidade grau I";
        else if (imc < 40.0) return "Obesidade grau II";
        else                 return "Obesidade grau III";
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] dados = new String[3];

        System.out.println("------ Calculo de IMC ------\n");
        inserirDados(entrada, dados);

        String nome  = dados[0];
        float peso   = Float.parseFloat(dados[1]);
        float altura = Float.parseFloat(dados[2]);
        float imc    = calcularIMC(peso, altura);

        if (imc != -1) {
            exibirDados(nome, peso, altura, imc);
        }

        entrada.close();
    }
}