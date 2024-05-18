import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/bibliotecaJava";
            String user = "postgres";
            String password = "admin";
            connection = DriverManager.getConnection(url, user, password);


            System.out.println("Conexão estabelecida com sucesso!");

            // Não esquecer de fechar a conexão quando terminar de usar!!!!!!!!!!!
            // connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados.");
            e.printStackTrace();
        } finally {
            // Fechar a conexão no bloco finally para garantir que sempre seja fechada, mesmo em caso de exceção
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
