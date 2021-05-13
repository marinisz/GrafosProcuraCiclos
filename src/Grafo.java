import java.util.*;

public class Grafo {
    private ListaVertice listaVertice = new ListaVertice();
    private ListaAresta listaAresta = new ListaAresta();
    public static int contaCiclo=0;
    public String caminhamento = new String();

    /**
     * Classe Grafo
     *
     */
    //metodos

    public String[] extraiVertice(){
        /**
         * Extrai os vertices do grafo;
         * Transformando-os em uma String[]
         * @return String[] com os vertices
         */
        int tam = this.listaVertice.getTamanho();
        String[] vertices = new String[tam];
        if(this.listaVertice.isEmpty()){
            return vertices;
        }else {
            CelulaVertice aux = this.listaVertice.getInicio();
            int i=0;
            while(aux.getProximo()!=null){
                vertices[i]=aux.getAtual().getNome();
                aux=aux.getProximo();
                i++;
            }
            vertices[i]=aux.getAtual().getNome();
        }
        return vertices;

    }

    public void mostraCiclos(){
        /**
         * Método principal de permutação;
         * Pega os vertices
         * permuta-os
         * Salva eliminando as repetições
         * Confere quais são de fato ciclos do Grafo
         */
        long start = System.currentTimeMillis();
        String[] vertices = this.extraiVertice();
        Permutacoes permutador = new Permutacoes();

        for(int j=3;j<=vertices.length;j++){
            String[] aux = new String[j];
            String[] aux2 = new String[j];
            int a=vertices.length-1;
            for(int i = 0;i<j;i++){
                aux[i]=vertices[i];
                aux2[i]=vertices[a];
                a--;
            }
            permutador.permuta(aux);
            permutador.permuta(aux2);
        }

        String[] ciclos = salvaCiclos(permutador);
        this.confereCiclos(ciclos);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("|Busca com permutação|\nTempo de execução = "+elapsed+"ms");
    }

    public void confereCiclos(String[] ciclos){
        /**
         * Acessa um método que confere se o ciclo em questão existe no grafo
         * @param ciclos São os ciclos gerados na permutação
         */
        this.getListaAresta().eAresta(ciclos);
    }

    public String[] salvaCiclos(Permutacoes permutador){
        /**
         * 1 pega os ciclos
         * 2 transforma em arraylist
         * 3 remove os iguais
         * 4 coloca de novo em String[])
         * @param permutador é a classe que permuta e salva os ciclos, o metodo precisa do atributo ciclos dela para conseguir salvar
         */

        String array[] = permutador.getCiclos().toString().split("\n");
        int tamanho = array.length;
        ArrayList<String> ciclos =new ArrayList<String>();
        for(int i =0;i<tamanho;i++){
            ciclos.add(array[i]);
        }

        Set<String> set = new HashSet<>(ciclos);
        ciclos.clear();
        ciclos.addAll(set);

        String[] arrayCiclos = new String[ciclos.size()];
        ArrayList<String> ciclosNaoRepetidos =new ArrayList<String>();
        for(int i=0;i<ciclos.size();i++){
            arrayCiclos[i]=ciclos.get(i);
        }

        for(int i=0;i<arrayCiclos.length;i++){
            for(int j=1;j<arrayCiclos.length;j++){
                if(this.confereIgualdade(arrayCiclos[i],arrayCiclos[j])){
                    ciclosNaoRepetidos.add(arrayCiclos[i]);
                }
            }
        }

        Set<String> set2 = new HashSet<>(ciclosNaoRepetidos);
        ciclosNaoRepetidos.clear();
        ciclosNaoRepetidos.addAll(set2);

        String[] resp = new String[ciclosNaoRepetidos.size()];
        for(int i=0;i<ciclosNaoRepetidos.size();i++){
            resp[i]=ciclosNaoRepetidos.get(i);
        }
        return resp;
    }

    public String[] salvaCiclosCaminhamento(String[] a) {
        int tamanho = a.length;
        ArrayList<String> ciclos =new ArrayList<String>();
        for(int i =0;i<tamanho;i++){
            ciclos.add(a[i]);
        }

        Set<String> set = new HashSet<>(ciclos);
        ciclos.clear();
        ciclos.addAll(set);

        String[] arrayCiclos = new String[ciclos.size()];
        ArrayList<String> ciclosNaoRepetidos =new ArrayList<String>();
        for(int i=0;i<ciclos.size();i++){
            arrayCiclos[i]=ciclos.get(i);
        }
        return arrayCiclos;
    }

