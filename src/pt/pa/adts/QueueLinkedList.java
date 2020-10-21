package pt.pa.adts;

/**
 * Classe que representa uma fila.
 *
 * @param <T> Tipo de elemento a armazenar na fila.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;

    public QueueLinkedList() {
        this.trailer = new Node(null, null, null); //header not instanciated yet!
        this.header = new Node(null, this.trailer, null);
        this.trailer.prev = this.header;
        this.size = 0;
    }

    /**
     * Insere o elemento <i>element</i> no final da fila.
     *
     * @param element elemento a inserir
     * @throws FullQueueException se não houver capacidade/memória para mais elementos.
     */
    /**
     * Insere o elemento <i>element</i> no final da fila.
     *
     * @param element elemento a inserir
     * @throws FullQueueException se não houver capacidade/memória para mais elementos.
     */
    @Override
    public void enqueue(T element) throws FullQueueException {
        //Complexidade algorítmica: O(1)
        try {
            Node newNode = new Node(element, this.trailer, this.trailer.prev);

            this.trailer.prev.next = newNode;
            this.trailer.prev = newNode;

            this.size++;

            // ... n2 n1 ... --n3(el3, null, n1)--> ... n2 n1 (n3) ...

        } catch (OutOfMemoryError e) {
            throw new FullQueueException();
        }
    }

    /**
     * Remove e devolve o elemento no início da fila.
     *
     * @return o elemento no início da fila.
     * @throws EmptyQueueException se a fila estiver vazia.
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();

        T element = this.header.next.element;
        this.header.next = this.header.next.next;
        this.header.next.prev = this.header;

        this.size--;
        // ... (n3) n2 n1 ... --> ... n2 n1 ...

        return element;
    }

    /**
     * Devolve o elemento no início da fila
     *
     * @return o elemento no início da fila.
     * @throws EmptyQueueException se a fila estiver vazia.
     */
    @Override
    public T front() throws EmptyQueueException {
        if(this.header.next == this.trailer) throw new EmptyQueueException();

        T front = this.header.next.element;

        return front;
    }

    /**
     * Retorna o número de elementos na fila.
     *
     * @return o número de elementos na fila.
     */
    @Override
    public int size() {
        int counter = 0;
        Node current = header.next;
        while(current.element != null) {
            counter++;
            current = current.next;
        }

        // ..header.. 5 2 4 1 8 ..trailer..
        return counter;
    }

    /**
     * Retorna true se a fila se encontra vazia, false caso contrário.
     *
     * @return o booleano resultante da mencionada verificação.
     */
    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Apaga a totalidade do conteúdo da fila.
     */
    @Override
    public void clear() {
        this.trailer.element = null;
        this.trailer.next = null;
        this.trailer.prev = null;

        this.header.element = null;
        this.header.next = this.trailer;
        this.header.prev = null;

        this.trailer.prev = this.header;
        this.size = 0;
    }

    /**
     * Classe que representa um nó
     */
    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
