package com.example.trabalho_pw_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoH2 {
    private static final String URL = "jdbc:h2:~/loja_online;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void criarTabelas() {
        String criarClientes = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) UNIQUE NOT NULL, " +
                "senha VARCHAR(100) NOT NULL)";

        String criarLojistas = "CREATE TABLE IF NOT EXISTS lojistas (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) UNIQUE NOT NULL, " +
                "senha VARCHAR(100) NOT NULL)";

        String criarProdutos = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "descricao TEXT, " +
                "preco DECIMAL(10,2) NOT NULL, " +
                "quantidade INT NOT NULL)";

        try (Connection conn = getConnection();
             var stmt = conn.createStatement()) {

            stmt.execute(criarClientes);
            stmt.execute(criarLojistas);
            stmt.execute(criarProdutos);

            // Inserir dados iniciais
            stmt.execute("MERGE INTO clientes KEY(email) VALUES " +
                    "(1, 'João Pedro', 'jp2017@uol.com.br', '12345jaum'), " +
                    "(2, 'Amara Silva', 'amarasil@bol.com.br', 'amara82'), " +
                    "(3, 'Maria Pereira', 'mariape@terra.com.br', '145aektm')");

            stmt.execute("MERGE INTO lojistas KEY(email) VALUES " +
                    "(1, 'Taniro Rodrigues', 'tanirocr@gmail.com', '123456abc'), " +
                    "(2, 'Lorena Silva', 'lore_sil@yahoo.com.br', '12uhuuu@')");

            stmt.execute("MERGE INTO produtos KEY(id) VALUES " +
                    "(1, 'Mesa', 'Uma mesa de computador', 500.00, 10), " +
                    "(2, 'Lápis', 'Lápis B2 grafite', 2.00, 50), " +
                    "(3, 'Computador', 'Computador I5 16Gb de RAM', 1500.00, 2)");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}