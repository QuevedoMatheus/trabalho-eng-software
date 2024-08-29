package org.example;

public class ValidarProfessor implements IValidadorEmprestimo{
    @Override
    public boolean validar(Usuario usuario, Livro livro) {
        String nomeUsuario = usuario.getNome();
        String nomeLivro = livro.getTitulo();

        if (!livro.verificarDisponibilidade()) {
            GerenciadorMensagens.verificarDisponibilidade(nomeLivro);
            return false;
        }
        if (usuario.temDebito()) {
            GerenciadorMensagens.verificarDebito();
            return false;
        }

        Exemplar exemplar = null;

        if (livro.verificarDisponibilidade()) {
            exemplar = livro.getExemplarDisponivel();
        } else if (livro.estaReservado()) {
            exemplar = livro.getExemplarReservado();
        }

        exemplar.setStatusEmprestimo(true);
        Emprestimo emprestimo = new Emprestimo(usuario, livro, exemplar);
        usuario.addEmprestimo(emprestimo);
        livro.addEmprestimo(emprestimo);
        usuario.addNumEmprestimos();
        GerenciadorMensagens.empComSucesso(nomeLivro, nomeUsuario);

        return true;

    }
}