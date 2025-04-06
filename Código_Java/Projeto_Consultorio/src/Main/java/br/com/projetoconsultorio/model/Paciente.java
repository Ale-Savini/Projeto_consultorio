package Main.java.br.com.projetoconsultorio.model;

public class Paciente extends Pessoa {

    // Construtor
    public Paciente(int idPessoa, String nome, String sobrenome, String cpf, String email, String telefone) {
        super(idPessoa, nome, sobrenome, cpf, email, telefone);
    }

    // Sobrescrita do método para exibir informações
    @Override
    public void exibirInformacoes() {
        System.out.println("ID: " + getIdPessoa());
        super.exibirInformacoes();
    }
}
