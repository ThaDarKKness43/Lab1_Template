package pt.pa.adts;

/**
 * Interface que define o comportamento de uma fila.
 *
 * @param <T> Tipo de elemento a armazenar na fila.
 *
 * @author Daniel
 */
public interface Queue<T> {

    /**
     * Insere o elemento <i>element</i> no final da fila.
     *
     * @param element elemento a inserir
     * @throws FullQueueException se não houver capacidade/memória para mais elementos.
     */
    public void enqueue(T element) throws FullQueueException;

    /**
     * Remove e devolve o elemento no início da fila.
     *
     * @return o elemento no início da fila.
     * @throws EmptyQueueException se a fila estiver vazia.
     */
    public T dequeue() throws EmptyQueueException;

    /**
     * Devolve o elemento no início da fila
     *
     * @return o elemento no início da fila.
     * @throws EmptyQueueException se a fila estiver vazia.
     */
    public T front() throws EmptyQueueException;

    /**
     * Retorna o número de elementos na fila.
     *
     * @return o número de elementos na fila.
     */
    public int size();

    /**
     * Retorna true se a fila se encontra vazia, false caso contrário.
     *
     * @return o booleano resultante da mencionada verificação.
     */
    public boolean isEmpty();

    /**
     * Apaga a totalidade do conteúdo da fila.
     */
    public void clear();
}
