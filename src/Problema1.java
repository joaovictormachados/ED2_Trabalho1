public class Problema1<T extends Number & Comparable<T>> {

    public  T[] KMaiores(T[] v1, int[] P) {

        heapSort(v1);
        int tamP = P.length;
        T[] vetRes = (T[]) new Number[tamP];
        for (int i = 0; i<tamP; i++) {
            vetRes[i] =  v1[v1.length - P[i]];
        }
    return vetRes;
    }


    public void maxHeapify(T[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }

    public  void buildMaxHeap(T[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    public void heapSort(T[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);

        for (int j = n - 1; j >= 0; j--) {
            T temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            maxHeapify(arr, 0, j);
        }
    }






}
