public interface IProva<T extends Comparable> {

    void importarListas(Lista<T> l1, Lista <T> l2) throws Exception;

    void importarListas(Lista<T> l1, Lista<T> l2, boolean manterOrdenacao)throws Exception;

    boolean estahOrdenada() throws Exception;

    boolean estahOrdenada(Lista<T> lista) throws Exception;


}
