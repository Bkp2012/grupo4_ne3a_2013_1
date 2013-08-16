SHOW DATABASES;

CREATE DATABASE IF NOT EXISTS Sigmav;

USE Sigmav;

CREATE TABLE Peca(
    id INT PRIMARY KEY NOT NULL  AUTO_INCREMENT,
    descricao varchar(200) NOT NULL,
    codigoReferencia varchar (250) NOT NULL,
    grupo varchar (50) NOT NULL
);



DROP Table Manutencao;
CREATE TABLE Manutencao(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quilometragem INT NOT NULL,
    dataManutencao DATE,
    descricao VARCHAR(200) NOT NULL,
    custoManutencao FLOAT NOT NULL    
);

select * from Manutencao;

CREATE TABLE Consumo(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dataAbastecimento DATE NOT NULL,
    quilometragem INT NOT NULL,
    litros FLOAT,
    preco FLOAT,
    combustivel VARCHAR(30),
    local INT,
    idVeiculo INT
);

CREATE TABLE Contato(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    telefoneA VARCHAR(10),
    telefoneB VARCHAR(10),
    telefoneC VARCHAR(10),
    eMail VARCHAR(150),
    responsavel VARCHAR(100)
);

CREATE TABLE Fornecedor(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100), 
    cnpj VARCHAR(13),
    endereco VARCHAR(300),
    grupos VARCHAR(400),
    contatoID INT,
    comentario VARCHAR(300)
);

DESCRIBE Manutencao;
SELECT * FROM Manutencao;