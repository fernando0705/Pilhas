import javax.management.NotCompliantMBeanException;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;
        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        while (this.inicio != null && this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx();
            removidos++;
        }
        No aux = this.inicio;
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                removidos++;
            } else {
                aux = aux.getProx();
            }
        }
        System.out.println(removidos);
        return removidos;
    }

    @Override
    public int contar() {
        int contador = 0;
        No aux = inicio;
        while (aux != null) {
            contador++;
            aux = aux.getProx();
        }
        System.out.println(contador);
        return contador;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length; i++) {
            No novo = new No(elementos[i]);
            if (this.inicio == null) {
                this.inicio = novo;
            } else {
                No aux = this.inicio;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novo);
            }
            adicionados++;
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice > 0) {
            No aux = this.inicio;
            int i = 0;
            while (aux != null) {
                if (i == indice) {
                    return aux.getConteudo();
                }
                aux = aux.getProx();
                i++;
            }
            return aux.getConteudo();
        }
        return "Índice inválido!";
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) return false;
        No novo = new No(elemento);
        if (indice == 0) {
            novo.setProx(this.inicio);
            this.inicio = novo;
            return true;
        }
        No aux = this.inicio;
        int i = 0;
        while (aux != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux == null) return false;
        novo.setProx(aux.getProx());
        aux.setProx(novo);
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        String removido;
        if (indice < 0 || this.inicio == null) return null;
        if (indice == 0) {
            removido = this.inicio.getConteudo();
            this.inicio = this.inicio.getProx();
            return removido;
        }
        No aux = this.inicio;
        int i = 0;
        while (aux.getProx() != null && i < indice - 1) {
            aux = aux.getProx();
            i++;
        }
        if (aux.getProx() == null) return null;
        removido = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());
        return removido;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        System.out.println("Lista esta limpa!");
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = 0;
        int ultimo = -1;
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                ultimo = indice;
            }
            aux = aux.getProx();
            indice++;
        }
        return ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                contador++;
            }
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                substituidos++;
            }
            aux = aux.getProx();
        }
        return substituidos;
    }

}