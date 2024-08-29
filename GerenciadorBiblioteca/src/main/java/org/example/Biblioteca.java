package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();

    private static Biblioteca instancia;

    public static Biblioteca obterInstancia(){
        if(instancia == null){
            instancia = new Biblioteca();
        }
        return instancia;
    }
    public Usuario encontrarUsuarioByID(int idUsuario){
        for(Usuario usuario : usuarios){
            if (usuario.getIdUsuario() == idUsuario){
                return usuario;
            }
        }
        return null;
    }

    public Livro encontrarLivroByID(int idLivro){
        for ( Livro livro : livros){
            if (livro.getIdLivro() == idLivro){
                return livro;
            }
        }
        return null;
    }

    private Usuario getUsuario (int idUsuario){
        for (Usuario usuario : usuarios){
            if (usuario.getIdUsuario() == idUsuario){
                return usuario;
            }
        }
        return null;
    }

    public Livro getLivro (int idLivro){
        for ( Livro livro : livros){
            if (livro.getIdLivro() == idLivro){
                if(livro.verificarDisponibilidade()){
                    return livro;
                }
            }
        }
        return  null;
    }

    public void cmdReservar(int idCliente, int idLivro) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.getUsuario(idCliente);
        Livro livro = biblioteca.getLivro(idLivro);
        boolean encontrouReserva = false;
        if (usuario.getQtdReserva() < 3) {
            encontrouReserva = false;
            for (Reserva reserva : usuario.reservas) {
                if (reserva.getIdLivro() == idLivro) {
                    encontrouReserva = true;
                    break;
                }
            }

            if (!encontrouReserva) {
                Reserva reserva = new Reserva(usuario, livro);
                livro.addReserva(reserva);
                usuario.addReserva(reserva);
                GerenciadorMensagens.resRealizada(usuario, livro);
            } else {
                GerenciadorMensagens.resDuplicada(livro, usuario);
            }
        }
        else {
            GerenciadorMensagens.resNumMaximo();
        }
    }
    public void cmdDevolver(int idCliente, int idLivro){
        Biblioteca biblioteca = obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        Livro livro = biblioteca.encontrarLivroByID(idLivro);
        boolean temLivro = usuario.livroEstaComUsuario(idLivro);
        if (temLivro){
            Exemplar exemplar = usuario.getExemplarParaDevolver(idLivro);
            GerenciadorMensagens.devRealizada(livro, usuario);
            exemplar.disponibilizarExemplar(idLivro);
            usuario.devolverReservaExemplar(idLivro);
            usuario.addNumEmprestimos();
            livro.removerEmprestimoPorExemplar(exemplar.getIdExemplar());
            exemplar.setStatusEmprestimo(false);
        } else {
            GerenciadorMensagens.devNaoRealizada(livro, usuario);
        }

    }

    public void cmdConsultarLivro(int idLivro){
        Biblioteca biblioteca = obterInstancia();
        Livro livro = biblioteca.encontrarLivroByID(idLivro);
        GerenciadorMensagens.livConsulta(livro);
    }

    public void cmdConsultarUsuario(int idCliente){
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        GerenciadorMensagens.usuConsulta(usuario);
    }

    public void cmdConsultaNotificacao(int idCliente){
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.getUsuario(idCliente);
       GerenciadorMensagens.ntfConsulta(usuario);
    }

    public void cmdObservar(int idCliente, int idLivro){
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.getUsuario(idCliente);
        Livro livro = biblioteca.getLivro(idLivro);

        livro.registrarObservador((Observer) usuario);
        GerenciadorMensagens.obsAdicionado(livro, usuario);
    }

    public void cmdSair(){
        GerenciadorMensagens.sair();
        System.exit(0);
    }

    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void cmdEmprestar (int idCliente, int idLivro){
        Biblioteca biblioteca = obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        Livro livro = biblioteca.encontrarLivroByID(idLivro);

        if(livro == null){
            GerenciadorMensagens.empSemExemplar();
        }
        usuario.fazerEmprestimo(usuario, livro);
    }


}
