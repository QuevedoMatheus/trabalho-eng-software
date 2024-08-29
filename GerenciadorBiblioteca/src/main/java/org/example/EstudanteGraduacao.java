package org.example;

public class EstudanteGraduacao extends Usuario{

    private int qtdMaxLivroEmprestimo;

    public  EstudanteGraduacao (int idUsuario, String nome){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.qtdMaxLivroEmprestimo = 3;
        setMaximoDiasEmprestimo(3);
        validador = new ValidarEstudante();
    }

    public int getQtdMaximoLivroEmprestimo() {
        return qtdMaxLivroEmprestimo;
    }
}
