package Main.java.br.com.projetoconsultorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/consultorio";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";


public static Connection conectar(){
    try {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    } catch (SQLException e) {
    System.out.println("Erro ao concectar ao banco de dados: " + e.getMessage());
    
return null;
    }
}

public static void desconectar(Connection connection){
try {

if(connection !=null && !connection.isClosed()){
    connection.close();
}

    
} catch (SQLException e) {
    System.out.println("Erro ao fechar a conexão" + e.getMessage());
}
}
}