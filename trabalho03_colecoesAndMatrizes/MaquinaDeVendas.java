package trabalho03_colecoesAndMatrizes;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe que simula uma máquina de venda automática.
 * Permite comprar chiclete, chocolate, pipoca e suco.
 * Mantém histórico de compras e exibe relatórios de vendas.
 */
public class MaquinaDeVendas {
    
    /**
     * Exibe o menu com as opções disponíveis na máquina de venda.
     */
    public static void exibirOpcoes() {

        System.out.println("------ Máquina de Vendas ------ \n");

        System.out.println("Escolha umas das opções:");
        System.out.println("[1] - Comprar chiclete");
        System.out.println("[2] - Comprar chocolate");
        System.out.println("[3] - Comprar pipoca");
        System.out.println("[4] - Comprar suco");
        System.out.println("[5] - Exibir total vendido");
        System.out.println("[6] - Exibir histórico de compras");
        System.out.println("[7] - Sair");
        System.out.println();

    }

    /**
     * Confirma a venda de um produto e atualiza o contador de vendas.
     * 
     * @param nomeProduto O nome do produto comprado
     * @param tabelaProdutos Matriz contendo código, quantidade vendida e preço de cada produto
     * @param produtos ArrayList que armazena o histórico de compras
     */
    public static void confirmacaoVenda(String nomeProduto, double[][] tabelaProdutos, ArrayList<String> produtos) {

        System.out.println("Compra Confirmada: [" + nomeProduto + "] - Aqui está! \n");

        switch(nomeProduto) {

            case "Chiclete":
                tabelaProdutos[0][1]++;
            break;

            case "Chocolate":
                tabelaProdutos[1][1]++;
            break;

            case "Pipoca":
                tabelaProdutos[2][1]++;
            break;

            case "Suco":
                tabelaProdutos[3][1]++;
            break;

        }

        produtos.add(nomeProduto);
        
    }

    /**
     * Exibe a quantidade vendida de cada produto até o momento.
     * 
     * @param tabelaProdutos Matriz contendo código, quantidade vendida e preço de cada produto
     */
    public static void exibirQuantidadeVendida(double[][] tabelaProdutos) {

        System.out.println("------ Confira as quantidades vendidas ------ \n");

        System.out.println("Unidades vendidas de Chiclete -  [" + tabelaProdutos[0][1] + "]");
        System.out.println("Unidades vendidas de Chocolate - [" + tabelaProdutos[1][1] + "]");
        System.out.println("Unidades vendidas de Pipoca -    [" + tabelaProdutos[2][1] + "]");
        System.out.println("Unidades vendidas de Suco -      [" + tabelaProdutos[3][1] + "]");
        System.out.println();

    }

    /**
     * Exibe o histórico de compras realizadas na ordem em que foram feitas.
     * 
     * @param produtos ArrayList contendo o histórico de compras
     */
    public static void exibirHistorico(ArrayList<String> produtos) {
        
        System.out.println("------ Histórico de Compras ------\n");

        if(produtos.size() == 0) {
            System.out.print("Historico Vazio! ");
        }

        for(String produto : produtos) {
            System.out.print(produto + "-> ");
        }

        System.out.print("| FIM! \n");

        System.out.println();

    }

