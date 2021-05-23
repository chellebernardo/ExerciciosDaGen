CREATE DATABASE db_cidade_das_frutas;

USE db_cidade_das_frutas;

-- determine 3 atributos para a Categoria
CREATE TABLE tb_categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- nomde da categoria
tipo VARCHAR (255), -- organico, industrializado, enlatado
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
INSERT INTO tb_categoria (nome, tipo)
VALUES

("Verdura", "Orgânico"), -- 1
("Fruta", "Orgânico"), -- 2
("Grãos e Cereais", "Orgânico"), -- 3
("Enlatados e Conservas", "Insdustrializado"), -- 4
("Massas", "Industrializados"), -- 5
("Legumes", "Orgânico"), -- 6
("Óleos e azeites", "Orgânico"), -- 7
("Farináceos", "Orgânico"), -- 8
("Molhos, temperos e condimentos", "Orgânico"), -- 9
("Congelados", "Orgânico"); -- 10

-- inserindo 8 dados na tb_produto
INSERT INTO tb_produto (nome, descricao, peso, validade, valor, fk_categoria)
VALUES
("Alface Americana", "Tipo bola", "250g", "Perecível", 2.89, 1),
("Arroz Camil", "Grãos de arroz embalado", "5kg", "2023-01", 23.99, 3),
("Macarrão Espaguete ADRIA", "Massa de espaguete com Ovos tipo 8", "500g", "2023-02", 3.09, 5),
("Feijão Carioca QUALITÁ", "Grãos de feijão embalado", "1kg", "2023-03", 5.99, 3),
("Milho Conversa Quero", "Milho em conserva", "170g", "2023-04", 2.55, 4),
("Cebola à Granel", "Cebolas", "500g", "Perecível", 1.79, 6),
("Canjiquinha Xerem Yoki", "Canjica", "500g", "2023-05", 5.79, 3),
("Óleo LIZA", "Óleo de soja", "900ml", "2022-01", 7.59, 7),
("Farinha de mandioca Yoki", "Farinha de mandioca grossa", "1kg", "2023-06", 8.99, 8),
("Repolho verde", "Replho verde bola", "Unidade", "Perecível", 5.38, 1),
("Acelga Japonesa", "Acelga embalada", "Unidade", "Perecível", 3.79, 1),
("Salmão Congelado QUALITÁ", "Pedaços de salmão congelados", "1kg", "2023-04", 63.90, 10),
("Molho Curry QUALITÁ", "Molho pronto em vidro", "330g", "2023-06", 15.00, 9),
("Cenoura", "A granel", "500g", "Perecível", 1.25, 6),
("Laranja Pera", "Laranja", "1kg", "Perecível", 3.49, 2),
("Banana Prata", "Banana", "600g", "Perecível", 3.59, 2),
("Mamão Formosa", "Bandeja", "Unidade", "Perecível", 7.48, 2),
("Pera Portuguesa", "A granel", "400g", "Perecível", 5.20, 2),
("Maracujá", "A granel", "350g", "Perecível", 2.20, 2);

-- retornar produtos com valor maior que 50 reais
SELECT tb_produto.nome AS Produto, tb_categoria.tipo AS Tipo, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor > 50
ORDER BY valor DESC;

-- mostrar produtos com o valor entre 3 e 60 reais
SELECT tb_produto.nome AS produto, tb_categoria.tipo AS Tipo, tb_produto.validade, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor BETWEEN 3 AND 60
ORDER BY tb_produto.valor DESC;

-- mostrar todos os produtos que contém a letra C
SELECT * 
FROM tb_produto
WHERE nome LIKE '%c%';

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
WHERE id_categoria = 2
ORDER BY tb_produto.nome ASC;

-- para saber o nome de todos os produtos, sua categoria, descrição e o valor
SELECT tb_produto.id_produto AS Código, tb_produto.nome AS Nome, tb_categoria.nome AS Tipo, tb_produto.descricao AS Descricao, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
ORDER BY tb_produto.nome ASC;