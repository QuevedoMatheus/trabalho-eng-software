package org.example.Cmds;

import org.example.CarregadorArgs;
import org.example.Biblioteca;

public class cmdSair implements IComando {
    @Override
    public void executar(CarregadorArgs args) {

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.cmdSair();
    }
}
