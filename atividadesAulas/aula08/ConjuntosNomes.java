package atividadesAulas.aula08;

import java.util.ArrayList;
import java.util.HashSet;

public class ConjuntosNomes {

    static void exibirLista(ArrayList<String> lista) {
        for (String nome : lista) {
            System.out.println(nome);
        }
    }

    static void exibirConjunto(HashSet<String> conjunto) {
        for (String nome : conjunto) {
            System.out.println(nome);
        }
    }

    public static void main(String[] args) {

        //ArrayList

        ArrayList<String> listaNomes = new ArrayList<String>();
        
        listaNomes.add("Ana");
        listaNomes.add("Carlos");
        listaNomes.add("Beatriz");
        listaNomes.add("Ana");
        listaNomes.add("Daniel");
        listaNomes.add("Carlos");

        System.out.println("------ Lista de Nomes (ArrayList) ------");
        exibirLista(listaNomes);

        String nomeBuscado = "Ana";
        System.out.println("\nO nome \"" + nomeBuscado + "\" está na lista? [" + listaNomes.contains(nomeBuscado) + "]");

        //HashSet

        HashSet<String> conjuntoNomes = new HashSet<String>();

        conjuntoNomes.addAll(listaNomes);

        System.out.println("\n------ Conjunto de Nomes (HashSet) ------");
        exibirConjunto(conjuntoNomes);

        String nomeBuscado2 = "Carlos";
        System.out.println("\nO nome \"" + nomeBuscado2 + "\" está na lista? [" + listaNomes.contains(nomeBuscado2) + "]");

        System.out.println("\n------ Comparação ------");
        System.out.println("Tamanho da lista (ArrayList):   " + listaNomes.size());
        System.out.println("Tamanho do conjunto (HashSet):  " + conjuntoNomes.size());
    }
    
}