package org.example;

public class Professor extends Usuario implements Observer{


   public Professor(int idUsuario, String nome){
       this.idUsuario = idUsuario;
       this.nome = nome;
       validador = new ValidarProfessor();
       setMaximoDiasEmprestimo(7);
   }

   private  int notificacao;

   public int getNotificacao(){
       return notificacao;
   }


    @Override
    public void update(Livro livro) {
        notificacao++;
    }
}
