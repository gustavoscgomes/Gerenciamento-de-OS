//create table clientes (
//        idcliente int primary key auto_increment,
//        nome_cli varchar (50) not null,
//        cpf_cli varchar (14),
//        fone_cli varchar(14) not null,
//        email_cli varchar (50),
//        rua_cli varchar (100) not null,
//        bairro_cli varchar (100) not null,
//        cidade_cli varchar (100) not null,
//        uf_cli varchar (2) not null,
//        data_nascimento_cli date
//        );

import java.sql.Date;

public class Cliente {

    private int idCliente;
    private String nomeCli;
    private String foneCli;
    private String emailCli;
    private String cpfCli;
    private String ruaCli;
    private String bairroCli;
    private String cidadeCli;
    private String ufCli;
    private Date dataNascimentoCli;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getFoneCli() {
        return foneCli;
    }

    public void setFoneCli(String foneCli) {
        this.foneCli = foneCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(String cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getRuaCli() {
        return ruaCli;
    }

    public void setRuaCli(String ruaCli) {
        this.ruaCli = ruaCli;
    }

    public String getBairroCli() {
        return bairroCli;
    }

    public void setBairroCli(String bairroCli) {
        this.bairroCli = bairroCli;
    }

    public String getCidadeCli() {
        return cidadeCli;
    }

    public void setCidadeCli(String cidadeCli) {
        this.cidadeCli = cidadeCli;
    }

    public String getUfCli() {
        return ufCli;
    }

    public void setUfCli(String ufCli) {
        this.ufCli = ufCli;
    }

    public Date getDataNascimentoCli() {
        return dataNascimentoCli;
    }

    public void setDataNascimentoCli(Date dataNascimentoCli) {
        this.dataNascimentoCli = dataNascimentoCli;
    }
}