    /**
     * Calcula e exibe um relatório final de vendas contendo:
     * quantidade vendida de cada produto, total por produto e total geral arrecadado.
     * 
     * @param tabelaProdutos Matriz contendo código, quantidade vendida e preço de cada produto
     */
    public static void calcularVendasRelatorio (double[][] tabelaProdutos) {

        System.out.println("------ Relatório Final de Vendas ------ \n");

        // quantidade vendida de cada produto e total arrecadado por cada um
        System.out.println("Unidades vendidas de Chiclete -  [" + tabelaProdutos[0][1] + "] | Total Produto: R$" + (tabelaProdutos[0][1] * tabelaProdutos[0][2]));
        System.out.println("Unidades vendidas de Chocolate - [" + tabelaProdutos[1][1] + "] | Total Produto: R$" + (tabelaProdutos[1][1] * tabelaProdutos[1][2]));
        System.out.println("Unidades vendidas de Pipoca -    [" + tabelaProdutos[2][1] + "] | Total Produto: R$" + (tabelaProdutos[2][1] * tabelaProdutos[2][2]));
        System.out.println("Unidades vendidas de Suco -      [" + tabelaProdutos[3][1] + "] | Total Produto: R$" + (tabelaProdutos[3][1] * tabelaProdutos[3][2]));
        System.out.println();

        // total arrecadado
        double totalArrecadado = (tabelaProdutos[0][1] * tabelaProdutos[0][2]) + (tabelaProdutos[1][1] * tabelaProdutos[1][2])
        + (tabelaProdutos[2][1] * tabelaProdutos[2][2] + (tabelaProdutos[3][1] * tabelaProdutos[3][2]));

        System.out.println("Total Geral Arrecadado - R$" + totalArrecadado);

    }

    /**
     * Método principal que executa a máquina de venda automática.
     * Controla o loop principal de interação com o usuário.
     * 
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcaoVenda;
        String nomeProduto;
        ArrayList<String> produtos = new ArrayList<>();

        double[][] tabelaProdutos = new double[4][3];

        /* vou registrar o codigo dos produtos e o valor na mao pois eh um dado que nao vamos precisar
        editar depois entao nao vai afetar nosso sistema nesse caso e vai ser mais tranquilo assim
        
        e o codigo vai ser estilo ID 1, 2, 3 e 4 so pra representar mesmo */

        // codigos dos produtos
        tabelaProdutos[0][0] = 1; // [0][j] = chiclete
        tabelaProdutos[1][0] = 2; // [1][j] = chocolate
        tabelaProdutos[2][0] = 3; // [2][j] = pipoca
        tabelaProdutos[3][0] = 4; // [3][j] = suco

        // preco unitario
        tabelaProdutos[0][2] = 2.0; // chiclete trident
        tabelaProdutos[1][2] = 5.0; // suflair
        tabelaProdutos[2][2] = 7.5; // saco de pipoca gourmet
        tabelaProdutos[3][2] = 4.7; // suco de caixinha grande


        do {

            exibirOpcoes();
            System.out.print("Insira sua opção: ");

            try {
                opcaoVenda = Integer.parseInt(sc.nextLine());
                if (opcaoVenda < 1 || opcaoVenda > 7) {
                    System.out.println("Escolha um opção válida entre 1 e 7!");
                    System.out.println();
                }
            } catch(NumberFormatException e) {
                System.out.println("Erro " + e.getMessage() + ": Insira um número válido!");
                System.out.println();
                opcaoVenda = 0;
            }

            switch(opcaoVenda) {

                case 1:

                    nomeProduto = "Chiclete";
                    confirmacaoVenda(nomeProduto, tabelaProdutos, produtos);

                break;

                case 2:

                    nomeProduto = "Chocolate";
                    confirmacaoVenda(nomeProduto, tabelaProdutos, produtos);

                break;

                case 3:

                    nomeProduto = "Pipoca";
                    confirmacaoVenda(nomeProduto, tabelaProdutos, produtos);

                break;

                case 4:

                    nomeProduto = "Suco";
                    confirmacaoVenda(nomeProduto, tabelaProdutos, produtos);

                break;

                case 5:

                    exibirQuantidadeVendida(tabelaProdutos);

                break;

                case 6:

                    exibirHistorico(produtos);

                break;

            }

        } while(opcaoVenda != 7);

        System.out.println();
        calcularVendasRelatorio(tabelaProdutos);

        System.out.println();
        System.out.println("Obrigado por utilizar! \nEncerrando...");
        
        sc.close();

    }

}
