CREATE DATABASE db_generation_game_online;

USE db_generation_game_online;

-- determine 3 atributos para a Classe
CREATE TABLE tb_classe (
id_classe INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255),
raca VARCHAR (255),
habilidade VARCHAR (255),
UNIQUE (id_classe),
PRIMARY KEY (id_classe)
);

-- determine 5 atributos para o Personagem
CREATE TABLE tb_personagem (
id_personagem INT NOT NULL AUTO_INCREMENT,
nome VARCHAR (255),
sexo VARCHAR (255),
clan VARCHAR (255),
poder_atk VARCHAR (255),
poder_def VARCHAR (255),
fk_classe INT,
UNIQUE (nome),
UNIQUE (id_personagem),
PRIMARY KEY (id_personagem),
FOREIGN KEY (fk_classe) REFERENCES tb_classe (id_classe)
);

-- inserindo 5 dados na tb_classe
INSERT INTO tb_classe (nome, raca, habilidade)
VALUES
("Sacerdotise", "Asura", "Curandeire"), -- 1
("Atalante", "Amazone", "Agilidade"), -- 2
("Arqueire", "Elfe", "Precisão e Agilidade"), -- 3
("Mage", "Humane", "Magia Elemental"), -- 4
("Assassine", "Humane", "Especialista em assassinato, subterfúgio e engano"),-- 5
("Guerreire", "Humane", "Dano e combate corpo a corpo"); -- 6

-- inserindo 8 dados na tb_personagem
INSERT INTO tb_personagem (nome, sexo, clan, poder_atk, poder_def, fk_classe)
VALUES
("Celstial", "Feminino", "Senju", 2021, 4000, 1),
("Norana", "Femino", "Alfheim", 3540, 1020, 3),
("Bizz", "Masculino", "Monark", 2000, 3240, 4),
("Maena", "Femino", "Temiscira", 5000, 3600, 2),
("Dephredo", "Masculino", "Yerkir", 6500 , 3000, 6),
("Cerberon", "Masculino", "Dazhan", 4000, 1020, 5),
("Lysara", "Femino", "Alfheim", 3540, 1020, 3),
("Adafine", "Femino", "Yerkir", 6500, 3000, 6);

-- poder de ataque maior que 2000
SELECT nome AS Personagem, fk_classe AS Classe, poder_atk AS ATK, poder_def AS DEF
FROM tb_personagem
WHERE poder_atk > 2000
ORDER BY poder_atk DESC;

-- poder de defesa entre 1000 e 2000
SELECT nome AS Personagem, fk_classe AS Classe, poder_atk AS ATK, poder_def AS DEF
FROM tb_personagem
WHERE poder_def BETWEEN 1000 AND 2000
ORDER BY poder_def DESC;

-- select de LIKE para personagens com a letra C
SELECT * 
FROM tb_personagem
WHERE nome LIKE '%c%';

SELECT tb_classe.nome AS Classe
FROM tb_personagem
INNER JOIN tb_classe
ON tb_personagem.fk_classe = tb_classe.id_classe
ORDER BY tb_classe.nome ASC;

SELECT * FROM tb_personagem
WHERE fk_classe = 6;