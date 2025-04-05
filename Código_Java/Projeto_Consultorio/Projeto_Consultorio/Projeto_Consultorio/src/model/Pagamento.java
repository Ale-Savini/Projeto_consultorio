package model;
import java.time.LocalDateTime;

public class Pagamento {
    private int idPagamento; 
    private Paciente paciente; 
    private Profissional profissional; 
    private double valor; 
    private LocalDateTime dataPagamento; 
    private String metodoPagamento; 

    
    public Pagamento(int idPagamento, Paciente paciente, Profissional profissional, double valor, String metodoPagamento) {
        this.idPagamento = idPagamento;
        this.paciente = paciente;
        this.profissional = profissional;
        this.valor = valor;
        this.dataPagamento = LocalDateTime.now(); // Registra o momento atual do pagamento
        this.metodoPagamento = metodoPagamento;
    }

  
    public int getIdPagamento() {
        return idPagamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

   
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    
    public void exibirPagamento() {
        System.out.println("ID do Pagamento: " + idPagamento);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Profissional: " + profissional.getNome());
        System.out.println("Valor: R$" + valor);
        System.out.println("Data do Pagamento: " + dataPagamento);
        System.out.println("Método de Pagamento: " + metodoPagamento);
    }
}
