package org.example;

public abstract class GerenciadorMensagens {

    //Mensagem main
    public static void mainInicializacao(){
        System.out.println("Sistema de Biblioteca");
    }

    //Mensagens Comando Livro Consulta
    public static void livConsulta (Livro livro)  {
        System.out.println("Informações do livro");
        System.out.println("Titulo: " + livro.getTitulo() + "\n" + "Número Emprestimos: " + livro.numeroEmprestimos());
        System.out.println("Número Reservas: " + livro.numeroReservas());

        if (livro.numeroReservas() > 0) {
            System.out.println("Usuarios com Reserva: " + livro.usuariosComReserva());
        }

        if (livro.numeroEmprestimos() > 0) {
            System.out.println("Usuarios com Emprestimos: " + livro.usuariosComEmprestimo());
        }

        if (livro.temExemplar()){
            for (Exemplar exemplar : livro.listaExemplares){

                if (exemplar.isStatusEmprestimo()){
                    System.out.println ("Exemplar de ID " + exemplar.getIdExemplar() +  "emprestado para " + exemplar.getLivro().usuarioComEmprestimoExemplar(exemplar) );

                } else{
                    System.out.println ("Status Exemplar: Disponivel");
                }
            }
        }
        else {System.err.println("O livro não possui exemplares!");}
    }

    //Mensagens Comando Notificação Consulta
    public static void ntfConsulta (Usuario usuario)  {
        System.out.println("Notificações Realizadas: " + ((Professor) (usuario)).getNotificacao());
    }

    //Mensagens Comando Usuario Consulta
    public static void usuConsulta(Usuario usuario) {
        if (usuario.reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva reserva : usuario.reservas) {
                System.out.println("Reserva: " + "Titulo: " + reserva.livro.getTitulo() + "\n" + "Data de solicitacao " + reserva.getDataSolicitacao());
            }
        }

        if (usuario.emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado.");
        } else {
            for (Emprestimo emprestimo : usuario.emprestimos) {
                System.out.println("Emprestimo: Atual " + "Titulo: " + emprestimo.exemplar.getLivro().getTitulo() + "\n" + "Data de emprestimo: " + emprestimo.getDataEmprestimo() + "\n" + "Prazo de devolucao: " + emprestimo.getDataDevolucao());
                if (emprestimo.estado.statusEmprestimo()) {
                    System.out.println("Estado do emprestimo: Emprestado");
                } else {
                    System.out.println("Estado do emprestimo: Em andamento");
                }
            }
        }
    }

    //Mensagens Comando Devolucao
    public static void devRealizada (Livro livro, Usuario usuario)  {
        System.out.println("Livro " + livro.getTitulo() + " devolvido pelo Usuario " + usuario.getNome());
    }

    public static void devNaoRealizada (Livro livro, Usuario usuario)  {
        System.out.println("Devolução não realizada. O livro '" + livro.getTitulo() + "' não está com o usuário " + usuario.getNome());
    }

    //Mensagens Comando Reserva
    public static void resRealizada (Usuario usuario, Livro livro)  {
        System.out.println("O Usuario  " + usuario.getNome() + " reservou o livro: " + livro.getTitulo());
    }

    public static void resDuplicada(Livro livro, Usuario usuario)  {
        System.out.println("Devolução não realizada. O livro '" + livro.getTitulo() + "' não está com o usuário " + usuario.getNome());
    }

    public static void resNumMaximo ()  {
        System.out.println("O Usuario atingiu o número máximo de reservas");
    }

    //Mensagens Comando Emprestar
    public static void empSemExemplar()  {
        System.out.println("Não tem exemplar");
    }

    public static void empComSucesso(String nomeLivro, String nomeUsuario)  {
        System.out.println(nomeLivro + " emprestado com sucesso para " + nomeUsuario + "!");
    }


    //Mensagens Comando Observer
    public static void obsAdicionado(Livro livro, Usuario usuario)  {
        System.out.println ("Professor " + usuario.getNome() + "está observando o livro: " + livro.getTitulo());
    }

    //Mensagens Comando Sair
    public static void sair()  {
        System.out.println("Programa finalizado!");
    }

    //Mensagens Validar
    public static void verificarDisponibilidade(String nomeLivro)  {
        System.out.println("Não há exemplar para o livro " + nomeLivro);
    }

    public static void verificarDebito()  {
        System.out.println("O Usuário tem débito em atraso! Não é possível efetuar o empréstimo.");
    }

    public static void verificarLimite()  {
        System.out.println("O Usuário excedeu o limite de empréstimos!");
    }

    public static void verificarExemplaresDisponiveis()  {
        System.out.println("A quantidade de reserva existente é menor do que a quantidade de exemplares disponíveis!");
    }

    public static void verificarUsuarioComLivro(Livro livro)  {
        System.out.println("O usuário já tem o livro: " + livro.getTitulo());
    }




}