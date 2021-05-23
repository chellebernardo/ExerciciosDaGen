CREATE DATABASE db_cursoDaMinhaVida;

USE db_cursoDaMinhaVida;

-- determine 3 atributos para a Categoria
CREATE TABLE tb_categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255),
departamento VARCHAR (255), -- qual area de ensino
nivel VARCHAR (255), -- iniciante, intermediário e avançado
UNIQUE (id_categoria),
PRIMARY KEY (id_categoria)
);

-- determine 5 atributos para o produto
CREATE TABLE tb_produto (
id_produto INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- nome do produto
descricao VARCHAR (255), -- bla bla
ensino VARCHAR (255), -- Presencial, EAD ou remoto
tamanho VARCHAR (255), -- duração
certificado VARCHAR (255), -- sim ou não
valor VARCHAR (255),
fk_categoria INT,
UNIQUE (nome),
UNIQUE (id_produto),
PRIMARY KEY (id_produto),
FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

-- inserindo 5 dados na tb_categoria
INSERT INTO tb_categoria (nome, departamento, nivel)
VALUES

/*1*/("Programação", "Tech", "Iniciante"),
/*2*/("Front-end", "Tech", "Intermediário"),
/*3*/("Data Science", "Tech", "Avançado"),
/*4*/("DevOps", "Tech", "Avançado"),
/*5*/("UX & Design", "Tech", "Intermediário");

-- inserindo 8 dados na tb_produto
INSERT INTO tb_produto (nome, descricao, ensino, tamanho, certificado, valor, fk_categoria)
VALUES
/*1*/("Lógica de programação Javascript I", "Os primeiros programas com Javascript", "EAD", "16h", "Sim", 1200, 1),
/*2*/("HTML5 e CSS3 parte I", "A primeira página da Web", "EAD", "8h", "Sim", 900, 2),
/*3*/("Introdução ao SQL com MySQL", "Manipule e consulte dados", "Remoto", "12h", "Sim", 1400, 3),
/*4*/("Git e GitHub", "Controle e compartilhe o seu código", "Presencial", "6h", "Sim", 900, 4),
/*5*/("Adobe XD", "Design visual de um site mobile", "EAD", "10h", "Sim", 1400, 5),
/*6*/("Curso EX", "Metodologias práticas para designers", "Remoto", "10h", "Sim", 1200, 5),
/*7*/("Administração do Oracle Database", "Criação e gerenciamento do banco de dados", "EAD", "10h", "Sim", 1200, 3),
/*8*/("Angular", "Começando com o framework", "Presencial", "10h", "Sim", 900, 2);


-- retornar produtos com valor maior que 50 reais
SELECT tb_produto.nome AS Curso, tb_categoria.departamento AS Departamento, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor > 50
ORDER BY valor DESC;

-- mostrar produtos com o valor entre 3 e 60 reais
SELECT tb_produto.nome AS Curso, tb_categoria.departamento AS Departamento, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor BETWEEN 3 AND 60
ORDER BY tb_produto.valor DESC;

-- mostrar todos os produtos que contém a letra J
SELECT *
FROM tb_produto
WHERE nome LIKE '%J%';

-- INNER JOIN para saber nome e a quantidade de produtos de um mesmo departamento
SELECT tb_categoria.departamento AS Categoria, count(*) AS Quantidade
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
GROUP BY tb_categoria.departamento
ORDER BY tb_categoria.departamento ASC;

-- para informar todos os produtos que são de uma categoria específica
SELECT tb_produto.nome AS Curso, tb_categoria.nome AS Categoria
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE id_categoria = 2
ORDER BY tb_produto.nome ASC;

-- para saber o nome de todos os produtos, sua categoria, descrição, duração e o valor
SELECT tb_produto.id_produto AS Código, tb_produto.nome AS Nome, tb_categoria.departamento AS Departamento, tb_produto.descricao AS Descricao, tb_produto.tamanho AS Duração, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
ORDER BY tb_produto.nome ASC;