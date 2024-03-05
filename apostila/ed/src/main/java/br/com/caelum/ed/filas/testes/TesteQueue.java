package br.com.caelum.ed.filas.testes;

import br.com.caelum.ed.vetores.Aluno;

import java.util.LinkedList;
import java.util.Queue;

public class TesteQueue {
    public static void main(String[] args) {
        Queue<Aluno> fila = new LinkedList<>();
        fila.offer(new Aluno());
        fila.poll();
    }
}
