package br.com.caelum.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoParametrizado<T> {
    private List<List<T>> tabela = new ArrayList<List<T>>();
    private int tamanho = 0;
    public ConjuntoParametrizado(){
        for(int i=0; i < 26; i++){
            LinkedList<T> listaLigada = new LinkedList<T>();
            tabela.add(listaLigada);
        }
    }
    private void redimensionaTabela(int novaCapacidade){
        List<T> objetos = this.pegaTodas();
        this.tabela.clear();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<T>());
        }
        for (T objeto : objetos) {
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
    private int calculaIndiceDaTabela(T objeto){
        int codigoDeEspalhamento = objeto.hashCode();
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % tabela.size();
    }
    public void adiciona(T objeto){
        if(!contem(objeto)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(objeto);
            List<T> lista = tabela.get(indice);
            lista.add(objeto);
            tamanho++;
        }

    }
    public void remove(T objeto){
        if(!contem(objeto)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(objeto);
            List<T> lista = tabela.get(indice);
            lista.remove(objeto);
            tamanho--;
        }
    }
    public boolean contem(T objeto){
        int indice = calculaIndiceDaTabela(objeto);
        List<T> lista = tabela.get(indice);
        return lista.contains(objeto);
    }
    public List<T> pegaTodas(){
        ArrayList<T> objetos = new ArrayList<>();
        for (int i=0; i < tabela.size(); i++){
            objetos.addAll(tabela.get(i));
        }
        return objetos;
    }
    public int tamanho(){
        return tamanho;
    }

    public void imprimeTabela() {
        for (List<T> lista : this.tabela) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }
}
