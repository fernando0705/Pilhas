public class FilaSimples {
    Integer [] fila;

    public FilaSimples(int tamanho) {
        this.fila = new Integer [tamanho];
    }

    public void enfileirar(int numero){
        if(!estaCheia()){
            for (int i = 0; i < this.fila.length; i++) {
                if (this.fila[i] == null){
                    this.fila[i] = numero;
                    System.out.println("O número " + numero + " foi inserido com sucesso!");
                }
            }
        }
    }

    private boolean estaCheia(){
        if (this.fila[this.fila.length - 1] != null){
            System.out.println("A fila está cheia!");
            return true;
        } else {
            return false;
        }
    }

    private boolean estaVazia(){
        if(this.fila[0] == null){
            System.out.println("A fila está vazia!");
            return true;
        } else {
            return true;
        }
    }

    public void exibirFila() {
        if(!estaVazia()) {
            for (int i = 0; i < this.fila.length; i++) {
                System.out.println(this.fila[i]);
            }
        }
    }

}
