
drop database Consultorio;
create database Consultorio;
use Consultorio;

CREATE TABLE Pessoa (
    idPessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE Paciente (
    idPaciente INT PRIMARY KEY AUTO_INCREMENT,
    idPessoa INT NOT NULL,
    CONSTRAINT fk_paciente_pessoa FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa) ON DELETE CASCADE
);

CREATE TABLE Profissional (
    idProfissional INT PRIMARY KEY AUTO_INCREMENT,
    idPessoa INT NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    CONSTRAINT fk_profissional_pessoa FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa) ON DELETE CASCADE
);

create table Sala (
    idSala INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    tipo ENUM('Consulta', 'Terapia') NOT NULL,
    capacidade INT DEFAULT 1
);

-- Criar tabelas que dependem das anteriores
create table Agenda (
    idAgenda INT AUTO_INCREMENT PRIMARY KEY,
    idProfissional INT NOT NULL,
    idSala INT NOT NULL,
    dataHoraInicio DATETIME NOT NULL,
    dataHoraFim DATETIME NOT NULL,
    status ENUM('Confirmado', 'Cancelado', 'Pendente') DEFAULT 'Pendente',
    FOREIGN KEY (idProfissional) REFERENCES Profissional(idProfissional) ON DELETE CASCADE,
    FOREIGN KEY (idSala) REFERENCES Sala(idSala) ON DELETE CASCADE
);

create table Consulta (
    idConsulta INT AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT NOT NULL,
    idProfissional INT NOT NULL,
    data DATE NOT NULL,
    status ENUM('Agendado', 'Realizado', 'Cancelado') DEFAULT 'Agendado',
    observacoes TEXT,
    anexo BLOB,
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente) ON DELETE CASCADE,
    FOREIGN KEY (idProfissional) REFERENCES Profissional(idProfissional) ON DELETE CASCADE
);

create table Estoque (
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    quantidade INT NOT NULL
);

create table MovimentacaoEstoque (
    idMovimentacaoEstoque INT AUTO_INCREMENT PRIMARY KEY,
    idProduto INT NOT NULL,
    idProfissional INT,
    idConsulta INT,
    tipo_movimento ENUM('Entrada', 'Saída') NOT NULL,
    quantidade INT NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo TEXT,
    FOREIGN KEY (idProduto) REFERENCES Estoque(idProduto) ON DELETE CASCADE,
    FOREIGN KEY (idProfissional) REFERENCES Profissional(idProfissional) ON DELETE SET NULL,
    FOREIGN KEY (idConsulta) REFERENCES Consulta(idConsulta) ON DELETE SET NULL
);

create table Pagamento (
    idPagamento INT AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT NOT NULL,
    idProfissional INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pagamento ENUM('Dinheiro', 'Cartão Crédito', 'Cartão Débito', 'Pix') NOT NULL,
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente) ON DELETE CASCADE,
    FOREIGN KEY (idProfissional) REFERENCES Profissional(idProfissional) ON DELETE CASCADE
);

CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    idPessoa INT NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipoUsuario ENUM('Admin', 'Profissional', 'Paciente') NOT NULL,
    CONSTRAINT fk_usuario_pessoa FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa) ON DELETE CASCADE
);
