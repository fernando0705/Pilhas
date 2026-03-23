public class PilhaDinamica {
    private No topo;

    public PilhaDinamica() {
        this.topo = null;
    }

    public void empilhar(int elemento) {
        No aux = new No(elemento);
        aux.prox = this.topo;
        this.topo = aux;
        System.out.println(elemento);
    }

    public void desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia! Nada para remover.");
            return;
        }
        System.out.println("Removido: " + this.topo.elemento);
        this.topo = this.topo.prox;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return;
        } else {
            No aux = this.topo;
            while (aux != null) {
                System.out.println(aux.elemento);
                aux = aux.prox;
            }
        }
    }

    public boolean estaVazia() {
        return topo == null;
    }
}