package org.example;

import org.example.Cmds.*;

import java.util.HashMap;
import java.util.Map;

public class Entrada {
    private static Map<String, IComando> comandos = new HashMap<String, IComando>();

    static {
        comandos.put("emp", new cmdEmprestar());
        comandos.put("res", new cmdReservar());
        comandos.put("dev", new cmdDevolver());
        comandos.put("obs", new cmdObservar());
        comandos.put("liv", new cmdConsultaLivro());
        comandos.put("usu", new cmdConsultaUsuario());
        comandos.put("ntf", new cmdConsultaNotificacao());
        comandos.put("sai", new cmdSair());

    }

    public static void executarComando(String cmd) {
        CarregadorArgs parametros = null;

        String[] args = cmd.split(" ");
        String command = args[0];

        if(args.length == 1){
            parametros = new CarregadorArgs();
        } else if (args.length == 2) {
            int arg1 = Integer.parseInt(args[1]);
            parametros = new CarregadorArgs(arg1);
        } else if (args.length == 3) {
            int arg1 = Integer.parseInt(args[1]);
            int arg2 = Integer.parseInt(args[2]);
            parametros = new CarregadorArgs(arg1, arg2);
        }
        comandos.get(command).executar(parametros);

    }
}
