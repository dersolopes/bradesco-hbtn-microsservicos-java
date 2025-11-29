import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateH2Database {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:file:./bd/demobd";
        String username = "sa";
        String password = "123456";

        try {
            // Carrega o driver H2
            Class.forName("org.h2.Driver");

            // Cria conexão (isso criará o arquivo .mv.db)
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Cria uma tabela de exemplo
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS INFO (ID INT PRIMARY KEY, NAME VARCHAR(255))");
            stmt.execute("INSERT INTO INFO VALUES (1, 'H2 Database Initialized')");

            System.out.println("Banco de dados H2 criado com sucesso!");
            System.out.println("Arquivo: bd/demobd.mv.db");

            // Fecha conexão
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("Erro ao criar banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

