import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println();
            System.out.println("|----------MENU-----------|");
            System.out.println("1 - Questão 1");
            System.out.println("2 - Questão 2");
            System.out.println("3 - Questão 3");
            System.out.println("4 - Questão 4");
            System.out.println("5 - Sair");
            System.out.println("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    questao1();
                    break;
                case 2:
                    questao2();
                    break;
                case 3:
                    questao3();
                    break;
                case 4:
                    questao4();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void questao1() {

        //QUESTAO 1
        Integer[] vetor = {1, 5, 85, 23, 10, 9, 60};
        int[] indices = {1, 5, 3};

        Problema1<Integer> objeto1 = new Problema1<Integer>();

        Number[] maiores = objeto1.KMaiores(vetor, indices);

        // Agora você tem um vetor com os k maiores elementos como Numbers
        // Converta os elementos para Integer
        Integer[] maioresInteger = new Integer[maiores.length];
        for (int i = 0; i < maiores.length; i++) {
            maioresInteger[i] = maiores[i].intValue();
        }

        System.out.println("Vetor Ordenado: ");
        for (int i : vetor) {
            System.out.printf("[%d]", i);
        }

        System.out.println("\nVetor Resultante:");
        for (int i : maioresInteger) {
            System.out.printf("[%d]", i);
        }
    }

    public static void questao2() {
        //QUESTAO2
        Integer[] v1 = new Integer[15];
        Integer[] v2 = new Integer[15];
        Random random = new Random();
        for (int i = 0; i < v1.length; i++) {
            v1[i] = random.nextInt(100);
        }

        for (int i = 0; i < v2.length; i++) {
            v2[i] = random.nextInt(100);
        }

        System.out.println("Vetores Informados: ");
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));

        Problema2<Integer> objeto1 = new Problema2<Integer>();
        Integer result1 = Integer.valueOf(objeto1.mediana(v1, v2));
        System.out.println("\nMediana: " + result1);

        System.out.println();

        String[] v3 = {"d", "g", "a", "z", "b"};
        String[] v4 = {"p", "z", "c", "t", "s"};

        System.out.println("Vetores Informados: ");
        System.out.println(Arrays.toString(v3));
        System.out.println(Arrays.toString(v4));

        Problema2<String> objeto = new Problema2<String>();
        String result = objeto.mediana(v3, v4);
        System.out.println("\nMediana: " + result);

    }

    public static void questao3() {
//        QUESTAO3
//
        Integer[] v1 = {1, 9, 0, 4, 6};
        Integer[] v2 = {3, 3, 8, 0, 9};

        Problema3<Integer> objeto = new Problema3<Integer>();
        System.out.println("Vetor Informado: ");
        System.out.println(Arrays.toString(v1));
        System.out.println();

        Number[] da = objeto.distanciaTa(v1, 3);
        Integer[] dTa = new Integer[2];
        for (int i = 0; i < 2; i++) {
            dTa[i] = da[i].intValue();
        }
        System.out.println("Resposta:");
        for (int i : dTa) {
            System.out.printf("[" + i + "]");
        }
        System.out.println();

        System.out.println("\nVetor Informado: ");
        System.out.println(Arrays.toString(v2));
        Number[] db = objeto.distanciaTb(v2, 3);
        Integer[] dTb = new Integer[2];
        for (int i = 0; i < 2; i++) {
            dTb[i] = db[i].intValue();
        }
        System.out.println("Resposta:");
        for (int i : dTb) {
            System.out.printf("[" + i + "]");
        }
    }


    public static void questao4() {
//        QUESTAO4

        Integer[] v = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(15);
        }

        //String[] v = {"c", "a", "f", "s", "b", "a", "j"};

        System.out.println("Vetor original: ");
        //for (String i : v) {
        //    System.out.print(i + " ");
        //}
        for (Integer i : v) {
            System.out.print(i + " ");
        }

        System.out.println("");

        System.out.println("Vetor ordenado: ");
        //Problema4<String> obj = new Problema4<String>();
        Problema4<Integer> obj = new Problema4<Integer>();
        //String[] resultado = obj.BHSISort(v);
        Integer[] resultado = obj.BHSISort(v);
        //for (String i : resultado) {
        //System.out.print(i + " ");
        //}
        for (Integer i : resultado) {
            System.out.print(i + " ");
        }
    }

}