package model;
import java.time.LocalDateTime;

public class MovimentacaoEstoque {
    private String tipoMovimento; 
    private int quantidade; 
    private String motivo; 
    private LocalDateTime dataMovimento; 

    
    public MovimentacaoEstoque(String tipoMovimento, int quantidade, String motivo) {
        this.tipoMovimento = tipoMovimento;
        this.quantidade = quantidade;
        this.motivo = motivo;
        this.dataMovimento = LocalDateTime.now(); 
    }

    
    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    
    public void exibirMovimentacao() {
        System.out.println("Tipo de Movimento: " + tipoMovimento);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Motivo: " + motivo);
        System.out.println("Data e Hora: " + dataMovimento);
    }
}
