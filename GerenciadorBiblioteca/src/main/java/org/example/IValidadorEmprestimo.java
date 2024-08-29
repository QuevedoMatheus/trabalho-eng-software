package org.example;

import org.example.Livro;
import org.example.Usuario;

public interface IValidadorEmprestimo {
    public boolean validar (Usuario usuario, Livro livro);
}
