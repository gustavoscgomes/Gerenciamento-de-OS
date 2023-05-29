import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
    public static Connection geraConexao(){
        Connection conexao = null;
        try{
            String url = "jdbc:mysql://localhost/dbevoenergy";
            String usuario ="root";
            String senha="root1234";
            conexao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão realizada com sucesso.");
        } catch (
                SQLException e) {
            System.out.println("Ocorreu um erro ao tentar conectar: " + e.getMessage());
            conexao = null;
        }
        return conexao;
    }
}
