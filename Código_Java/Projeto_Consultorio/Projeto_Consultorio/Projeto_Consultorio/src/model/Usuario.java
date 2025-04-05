package model;
public class Usuario {
    private int idUsuario; 
    private String nome; 
    private String email; 
    private String senha; 
    private String tipoUsuario; 
    private Integer idProfissional; 

    // Construtor
    public Usuario(int idUsuario, String nome, String email, String senha, String tipoUsuario, Integer idProfissional) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.idProfissional = idProfissional;
    }

    // Métodos Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Integer getIdProfissional() {
        return idProfissional;
    }

    // Métodos Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setIdProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    // Método para exibir informações do usuário
    public void exibirUsuario() {
        System.out.println("ID: " + idUsuario);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Usuário: " + tipoUsuario);
        System.out.println("ID Profissional: " + (idProfissional != null ? idProfissional : "Nenhum"));
    }
}
