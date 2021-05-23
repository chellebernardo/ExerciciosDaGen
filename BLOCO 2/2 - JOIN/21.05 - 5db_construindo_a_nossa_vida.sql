CREATE DATABASE db_construindo_a_nossa_vida;

USE db_construindo_a_nossa_vida;

-- determine 3 atributos para a Categoria
CREATE TABLE tb_categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
departamento VARCHAR (255), -- iluminação, ferramentas, tintas, pisos e revestimentos, elétrica
material VARCHAR (255), -- madeira, pvc, vidro, pedra, silicone, ferro, plástico
UNIQUE (id_categoria),
PRIMARY KEY (id_categoria)
);

-- determine 5 atributos para o produto
CREATE TABLE tb_produto (
id_produto INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255), -- nome do produto
marca VARCHAR (255), -- suvinil, tigre e etc
descricao VARCHAR (255),
tamanho VARCHAR (255),
validade VARCHAR (255), -- perecível ou não perecível
valor VARCHAR (255),
fk_categoria INT,
UNIQUE (nome),
UNIQUE (id_produto),
PRIMARY KEY (id_produto),
FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
);

-- inserindo 5 dados na tb_categoria
INSERT INTO tb_categoria (departamento, material)
VALUES

/*1*/ ("Iluminação", "Vidro, pvc"),
/*2*/ ("Ferramentas", "Ferro"),
/*3*/ ("Tintas", "--"),
/*4*/ ("Revestimentos", "Madeira"),
/*5*/ ("Elétrica", "Fios e cabos");

-- inserindo 8 dados na tb_produto
INSERT INTO tb_produto (nome, marca, descricao, tamanho, validade, valor, fk_categoria)
VALUES
("Lampada Led", "Osram", "Aplicações domésticas, iluminação geral", "Pequeno", "--", 9.90, 1),
("Chave Philips", "Novipro", "Com ponta imantada, resistente e fácil de usar", "10x200mm", "--", 12.90, 2),
("Tinta Acrilica", "Coral Coralar", "Tinta acrílica, fosco branco e antimofo", "18L", "--", 155.90, 3),
("Piso Rocotolor caixa", "Formigres", "Produto certificado. Estilo madeira", "50x50cm", "--", 49.75, 4),
("Cabo flexível", "Cobrecom", "Alto grau de qualidade. Aguenta até 750v", "2,5mm com 100 m", "--", 209.89, 5),
("Tinta Epóxi", "Suvinil", "Tinta para banheiro e cozinha Epóxi, base de água, cor branca", "900ml", "--", 57.51, 3),
("Tinta Látex", "Suvinil", "Tinta Látex fosco standar. Rende e cobre muito, cor branco", "3,6L", "--", 72.81, 3),
("Tinta Acrílica DUO", "Coral Coralar DUO", "Tinta lavável, resistente. Fosca cor rubi", "18L", "--", 239.90, 3);


-- retornar produtos com valor maior que 50 reais
SELECT tb_produto.nome AS Produto, tb_categoria.departamento AS Departamento, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor > 50
ORDER BY valor DESC;

-- mostrar produtos com o valor entre 3 e 60 reais
SELECT tb_produto.nome AS produto, tb_categoria.departamento AS Departamento, tb_produto.validade, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE valor BETWEEN 3 AND 60
ORDER BY tb_produto.valor DESC;

-- mostrar todos os produtos que contém a letra C
SELECT * 
FROM tb_produto
WHERE nome LIKE '%c%';

-- INNER JOIN para saber nome e a quantidade de produtos de um mesmo departamento
SELECT tb_categoria.departamento AS Categoria, count(*) AS Quantidade
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
GROUP BY tb_categoria.departamento
ORDER BY tb_categoria.departamento ASC;

-- para informar todos os produtos que são de uma categoria específica
SELECT tb_produto.nome AS nome, tb_categoria.departamento AS Categoria
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
WHERE id_categoria = 3
ORDER BY tb_produto.nome ASC;

-- para saber o nome de todos os produtos, sua categoria, descrição e o valor
SELECT tb_produto.id_produto AS Código, tb_produto.nome AS Nome, tb_categoria.departamento AS Departamento, tb_produto.descricao AS Descricao, tb_produto.valor AS Valor
FROM tb_produto
INNER JOIN tb_categoria
ON tb_produto.fk_categoria = tb_categoria.id_categoria
ORDER BY tb_produto.nome ASC;