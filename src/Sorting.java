//ESSA CLASSE É DEDICADA A ARMAZENAR OS ALGORITMOS DE ORDENAÇÃO UTILIZADOS NOS PROBLEMAS PROPOSPOSTOS PELO PROFESSOR


public class Sorting <T extends Comparable<T>>{


    public static void insertionSort(int[] v) {
        int tam = v.length;
        int chave,i;

        for (int j=1; j<tam; j++) {
            chave = v[j];
            i = j-1;
            while (i>=0 && v[i]>chave) {
                v[i+1] = v[i];
                i=i-1;
            }
            v[i+1] = chave;
        }
    }

//        public  T[] insertionSort (T[] array){
//        int tamanho = array.length;
//
//        for (int j = 1; j < tamanho; j++) {
//            T chave = array[j];
//            int i = j - 1;
//
//            while (i >= 0 && array[i].compareTo(chave) > 0) {
//                array[i + 1] = array[i];
//                i = i - 1;
//            }
//            array[i + 1] = chave;
//        }
//        return array;
//    }






//    public static boolean buscaBinaria(int[] vetor, int elemento) {
//        int esquerda = 0;
//        int direita = vetor.length - 1;
//
//        while (esquerda <= direita) {
//            int meio = esquerda + (direita - esquerda) / 2;
//
//            if (vetor[meio] == elemento) {
//                return true; // Elemento encontrado, retorna o índice
//            }
//
//            if (vetor[meio] < elemento) {
//                esquerda = meio + 1;
//            } else {
//                direita = meio - 1;
//            }
//        }
//
//        return false; // Elemento não encontrado
//    }

    public static <T extends Comparable<T>> boolean buscaBinaria(T[] array, T elemento) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int comparacao = elemento.compareTo(array[meio]);
            if (comparacao == 0) {
                return true; // Elemento encontrado
            }
            if (comparacao > 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false; // Elemento não encontrado
    }








    public T[] mergeSort2(T[] array) {
        T[] tempArray = (T[]) new Comparable[array.length];
        mergeMain2(array, tempArray, 0, array.length - 1);
        return array;
    }
    private void mergeMain2(T[] array, T[] tempArray, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            mergeMain2(array, tempArray, esquerda, meio);
            mergeMain2(array, tempArray, meio + 1, direita);

            merge2(array, tempArray, esquerda, meio, direita);
        }
    }
    private void merge2(T[] array, T[] tempArray, int esquerda, int meio, int direita) {
        for (int i = esquerda; i <= direita; i++) {
            tempArray[i] = array[i];
        }

        int i = esquerda;
        int j = meio + 1;
        int k = esquerda;

        while (i <= meio && j <= direita) {
            if (tempArray[i].compareTo(tempArray[j]) <= 0) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        while (j <= direita) {
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }










    public  int[] mergeSort(int [] vec){
        int [] tempVec = new int[vec.length];

        return mergeMain(vec, tempVec, 0, vec.length-1);
    }

    public static int [] mergeMain(int [] vec, int [] tempVec, int esq, int dir){
        int meio;
        if(esq<dir){
            meio = (esq+dir) / 2;
            mergeMain(vec, tempVec, esq, meio);
            mergeMain(vec, tempVec, meio + 1, dir);
            merge(vec, tempVec, esq, meio+1, dir);
        }

        return vec;
    }

    public static void merge (int [] vec, int [] tempVec, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(vec[esqPos] <= vec[dirPos]){
                tempVec[tempPos] = vec[esqPos];
                esqPos++;
            }else{
                tempVec[tempPos] = vec[dirPos];
                dirPos++;
            }
            tempPos++;
        }

        while(esqPos <= esqFim){
            tempVec[tempPos] = vec[esqPos];
            tempPos++;
            esqPos++;
        }

        while(dirPos <= dirFim){
            tempVec[tempPos] = vec[dirPos];
            tempPos++;
            dirPos++;
        }

        for(int i=0; i<numElem; i++, dirFim--){
            vec[dirFim] = tempVec[dirFim];
        }
    }


    public static void Maxheap(int []vetor, int i, int n){
        int esquerda=2*i+1;
        int direita= 2*i+2;
        int raiz=i;
        if(esquerda<n&&vetor[esquerda]>vetor[raiz]){
            raiz=esquerda;
        }
        if(direita<n&&vetor[direita]>vetor[raiz]){
            raiz=direita;
        }
        if(raiz!=i){
            int aux=vetor[raiz];
            vetor[raiz]=vetor[i];
            vetor[i]=aux;
            Maxheap(vetor, raiz, n);
        }
    }

    //faz um vetor ficar no formato de heap
    public static void ConstroiHeap(int []vetor){
        int n=vetor.length;
        for(int i=n/2 -1;i>=0;i--){
            Maxheap(vetor, i,n);
        }
    }

    public static void heapSort(int []vetor){
        int n=vetor.length;
        for(int j=n-1;j>=0;j--){
            int aux=vetor[0];
            vetor[0]=vetor[j];
            vetor[j]=aux;
            Maxheap(vetor,0, j);
        }
    }


}
