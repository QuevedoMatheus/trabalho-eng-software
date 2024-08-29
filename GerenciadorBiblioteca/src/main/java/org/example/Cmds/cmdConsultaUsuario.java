package org.example.Cmds;

import org.example.CarregadorArgs;
import org.example.Biblioteca;

public class cmdConsultaUsuario implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        int idUsuario = args.getArg1();


        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdConsultarUsuario(idUsuario);
    }
}
