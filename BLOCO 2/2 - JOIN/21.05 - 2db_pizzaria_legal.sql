CREATE DATABASE db_pizzaria_legal;

USE db_pizzaria_legal;

-- determine 3 atributos para a Categoria
CREATE TABLE tb_categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- pizza, broto
tipo VARCHAR (255), -- doce, salgada
tamanho VARCHAR (255), -- grande, média, pequena
UNIQUE (id_categoria),
PRIMARY KEY (id_categoria)
);

-- determine 5 atributos para o Pizza
CREATE TABLE tb_pizza (
id_pizza INT NOT NULL AUTO_INCREMENT,
sabor VARCHAR (255), -- nome do sabor
descricao VARCHAR (255), -- pequena descrição
borda VARCHAR (255), -- recheada ou não
molho VARCHAR (255), -- opções de molho
valor VARCHAR (255), -- preço
fk_categoria INT,
UNIQUE (sabor),
UNIQUE (id_pizza),
PRIMARY KEY (id_pizza),
FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

-- inserindo 5 dados na tb_categoria
INSERT INTO tb_categoria (nome, tipo, tamanho)
VALUES
("Pizza", "Salgada", "Grande"), -- 1
("Pizza", "Salgada", "Média"), -- 2
("Pizza", "Doce", "Grande"), -- 3
("Pizza", "Doce", "Média"), -- 4
("Broto", "Salgada", "Média"), -- 5
("Broto", "Salgada", "Pequena"), -- 6
("Broto", "Doce", "Média"), -- 7
("Broto", "Doce", "Pequena"); -- 8


-- inserindo 8 dados na tb_pizza
INSERT INTO tb_pizza (sabor, descricao, borda, molho, valor, fk_categoria)
VALUES
("Napolitana", "Parmesão, mussarela, rodelas de tomates, orégano e alho", "recheada", "molho tradicional", 59.90, 1),
("Pepperoni & Requijão", "Pepperoni, mussarela e requeijão", "sem recheio", "molho tradicional", 65.90, 5), 
("Calábria", "Calabresa, cebola, mussarela e requeijão", "recheada", "molho tracional", 74.90, 2), 
("Dois Queijos Garlic", "Mussarela, requeijão e alho", "sem recheio", "molho tradicional", 74.90, 1), 
("Brigadeiro", "Chocolate brigadeiro com granulado", "recheada", "sem molho", 39.90, 3), 
("Doce de Leite", "Doce de Leite povilhado com farofa de amendoin", "sem recheio", "sem molho", 44.90, 7), 
("Ovomaltine", "Massa crocante com chocolate ovomaltine", "sem recheio", "sem molho", 34.99, 8), 
("Passione", "Chocolate, pedaços de morango e uma bola grande de creme", "sem recheio", "sem molho", 49.90, 4), 
("Marguerita", "Mussarela, rodelas de tomate e um toque de manjericão", "sem recheio", "molho tradicional", 44.90, 1),
("Calabresa", "Calabresa, cebola, azeitonas verdes e mussarela", "sem recheio", "molho tradicional", 69.90, 1),
("Frango com Requeijão", "Frango desfiado, mussarela e requeijão", "sem recheio", "molho tradicional", 75.90, 1),
("Portuguesa", "Mussarela, presunto, cebola, azeitona preta e cream cheese", "recheada", "molho tradicional", 55.90, 1),
("Peito de Peru", "Mussarela, peito de peru, cream cheese, azeitonas pretas e tomate", "recheada", "molho tradicional", 64.90, 1),
("Vegetariana", "cebola, pimentão, champignon, rodelas de tomate, azeitonas verdes e mussarela", "recheada", "molho tradicional", 55.90, 1);

-- retornar produtos com valor maior que 45 reais
SELECT tb_pizza.sabor AS Pizza, tb_categoria.tipo AS Tipo, tb_pizza.valor AS Valor
FROM tb_pizza
INNER JOIN tb_categoria
ON tb_pizza.fk_categoria = tb_categoria.id_categoria
WHERE valor > 45
ORDER BY valor DESC;

-- mostrar produtos com o valor entre 29 e 60 reais
SELECT tb_pizza.sabor AS Pizza, tb_categoria.tipo AS Tipo, tb_pizza.valor AS Valor
FROM tb_pizza
INNER JOIN tb_categoria
ON tb_pizza.fk_categoria = tb_categoria.id_categoria
WHERE valor BETWEEN 29 AND 60
ORDER BY valor DESC;

-- mostrar todos os produtos que contém a letra C no nome
SELECT * 
FROM tb_pizza
WHERE sabor LIKE '%c%';

-- INNER JOIN para saber nome e a quantidade de produtos de um mesmo tipo
SELECT tb_categoria.tipo AS Categoria, count(*) AS Quantidade
FROM tb_pizza
INNER JOIN tb_categoria
ON tb_pizza.fk_categoria = tb_categoria.id_categoria
GROUP BY tb_categoria.tipo
ORDER BY tb_categoria.tipo ASC;

-- para informar todas os produtos que são de uma categoria específica
SELECT tb_pizza.sabor AS Sabor, tb_categoria.nome AS Categoria
FROM tb_pizza
INNER JOIN tb_categoria
ON tb_pizza.fk_categoria = tb_categoria.id_categoria
WHERE id_categoria = 1
ORDER BY tb_pizza.sabor ASC;

-- para saber o nome de todos os produtos, sua categoria, descrição e o preco
SELECT tb_pizza.sabor AS Nome, tb_categoria.nome AS Tipo, tb_pizza.descricao AS Descricao, tb_pizza.valor AS Valor
FROM tb_pizza
INNER JOIN tb_categoria
ON tb_pizza.fk_categoria = tb_categoria.id_categoria
ORDER BY tb_pizza.sabor ASC;