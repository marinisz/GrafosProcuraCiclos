public class Aresta {
    private Vertice inicio;
    private Vertice fim;

    /**
     * Aresta salva com inicio e fim (Partida e destino)
     */

    //construtor

    Aresta() {
        this.inicio = this.fim = null;
    }

    Aresta(Vertice partida, Vertice destino) {
        this.inicio = partida;
        this.fim = destino;
    }

    //gets e sets

    public Vertice getInicio() {
        return this.inicio;
    }

    public void setInicio(Vertice vertice) {
        this.inicio = vertice;
    }

    public Vertice getFim() {
        return this.fim;
    }

    public void setFim(Vertice vertice) {
        this.fim = vertice;
    }

    //metodos

    public void mostraAresta() {
        /**
         * Imprime a aresta
         */
        System.out.print("Ponto de partida= " + this.getInicio().getNome());
        System.out.print(" e destino= " + this.getFim().getNome() + "\n");
    }
}
