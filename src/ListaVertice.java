public class ListaVertice {
    private CelulaVertice inicio;
    private CelulaVertice ultimo;
    private int tamanho;

    /**
     * Lista encadeada padrão;
     */

    //construtor

    public ListaVertice() {
        this.tamanho=0;
    }

    //metodos

    public void inserir (Vertice vertice){
        CelulaVertice nova = new CelulaVertice(vertice);
        nova.setProximo(null);
        if(this.isEmpty()){
            this.setInicio(nova);
            this.setUltimo(nova);
        }else {
            CelulaVertice aux = this.getInicio();
            while(aux.getProximo()!=null){
                aux=aux.getProximo();
            }
            aux.setProximo(nova);
            this.setUltimo(nova);
        }
        this.setTamanho(this.getTamanho()+1);
    }

    public boolean isEmpty(){
        return this.inicio==null;
    }

    public void limpaStatus(){//status vira 1 e pai null
        CelulaVertice aux = this.getInicio();
        while(aux.getProximo()!=null){
            aux.getAtual().setStatus(1);//nao visitado
            aux.getAtual().setPai(null);
            aux=aux.getProximo();
        }
        aux.getAtual().setStatus(1);
    }

    //gets e sets

    public CelulaVertice getInicio() {
        return inicio;
    }

    public void setInicio(CelulaVertice inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public CelulaVertice getUltimo() {
        return ultimo;
    }

    public void setUltimo(CelulaVertice ultimo) {
        this.ultimo = ultimo;
    }


}
