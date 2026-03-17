package atividadesAulas.aula06;
import java.util.Scanner;

public class StudentsMarks {

    static int[] enterExamMarks (Scanner entrada, int[] javaStudents) {

        System.out.println("1° Etapa - Inserir Notas \n");

        for(int i = 0 ; i < javaStudents.length ; i++) {
            System.out.print("Nota do " + (i+1) + "° aluno: ");
            javaStudents[i] = entrada.nextInt();

            if(javaStudents[i] < 0 || javaStudents[i] > 10) {
                do{
                    System.out.println("Insira corretamente! Notas inteiras de 0 a 10 apenas!");
                    System.out.print("Nota do " + (i+1) + "° aluno: ");
                    javaStudents[i] = entrada.nextInt();
                } while (javaStudents[i] < 0 || javaStudents[i] > 10);
            }
        }

        return javaStudents;

    }

    static void viewExamMarks (int[] javaStudents) {

        System.out.println("Imprimindo notas...");

        for(int i = 0 ; i < javaStudents.length ; i++) {
            if(i == 0) {System.out.print("[" + javaStudents[i] + ", "); continue;}
            if(i == (javaStudents.length-1)) {System.out.print(javaStudents[i] + "]"); break;}
            System.out.print(javaStudents[i] + ", ");
        }

        System.out.println();

    }

    static int[] increaseMarks (int[] javaStudents) {

        for(int i = 0 ; i < javaStudents.length ; i++) {
            javaStudents[i] += 3;

            if(javaStudents[i] > 10) {
                javaStudents[i] = 10;
            }
        }

        return javaStudents;

    }

    static boolean allHavePasssed(int[] javaStudents) {

        int soma = 0;
        float media;

        for(int i = 0 ; i < javaStudents.length ; i++) {
            if(i == 0) {soma = javaStudents[i]; continue;}

            soma =+ javaStudents[i];
        }

        media = soma / javaStudents.length;

        if(media >= 5) {return true;} else {return false;}

    }

    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);

        char condicao;

        int[] javaStudents = new int[4];

        System.out.println("-------- BEM-VINDO ao Java Students Marks! --------\n");

        do {

            enterExamMarks(entrada, javaStudents);

            System.out.println();

            viewExamMarks(javaStudents);

            System.out.println();

            increaseMarks(javaStudents);

            System.out.println("Incremetando 3 pontos... O professor liberou...");

            viewExamMarks(javaStudents);

            System.out.println();
            
            if(allHavePasssed(javaStudents)) {
                System.out.println("Todos passaram! Média >= 5, parabéns!");
            } else {
                System.out.println("Média abaixo de 5! Infelizmente perdemos alguns soldados...");
            }

            System.out.print("\nDeseja continuar utilizando o sistema? (s|n) | ");
            condicao = entrada.next().charAt(0);

        } while (condicao == 's' || condicao == 'S');

        System.out.println("Encerrando...");
        System.out.println("Obrigado por utilizar o sistema!");

        entrada.close();

    }

}