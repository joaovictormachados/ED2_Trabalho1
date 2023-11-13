public class Problema4<T> {

    public int compara(T obj1, T obj2){
        if(obj1 instanceof String){
            int i = (obj1.toString()).compareTo(obj2.toString());
            return i;
        }
        else {
            if(Integer.parseInt(obj1.toString()) < Integer.parseInt(obj2.toString())){
                return -1;
            }
            else if(Integer.parseInt(obj1.toString()) == Integer.parseInt(obj2.toString())){
                return 0;
            }
            else{
                return 1;
            }
        }
    }

    public T[] BHSISort(T[] v1){

        int endIndex = ((v1.length / 3) - 1 ); // Calcula o índice final para o primeiro Selection Sort
        int startInsert = endIndex + 1; // Índice inicial para Insertion Sort

        int startIndex = ((v1.length - endIndex) - 1); // Calcula o índice inicial para o segundo Selection Sort
        int endInsert = startIndex-1; // Índice final para Insertion Sort

        // Construir um heap máximo
        buildMinHeap(v1, v1.length);

        // Ordenar as extremidades com Selection Sort
        selectionSort(v1, endIndex, startIndex);

        // Ordenar o meio com Insertion Sort
        insertionSort(v1, startInsert, endInsert);



        return v1;
    }


    public void heapify(T[] v1, int tam, int raiz)
    {
        int menor = raiz; // inicializa o menor como a raiz
        int l = 2 * raiz + 1; // left = 2*raiz + 1
        int r = 2 * raiz + 2; // right = 2*raiz + 2

        // se o filho esquerdo é menor que a raiz
        if (l < tam && (compara(v1[l],v1[menor]) < 0))
            menor = l;

        // se o filho direito é menor que o menor até agora
        if (r < tam && (compara(v1[r],v1[menor]) < 0))
            menor = r;

        // se menor não for a raiz, então troca raiz e menor
        if (menor != raiz) {
            T temp = v1[raiz];
            v1[raiz] = v1[menor];
            v1[menor] = temp;

            // chama heapify recursivamente para a sub-árvore
            heapify(v1, tam, menor);
        }
    }

    public void buildMinHeap(T[] v1, int n){
        for (int raiz = n / 2 - 1; raiz >= 0; raiz--)
            heapify(v1, n, raiz);
    }

    public void selectionSort(T[] v1, int endIndex, int startIndex){
        //Ordena primeira extremidade
        for (int i = 0; i <= endIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= v1.length-1; j++) {
                if ((compara(v1[j], v1[minIndex])) < 0) {
                    minIndex = j;
                }
            }
            T temp = v1[i];
            v1[i] = v1[minIndex];
            v1[minIndex] = temp;
        }
        //Ordena segunda extremidade
        //int aux = endIndex+1;
        for (int i = v1.length-1; i >= startIndex; i--) {
            int maxIndex = i;
            for (int j = i-1; j >= endIndex+1; j--) {
                if ((compara(v1[j], v1[maxIndex])) > 0) {
                    maxIndex = j;
                }
            }
            T temp = v1[i];
            v1[i] = v1[maxIndex];
            v1[maxIndex] = temp;
        }
    }

    public void insertionSort(T[] v1, int comeco, int fim) {
        for (int i = comeco; i <= fim; i++) {
            T chave = v1[i];
            int j = i - 1;
            while (j >= comeco && ((compara(v1[j], chave)) > 0)) {
                v1[j + 1] = v1[j];
                j--;
            }
            v1[j + 1] = chave;
        }
    }
}