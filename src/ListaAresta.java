import java.util.Arrays;

public class ListaAresta {
    private CelulaAresta inicio;
    private CelulaAresta ultimo;
    private int tamanho;

    /**
     * Lista com os vertices do grafo que foram inseridos;
     */
    //construtor

    public ListaAresta() {
        this.tamanho=0;
    }

    //metodos

    public void inserir (Aresta aresta){
        Aresta outra = new Aresta(aresta.getFim(), aresta.getInicio());
        CelulaAresta nova = new CelulaAresta(aresta);
        CelulaAresta outroCaminho = new CelulaAresta(outra);
        nova.setProximo(outroCaminho);
        outroCaminho.setProximo(null);
        if(this.isEmpty()){
            this.setInicio(nova);
            this.setUltimo(outroCaminho);
        }else {
            CelulaAresta aux = this.getInicio();
            while(aux.getProximo()!=null){
                aux=aux.getProximo();
            }
            aux.setProximo(nova);
            nova.setProximo(outroCaminho);
            this.setUltimo(outroCaminho);
        }
        this.setTamanho(this.getTamanho()+1);

    }

    public boolean isEmpty(){
        return this.inicio==null;
    }

    public void imprimeAresta(){
        CelulaAresta aux = this.getInicio();
        while(aux.getProximo()!=null){
            System.out.println(aux.getAtual().getInicio().getNome()+"->"+aux.getAtual().getFim().getNome());
            aux=aux.getProximo();
        }
        System.out.println(aux.getAtual().getInicio().getNome()+"->"+aux.getAtual().getFim().getNome());
    }

    public String[] encontraAresta(String a){
        /**
         * @param a
         * Recebe uma string e busca na lista de arestas;
         * Caso o vertice de partida exista, busca todos os destinos partindo do vertice
         * @return String[] com todos os destinos
         */
        CelulaAresta aux = this.getInicio();
        StringBuilder builder = new StringBuilder();
        while(aux.getProximo()!=null){
            if(aux.getAtual().getInicio().getNome().equals(a)){
               builder.append(aux.getAtual().getFim().getNome());
               aux=aux.getProximo();
            }else{
                aux=aux.getProximo();
            }
        }
        String[] resp = this.splitString(builder.toString());
        return resp;
    }

    public void eAresta(String[] arrayRecebido){
        /**
         * @param arrayRecebido recebe um array com todos os ciclos
         * Percorre todos os ciclos gerais, confere na se são ciclos do grafo em questão;
         * Printa os ciclos encotrados
         */
        int contaCiclos=0;
        for(int i=0;i< arrayRecebido.length;i++){
            String[] ciclosSplitados = this.splitString(arrayRecebido[i]);//pega um ciclo e splita por letra
            int contador = 0;
            for(int k = 0;k<ciclosSplitados.length;k++){
                String[] destinos = this.encontraAresta(ciclosSplitados[k]);//encontra todos destinos de uma aresta x
                if(k+1<ciclosSplitados.length){
                    boolean contains = this.contemAresta(ciclosSplitados[k+1],destinos);//confere se o valor a frente do vertice é um possível destino;
                    if(contains){
                        contador++;
                    }
                }
            }
            if(contador==ciclosSplitados.length-1){
                contaCiclos++;
                for(int l = 0;l<ciclosSplitados.length;l++){
                    if(l==ciclosSplitados.length-1){
                        System.out.print(ciclosSplitados[l]);
                    }else{
                        System.out.print(ciclosSplitados[l]+"->");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("O grafo possui "+contaCiclos+" ciclos! Confira acima!");

    }

    public boolean contemAresta(String a,String[] b){
        /**
         * confere se o valor a frente do vertice é um possível destino;
         * @return true se for um destino e false se não for
         */
        for(int i = 0;i<b.length;i++){
            if(a.equals(b[i])){
                return true;
            }
        }
        return false;
    }

    public CelulaAresta retornaCelulaAresta(String a){
        CelulaAresta aux = this.getInicio();
        CelulaAresta resp = new CelulaAresta();
        while(aux.getProximo()!=null){
            if(aux.getAtual().getInicio().getNome().equals(a)){
                resp = aux;
            }
            aux=aux.getProximo();
        }
        return resp;
    }

    public String[] splitString(String texto){
        /**
         * Igual ao da classe grafo;
         */
        String[] aux=new String[texto.length()];
        for(int i = 0;i<texto.length();i++){
            aux[i]=texto.substring(i,i+1);
        }
        return aux;
    }

    //gets e sets

    public CelulaAresta getInicio() {
        return inicio;
    }

    public void setInicio(CelulaAresta inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public CelulaAresta getUltimo() {
        return ultimo;
    }

    public void setUltimo(CelulaAresta ultimo) {
        this.ultimo = ultimo;
    }



}
