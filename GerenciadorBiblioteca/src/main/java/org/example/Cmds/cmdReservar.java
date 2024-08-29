package org.example.Cmds;

import org.example.CarregadorArgs;
import org.example.Biblioteca;

public class cmdReservar implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        int idUsuario = args.getArg1();
        int idLivro = args.getArg2();

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdReservar(idUsuario, idLivro);
    }
}
