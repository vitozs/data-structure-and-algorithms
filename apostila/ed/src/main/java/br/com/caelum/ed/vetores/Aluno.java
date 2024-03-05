package br.com.caelum.ed.vetores;

public class Aluno {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object object) {
        Aluno outro = (Aluno)object;
        return  this.nome.equals(outro.getNome());
    }

}
