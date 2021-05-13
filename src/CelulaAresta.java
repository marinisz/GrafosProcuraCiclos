public class CelulaAresta {
    private Aresta atual;
    private CelulaAresta proximo;

    /**
     * Celula para entrar na lista de aresta;
     * Armazena a poisção atual e a seguinte;
     */

    //construtor
    public CelulaAresta(){
        this.setAtual(null);
    }
    public CelulaAresta(Aresta aresta){
        this.setAtual(aresta);
    }
    //get e set
    public Aresta getAtual() {
        return atual;
    }

    public void setAtual(Aresta atual) {
        this.atual = atual;
    }

    public CelulaAresta getProximo() {
        return proximo;
    }

    public void setProximo(CelulaAresta proximo) {
        this.proximo = proximo;
    }
    //metodos
    public void imprime(){
        System.out.println("Atual - inicio:" + (this.getAtual().getInicio().getNome()));
        System.out.println("Atual - fim:" + (this.getAtual().getFim().getNome()));
    }
    public void copia(CelulaAresta celulaAux){
        this.setProximo(celulaAux.getProximo());
        this.setAtual(celulaAux.getAtual());
    }
}