    public boolean confereIgualdade(String a, String b){

        /**
         * @param a string para ser comparada com b;
         * @param b string;
         * @return true se for igual e false se não for;
         *
         */

        if(a.length()!=b.length()){
            return false;
        }
        String[] aaux = this.splitStringEspecial(a);
        String[] baux = this.splitStringEspecial(b);
        int contadorB = 0;
        for(int i =0;i<aaux.length;i++){
            for(int j=0;j<aaux.length;j++){
                if(aaux[i].equals(baux[j])){
                    contadorB=j;
                    i= aaux.length;
                    j= aaux.length;
                }
            }
        }
        String respB=new String();
        for(int i = 0;i< baux.length;i++){
            if(i==0){
                respB+=baux[contadorB];
                contadorB++;
            }else{
                if(contadorB+1>= baux.length){
                    respB+=baux[contadorB];
                    contadorB=0;
                }else{
                    respB+=baux[contadorB];
                    contadorB++;
                }

            }
        }
        int marcacao = 0;
        String[] arrayB = this.splitStringEspecial(respB);
        int tamanho = arrayB.length;
        for(int k=0;k<tamanho;k++){
            for(int l = 1;l<tamanho;l++){
                if(arrayB[k].equals(arrayB[l])){
                    marcacao = l;
                    String aux = arrayB[marcacao];
                    for(int ii =marcacao;ii< arrayB.length;ii++){
                        if(ii+1<arrayB.length){
                            arrayB[ii]=arrayB[ii+1];
                        }else{
                            arrayB[arrayB.length-1]=aux;
                        }

                    }
                    l = k = arrayB.length;
                }
            }
        }
        String resp = new String();
        for(int i =0;i< arrayB.length;i++){
            resp+=arrayB[i];
        }

        if(a.equals(resp)){
            return true;
        }
        return false;

    }

    public String[] splitStringEspecial(String texto){
        /**
         * Pega uma string qualquer, percorre letra por letra e separa criando uma String[];
         * @param texto string comum;
         * @return String[]
         */
        String[] aux=new String[texto.length()];
        for(int i = 0;i<texto.length();i++){
            aux[i]=texto.substring(i,i+1);
        }
        return aux;
}

    public void criaMatriz(){
        /**
         * Cria a matriz de adjacencia do grafo
         */
        int contador = this.listaVertice.getTamanho();
        int matriz[][]=new int[contador][contador];
        String[] vertices = this.extraiVertice();

        for(int i = 0; i<contador;i++){
            String[] arestas = getListaAresta().encontraAresta(vertices[i]);
            for(int j = 0; j< contador;j++){
                boolean resp = false;
                for(int k=0;k<arestas.length;k++){
                    if(vertices[j].equals(arestas[k])){
                        resp=true;
                    }
                    if(resp){
                        matriz[i][j]=1;
                    }else{
                        matriz[i][j]=0;
                    }
                }
            }
        }
        imprimeMatriz(matriz);
    }

    public void imprimeMatriz(int[][] a){
        for(int i = 0; i<a.length;i++){

            for(int j = 0; j<a.length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void caminhamentoCompleto(){
        /**
         * Percorre cada vertice fazendo o caminhamento iniciando por ele
         */
        long start = System.currentTimeMillis();
        String[] vertices = this.extraiVertice();
        for(int i = 0;i< vertices.length;i++){
            this.getListaVertice().limpaStatus();
            CelulaAresta atual = this.getListaAresta().retornaCelulaAresta(vertices[i]);
            percorre(atual,null);
        }
        String[] ciclosEncontrados = caminhamento.split(",");
        ciclosEncontrados = salvaCiclosCaminhamento(ciclosEncontrados);
        confereCiclos(ciclosEncontrados);
        System.out.println("|Busca com caminhamento|");
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução = "+elapsed+"ms");
        System.out.println();
    }

    public void percorre(CelulaAresta v,CelulaAresta pai) {
        /**
         * Faz o caminhamento de forma recursiva
         */
        StringBuilder retorno = new StringBuilder();

        if(pai!=null){
            v.getAtual().getInicio().setPai(pai.getAtual().getInicio());
            retorno.append(v.getAtual().getInicio().getNome());
        }else{
            retorno.append(v.getAtual().getInicio().getNome());
        }

        //pega o vertice
        v.getAtual().getInicio().setStatus(3);//visitando
        String[] destinos = this.getListaAresta().encontraAresta(v.getAtual().getInicio().getNome());//busca os destinos, vertices, do vertice em questão
        for(int i = 0;i<destinos.length;i++){
            CelulaAresta aux = this.getListaAresta().retornaCelulaAresta(destinos[i]);
            retorno.append(aux.getAtual().getInicio().getNome());
            if(aux.getAtual().getInicio().getStatus()==1){
                percorre(aux,v);
            }
            if(aux.getAtual().getInicio().getStatus()==3){
                if(aux.getAtual().getInicio().getPai()!=v.getAtual().getInicio().getPai()){
                    retorno.append(v.getAtual().getInicio().getNome());
                    if(retorno.length()>3){
                        if (testaCiclo(retorno.toString()) == true) {
                            caminhamento += retorno;
                            caminhamento += ",";
                            contaCiclo++;
                        }
                    }

                }
            }
            v.getAtual().getInicio().setStatus(2);
        }
    }

    public boolean testaCiclo(String a){
        String[] array = this.splitStringEspecial(a);
        for(int i = 0;i<array.length;i++){
            for(int j=1;j<array.length-1;j++){
                if(array[i].equals(array[j])&&i!=j){
                    return false;
                }
            }
        }
        return true;
    }

    //gets e sets

    public ListaVertice getListaVertice() {
        return listaVertice;
    }

    public void setListaVertice(ListaVertice listaVertice) {
        this.listaVertice = listaVertice;
    }

    public ListaAresta getListaAresta() {
        return listaAresta;
    }

    public void setListaAresta(ListaAresta listaAresta) {
        this.listaAresta = listaAresta;
    }

}
