import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

//
public class UsuarioDAO {


    private Connection connection;
    public UsuarioDAO() {
        this.connection = new Conexao().geraConexao();
    }
    public void adiciona(Usuario u) {
        String sql = "INSERT INTO usuarios(usuario, login, senha) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());

//          adicionar data atual
//            stmt.setDate(3, new java.sql.Date(p.getDataDeNascimento().getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void remove(Usuario u) {
        String sql = "DELETE FROM usuarios WHERE usuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(Usuario u) {
        String sql = "UPDATE usuarios SET senha = ?, login = ? WHERE usuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getSenha());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getUsuario());
            stmt.execute();

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
