public class Problema3<T> {

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
    public T[] distanciaTa (T [] vetor, int D) {
        //O(n²)
        T[] vetorRes = (T[]) new Number[2];
        int tam = vetor.length;

        insertionSort(vetor);
        System.out.println("vetor A ordenado:");
        for (T i: vetor) {
            System.out.print(i.toString());
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < tam; i++) {
            for (int j = i + 1; j < tam; j++) {
                Number aux = (Number) ((Integer.parseInt(vetor[i].toString())) - (Integer.parseInt(vetor[j].toString())));
                T chave = (T)aux;

                if (Integer.parseInt(chave.toString()) < 0){
                    Number aux2 = (Number) ((Integer.parseInt(chave.toString())) * -1);
                    T novaChave = (T) aux2;
                    //System.out.println("CHAVE A:" + novaChave);
                    if (((Integer.parseInt(novaChave.toString())) == D)) {
                        vetorRes[0] = vetor[i];
                        vetorRes[1] = vetor[j];
                    }
                }
                else {
                    //System.out.println("CHAVE A:" + chave);
                    if (((Integer.parseInt(chave.toString())) == D)) {
                        vetorRes[0] = vetor[i];
                        vetorRes[1] = vetor[j];
                    }
                }
            }
        }

        return vetorRes;
        //mostraVetor(vetorRes);
    }
    public void insertionSort(T[] v) {
        int tam = v.length;
        int i;
        T chave;

        for (int j=1; j<tam; j++) {
            chave = v[j];
            i = j-1;
            while (i>=0 && (compara(v[i], chave) == 1)) {
                v[i+1] = v[i];
                i=i-1;
            }
            v[i+1] = chave;
        }
    }

    public T[] distanciaTb (T[] vetor, int D) {
        T [] vetorRes = (T[])new Number[2];
        int tam = vetor.length;

        System.out.println("\nVetor B ordenado:");
        Problema2<T> obj = new Problema2<T>();
        obj.sort(vetor,0,tam-1);
        for (T i: vetor)
            System.out.printf(i.toString()+" ");
        System.out.println();

        for (T j : vetor) {
            Object aux = (Object)(D - (Integer.parseInt (j.toString())));
            T chave = (T) aux;
            if ((chave instanceof Integer) && (Integer)chave < 0) {
                Integer novaChave= Integer.parseInt(chave.toString());
                novaChave *= -1;
               // System.out.println("CHAVE B:"+ novaChave.toString());
            }
            //else System.out.println("CHAVE B:"+ chave.toString());

            if (buscaBinaria(vetor, chave)) {
                vetorRes[0] = j;
                vetorRes[1] = chave;
            }
        }
        return vetorRes;
        //mostraVetor(vetorRes);
    }

    public boolean buscaBinaria(T[] vetor, T elemento) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (compara(vetor[meio], elemento) == 0) {
                //System.out.println("verdadeiro");
                return true; // Elemento encontrado, retorna o índice
            }

            if ((compara(vetor[meio], elemento)== -1)) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        //System.out.println("falso");
        return false; // Elemento não encontrado
    }

    public void mostraVetor(T[]vetor){
        for(T i : vetor){
            System.out.print(i + " ");
        }
    }
}