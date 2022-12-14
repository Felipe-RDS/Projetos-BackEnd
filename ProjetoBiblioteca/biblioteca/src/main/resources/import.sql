

INSERT INTO usuario(id, nome, senha) VALUES (1, 'Bruna', '2020');
INSERT INTO usuario(id, nome, senha) VALUES (2, 'Felipe', '2021');


INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('1', 'Livro1', 'Bruna', 2020, false, 1); 
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('2', 'Livro2', 'Felipe', 2021, false, 2);
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('3', 'Livro3', 'Bruna', 2020, false, 3); 
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('4', 'Livro4', 'Felipe', 2021, false, 2);
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('5', 'Livro5', 'Bruna', 2020, false, 1); 
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('6', 'Livro6', 'Felipe', 2021, false, 3);
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('7', 'Livro7', 'Bruna', 2020, false, 1); 
INSERT INTO livro(id, nome, autor, ano, status, genero) VALUES ('8', 'Livro8', 'Felipe', 2021, false, 2);

INSERT INTO emprestimo(id, status, livro_id, usuario_id) VALUES ('1', true,'3','2');
INSERT INTO emprestimo(id, status, livro_id, usuario_id) VALUES ('2', true,'2','1');
