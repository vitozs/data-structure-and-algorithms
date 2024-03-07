package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.List;

public class MapaLista {
    private List<Associacao> associacoes = new ArrayList<>();
    public void adiciona(String placa, Carro carro){
        if(!contemChave(placa)){
            Associacao associacao = new Associacao(placa, carro);
            associacoes.add(associacao);
        }
    }
    public Carro pega(String placa){
        for(Associacao associacao : associacoes){
            if(placa.equals(associacao.getPlaca())){
                return associacao.getCarro();
            }
        }
        throw new IllegalArgumentException("Placa inválida!");
    }
    public void remove(String placa){
        if(contemChave(placa)){
            for (int i =0; i < associacoes.size(); i++){
                Associacao associacao = associacoes.get(i);
                if (placa.equals(associacao.getPlaca())){
                    associacoes.remove(i);
                    break;
                }
            }
        }
        throw new IllegalArgumentException("chave inválida");
    }
    public boolean contemChave(String placa){
        for (Associacao associacao : associacoes){
            if(associacao.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return associacoes.size();
    }

}
