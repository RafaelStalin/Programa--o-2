
CREATE DATABASE loja;

use loja;

CREATE TABLE clientes(
		idclientes int(11) auto_increment primary key,
		clientesnome varchar(50),
		clientesemail  varchar(100),
		clientescpf varchar(20),
		clientesend varchar(100)

);

CREATE TABLE produtos (
	idprodutos int(11)  auto_increment primary key,
	produtosqtd int(20),
	produtosdsc varchar(100),
	produtosnome varchar(50),
	produtosvalor double

);

CREATE TABLE itens (
	iditens int(11) auto_increment primary key,
	idclientes int(11),
	idprodutos int(11),
	qtdselecionada int(11)

	
);