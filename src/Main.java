import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner para Strings
        Scanner input = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
        int opcao = 0;

        System.out.print("Login: ");
        String loginmain = input.nextLine();

        System.out.print("Senha: ");
        String senhamain = input.nextLine();

        if (Autenticacao.autenticaLogin(loginmain, senhamain)) {

            do {
                System.out.println("Login successful");

                System.out.println("Menu:");
                System.out.println("1 - Menu Usuario");
                System.out.println("2 - Menu Cliente");
                System.out.println("3 - Menu Ordem De Serviço");

                opcao = scanner.nextInt();

                if (opcao == 1) {


                    System.out.println("Menu Usuario:");

                    System.out.println("1 - Adicionar Usuario");
                    System.out.println("2 - Remover Usuario");
                    System.out.println("3 - Atualizar Usuario");
                    //            System.out.println("4 - Buscar Cliente por Nome");
                    //            System.out.println("5 - Listar Todas os Clientes");
                    System.out.println("0 - Sair");

                    System.out.print("Digite a opção desejada: ");
                    opcao = input.nextInt();
                    input.nextLine();

                    switch (opcao) {
                        case 1:

                            System.out.print("Digite o Usuaio: ");
                            String usuario = scanner.nextLine();
                            System.out.print("Digite a Login: ");
                            String login = scanner.nextLine();
                            System.out.print("Digite a Senha: ");
                            String senha = scanner.nextLine();

                            Usuario u = new Usuario();
                            u.setUsuario(usuario);
                            u.setLogin(login);
                            u.setSenha(senha);

                            usuarioDAO.adiciona(u);

                            System.out.println("Usuarios adicionado!");

                            break;

                        case 2:

                            System.out.print("Digite o usuario ");
                            String usuarioRemover = scanner.nextLine();

                            Usuario uRemover = new Usuario();
                            uRemover.setUsuario(usuarioRemover);

                            usuarioDAO.remove(uRemover);

                            System.out.println("Usuario removido ");
                            break;

                        case 3:

                            System.out.print("Digite o usuário a ser atualizado ");
                            String usuarioAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo login ");
                            String novoLogin = scanner.nextLine();
                            System.out.print("Digite a nova senha ");
                            String novasenha = scanner.nextLine();


                            Usuario uAtualizar = new Usuario();
                            uAtualizar.setUsuario(usuarioAtualizar);
                            uAtualizar.setSenha(novasenha);
                            uAtualizar.setLogin(novoLogin);

                            usuarioDAO.atualiza(uAtualizar);
                            System.out.println("Usuario atualizada!");
                            break;
                    }
                    System.out.println("Digite 0 para voltar ao menu");
                    opcao = input.nextInt();

                } else if (opcao == 2) {

                    System.out.println("Menu Cliente:");

                    System.out.println("1 - Adicionar Cliente");
                    System.out.println("2 - Remover Cliente");
                    System.out.println("3 - Atualizar Cliente");
                    System.out.println("4 - Buscar Cliente por Nome");
                    System.out.println("5 - Listar Todas os Clientes");
                    System.out.println("0 - Sair");

                    System.out.print("Digite a opção desejada: ");
                    opcao = input.nextInt();
                    //                input.nextLine();

                    switch (opcao) {

                        case 1:

                            System.out.print("Digite o nome do cliente: ");
                            scanner.nextLine(); // para corrigir um erro do scanner
                            String nome_cli = scanner.nextLine();
                            System.out.print("Digite a cpf do cliente (apenas numeros): ");
                            String cpf_cli = scanner.nextLine();

                            while (!(Autenticacao.autenticaCPF(cpf_cli))) {
                                System.out.println("CPF invalido. Digite novamente");
                                cpf_cli = scanner.nextLine();
                            }

                            System.out.print("Digite a telefone do cliente: ");
                            String fone_cli = scanner.nextLine();
                            System.out.print("Digite o Email do cliente: ");
                            String email_cli = scanner.nextLine();

                            while (!(Autenticacao.autenticaEmail(email_cli))) {

                                System.out.println("Erro! email invalido, digite novamente: ");
                                email_cli = scanner.nextLine();
                            }

                            System.out.print("Digite a rua do cliente: ");
                            String rua_cli = scanner.nextLine();
                            System.out.print("Digite o bairro do cliente: ");
                            String bairro_cli = scanner.nextLine();
                            System.out.print("Digite a cidade do cliente: ");
                            String cidade_cli = scanner.nextLine();
                            System.out.print("Digite a Uf do cliente: ");
                            String uf_cli = scanner.nextLine();
                            System.out.println("Data de nascimento no formato AAAA-MM-DD");
                            String data_nascimento = scanner.nextLine();
                            Date dataDeNascimento = Date.valueOf(data_nascimento);


                            Cliente c = new Cliente();
                            c.setNomeCli(nome_cli);
                            c.setCpfCli(cpf_cli);
                            c.setFoneCli(fone_cli);
                            c.setEmailCli(email_cli);
                            c.setRuaCli(rua_cli);
                            c.setBairroCli(bairro_cli);
                            c.setCidadeCli(cidade_cli);
                            c.setUfCli(uf_cli);
                            c.setDataNascimentoCli(dataDeNascimento);

                            clienteDAO.adiciona(c);

                            break;

                        case 2:

                            System.out.print("Digite o Id do Cliente: ");
                            int clienteRemover = scanner.nextInt();

                            Cliente cRemover = new Cliente();
                            cRemover.setIdCliente(clienteRemover);

                            clienteDAO.remove(cRemover);

                            break;

                        case 3:
                            System.out.print("Digite o id do cliente a ser atualizado: ");
                            int id_atualizar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Digite o novo nome: ");
                            String novo_nome = scanner.nextLine();
                            System.out.print("Digite o novo cpf do cliente (apenas numeros): ");
                            String novo_cpf = scanner.nextLine();

                            while (!(Autenticacao.autenticaCPF(novo_cpf))) {
                                System.out.println("CPF invalido. Digite novamente");
                                cpf_cli = scanner.nextLine();
                            }
                            System.out.print("Digite o novo telefone ");
                            String novo_telefone = scanner.nextLine();
                            System.out.print("Digite o novo email ");
                            String novo_email = scanner.nextLine();

                            while (!(Autenticacao.autenticaEmail(novo_email))) {

                                System.out.println("Erro! email invalido, digite novamente: ");
                                novo_email = scanner.nextLine();
                            }

                            System.out.print("Digite a nova rua: ");
                            String nova_rua = scanner.nextLine();
                            System.out.print("Digite o novo bairro: ");
                            String novo_bairro = scanner.nextLine();
                            System.out.print("Digite a nova cidade: ");
                            String nova_cidade = scanner.nextLine();
                            System.out.print("Digite a nova UF: ");
                            String nova_uf = scanner.nextLine();
                            System.out.println("Data a nova data de nascimento no formato AAAA-MM-DD");
                            String nova_data = scanner.nextLine();
                            Date novaDataDeNascimento = Date.valueOf(nova_data);



                            Cliente cliente_atualizar = new Cliente();
                            cliente_atualizar.setNomeCli(novo_nome);
                            cliente_atualizar.setCpfCli(novo_cpf);
                            cliente_atualizar.setFoneCli(novo_telefone);
                            cliente_atualizar.setEmailCli(novo_email);
                            cliente_atualizar.setRuaCli(nova_rua);
                            cliente_atualizar.setBairroCli(novo_bairro);
                            cliente_atualizar.setCidadeCli(nova_cidade);
                            cliente_atualizar.setUfCli(nova_uf);
                            cliente_atualizar.setDataNascimentoCli(novaDataDeNascimento);
                            cliente_atualizar.setIdCliente(id_atualizar);

                            clienteDAO.atualiza(cliente_atualizar);

                            break;

                        case 4:
                            System.out.print("Digite o nome ");
                            scanner.nextLine();
                            String nomeBuscar = scanner.nextLine();

                            Cliente clienteBuscar = clienteDAO.buscaPorNome(nomeBuscar);

                            if (clienteBuscar != null) {
                                System.out.println("Id: " +clienteBuscar.getIdCliente()+ "\nNome: " + clienteBuscar.getNomeCli() +
                                        "\nCpf: " +clienteBuscar.getCpfCli()+
                                        "\nFone: " +clienteBuscar.getFoneCli()+
                                        "\nEmail: " +clienteBuscar.getEmailCli()+
                                        "\nRua: " +clienteBuscar.getRuaCli()+
                                        "\nBairro: " +clienteBuscar.getBairroCli()+
                                        "\nCidade: " +clienteBuscar.getCidadeCli()+
                                        "\nUf: " +clienteBuscar.getUfCli()+
                                        "\nData de nascimento: " +clienteBuscar.getDataNascimentoCli());
                            } else {
                                System.out.println("Pessoa não encontrada!");
                            }
                            break;

                        case 5:
                            ArrayList<Cliente> clientes = clienteDAO.lista();
                            for (Cliente cliente : clientes) {
                                System.out.println("Id: " +cliente.getIdCliente()+ "\nNome: " + cliente.getNomeCli() +
                                        "\nCpf: " +cliente.getCpfCli()+
                                        "\nFone: " +cliente.getFoneCli()+
                                        "\nEmail: " +cliente.getEmailCli()+
                                        "\nRua: " +cliente.getRuaCli()+
                                        "\nBairro: " +cliente.getBairroCli()+
                                        "\nCidade: " +cliente.getCidadeCli()+
                                        "\nUf: " +cliente.getUfCli()+
                                        "\nData de nascimento: " +cliente.getDataNascimentoCli());
                            }
                            break;
                    }
                    System.out.println("Digite 0 para voltar ao menu");
                    opcao = input.nextInt();
                } else if (opcao == 3) {

                    System.out.println("Menu Ordem De Serviço:");

                    System.out.println("1 - Emitir ordem de serviço");
                    System.out.println("2 - Excluir Ordem De Serviço");
                    System.out.println("3 - Atualizar Ordem De Serviço");
                    System.out.println("4 - Buscar Ordem De Serviço por Id");
                    System.out.println("5 - Listar Todas os Clientes");
                    System.out.println("0 - Sair");

                    System.out.print("Digite a opção desejada: ");
                    opcao = input.nextInt();
                    //                input.nextLine();

                    switch (opcao) {

                        case 1:

                            System.out.print("Digite o Servico Instalaçao/Manutenção: ");
                            scanner.nextLine(); // para corrigir um erro do scanner
                            String servico = scanner.nextLine();
                            System.out.print("Digite O Valor: R$");
                            double valor = scanner.nextDouble();
                            System.out.print("Digite o Id do cliente: ");
                            int id_cliente = scanner.nextInt();



                            OrdemDeServico os = new OrdemDeServico();
                            os.setServico(servico);
                            os.setValor(valor);
                            os.setIdcliente(id_cliente);

                            ordemDeServicoDAO.emite(os);


                            break;

                        case 2:

                            System.out.print("Digite o Id da Ordem de Servico ");
                            scanner.nextLine(); // para ocrrigir um erro com o scanner
                            int osRemover = scanner.nextInt();

                            OrdemDeServico oRemover = new OrdemDeServico();
                            oRemover.setIdos(osRemover);

                            ordemDeServicoDAO.remove(oRemover);

                            break;

                        case 3:
                            System.out.print("Digite o id da Ordem De Serviço a ser atualizada: ");
                            int id_atualizar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Digite o tipo novo serviço manutenção/instalação: ");
                            String novo_servico = scanner.nextLine();
                            System.out.print("Digite o novo valor: R$ ");
                            double novo_valor = scanner.nextDouble();


                            OrdemDeServico os_atualizar = new OrdemDeServico();
                            os_atualizar.setServico(novo_servico);
                            os_atualizar.setValor(novo_valor);


                            os_atualizar.setIdos(id_atualizar);

                            ordemDeServicoDAO.atualiza(os_atualizar);

                            break;

                        case 4:
                            System.out.print("Digite o id da Ordem De Serviço ");

                            int idBuscar = scanner.nextInt();

                            OrdemDeServico osBuscar = ordemDeServicoDAO.buscaPorId(idBuscar);

                            if (osBuscar != null) {
                                System.out.println("Id: " +osBuscar.getIdos()+ "\nServiço: " +osBuscar.getServico()+
                                        "\nValor: RS" +osBuscar.getValor()+ "\nId do Cliente: " +osBuscar.getIdcliente()+
                                        "\nData: " +osBuscar.getDataOs());
                            } else {
                                System.out.println("Os não encontrada!");
                            }
                            break;

                        case 5:
                            ArrayList<OrdemDeServico> ordemDeServicos = ordemDeServicoDAO.lista();
                            for (OrdemDeServico ordemDeServico : ordemDeServicos) {
                                System.out.println("Id: " +ordemDeServico.getIdos()+ "\nServiço: " +ordemDeServico.getServico()+
                                        "\nValor: R$" +ordemDeServico.getValor()+ "\nId do cliente: " +ordemDeServico.getIdcliente()+
                                        "\nData: " +ordemDeServico.getDataOs());
                                System.out.println("");
                            }
                            break;
                    }
                    System.out.println("Digite 0 para voltar ao menu");
                    opcao = input.nextInt();

                }

            } while (opcao == 0);

        } else {
            System.out.println("Usuário e ou/ senha inválido(s)");
        }

    }

    }
