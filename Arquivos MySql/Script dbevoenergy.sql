create database dbevoenergy;
use dbevoenergy;
CREATE TABLE usuarios (
idusuario int primary key auto_increment,
usuario varchar(50) NOT NULL,
login varchar(30) NOT NULL,
senha varchar(30) NOT NULL,
data_add_us timestamp default current_timestamp
);

create table clientes (
idcliente int primary key auto_increment,
nomecli varchar (50) not null,
fonecli varchar(14) not null,
emailcli varchar (50) not null,
enderecocli varchar (150) not null,
data_add_cli timestamp default current_timestamp
);

drop table clientes;

describe clientes;
create table os(
idos int primary key auto_increment,
data_os timestamp default current_timestamp,
servico varchar(150),
valor decimal(10,2),
idcliente int not null,
foreign key(idcliente) references clientes(idcliente)
);
describe os;
insert into usuarios(usuario, login, senha)
values ('gustavo', 'admin', 'admin');
select * from clientes;
use dbevoenergy;
select * from os;
drop table clientes;
use dbevoenergy;
create table clientes (
idcliente int primary key auto_increment,
nome_cli varchar (50) not null,
cpf_cli varchar (14),
fone_cli varchar(14) not null,
email_cli varchar (50),
rua_cli varchar (100) not null,
bairro_cli varchar (100) not null,
cidade_cli varchar (100) not null,
uf_cli varchar (2) not null,
data_nascimento_cli date
);
describe clientes;
select * from clientes;
create table os(
idos int primary key auto_increment,
data_os timestamp default current_timestamp,
servico varchar(150),
valor decimal(10,2),
idcliente int not null,
foreign key(idcliente) references clientes(idcliente)
);
alter table os add tecnico varchar(50) after servico;
describe clientes;
alter table os add observacao varchar(150) after valor;
alter table os add status varchar(150) after observacao;
describe os;