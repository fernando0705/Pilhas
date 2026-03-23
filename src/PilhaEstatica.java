public class PilhaEstatica {
    Integer [] Pilha;
    int topo = -1;

    public PilhaEstatica(int tamanho) {
        Pilha = new Integer[tamanho];
    }

    public void empilhar(int elemento){
        if (pilhaCheia()){
            System.out.println("Pilha esta cheia!");
        } else {
            topo++;
            Pilha[topo] = elemento;
            System.out.println("Elemento empilhado");
        }
    }
    public void desempilhar() {
        if (!existeTopo()) {
            System.out.println("Pilha vazia!");
        } else {
            Pilha[topo] = 0;
            topo--;
            System.out.println("Elemento removido com sucesso.");
        }
    }
    public void exibir(){
        for (int i = this.topo; i >= 0; i--) {
            System.out.println(Pilha[i]);
        }
    }

    public boolean existeTopo() {
        if (this.topo != -1) {
            return true;
        }
        return false;
    }


    public boolean pilhaCheia(){
        if (this.topo == Pilha.length - 1){
            return true;
        }
        return false;
    }

}
