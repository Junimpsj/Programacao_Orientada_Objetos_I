package trabalho04_arquivosJava;
import java.util.Scanner;
import java.io.*;

/**
 * Classe que gerencia operações em arquivos de texto.
 * Permite escrever, ler, adicionar linhas, contar linhas e buscar palavras.
 * Suporta criação e acesso a diferentes arquivos dinamicamente.
 * 
 * Trabalho desenvolvido em dupla por Paulo Celso dos Santos Júnior e Kauan Abrantes Medeiros
 */
public class GerenciadorArquivos {

    /**
     * Exibe o menu com as opções disponíveis no gerenciador.
     * 
     * @param nomeArquivo Nome do arquivo atualmente selecionado
     */
    public static void exibirOpcoes(String nomeArquivo) {

        System.out.println("------ Gerenciador de Arquivos ------\n");
        System.out.println("Arquivo selecionado: [" + nomeArquivo + "]\n");

        System.out.println("Escolha uma das opções:");
        System.out.println("[1] - Escrever texto no arquivo (sobrescreve)");
        System.out.println("[2] - Ler conteúdo do arquivo");
        System.out.println("[3] - Adicionar novas linhas ao arquivo");
        System.out.println("[4] - Contar número de linhas do arquivo");
        System.out.println("[5] - Buscar palavra no arquivo");
        System.out.println("[6] - Trocar arquivo");
        System.out.println("[7] - Sair");
        System.out.println();

    }

    /**
     * Solicita o nome do arquivo ao usuário e verifica se ele já existe.
     * Se existir, informa que será acessado; se não existir, cria um novo arquivo vazio.
     * 
     * @param sc Scanner para leitura da entrada do usuário
     * @return O nome do arquivo selecionado/criado
     */
    public static String selecionarArquivo(Scanner sc) {

        System.out.print("Digite o nome do arquivo (ex: notas.txt): ");
        String nomeArquivo = sc.nextLine().trim();

        File arquivo = new File(nomeArquivo);

        if(arquivo.exists()) {
            System.out.println("Arquivo [" + nomeArquivo + "] encontrado! Acessando...\n");
        } else {
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo [" + nomeArquivo + "] não encontrado. Criando novo arquivo...\n");
            } catch(IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        }

        return nomeArquivo;

    }

    /**
     * Escreve um texto no arquivo, sobrescrevendo todo o conteúdo existente.
     * O usuário digita o texto que deseja inserir via terminal.
     * 
     * @param nomeArquivo Nome do arquivo onde o texto será escrito
     * @param sc Scanner para leitura da entrada do usuário
     * @throws IOException Se ocorrer um erro de entrada/saída no arquivo
     */
    public static void escreverTexto(String nomeArquivo, Scanner sc) throws IOException {

        System.out.println("------ Escrever no Arquivo ------\n");
        System.out.println("ATENÇÃO: O conteúdo atual do arquivo será sobrescrito!");
        System.out.print("Digite o texto a ser escrito: ");
        String texto = sc.nextLine();

        // try-with-resources garante o fechamento automático do arquivo
        try(FileWriter fw = new FileWriter(nomeArquivo, false);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(texto);
            System.out.println("Texto escrito com sucesso em [" + nomeArquivo + "]!\n");

        }

    }

    /**
     * Lê o conteúdo do arquivo linha a linha e exibe no console.
     * Caso o arquivo esteja vazio, informa o usuário.
     * 
     * @param nomeArquivo Nome do arquivo a ser lido
     * @throws IOException Se ocorrer um erro de entrada/saída no arquivo
     */
    public static void lerConteudo(String nomeArquivo) throws IOException {

        System.out.println("------ Conteúdo do Arquivo: [" + nomeArquivo + "] ------\n");

        // try-with-resources garante o fechamento automático do arquivo
        try(FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean arquivoVazio = true;

            while((linha = br.readLine()) != null) {
                System.out.println(linha);
                arquivoVazio = false;
            }

            if(arquivoVazio) {
                System.out.println("[Arquivo vazio!]");
            }

        }

        System.out.println();

    }

