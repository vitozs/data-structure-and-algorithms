package br.com.caelum.ed.listaLigada;

public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    int totalDeObjetos;

    public void adicionaNoComeco(Object elemento) {

        if(totalDeObjetos == 0){
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira = nova;
            this.ultima = nova;
        }else{
            Celula nova = new Celula(primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        totalDeObjetos++;
    }
    public void removeDoComeco() {
        if(!posicaoOcupada(0)){
            throw new IllegalArgumentException("Posicao invalida!");
        }
        primeira = primeira.getProxima();
        totalDeObjetos--;

        if(totalDeObjetos == 0){
            ultima = null;
        }
    }
    public void removeDoFim() {
        if(!posicaoOcupada(totalDeObjetos - 1)){
            throw new IllegalArgumentException("Posicao Inválida!");
        }else if(totalDeObjetos == 1){
            removeDoComeco();
        }else{
            Celula penultima = ultima.getAnterior();
            penultima.setProxima(null);
            ultima = penultima;
            totalDeObjetos--;
        }
    }

    public void remove(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Inválida!");
        }
        if(posicao == 0){
            removeDoComeco();
        } else if (posicao == totalDeObjetos - 1) {
            removeDoFim();
        }else{
            Celula anterior = pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            totalDeObjetos--;
        }

    }
    public void adiciona(Object elemento) {
        if(this.totalDeObjetos == 0){
            adicionaNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(ultima);
            this.ultima = nova;
            totalDeObjetos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if(totalDeObjetos == 0){
            adicionaNoComeco(elemento);
        }else if(posicao == totalDeObjetos){
            adiciona(elemento);
        }else{
            Celula anterior = pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            totalDeObjetos++;
        }
    }

    private Celula pegaCelula(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida!");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }
    public int tamanho() {return totalDeObjetos;}
    public boolean contem(Object o) {
        Celula atual = this.primeira;
        while (atual != null){
            if(atual.getElemento().equals(o)){
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeObjetos;
    }

    public String toString() {
        if(this.totalDeObjetos == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;
        for (int i = 0; i < this.totalDeObjetos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
}
