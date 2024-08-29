package org.example.Cmds;

import org.example.CarregadorArgs;
import org.example.Biblioteca;

public class cmdConsultaNotificacao implements IComando {
    @Override
    public void executar(CarregadorArgs args) {

        int idUsuario = args.getArg1();

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdConsultaNotificacao(idUsuario);
    }
}
