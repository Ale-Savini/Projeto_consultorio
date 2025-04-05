package model;
public class Sala {
    
    private int idSala;
    private String nome;
    private String tipo;

    public Sala(int idSala, String nome, String tipo) {
        this.idSala = idSala;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void exibirInformacoes() {
        System.out.println("ID da Sala: " + idSala);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
    }
}

