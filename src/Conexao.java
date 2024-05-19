import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Conexao {
    public static void main(String[] args) {
        Connection connection = null;
        final String url = "jdbc:postgresql://localhost:5432/bibliotecaJava";
        final String user = "postgres";
        final String password = "admin";

        try {
            Class.forName("org.postgresql.Driver");
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

    public void insertUsers() {
        final String url = "jdbc:postgresql://localhost:5432/bibliotecaJava";
        final String user = "postgres";
        final String password = "admin";
        Scanner scan = new Scanner(System.in);
        String sql = "INSERT INTO usuarios (nome, senha, email, datanascimento) VALUES (?, ?, ?, ?)";

        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Digite seu email: ");
        String email = scan.nextLine();

        System.out.println("Crie uma senha: ");
        String senha = scan.nextLine();

        System.out.println("Confirme sua senha: ");
        String senhaConfirm = scan.nextLine();

        while (!Objects.equals(senha, senhaConfirm)){
            System.out.println("Algo deu errado. Tente novamente");

            System.out.println("Crie uma senha: ");
            senha = scan.nextLine();

            System.out.println("Confirme sua senha: ");
            senhaConfirm = scan.nextLine();
        }

        System.out.println("Digite sua data de nascimento dividido por '-'. Exemplo: 2020-01-01");
        String data = scan.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Adicionar o primeiro registro
            pstmt.setString(1, nome);
            pstmt.setString(2, senha);
            pstmt.setString(3, email);
            pstmt.setDate(4, java.sql.Date.valueOf("1990-01-01"));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
