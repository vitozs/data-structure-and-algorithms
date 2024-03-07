package br.com.caelum.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspelhamento{
    private List<List<String>> tabela = new ArrayList<List<String>>();
    private int tamanho = 0;
    public ConjuntoEspelhamento(){
        for(int i=0; i < 26; i++){
            LinkedList<String> listaLigada = new LinkedList<String>();
            tabela.add(listaLigada);
        }
    }
    private void redimensionaTabela(int novaCapacidade){
        List<String> palavras = this.pegaTodas();
        this.tabela.clear();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<String>());
        }
        for (String palavra : palavras) {
            this.adiciona(palavra);
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
    private int calculaIndiceDaTabela(String palavra){
        int codigoDeEspalhamento = this.calculaCodigoDeEspalhamento(palavra);
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % tabela.size();
    }
    private int calculaCodigoDeEspalhamento(String palavra){
        int codigo = 1;
        for (int i = 0; i < palavra.length(); i++) {
            codigo = 31 * codigo + palavra.charAt(i);
        }
        return codigo;
    }
    public void adiciona(String palavra){
        if(!contem(palavra)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.add(palavra);
            tamanho++;
        }

    }
    public void remove(String palavra){
        if(!contem(palavra)){
            verificaCarga();
            int indice = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.remove(palavra);
            tamanho--;
        }
    }
    public boolean contem(String palavra){
        int indice = calculaIndiceDaTabela(palavra);
        List<String> lista = tabela.get(indice);
        return lista.contains(palavra);
    }
    public List<String> pegaTodas(){
        ArrayList<String> palavras = new ArrayList<>();
        for (int i=0; i < tabela.size(); i++){
            palavras.addAll(tabela.get(i));
        }
        return palavras;
    }
    public int tamanho(){
        return tamanho;
    }

    public void imprimeTabela() {
        for (List<String> lista : this.tabela) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }
}
