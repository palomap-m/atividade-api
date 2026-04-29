USE application;
 
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_de_usuario VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);
 
CREATE TABLE pizzarias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    endereco VARCHAR(255) NOT NULL
);
 
CREATE TABLE ingredientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade_estoque DOUBLE NOT NULL,
    unidade_medida VARCHAR(50) NOT NULL,
    pizzaria_id BIGINT NOT NULL,
    FOREIGN KEY (pizzaria_id) REFERENCES pizzarias(id)
);
 