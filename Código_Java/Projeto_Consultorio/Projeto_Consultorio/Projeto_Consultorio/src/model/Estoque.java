package model;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int idProduto; 
    private String nome; 
    private String descricao; 
    private int quantidade; 

    // Lista para armazenar movimentações do estoque
    private List<MovimentacaoEstoque> movimentacoes;


    public Estoque(int idProduto, String nome, String descricao, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.movimentacoes = new ArrayList<>(); // Inicializa a lista de movimentações
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public List<MovimentacaoEstoque> getMovimentacoes() {
        return movimentacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para registrar uma movimentação de estoque
    public void movimentarEstoque(String tipo, int quantidade, String motivo) {
        if (tipo.equalsIgnoreCase("Entrada")) {
            this.quantidade += quantidade; // Adiciona a quantidade ao estoque
        } else if (tipo.equalsIgnoreCase("Saída")) {
            if (this.quantidade >= quantidade) {
                this.quantidade -= quantidade; // Reduz a quantidade do estoque
            } else {
                System.out.println("Erro: Estoque insuficiente para a saída.");
                return;
            }
        } else {
            System.out.println("Erro: Tipo de movimentação inválido.");
            return;
        }

        // Criando e adicionando uma movimentação ao histórico
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque(tipo, quantidade, motivo);
        movimentacoes.add(movimentacao);
    }

    // Método para exibir informações do produto e seu estoque
    public void exibirInformacoes() {
        System.out.println("ID Produto: " + idProduto);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Quantidade em Estoque: " + quantidade);
        System.out.println("Movimentações:");
        for (MovimentacaoEstoque mov : movimentacoes) {
            mov.exibirMovimentacao();
        }
    }
}
