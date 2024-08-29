package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Subject{


    public String titulo;
    public int idLivro;
    public  int ano;
    public String autores;
    public String edicao;
    public String editora;


    public List<Reserva> reservas = new ArrayList<Reserva>();
    public List<Exemplar> listaExemplares = new ArrayList<Exemplar>();
    public List<Observer> listaObservadores = new ArrayList<Observer>();
    public ArrayList<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();

    public Livro(String titulo, int idLivro, int ano, String edicao, String editora, String autores) {
        this.titulo = titulo;
        this.idLivro = idLivro;
        this.ano = ano;
        this.edicao = edicao;
        this.editora = editora;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Exemplar> getListaExemplares() {
        return listaExemplares;
    }

    public void setListaExemplares(List<Exemplar> listaExemplares) {
        this.listaExemplares = listaExemplares;
    }

    public List<Observer> getListaObservadores() {
        return listaObservadores;
    }

    public void setListaObservadores(List<Observer> listaObservadores) {
        this.listaObservadores = listaObservadores;
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    // metodos da classe livro
    @Override
    public void registrarObservador(Observer observador) {
        listaObservadores.add(observador);
    }

    public void addExemplar(Exemplar exemplar){
        listaExemplares.add(exemplar);
    }

    public boolean verificarDisponibilidade(){
        for (Exemplar exemplar : listaExemplares){
            if (exemplar.isStatusEmprestimo() == false) //esta emprestado?
                return  true;
        }
        return false;
    }

    public boolean temExemplar(){
        if(listaExemplares.size()>0){
            return true;
        }
        return false;
    }

    public  int numeroEmprestimos(){
        return listaEmprestimos.size();
    }

    public int numeroReservas () {
        return reservas.size();
    }

    public String usuariosComReserva() {
        String nomes = " ";
        for (Reserva reserva : reservas){
            nomes += reserva.getUsuario().getNome() + ", ";
        }
        return nomes;
    }

    public String usuariosComEmprestimo() {
        String nomes = " ";
        for (Emprestimo emprestimo : listaEmprestimos) {
            nomes += emprestimo.getUsuario().getNome() + ", ";

        };
        return nomes;
    }

    public String usuarioComEmprestimoExemplar(Exemplar exemplar) {
        String nome = " ";
        for (Emprestimo emprestimo : listaEmprestimos) {
            if(exemplar == emprestimo.getExemplar()){
                nome = emprestimo.nomeUsuario();
                return nome;
            }

        };
        return nome;
    }

    public void livConsulta() throws IOException{
        GerenciadorMensagens.livConsulta(this);
    }

    public int getNumExemplaresDisponiveis() {
        int exemplaresDisponiveis = 0;
        for (Exemplar e : listaExemplares) {
            if (e.isStatusEmprestimo()==false) {
                exemplaresDisponiveis++;
            }
        }
        return exemplaresDisponiveis;
    }

    public boolean maisExemplaresDisponiveisQueReservados(){
        if(this.getNumExemplaresDisponiveis() > reservas.size()){
            return true;
        }
        return false;
    }

    public  void addEmprestimo(Emprestimo emprestimo){
        listaEmprestimos.add(emprestimo);
    }

    public void notificarOBS()
    {
        for(Observer obs : listaObservadores)
        {
            obs.update(this);
        }
    }


    public void addReserva(Reserva reserva){
        reservas.add(reserva);
        if(reservas.size() > 2){
            notificarOBS();
        }
    }
    public Exemplar getExemplarReservado(){
        for(Exemplar exemplar : listaExemplares){
            if(exemplar.isStatusEmprestimo()==false){
                return exemplar;
            }
        }
        return null;
    }

    public Exemplar getExemplarDisponivel() {
        for(Exemplar e : listaExemplares) {
            if(!e.isStatusEmprestimo()) {
                return e;
            }
        }
        return null;
    }

    public void removerReserva(Reserva reserva){
        int index = reservas.indexOf(reserva);
        if(index >=0){
            reservas.remove(index);
            reservas.size();
        }
    }

    public boolean estaReservado(){
        for (Exemplar exemplar : listaExemplares){
            if(exemplar.isStatusEmprestimo()){
                return true;
            }
        }
        return false;
    }

    public int indiceEmprestimoPorExemplar(int idExemplar){
        for(Emprestimo emprestimo : listaEmprestimos)
        {
            if(emprestimo.getIdExemplar() == idExemplar) {
                int index = listaEmprestimos.indexOf(emprestimo);
                return index;
            }
        }
        return 0;
    }


    public void removerEmprestimoPorExemplar(long idExemplar){
        long index = indiceEmprestimoPorExemplar((int) idExemplar);
        listaEmprestimos.remove(index);
    }

}
