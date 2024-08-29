package org.example;

public class Exemplar {
    public int idExemplar;
    public Livro livro;
    public boolean statusEmprestimo;

    public Exemplar(int idExemplar, Livro livro) {
        this.idExemplar = idExemplar;
        this.livro = livro;
        this.statusEmprestimo = statusEmprestimo;
    }

    public long getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(boolean statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public void disponibilizarExemplar(int idLivro) {
        this.statusEmprestimo = true;
    }
}
