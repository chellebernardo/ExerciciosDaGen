CREATE DATABASE db_funcionaries;

USE db_funcionaries;

CREATE TABLE tb_funcionaries  (
    id_funcionarie INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    sexo VARCHAR(255),
    funcao VARCHAR(255) NOT NULL,
    nascimento DATE,
    idade INT,
    email VARCHAR(255),
    cpf CHAR(34) NOT NULL UNIQUE,
    rg CHAR (34) NOT NULL,
    data_inicio DATE,
    salario FLOAT NULL,
    UNIQUE (id_funcionarie),
    PRIMARY KEY (id_funcionarie)
);
INSERT INTO tb_funcionaries (nome, sexo, funcao, nascimento, idade, email, cpf, rg, data_inicio, salario)
VALUES

("Anthony Marcos Vinicius da Rocha", "Masculino", "Tesoureiro", "1999-10-09", "22", "anthonymarcosvra@santosdumonthospital.com.br", "555.672.074-68", "19.472.062-7", "2020-02-01", "5000.0"),
("Rafaela Silvana da Costa", "Feminino", "Secretária", "1996-07-10", "25", "rafaelasilvanadacosta@dr.com", "254.034.428-39", "39.954.999-7", "2010-04-03", "2500.0"),
("Caroline Alice Aparício", "Feminino", "CEO", "1991-12-07", "30", "carolinealiceaparicio_@casabellavidros.com.br", "747.835.217-00", "50.517.257-4", "2010-10-07", "30000.0"),
("Gael Martin Manoel da Rosa", "Masculino", "Recepcionista", "1988-01-03", "33", "gaelmartinmanoeldarosa-96@yahoo.com.ar", "018.100.888-28", "37.240.565-4", "2018-03-25", "1826.6"),
("Daniela Isabel Pinto", "Feminino", "Assistente Junior", "1997-08-06", "24", "danielaisabelpinto@agsolve.com.br", "245.215.535-75", "12.017.489-3", "2019-04-21", "1754.8");


SELECT nome, salario
FROM tb_funcionaries
WHERE salario > 2000
ORDER BY salario DESC;

SELECT nome, salario
FROM tb_funcionaries
WHERE salario < 2000
ORDER BY salario DESC;

UPDATE tb_funcionaries
SET salario = 2123.6
WHERE id_funcionarie = 9;