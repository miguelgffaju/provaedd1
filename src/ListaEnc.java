//package br.edu.ifs.cads.ed1;
public class ListaEnc<T extends Comparable<T>> extends Lista<T> implements IProva<T>{

    private Node inicio;
    private int tamanho;


    public ListaEnc() {
        this.inicio = null;
        this.tamanho = 0;

    }

    @Override
    public void incluir(T elemento) throws Exception {
        //throw new Exception("Não Implementado");
        Node novo = new Node(elemento);
        if (inicio == null) {
            inicio = novo;

        } else {
            Node atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        tamanho++;
    }

    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição inválida");
        }

        Node atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual.setDado(atual.getProximo());
        }
        return (T) atual.getDado();


    }

    public int getPosElemento(T elemento) throws Exception {
        Node atual = inicio;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                return (int) atual.getDado();
            }
            atual.setDado(atual.getProximo());
        }

        throw new Exception("Elemento não localizado");
    }



    @Override

    public void incluirInicio(T elemento) throws Exception {
        Node novo = new Node(elemento);
        novo.setProximo(inicio);
        inicio = novo;
        tamanho++;


        //throw new Exception("Não Implementado");

    }

    @Override

    public void incluir(T elemento, int posiaco) throws Exception {
        if (posiaco < 0 || posiaco > tamanho) {
            throw new Exception("Posição inválida");
        }

        if (posiaco == 0) {
            incluirInicio(elemento);
            return;
        }

        Node novo = new Node(elemento);
        Node atual = inicio;
        for (int i = 0; i < posiaco - 1; i++) {
            atual = atual.getProximo();
        }
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        tamanho++;


        //throw new Exception("Não Implementado");
    }

    @Override

    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição inválida");
        }

        if (posicao == 0) {
            inicio = inicio.getProximo();
        } else {
            Node atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            atual.setProximo(atual.getProximo().getProximo());
        }
        tamanho--;

        //throw new Exception("Não Implementado");
    }

    @Override

    public int getTamanho() {
        return Integer.MIN_VALUE;

    }

    @Override

    public void limpar() {
        inicio = null;
        tamanho = 0;


    }

    @Override

    public boolean contem(T elemento) throws Exception {
        Node atual = inicio;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;


        // throw new Exception("Não Implementado");
    }

    @Override
    public boolean estahOrdenada() {

        if (inicio == null || inicio.getProximo() == null) {
            return true;

        }
        Node atual = inicio;
        while (atual.getProximo() != null) {
            if (atual.getDado().compareTo(atual.getProximo().getDado()) > 0) {
                return false;
            }
            atual = atual.getProximo();
        }

        return true;
    }

    @Override
    public boolean estahOrdenada(Lista<T> lista) throws Exception {
        Node<T> atual = inicio;
        if (atual == null || atual.getProximo() == null) {
            return true;
        }

        while (atual.getProximo() != null) {
            if (atual.getDado().compareTo(atual.getProximo().getDado()) > 0) {
                return false;
            }
            atual = atual.getProximo();
        }
        return true;
    }

    // Importa elementos de uma lista para outra
    @Override
    public void importarListas(Lista<T> l1, Lista<T> l2) throws Exception {
        Node<T> atual = (Node<T>) l1.get(0);
        while (atual != null) {
            l2.incluir(atual.getDado());
            atual = atual.getProximo();
        }
    }

    // Importa elementos de uma lista para outra com opção de manter ordenação
    @Override
    public void importarListas(Lista<T> l1, Lista<T> l2, boolean manterOrdenacao) throws Exception {
        Node<T> atual = (Node<T>) l1.get(0);
        ;
        while (atual != null) {
            l2.incluir(atual.getDado());
            atual = atual.getProximo();
        }

        if (manterOrdenacao && !l2.estahOrdenada()) {
            throw new Exception("A lista resultante não está ordenada");


        }
    }}