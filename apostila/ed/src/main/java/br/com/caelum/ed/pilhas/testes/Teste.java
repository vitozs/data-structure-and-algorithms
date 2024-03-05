package br.com.caelum.ed.pilhas.testes;

import br.com.caelum.ed.pilhas.Peca;
import br.com.caelum.ed.pilhas.Pilha;

public class Teste {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Peca peca = new Peca();
        pilha.insere(peca);
        Peca pecaRemovida = pilha.remove();
        if(peca != pecaRemovida){
            System.out.println("Erro: a peça removida não é igual " +
                    " a que foi inserida");
        }
        if (!pilha.vazia()) {
            System.out.println("Erro: A pilha não está vazia");
        }

    }
}
