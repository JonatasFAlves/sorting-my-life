import sorting.pancake.PancakeSort;
import sorting.tree.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String algoritmo = solicitarAlgoritmoOrdenacao();
        Integer numElementos = solicitarTamanhoArray();

        int[] array = gerarArrayAleatorio(numElementos);

        if(numElementos < 100) {
            System.out.println("Original array: ");
            System.out.println(Arrays.toString(array) + "\n");
        }

        long startTime = System.currentTimeMillis();

        switch (algoritmo) {
            case "tree":
                treeSort(array);
                break;

            case "pancake":
                pancakeSort(array);
                break;
        }

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tempo de execução em milissegundos: ");
        System.out.println(totalTime);
    }

    static String solicitarAlgoritmoOrdenacao() {
        System.out.println("Escolha o algoritmo de ordenação (tree / pancake) :");
        Scanner in = new Scanner(System.in);
        String algoritmoEscolhido = in.nextLine();

        List<String> algoritmosDisponiveis = Arrays.asList("tree", "pancake");

        if(algoritmosDisponiveis.contains(algoritmoEscolhido))
            return algoritmoEscolhido;
        else throw new RuntimeException("Algoritmo não implementado. Por favor escolha entre: "
                .concat(algoritmosDisponiveis.toString()));
    }


    static Integer solicitarTamanhoArray() {
        System.out.println("Quantidade de elementos desejada (50 / 50k / 500k) :");

        int numElementos;

        Scanner in = new Scanner(System.in);
        switch(in.nextLine()) {

            case "50":
                numElementos = 50;
                break;

            case "50k":
                numElementos = 50000;
                break;

            case "500k":
                numElementos = 500000;
                break;

            default:
                System.out.println("Quantidade não esperada. Usando array com 10 itens.");
                numElementos = 10;

        }

        return numElementos;
    }

    static int[] gerarArrayAleatorio(int numElementos) {
        int[] arr = new int[numElementos];
        for(int i = 0; i<numElementos; i++) {
            int rand = new Random().nextInt(numElementos);
            arr[i] = rand;
        }

        return arr;
    }

    static void treeSort(int[] arr) {
        Tree tree = new Tree(arr[0]);
        for(int num : arr){
            tree.insert(tree.node, num);
        }

        System.out.println("Sorted Array: ");
        tree.inOrder(tree.node);
        System.out.println();
    }

    static void pancakeSort(int[] arr) {
        int n = arr.length;

        PancakeSort.pancakeSort(arr, n);

        System.out.println("Sorted Array: ");
        PancakeSort.printArray(arr, n);
    }
}
