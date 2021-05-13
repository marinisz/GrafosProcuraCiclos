public class Vertice {
    private String nome;
    private Vertice pai=null;
    private int status;//1 = branco / 2 = preto  / 3 = cinza

    //construtor
    Vertice() {
        this.nome = "Sem nome";
        status = 1;//não visitado
    }

    Vertice(String nomeNovo) {
        this.setNome(nomeNovo);
    }

    //get e set
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeNovo) {
        this.nome = nomeNovo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}
