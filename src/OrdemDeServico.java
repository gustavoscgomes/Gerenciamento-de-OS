import java.sql.Date;

//idos int primary key auto_increment,
//        data_os timestamp default current_timestamp,
//        servico varchar(150),
//        valor decimal(10,2),
//        idcliente int not null,
public class OrdemDeServico {

    private int idos;
    private String servico;
    private String tecnico;
    private double valor;
    private int idcliente;

    private Date dataOs;
    private String observacao;


    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataOs() {
        return dataOs;
    }

    public void setDataOs(Date dataOs) {
        this.dataOs = dataOs;
    }

    public int getIdos() {
        return idos;
    }

    public void setIdos(int idos) {
        this.idos = idos;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
}
