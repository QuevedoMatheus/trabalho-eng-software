package org.example.Cmds;

import org.example.CarregadorArgs;
import org.example.Biblioteca;

public class cmdConsultaLivro implements IComando {
    @Override
    public void executar(CarregadorArgs args) {


        int idLivro = args.getArg1();

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdConsultarLivro(idLivro);
    }
}
