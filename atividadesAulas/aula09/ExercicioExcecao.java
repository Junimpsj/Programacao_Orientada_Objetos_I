package atividadesAulas.aula09;

public class ExercicioExcecao {

    public static void main(String[] args) {

        try {

            int numero = obterNumero(args);
            exibirNumero(numero);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Erro: nenhum argumento foi informado.");

        } catch (NumberFormatException e) {

            System.out.println("Erro: o argumento deve ser número inteiro.");

        }

    }

    //método para obter e converter o argumento
    static int obterNumero(String[] args) {
        return Integer.parseInt(args[0]);
    }

    //método responsável por exibir o número
    static void exibirNumero(int numero) {
        System.out.println("Número informado: " + numero);
    }

}