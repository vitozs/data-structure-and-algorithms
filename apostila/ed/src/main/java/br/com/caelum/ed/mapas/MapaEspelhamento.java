package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapaEspelhamento<C,V> {
    private List<List<Associacao<C,V>>> tabela = new ArrayList<List<Associacao<C,V>>>();

    public MapaEspelhamento() {
        for (int i = 0; i < 100; i++) {
            this.tabela.add(new LinkedList<Associacao<C,V>>());
        }
    }

    private int calculaIndiceDaTabela(C chave) {
        return Math.abs(chave.hashCode()) % this.tabela.size();
    }

    public void adiciona(C chave, V valor) {
        if (this.contemChave(chave)) {
            this.remove(chave);
        }
        int indice = this.calculaIndiceDaTabela(chave);
        List<Associacao<C,V>> lista = this.tabela.get(indice);
        lista.add(new Associacao(chave, valor));
    }
    public V pega(C chave) {
        int indice = this.calculaIndiceDaTabela(chave);
        List<Associacao<C,V>> lista = this.tabela.get(indice);
        for ( Associacao<C,V>  associacao : lista) {
            if (associacao.getChave().equals(chave)) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException("A chave não existe");
    }
    public void remove(C chave){
        if(contemChave(chave)){
            int indice = this.calculaIndiceDaTabela(chave);
            List<Associacao<C,V>> lista = this.tabela.get(indice);
            for (int i = 0; i < lista.size(); i++) {
                Associacao<C,V> associacao = lista.get(i);
                if (associacao.getChave().equals(chave)) {
                    lista.remove(i);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("chave inválida");
    }
    public boolean contemChave(C chave){
        int indice = calculaIndiceDaTabela(chave);
        List<Associacao<C,V>> lista = tabela.get(indice);
        for ( Associacao<C,V>  a : lista){
            if(a.getChave().equals(chave)){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return tabela.size();
    }

}
