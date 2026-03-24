package trabalho02_conceitosJava;
import java.util.Scanner;

/**
 * Sistema de login com validação de credenciais.
 * Permite até 3 tentativas de login com as credenciais corretas (login: admin, senha: 1234).
 */
public class SistemaLogin {
    
    /**
     * Método principal que executa o sistema de login.
     * Solicita login e senha, valida as credenciais e controla tentativas.
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int contador = 0;

        while(true) {

            if (contador == 3) {
                System.out.println("Limite de tentativas de login atingido! Acesso Bloqueado.");
                break;
            }

            if(contador == 0) {
                System.out.println("------ Insira dos Dados Para Login ------\n");
            }

            if (contador > 0 && contador < 3) {
                System.out.println("Tente novamente...");
            }

            System.out.print("Login: ");
            String login = sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if(login.equals("admin") && senha.equals("1234")) {
                System.out.println("Login Efetuado! Redirecionando...");
                break;
            }

            System.out.println();

            contador++;

        }

        sc.close();

    }

}
