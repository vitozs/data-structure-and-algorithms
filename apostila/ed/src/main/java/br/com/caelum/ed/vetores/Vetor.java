package br.com.caelum.ed.vetores;
import java.io.*;
import java.util.*;
public class Vetor {
    private Object[] objetos = new Object[100000];
    private int totalDeObjetos = 0;
    public void adiciona(Object objeto){
        //0.009s
        this.objetos[this.totalDeObjetos] = objeto;
        this.totalDeObjetos++;

        //0.012s
        /*garantaEspaco();
        this.objetos[this.totalDeObjetos] = objeto;
        this.totalDeObjetos++;*/

        //1.6s
        /*for (int i = 0; i < objetos.length; i++) {
            if (this.objetos[i] == null) {
                this.objetos[i] = objeto;
                break;
            }
        }*/
    }

    public void adiciona(int posicao, Object objeto){
        garantaEspaco();
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição invalida!");
        }
        for (int i = totalDeObjetos - 1; i >= posicao; i-- ){
            objetos[i + 1] = objetos[i];
        }

        objetos[posicao] = objeto;
        totalDeObjetos++;
    }

    private void garantaEspaco(){
        if(totalDeObjetos == objetos.length){
            Object[] novoArray = new Object[objetos.length * 2];
            for(int i = 0; i < totalDeObjetos; i++){
                novoArray[i] = objetos[i];
            }
            objetos = novoArray;

        }

    }
    public Object pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return objetos[posicao];

    }

    private boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < totalDeObjetos;
    }

    public boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= totalDeObjetos;
    }
    public void remove(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição vazia");
        }

        for(int i = posicao; i < totalDeObjetos; i++){
            objetos[i] = objetos[i+1];
        }
        totalDeObjetos--;
    }

    public boolean contem(Object objeto){
        for(int i = 0; i < totalDeObjetos; i++){
            if(objeto == objetos[i]){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return totalDeObjetos;
    }


    public String toString(){
        if (this.totalDeObjetos == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDeObjetos - 1; i++) {
            builder.append(this.objetos[i]);
            builder.append(", ");
        }
        builder.append(this.objetos[this.totalDeObjetos - 1]);
        builder.append("]");
        return builder.toString();
    }



}
