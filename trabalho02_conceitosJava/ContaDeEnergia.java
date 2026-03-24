package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Classe que calcula a conta de energia elétrica para vários consumidores.
 * Considera diferentes tarifas de acordo com o tipo de instalação (residencial, comercial ou industrial)
 * e aplica descontos e taxas conforme o consumo total.
 */
public class ContaDeEnergia {

    /**
     * Insere os dados de consumo e tipo de instalação de cada consumidor.
     * Valida se o consumo é maior que 0 e se o tipo é válido (R, C ou I).
     * 
     * @param sc Scanner para leitura das entradas do usuário
     * @param consumidores Matriz bidimensional que armazena consumo e tipo de instalação
     */
    public static void inserirDados(Scanner sc, String[][] consumidores) {

        for(int i = 0 ; i < consumidores[0].length ; i++) {

            int consumo = -1;

            do {

                try {

                    System.out.print("Insira o consumo do " + (i+1) + "° cliente em kWh: ");
                    consumo = Integer.parseInt(sc.nextLine());
                    
                    if(consumo < 1) {
                        System.out.println("Insira um consumo válido! (maior que 0)\n");
                    } else {
                        consumidores[0][i] = String.valueOf(consumo);
                        break;
                    }

                } catch(NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número.\n");
                }

            } while(true);
            

            do {

                System.out.print("Insira a inicial do tipo de instalação - Residencial, Comercial ou Industrial: ");
                String tipo = sc.nextLine().toUpperCase();
                
                if(tipo.equals("R") || tipo.equals("C") || tipo.equals("I")) {
                    consumidores[1][i] = tipo;
                    System.out.println();
                    break;

                } else {
                    System.out.println("Entrada inválida! Use R, C ou I.\n");
                }
                
            } while(true);
        }

    }

    /**
     * Calcula o valor da conta de energia de forma progressiva por faixa de consumo.
     * Aplica desconto de 5% se consumo > 300 kWh e taxa fixa de R$ 50 se consumo > 500 kWh.
     * 
     * @param consumo Consumo em kWh
     * @param tipo Tipo de instalação: 'R' (residencial), 'C' (comercial) ou 'I' (industrial)
     * @return Valor total da conta a pagar
     */
    public static double calcularConta(int consumo, char tipo) {
        double valor = 0;
        
        if(tipo == 'R') { 
            if(consumo <= 100) {
                valor = consumo * 0.50;
            } else {
                valor = (100 * 0.50) + ((consumo - 100) * 0.75);
            }
        } 
        else if(tipo == 'C') {
            if(consumo <= 200) {
                valor = consumo * 0.65;
            } else {
                valor = (200 * 0.65) + ((consumo - 200) * 0.80);
            }
        } 
        else if(tipo == 'I') {
            if(consumo <= 500) {
                valor = consumo * 0.55;
            } else {
                valor = (500 * 0.55) + ((consumo - 500) * 0.70);
            }
        }
        
        if(consumo > 300) {
            valor *= 0.95;
        }
        
        if(consumo > 500) {
            valor += 50;
        }
        
        return valor;
    }

    /**
     * Método principal que controla o fluxo do programa.
     * Solicita dados dos consumidores, calcula as contas e exibe o relatório com estatísticas.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------ Eletropaula Paulista ------\n");

        System.out.print("Quantos consumidores vamos registrar? | ");
        int qtdConsumidores = Integer.parseInt(sc.nextLine());

        if(qtdConsumidores < 1) {
            do {

                System.out.println();
                System.out.println("Insira uma quantidade válida! (maior que 0)");

                System.out.print("Quantos consumidores vamos registrar? | ");
                qtdConsumidores = Integer.parseInt(sc.nextLine());

                if(qtdConsumidores > 0) {
                    break;
                }

            } while (true);
        }

        String[][] consumidores = new String[2][qtdConsumidores];

        System.out.println();
        inserirDados(sc, consumidores);

        double[] contas = new double[qtdConsumidores];

        for(int i = 0 ; i < qtdConsumidores ; i++) {
            int consumo = Integer.parseInt(consumidores[0][i]);
            char tipo = consumidores[1][i].charAt(0);
            contas[i] = calcularConta(consumo, tipo);
        }

        System.out.println("\n------ RELATÓRIO DE CONTAS ------\n");

        for(int i = 0 ; i < qtdConsumidores ; i++) {
            System.out.println("Cliente " + (i+1) + ":");
            System.out.println("Tipo de instalação: " + consumidores[1][i]);
            System.out.println("Consumo: " + consumidores[0][i] + " kWh");
            System.out.printf("Valor a pagar: R$ %.2f\n\n", contas[i]);
        }

        double maior = contas[0];
        double menor = contas[0];
        double soma = 0;

        for(int i = 0 ; i < qtdConsumidores ; i++) {
            if(contas[i] > maior) {
                maior = contas[i];
            }
            if(contas[i] < menor) {
                menor = contas[i];
            }
            soma += contas[i];
        }

        double media = soma / qtdConsumidores;
        int acimaDaMedia = 0;

        for(int i = 0 ; i < qtdConsumidores ; i++) {
            if(contas[i] > media) {
                acimaDaMedia++;
            }
        }

        System.out.println("------ ESTATÍSTICAS ------");
        System.out.printf("Maior valor: R$ %.2f\n", maior);
        System.out.printf("Menor valor: R$ %.2f\n", menor);
        System.out.printf("Média das contas: R$ %.2f\n", media);
        System.out.println("Quantidade acima da média: " + acimaDaMedia);

        sc.close();

    }

}