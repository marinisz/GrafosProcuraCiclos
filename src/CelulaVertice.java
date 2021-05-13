public class CelulaVertice {
    private Vertice verticeAtual;
    private CelulaVertice proximo;

    /**
     * Celula para lista;
     * Possui o Vertice atual e o proximo;
     */
    //construtor
    public CelulaVertice(Vertice vertice){
        this.setAtual(vertice);
    }

    //get e set
    public Vertice getAtual() {
        return verticeAtual;
    }

    public void setAtual(Vertice atual) {
        this.verticeAtual = atual;
    }

    public CelulaVertice getProximo() {
        return proximo;
    }

    public void setProximo(CelulaVertice proximo) {
        this.proximo = proximo;
    }
}
