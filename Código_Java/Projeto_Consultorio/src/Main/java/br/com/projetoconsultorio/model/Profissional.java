package Main.java.br.com.projetoconsultorio.model;

public class Profissional extends Pessoa {
    private int idProfissional;
    private String especialidade;

    // Construtor
    public Profissional(int idProfissional, int idPessoa, String nome, String sobrenome, String cpf, String email, String telefone, String especialidade) {
        super(idPessoa, nome, sobrenome, cpf, email, telefone); // Chama o construtor da classe Pessoa
        this.idProfissional = idProfissional;
        this.especialidade = especialidade;
    }

    // Getters
    public int getIdProfissional() {
        return idProfissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    // Setters
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Sobrescrita do método para exibir as informações
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();  // Exibe as informações da pessoa (nome, cpf, etc)
        System.out.println("ID Profissional: " + idProfissional);
        System.out.println("Especialidade: " + especialidade);
    }
}

