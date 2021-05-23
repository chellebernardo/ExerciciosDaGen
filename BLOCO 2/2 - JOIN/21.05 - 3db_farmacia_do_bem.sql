CREATE DATABASE db_farmacia_do_bem;

USE db_farmacia_do_bem;

-- determine 3 atributos para a Categoria
CREATE TABLE tb_categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- nomde da categoria
tipo VARCHAR (255), -- generico ou original
uso VARCHAR (255), -- oral, nasal, tópico
UNIQUE (id_categoria),
PRIMARY KEY (id_categoria)
);

-- determine 5 atributos para o produto
CREATE TABLE tb_produto (
id_produto INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- nome do produto
descricao VARCHAR (255), -- pequena descrição
peso VARCHAR (255), -- kg/ml
validade VARCHAR (255), -- perecível ou não perecível
valor VARCHAR (255), -- preço
fk_categoria INT,
UNIQUE (nome),
UNIQUE (id_produto),
PRIMARY KEY (id_produto),
FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

-- inserindo 5 dados na tb_categoria
INSERT INTO tb_categoria (nome, tipo, uso)
VALUES
("Medicamentos", "Original", "Oral"), -- 1
("Medicamentos", "Generico", "Nasal"), -- 2
("Medicamentos", "Generico", "Tópico"), -- 3
("Cosmetico", "Original", "Tópico"), -- 4
("Beleza", "Original", "Tópico"), -- 5
("Higiene", "Original", "Tópico"); -- 6


-- inserindo 8 dados na tb_produto
INSERT INTO tb_produto (nome, descricao, peso, validade, valor, fk_categoria)
VALUES
("Dipirona", "Antitérmico e Analgésico", "30ml", 2023-02, 10.22, 1),
("Pampers", "Fraldas Hiper G", "856g", "2023-03", 35.39, 6),
("Nivea Creme Lata", "Creme facial e corporal", "145g", 2023-04, 24.99, 5),
("Eno", "Antiácido", "5gg", 2023-05, 3.24, 1),
("Bepantol", "Hidratação e regeneração da pele", "30g", 2023-06, 36.90, 4),
("La-Roche Posay Salicylic", "Sérum Anti-Idade", "30ml", 2023-07, 170.71, 4),
("Kit Colgate", "Creme dental", "90g", 2023-08, 16.90, 6),
("Protex Pro Hidrata Amendoa", "Sabonete líquido", "250ml", 2023-09, 9.99, 6);

-- retornar produtos com valor maior que 45 reais
SELECT tb_produto.nome AS Produto, tb_categoria.tipo AS Tipo, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor > 50
ORDER BY valor DESC;

-- mostrar produtos com o valor entre 29 e 60 reais
SELECT tb_produto.nome AS produto, tb_categoria.tipo AS Tipo, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor BETWEEN 3 AND 60
ORDER BY tb_produto.valor DESC;

-- mostrar todos os produtos que contém a letra B no nome
SELECT * 
FROM tb_produto
WHERE nome LIKE '%b%';

-- INNER JOIN para saber nome e a quantidade de produtos de um mesmo tipo
SELECT tb_categoria.tipo AS Categoria, count(*) AS Quantidade
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
GROUP BY tb_categoria.tipo
ORDER BY tb_categoria.tipo ASC;

-- para informar todos os produtos que são de uma categoria específica
SELECT tb_produto.nome AS nome, tb_categoria.nome AS Categoria
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE id_categoria = 6
ORDER BY tb_produto.nome ASC;

-- para saber o nome de todos os produtos, sua categoria, descrição e o valor
SELECT tb_produto.nome AS Nome, tb_categoria.nome AS Tipo, tb_produto.descricao AS Descricao, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
ORDER BY tb_produto.nome ASC;