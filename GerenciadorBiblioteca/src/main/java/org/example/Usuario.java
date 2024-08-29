package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    IValidadorEmprestimo validador;

    public  int idUsuario;
    public  String nome;
    private int maxDiasEmprestimo;
    private  int qtdMaximoLivroEmprestimo;
    private int numEmprestimos = 0;

    public List<Reserva> reservas = new ArrayList<Reserva>();
    public List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public IValidadorEmprestimo getValidador() {
        return validador;
    }

    public  int getQtdEmprestimo(){
        return this.emprestimos.size();
    }
    public void setValidador(IValidadorEmprestimo validador) {
        this.validador = validador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtMaximoLivroEmprestimo() {
        return qtdMaximoLivroEmprestimo;
    }

    public void setMaximoDiasEmprestimo(int dias) {
        this.maxDiasEmprestimo = dias;
    }

    public int getQtdMaximoLivroEmprestimo() {
        return qtdMaximoLivroEmprestimo;
    }

    public void setQtdMaximoLivroEmprestimo(int qtdMaximoLivroEmprestimo) {
        this.qtdMaximoLivroEmprestimo = qtdMaximoLivroEmprestimo;
    }

    public int getNumEmprestimos() {
        return numEmprestimos;
    }

    public void setNumEmprestimos(int numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public  boolean temDebito(){
        LocalDate dataHoraAtual = LocalDate.now();
        for(Emprestimo emprestimo : emprestimos){
            if (dataHoraAtual.isAfter(emprestimo.getDataDevolucao())){
                return true;
            }
        }
            return false;
    }

    public  boolean temReserva (int codigo){
        for (Reserva reserva : reservas){
            if (reserva.getLivro().getIdLivro() == codigo){
                return true;
            }
        }
        return false;
    }
    public Exemplar getExemplarParaDevolver(int idLivro){
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.obterlivroId() == idLivro && emprestimo.exemplarEstaEmprestado()){
                return emprestimo.getExemplar();
            }
        }
        return null;
    }

    public  boolean temLivro (int idLivro) {
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.obterlivroId() == idLivro && emprestimo.exemplarEstaEmprestado()){
                return true;
            }
        }
        return false;
    }

    public boolean livroEstacomUsuario(int idLivro){
        for (Emprestimo emprestimo : emprestimos){
            int livroid = emprestimo.obterlivroId();
            if(livroid == idLivro && emprestimo.exemplarEstaEmprestado()){
                return true;
            }
        }
        return false;
    }

    public Reserva getReserva(int codigoLivro){
        for(Reserva reserva : reservas){
            if (reserva.getLivro().getIdLivro() == codigoLivro){
                return reserva;
            }
        }
        return null;
    }
    public void addNumEmprestimos() {
        this.numEmprestimos++;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);

    }
    public void removerReserva( Reserva reserva){
        int index = reservas.indexOf(reserva);
        if(index >= 0){
            reservas.remove(index);
            reservas.size();
        }
    }
    public void devolverReservaExemplar(int codigoLivro){
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.obterlivroId() == codigoLivro && emprestimo.getDataDevolucao() == null){
                emprestimo.setDataDevolucao(LocalDate.now());
                return;
            }
        }
    }
    public void fazerEmprestimo(Usuario usuario, Livro livro) {
        validador.validar(usuario, livro);
    }

    public int getQtdReserva() {
        return this.reservas.size();

    }

    public boolean livroEstaComUsuario(int idLivro) {
        for (Emprestimo emprestimo : emprestimos){
            int idlivro = emprestimo.obterlivroId();
            if (idlivro == idLivro && emprestimo.exemplarEstaEmprestado()){
                return true;
            }
        }
        return false;
    }
}
