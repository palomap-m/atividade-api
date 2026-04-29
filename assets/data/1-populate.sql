USE application;
 
# admin & admin
INSERT INTO usuarios(nome_de_usuario, senha) VALUES
    ('admin', '$2a$12$nFBW8.bWFFRDrRI04L6vz.DJpmxth2sdV8THDljA0HnnEFkTFwWIi');
 
INSERT INTO pizzarias(nome, cnpj, endereco) VALUES
    ('Pizzaria Bella Napoli', '12.345.678/0001-90', 'Rua das Flores, 100 - São Paulo/SP'),
    ('Pizzaria Margherita', '98.765.432/0001-10', 'Av. Paulista, 500 - São Paulo/SP');
 
INSERT INTO ingredientes(nome, quantidade_estoque, unidade_medida, pizzaria_id) VALUES
    ('Farinha de Trigo', 50.0, 'kg', 1),
    ('Molho de Tomate', 20.0, 'L', 1),
    ('Mussarela', 15.0, 'kg', 1),
    ('Manjericão', 2.0, 'kg', 2),
    ('Azeite Extra Virgem', 5.0, 'L', 2);