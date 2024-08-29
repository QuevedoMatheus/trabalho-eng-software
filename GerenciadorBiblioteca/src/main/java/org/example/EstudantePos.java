package org.example;

public class EstudantePos extends Usuario{
    private int qtdMaximoLivroEmprestimo;
    public EstudantePos (int idUsuario, String nome){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.qtdMaximoLivroEmprestimo = 4;
        setMaximoDiasEmprestimo(3);
        validador = new ValidarEstudante();
    }
}
