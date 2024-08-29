package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Entrada entrada = new Entrada();


        Usuario usuario1 = new EstudanteGraduacao(123, "João da Silva");
        Usuario usuario2 = new EstudantePos(456, "Luiz Fernando Rodrigues");
        Usuario usuario3 = new EstudanteGraduacao(789, "Pedro Paulo");
        Usuario usuario4 = new Professor(100, "Carlos Lucena");


        Livro livro1 = new Livro("Engenharia de Software", 100, 2000, "6", "AddisonWesley", "Ian Sommervile");
        Livro livro2 = new Livro("UML - Guia do Usuario", 101, 2000, "7", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson");
        Livro livro3 = new Livro("Code Complete", 200, 2014, "2", "Microsoft Press", "Steve McConnell");
        Livro livro4 = new Livro("Agile Software Development, Principles, Patterns, and Practices", 201, 2002, "1", "Prentice Hall", "Robert Martin");
        Livro livro5 = new Livro("Refactoring: Improving the Design of Existing Code", 300, 1999, "1", "Addison-Wesley Professional", "Martin Fowler");
        Livro livro6 = new Livro("Software Metrics: A Rigorous and Practical Apporach", 301, 2014, "3", "CRC Press", "Norman Fenton, James Bieman");
        Livro livro7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Sofware", 400, 1994, "1", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        Livro livro8 = new Livro("UML Distilled: A Brief guide to the Standard Object Modeling Language", 401, 2003, "3", "Addison-Wesley Professional", "Martin Fowler");

        Exemplar exemplar1 = new Exemplar(01, livro1);
        Exemplar exemplar2 = new Exemplar(02, livro1);
        Exemplar exemplar3 = new Exemplar(03, livro2);
        Exemplar exemplar4 = new Exemplar(04, livro3);
        Exemplar exemplar5 = new Exemplar(05, livro4);
        Exemplar exemplar6 = new Exemplar(06, livro5);
        Exemplar exemplar7 = new Exemplar(07, livro5);
        Exemplar exemplar8 = new Exemplar(8, livro7);
        Exemplar exemplar9 = new Exemplar(9, livro7);

        livro1.addExemplar(exemplar1);
        livro1.addExemplar(exemplar2);
        livro2.addExemplar(exemplar3);
        livro3.addExemplar(exemplar4);
        livro4.addExemplar(exemplar5);
        livro5.addExemplar(exemplar6);
        livro5.addExemplar(exemplar7);
        livro7.addExemplar(exemplar8);
        livro7.addExemplar(exemplar9);

        Biblioteca biblioteca = Biblioteca.obterInstancia();
        biblioteca.addUsuario(usuario1);
        biblioteca.addUsuario(usuario2);
        biblioteca.addUsuario(usuario3);
        biblioteca.addUsuario(usuario4);

        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);
        biblioteca.addLivro(livro3);
        biblioteca.addLivro(livro4);
        biblioteca.addLivro(livro5);
        biblioteca.addLivro(livro6);
        biblioteca.addLivro(livro7);
        biblioteca.addLivro(livro8);

        GerenciadorMensagens.mainInicializacao();

        while(true){
            String comando = scanner.nextLine();

            entrada.executarComando(comando);
        }



    }
}