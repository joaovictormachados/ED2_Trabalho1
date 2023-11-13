public class Problema2<T> {
    public int compara(T obj1, T obj2) {
        if (obj1 instanceof String) {
            int i = (obj1.toString()).compareTo(obj2.toString());
            return i;
        } else {
            if (Integer.parseInt(obj1.toString()) < Integer.parseInt(obj2.toString())) {
                return -1;
            } else if (Integer.parseInt(obj1.toString()) == Integer.parseInt(obj2.toString())) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public T mediana(T[] v1, T[] v2) {
        int tam = v1.length + v2.length;

        //PRIMEIRO PASSO: Vamos criar um novo vetor que contenha o v1 e o v2
        T[] vetor = (T[]) new Object[tam];
        System.arraycopy(v1, 0, vetor, 0, v1.length);
        System.arraycopy(v2, 0, vetor, v1.length, v2.length);

        //SEGUNDO PASSO: Agora é necessário ordenar o vetor para encontramos a mediana
        sort(vetor,0,tam-1);    //O(nLogn)
        System.out.println("vetor ordenado: ");
        for (T i : vetor) {
            System.out.print(i.toString());
            System.out.print(" ");
        }

        //TERCEIRO PASSO: Agora precisamos calcular a mediana, para isso:
        Object mediana;
        int meio = tam / 2 - 1;
        if (tam % 2 == 0) {
            if (vetor[meio] instanceof String) {
                mediana = (Object) ((vetor[meio].toString()).concat(vetor[meio + 1].toString()));
            } else {
                mediana = (Object) ((Integer.parseInt(vetor[meio].toString()) + (Integer.parseInt(vetor[meio + 1].toString()))) / 2);
            }

        } else {
            mediana = (Object) vetor[meio + 1];
        }

        return (T) mediana;

    }


    public void merge(T[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        T[] L = (T[]) new Object[n1];
        T[] R = (T[]) new Object[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if ((compara(L[i], R[j]) <= 0)) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(T[] arr, int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}