import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class app {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        //Vertice e = new Vertice("e");
        //Vertice f = new Vertice("f");
        //ad/ab/ae/bd/bc/be/cf/ce/df/dc/ef
        Aresta ad = new Aresta(a,d);
        Aresta ab = new Aresta(a,b);
        //Aresta ae = new Aresta(a,e);
        Aresta bd = new Aresta(b,d);
        Aresta bc = new Aresta(b,c);
        //Aresta be = new Aresta(b,e);
        //Aresta cf = new Aresta(c,f);
        //Aresta ce = new Aresta(c,e);
        //Aresta df = new Aresta(d,f);
        Aresta dc = new Aresta(d,c);
        //Aresta ef = new Aresta(e,f);

        grafo.getListaVertice().inserir(a);
        grafo.getListaVertice().inserir(b);
        grafo.getListaVertice().inserir(c);
        grafo.getListaVertice().inserir(d);
        //grafo.getListaVertice().inserir(e);
        //grafo.getListaVertice().inserir(f);
        grafo.getListaAresta().inserir(ab);
        grafo.getListaAresta().inserir(ad);
//        grafo.getListaAresta().inserir(ae);
        grafo.getListaAresta().inserir(bd);
        grafo.getListaAresta().inserir(bc);
//        grafo.getListaAresta().inserir(be);
//        grafo.getListaAresta().inserir(cf);
//        grafo.getListaAresta().inserir(ce);
//        grafo.getListaAresta().inserir(df);
        grafo.getListaAresta().inserir(dc);
//        grafo.getListaAresta().inserir(ef);
        grafo.caminhamentoCompleto();
        grafo.mostraCiclos();
    }
}
