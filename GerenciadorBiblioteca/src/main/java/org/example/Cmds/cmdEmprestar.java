package org.example.Cmds;

import org.example.Biblioteca;
import org.example.CarregadorArgs;

public class cmdEmprestar implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        int idUsuario = args.getArg1();
        int idLivro = args.getArg2();

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdEmprestar(idUsuario, idLivro);
    }
}