    /**
     * Adiciona novas linhas ao final do arquivo sem sobrescrever o conteúdo existente.
     * O usuário digita o texto que deseja inserir via terminal.
     * 
     * @param nomeArquivo Nome do arquivo onde as linhas serão adicionadas
     * @param sc Scanner para leitura da entrada do usuário
     * @throws IOException Se ocorrer um erro de entrada/saída no arquivo
     */
    public static void adicionarNovasLinhas(String nomeArquivo, Scanner sc) throws IOException {

        System.out.println("------ Adicionar Linhas ao Arquivo ------\n");
        System.out.print("Digite o texto a ser adicionado: ");
        String novoTexto = sc.nextLine();

        // o segundo parametro 'true' no FileWriter ativa o modo append (não sobrescreve)
        try(FileWriter fw = new FileWriter(nomeArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.newLine(); // pula linha antes de adicionar o novo conteúdo
            bw.write(novoTexto);
            System.out.println("Conteúdo adicionado com sucesso em [" + nomeArquivo + "]!\n");

        }

    }

    /**
     * Conta e exibe o número total de linhas do arquivo.
     * Linhas em branco também são contabilizadas.
     * 
     * @param nomeArquivo Nome do arquivo a ter suas linhas contadas
     * @throws IOException Se ocorrer um erro de entrada/saída no arquivo
     */
    public static void contarLinhas(String nomeArquivo) throws IOException {

        System.out.println("------ Contar Linhas do Arquivo ------\n");

        try(FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr)) {

            int totalLinhas = 0;

            while(br.readLine() != null) {
                totalLinhas++;
            }

            System.out.println("Total de linhas em [" + nomeArquivo + "]: [" + totalLinhas + "]\n");

        }

    }

    /**
     * Busca uma palavra no arquivo e retorna se ela foi encontrada ou não.
     * A busca é case-insensitive (não diferencia maiúsculas de minúsculas).
     * 
     * @param nomeArquivo Nome do arquivo onde a busca será realizada
     * @param sc Scanner para leitura da palavra a ser buscada
     * @throws IOException Se ocorrer um erro de entrada/saída no arquivo
     */
    public static void buscarPalavras(String nomeArquivo, Scanner sc) throws IOException {

        System.out.println("------ Buscar Palavra no Arquivo ------\n");
        System.out.print("Digite a palavra a ser buscada: ");
        String palavraBuscada = sc.nextLine().trim();

        try(FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean encontrada = false;
            int numeroLinha = 0;

            while((linha = br.readLine()) != null) {
                numeroLinha++;
                // contém ignora diferença entre maiúsculas e minúsculas
                if(linha.toLowerCase().contains(palavraBuscada.toLowerCase())) {
                    encontrada = true;
                    System.out.println("Palavra encontrada na linha [" + numeroLinha + "]: " + linha);
                }
            }

            if(encontrada) {
                System.out.println("\nResultado: [true] - Palavra \"" + palavraBuscada + "\" encontrada no arquivo!\n");
            } else {
                System.out.println("Resultado: [false] - Palavra \"" + palavraBuscada + "\" não encontrada no arquivo.\n");
            }

        }

    }

    /**
     * Método principal que executa o gerenciador de arquivos.
     * Controla o loop principal de interação com o usuário.
     * 
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao;

        System.out.println("------ Bem-vindo ao Gerenciador de Arquivos! ------\n");

        String nomeArquivo = selecionarArquivo(sc);

        do {

            exibirOpcoes(nomeArquivo);
            System.out.print("Insira sua opção: ");

            try {

                opcao = Integer.parseInt(sc.nextLine());

                if(opcao < 1 || opcao > 7) {
                    System.out.println("Escolha uma opção válida entre 1 e 7!");
                    System.out.println();
                }

            } catch(NumberFormatException e) {
                System.out.println("Erro " + e.getMessage() + ": Insira um número válido!");
                System.out.println();
                opcao = 0;
            }

            switch(opcao) {

                case 1:
                    try {
                        escreverTexto(nomeArquivo, sc);
                    } catch(IOException e) {
                        System.out.println("Erro ao escrever no arquivo: " + e.getMessage() + "\n");
                    }
                break;

                case 2:
                    try {
                        lerConteudo(nomeArquivo);
                    } catch(IOException e) {
                        System.out.println("Erro ao ler o arquivo: " + e.getMessage() + "\n");
                    }
                break;

                case 3:
                    try {
                        adicionarNovasLinhas(nomeArquivo, sc);
                    } catch(IOException e) {
                        System.out.println("Erro ao adicionar linhas no arquivo: " + e.getMessage() + "\n");
                    }
                break;

                case 4:
                    try {
                        contarLinhas(nomeArquivo);
                    } catch(IOException e) {
                        System.out.println("Erro ao contar linhas do arquivo: " + e.getMessage() + "\n");
                    }
                break;

                case 5:
                    try {
                        buscarPalavras(nomeArquivo, sc);
                    } catch(IOException e) {
                        System.out.println("Erro ao buscar no arquivo: " + e.getMessage() + "\n");
                    }
                break;

                case 6:
                    // troca o arquivo sem encerrar o programa
                    nomeArquivo = selecionarArquivo(sc);
                break;

            }

        } while(opcao != 7);

        System.out.println();
        System.out.println("Obrigado por utilizar! \nEncerrando...");

        sc.close();

    }

}
