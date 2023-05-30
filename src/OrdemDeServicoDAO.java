import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdemDeServicoDAO {

    private Connection connection;
    public OrdemDeServicoDAO() {
        this.connection = new Conexao().geraConexao();
    }
    public void emite(OrdemDeServico os) {
        String sql = "INSERT INTO os(servico, valor, idcliente) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, os.getServico());
            stmt.setDouble(2, os.getValor());
            stmt.setInt(3, os.getIdcliente());
//            stmt.setDate(3, new Date(p.getDataDeNascimento().getTime()));
//            adicionar data atual
//            stmt.setDate(3, new java.sql.Date(p.getDataDeNascimento().getTime()));
            if (os.getServico().isEmpty() ||
                    os.getIdcliente() == 0)  {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Ordem De Serviço emitida!");
                    stmt.close();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<OrdemDeServico> lista() {
        try {
            ArrayList<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM os");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemDeServico os = new OrdemDeServico();
                os.setIdos(rs.getInt("idos"));
                os.setDataOs(rs.getDate("data_os"));
                os.setServico(rs.getString("servico"));
                os.setValor(rs.getDouble("valor"));
                os.setIdcliente(rs.getInt("idcliente"));

                ordemDeServicos.add(os);
            }
            rs.close();
            stmt.close();
            return ordemDeServicos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void remove(OrdemDeServico os) {
        String sql = "DELETE FROM os WHERE idos = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, os.getIdos());

            if (os.getIdos() == 0) {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Ordem De Serviço removida!");
                    stmt.close();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(OrdemDeServico os) {
        String sql = "UPDATE os SET  = ?, servico = ?, valor = ?, idcliente = ? WHERE idos = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, os.getServico());
            stmt.setDouble(2, os.getValor());
            stmt.setInt(3, os.getIdcliente());

            if (os.getServico().isEmpty() ||
            os.getValor() == 0 || os.getIdcliente() == 0) {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Ordem De Serviço Atualizada!");
                    stmt.close();
                }

            }
//            stmt.execute();
//            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public OrdemDeServico buscaPorId(int idos) {
        String sql = "SELECT * FROM os WHERE idos = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idos);
            ResultSet rs = stmt.executeQuery();
            OrdemDeServico os = null;
            if (rs.next()) {
                os = new OrdemDeServico();
                os.setIdos(rs.getInt("idos"));
                os.setServico(rs.getString("servico"));
                os.setDataOs(rs.getDate("data_os"));
                os.setValor((rs.getDouble("valor")));
                os.setIdcliente((rs.getInt("idcliente")));
            }
            rs.close();
            stmt.close();
            return os;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
