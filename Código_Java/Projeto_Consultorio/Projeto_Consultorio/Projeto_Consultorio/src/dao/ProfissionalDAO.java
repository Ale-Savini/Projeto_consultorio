package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Profissional;

public class ProfissionalDAO {

    public void cadastrarProfissional(Profissional profissional) {
        String sqlPessoa = "INSERT INTO pessoa (nome, sobrenome, cpf, email, telefone) VALUES (?, ?, ?, ?, ?)";
        String sqlProfissional = "INSERT INTO profissional (idPessoa, especialidade) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS)) {
                stmtPessoa.setString(1, profissional.getNome());
                stmtPessoa.setString(2, profissional.getSobrenome());
                stmtPessoa.setString(3, profissional.getCpf());
                stmtPessoa.setString(4, profissional.getEmail());
                stmtPessoa.setString(5, profissional.getTelefone());
                stmtPessoa.executeUpdate();

                ResultSet generatedKeys = stmtPessoa.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idPessoa = generatedKeys.getInt(1);
                    profissional.setIdPessoa(idPessoa);

                    try (PreparedStatement stmtProf = conn.prepareStatement(sqlProfissional)) {
                        stmtProf.setInt(1, idPessoa);
                        stmtProf.setString(2, profissional.getEspecialidade());
                        stmtProf.executeUpdate();
                    }
                }

                conn.commit();
                System.out.println("Profissional cadastrado com sucesso!");

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Erro ao cadastrar profissional: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    public ArrayList<Profissional> listarProfissionais() {
        ArrayList<Profissional> lista = new ArrayList<>();
        String sql = "SELECT p.idPessoa, p.nome, p.sobrenome, p.cpf, p.email, p.telefone, " +
                     "pr.idProfissional, pr.especialidade " +
                     "FROM pessoa p " +
                     "INNER JOIN profissional pr ON p.idPessoa = pr.idPessoa";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Profissional p = new Profissional(
                    rs.getInt("idProfissional"),
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("especialidade")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar profissionais: " + e.getMessage());
        }

        return lista;
    }

    public void atualizarProfissional(Profissional profissional) {
        String sqlPessoa = "UPDATE pessoa SET nome=?, sobrenome=?, cpf=?, email=?, telefone=? WHERE idPessoa=?";
        String sqlProfissional = "UPDATE profissional SET especialidade=? WHERE idPessoa=?";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPessoa = conn.prepareStatement(sqlPessoa)) {
                stmtPessoa.setString(1, profissional.getNome());
                stmtPessoa.setString(2, profissional.getSobrenome());
                stmtPessoa.setString(3, profissional.getCpf());
                stmtPessoa.setString(4, profissional.getEmail());
                stmtPessoa.setString(5, profissional.getTelefone());
                stmtPessoa.setInt(6, profissional.getIdPessoa());
                stmtPessoa.executeUpdate();
            }

            try (PreparedStatement stmtProf = conn.prepareStatement(sqlProfissional)) {
                stmtProf.setString(1, profissional.getEspecialidade());
                stmtProf.setInt(2, profissional.getIdPessoa());
                stmtProf.executeUpdate();
            }

            conn.commit();
            System.out.println("Profissional atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar profissional: " + e.getMessage());
        }
    }

    public void deletarProfissional(int idPessoa) {
        String sqlProfissional = "DELETE FROM profissional WHERE idPessoa=?";
        String sqlPessoa = "DELETE FROM pessoa WHERE idPessoa=?";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(sqlProfissional)) {
                stmt1.setInt(1, idPessoa);
                stmt1.executeUpdate();
            }

            try (PreparedStatement stmt2 = conn.prepareStatement(sqlPessoa)) {
                stmt2.setInt(1, idPessoa);
                stmt2.executeUpdate();
            }

            conn.commit();
            System.out.println("Profissional deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar profissional: " + e.getMessage());
        }
    }
}
