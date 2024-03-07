package br.com.caelum.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoGenerico {
    private List<List<Object>> tabela = new ArrayList<List<Object>>();
    private int tamanho = 0;
    public ConjuntoGenerico(){
        for(int i=0; i < 26; i++){
            LinkedList<Object> listaLigada = new LinkedList<Object>();
            tabela.add(listaLigada);
        }
    }
    private void redimensionaTabela(int novaCapacidade){
        List<Object> objetos = this.pegaTodas();
        this.tabela.clear();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<Object>());
        }
        for (Object objeto : objetos) {
            this.adiciona(objeto);
        }
    }
    private void verificaCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;
        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }
    private int calculaIndiceDaTabela(Object objeto){
        int codigoDeEspalhamento = objeto.hashCode();
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % tabela.size();
    }

    public void adiciona(Object objeto){
        if(!contem(objeto)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(objeto);
            List<Object> lista = tabela.get(indice);
            lista.add(objeto);
            tamanho++;
        }

    }
    public void remove(Object objeto){
        if(!contem(objeto)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(objeto);
            List<Object> lista = tabela.get(indice);
            lista.remove(objeto);
            tamanho--;
        }
    }
    public boolean contem(Object objeto){
        int indice = calculaIndiceDaTabela(objeto);
        List<Object> lista = tabela.get(indice);
        return lista.contains(objeto);
    }
    public List<Object> pegaTodas(){
        ArrayList<Object> objeto = new ArrayList<>();
        for (int i=0; i < tabela.size(); i++){
            objeto.addAll(tabela.get(i));
        }
        return objeto;
    }
    public int tamanho(){
        return tamanho;
    }

    public void imprimeTabela() {
        for (List<Object> lista : this.tabela) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }
}
