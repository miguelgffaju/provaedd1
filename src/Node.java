public class Node<T extends Comparable> implements Comparable<T> {

    private T dado;
    private Node<T> proximo;

    public Node(T item){
        this.dado = item;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
