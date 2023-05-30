import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection connection;
    public ClienteDAO() {
        this.connection = new Conexao().geraConexao();
    }

    //    nome_cli varchar (50) not null,
//    cpf_cli varchar (14),
//    fone_cli varchar(14) not null,
//    email_cli varchar (50),
//    rua_cli varchar (100) not null,
//    bairro_cli varchar (100) not null,
//    cidade_cli varchar (100) not null,
//    uf_cli varchar (2) not null,
//    data_nascimento_cli date


    public void adiciona(Cliente c) {
        String sql = "INSERT INTO clientes(nome_cli, cpf_cli, fone_cli," +
                "email_cli, rua_cli, bairro_cli, cidade_cli," +
                "uf_cli, data_nascimento_cli) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getNomeCli());
            stmt.setString(2, c.getCpfCli());
            stmt.setString(3, c.getFoneCli());
            stmt.setString(4, c.getEmailCli());
            stmt.setString(5, c.getRuaCli());
            stmt.setString(6, c.getBairroCli());
            stmt.setString(7, c.getCidadeCli());
            stmt.setString(8, c.getUfCli());
            stmt.setDate(9, new Date(c.getDataNascimentoCli().getTime()));
//            adicionar data atual
//            stmt.setDate(3, new java.sql.Date(p.getDataDeNascimento().getTime()));
            if (c.getNomeCli().isEmpty() || c.getCpfCli().isEmpty() ||
                    c.getFoneCli().isEmpty() || c.getEmailCli().isEmpty() ||
                    c.getRuaCli().isEmpty() || c.getBairroCli().isEmpty() ||
                    c.getCidadeCli().isEmpty() || c.getUfCli().isEmpty()) {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                 int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Cliente adicionado!");
                    stmt.close();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cliente> lista() {
        try {
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCli(rs.getString("nome_cli"));
                c.setCpfCli(rs.getString("cpf_cli"));
                c.setFoneCli(rs.getString("fone_cli"));
                c.setEmailCli(rs.getString("email_cli"));
                c.setRuaCli(rs.getString("rua_cli"));
                c.setBairroCli(rs.getString("bairro_cli"));
                c.setCidadeCli(rs.getString("cidade_cli"));
                c.setUfCli(rs.getString("uf_cli"));
                c.setDataNascimentoCli(rs.getDate("data_nascimento_cli"));
                clientes.add(c);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void remove(Cliente c) {
        String sql = "DELETE FROM clientes WHERE idcliente = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, c.getIdCliente());

            if (c.getIdCliente() == 0) {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Cliente removido!");
                    stmt.close();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(Cliente c) {
        String sql = "UPDATE clientes SET nome_cli = ?,cpf_cli = ?,fone_cli = ?," +
                "email_cli = ?,rua_cli = ?,bairro_cli = ?,cidade_cli = ?,uf_cli = ?," +
                "data_nascimento_cli = ? WHERE idcliente = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getNomeCli());
            stmt.setString(2, c.getCpfCli());
            stmt.setString(3, c.getFoneCli());
            stmt.setString(4, c.getEmailCli());
            stmt.setString(5, c.getRuaCli());
            stmt.setString(6, c.getBairroCli());
            stmt.setString(7, c.getCidadeCli());
            stmt.setString(8, c.getUfCli());
            stmt.setDate(9, new Date(c.getDataNascimentoCli().getTime()));
            stmt.setInt(10, c.getIdCliente());

            if (c.getNomeCli().isEmpty() || c.getCpfCli().isEmpty() ||
                    c.getFoneCli().isEmpty() || c.getEmailCli().isEmpty() ||
                    c.getRuaCli().isEmpty() || c.getBairroCli().isEmpty() ||
                    c.getCidadeCli().isEmpty() || c.getUfCli().isEmpty()) {

                System.out.println("É necessário preencher todos os campos!!");
            } else {

                int adicionado = stmt.executeUpdate();
//                stmt.close();

                if (adicionado > 0) {
                    System.out.println("Cliente Atualizado!");
                    stmt.close();
                }

            }
//            stmt.execute();
//            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //    nome_cli varchar (50) not null,
//    cpf_cli varchar (14),
//    fone_cli varchar(14) not null,
//    email_cli varchar (50),
//    rua_cli varchar (100) not null,
//    bairro_cli varchar (100) not null,
//    cidade_cli varchar (100) not null,
//    uf_cli varchar (2) not null,
//    data_nascimento_cli date
    public Cliente buscaPorNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome_cli = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = null;
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNomeCli(rs.getString("nome_cli"));
                cliente.setCpfCli(rs.getString("cpf_cli"));
                cliente.setFoneCli(rs.getString("fone_cli"));
                cliente.setEmailCli(rs.getString("email_cli"));
                cliente.setRuaCli(rs.getString("rua_cli"));
                cliente.setBairroCli(rs.getString("bairro_cli"));
                cliente.setCidadeCli(rs.getString("cidade_cli"));
                cliente.setUfCli(rs.getString("uf_cli"));
                cliente.setDataNascimentoCli(rs.getDate("data_nascimento_cli"));
            }
            rs.close();
            stmt.close();
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
