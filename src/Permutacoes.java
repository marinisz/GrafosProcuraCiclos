public class Permutacoes {

    //numero da permutacao atual
    private static int cont=0;

    //armazena a permutacao corrente
    private static String[] p;

    //salva os possíveis ciclos
    private static StringBuilder ciclos = new StringBuilder();

    /**
     * metodo principal: recebe o vetor cujos elementos que serao permutados
     */
    public static void permuta(String[] vet) {//permuta todos os vertices e salva em ciclos;
            p = new String[vet.length];
            permuta(vet,0);
    }


    /**
     * método recursivo que implementa as permutacoes
     * @param vet
     * @param n
     */
    private static void permuta(String[] vet, int n) {

        if (n==vet.length) {
            cont++;

        } else {

            for (int i=0; i < vet.length; i++) {

                boolean achou = false;

                for (int j = 0; j < n; j++) {

                    if (p[j]==vet[i]) achou = true;
                }

                if (!achou) {

                    p[n] = vet[i];
                    permuta(vet,n+1);
                }

            } //--for
            int i;
            for (i=0; i < p.length; i++) {
                ciclos.append(p[i]);
            }
            ciclos.append(p[0]);
            ciclos.append('\n');

        } //--if/else

    } //--permuta



    /** imprime a permutacao corrente */
    private static void imprime() {
        System.out.println();
        System.out.print("(" + cont + ") : ");
        for (int i=0; i < p.length-1; i++){
            System.out.print(p[i] + " ");
        }
        System.out.print(p[0]);
    }//--imprime
    public static StringBuilder getCiclos() {
        return ciclos;
    }

}