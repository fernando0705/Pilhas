public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        ListaDinamica listaDinamica = new ListaDinamica();

        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");

        listaDinamica.exibirElementos();
        System.out.println();

        listaDinamica.contar();
        System.out.println();

        System.out.println(listaDinamica.obter(2));
        System.out.println();

        System.out.println(listaDinamica.removerPorIndice(2));
        System.out.println();

        listaDinamica.exibirElementos();
    }
}