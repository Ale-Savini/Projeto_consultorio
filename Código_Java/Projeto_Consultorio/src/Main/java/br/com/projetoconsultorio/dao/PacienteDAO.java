package Main.java.br.com.projetoconsultorio.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Main.java.br.com.projetoconsultorio.model.Paciente;

public class PacienteDAO {

    // Inserir pessoa na tabela e retornar o id gerado
public int inserirPessoa(String nome, String sobrenome, String cpf, String email, String telefone) {
    String sql = "INSERT INTO pessoa (nome, sobrenome, cpf, email, telefone) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, nome);
        stmt.setString(2, sobrenome);
        stmt.setString(3, cpf);
        stmt.setString(4, email);
        stmt.setString(5, telefone);

        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // retorna idPessoa gerado
            }
        }

    } catch (SQLException e) {
        System.out.println("Erro ao inserir pessoa: " + e.getMessage());
    }

    return -1; // erro
}


    // Método para inserir um novo paciente no banco
    public void adicionarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (idPessoa) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paciente.getIdPessoa());
            stmt.executeUpdate();
            System.out.println("Paciente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    // Método para listar todos os pacientes
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT p.idPessoa, p.nome, p.sobrenome, p.cpf, p.email, p.telefone FROM paciente pac "
                   + "JOIN pessoa p ON pac.idPessoa = p.idPessoa";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente(
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pacientes: " + e.getMessage());
        }

        return pacientes;
    }

    // Método para atualizar dados do paciente (na tabela pessoa)
    public void atualizarPaciente(Paciente paciente) {
        String sql = "UPDATE pessoa SET nome=?, sobrenome=?, cpf=?, email=?, telefone=? WHERE idPessoa=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getSobrenome());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getEmail());
            stmt.setString(5, paciente.getTelefone());
            stmt.setInt(6, paciente.getIdPessoa());
            stmt.executeUpdate();
            System.out.println("Paciente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    // Método para deletar um paciente (na tabela pessoa e paciente)
    public void deletarPaciente(int idPessoa) {
        String sqlPaciente = "DELETE FROM paciente WHERE idPessoa=?";
        String sqlPessoa = "DELETE FROM pessoa WHERE idPessoa=?";

        try (Connection conn = Conexao.conectar()) {
            // Deletar da tabela paciente
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlPaciente)) {
                stmt1.setInt(1, idPessoa);
                stmt1.executeUpdate();
            }

            // Deletar da tabela pessoa
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlPessoa)) {
                stmt2.setInt(1, idPessoa);
                stmt2.executeUpdate();
            }

            System.out.println("Paciente deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar paciente: " + e.getMessage());
        }
    }
}
