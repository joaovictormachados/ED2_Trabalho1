RELATORIO DE COMPORTAMENTO ASSINTOTICO DA RESOLUCAO DOS PROBLEMAS PROPOSTOS


    PROBLEMA 1:
    A resolução do problema consiste em ordenar o vetor, utilizando o Heap Sort, entretanto, esse tem comportamento as-
    sintótico O(nlogn), portanto, é necessário fazer algumas alterações no algoritmo, para que ele execute com O(nlogK).
    Temos que o algoritmo ordena o vetor de tras para frente, portanto basta ordenarmos o vetor K vezes, de modo que a-
    penas os elementos necessários sejam ordenados, resultando no comportamento assintótico desejado.
    O comportamento assintótico desse algoritmo é O(nlogk) devido ao uso do heapsort modificado no momento de ordenacao
    do vetor.
    (esse é nosos objetivo, ainda nao chegamos la, no momento temos complexidade O(nlogn) por causa do uso do heapsort
    padrão).


    PROBLEMA 2:
    A resolução do problema consiste concatenar os dois vetores recebidos, ordenar e então, calcular a mediana no vetor.
    O calculo é baseado em duas possiblidades, se o vetor tiver quantidade par ou impar.
    O comportamento assintótico desse algoritmo é O(nlogn) devido ao uso do mergesort no momento de ordenacao do vetor.


    PROBLEMA 3:
    a) A resolução do problema consiste ordenar o vetor com insertion sort (O(n²)), depois disso, fazemos uma verifica-
    ção percorrendo todo o vetor com objetivo de verificar se a diferença de um elemento na posicao i e um elemento na
    posição j tem uma diferença igual ao parametro T, passado no cabeçalho da função, também com custo O(n²).
    O comportamento assintótico desse algoritmo é O(n²) devido ao uso do insertionsort no momento de ordenacao do vetor
    e também devido a 2 for aninhados.
    No final do algoritmo temos um custo O(n²), como pedido na questão.

    B) A resolução do problema consiste em ordenar o vetor com merge sort (O(nlogn)), depois disso fazemos uma vericação
    percorrendo todo o vetor e aplicando uma busca binária (O(logn)) para ver se conseguimos encontrar a diferença entre
    um elemento[i] e o parametro T, passado no cabeçalho da função. Caso encontremos, isso quer dizer que achamos os do-
    is elementos com distancia T que estavamos procurando.
    O comportamento assintótico desse algoritmo é O(nlogn) devido ao uso do mergesort no momento de ordenacao do vetor.


    PROBLEMA 4:

