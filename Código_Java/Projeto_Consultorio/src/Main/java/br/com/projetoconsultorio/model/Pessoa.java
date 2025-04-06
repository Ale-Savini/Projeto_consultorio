package Main.java.br.com.projetoconsultorio.model;

public class Pessoa {
    private int idPessoa;
    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected String email;
    protected String telefone;

    // Construtor
    public Pessoa(int idPessoa, String nome, String sobrenome, String cpf, String email, String telefone) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters
    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    // Setters
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }
}
