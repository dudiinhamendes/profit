insert into usuario (username, nome, senha, role, ativo, data_criacao,telefone)
values ('admin', 'Ana Paula','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ADMIN', 'true', '2020-02-06 08:00:00','925276525'),
('user', 'Clara Maria','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ATENDENTE', 'true', '2021-05-31 08:00:00','938558148'),
('vitor', 'Vitor Silva','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ATENDENTE', 'true', '2018-10-27 08:00:00','923876665'),
('marial', 'Maria Lopes','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2025-11-15 08:00:00','934477777'),
('esantos', 'Eduarda Santos','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2023-09-23 08:00:00','923303756'),
('gperez', 'Gabirela Perez','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2023-06-24 08:00:00','921302373'),
('sdias', 'Sara Dias','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-01-20 08:00:00','937789946'),
('pilha', 'Pietra Ilha','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-11-16 08:00:00','931895564'),
('rmartins', 'Ricardo Martins','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-11-24 08:00:00','922588289');

insert into aluno (id, sexo)
values (4, 'f'),
(5, 'f'),
(6, 'f');

insert into professor (id, cpf, data_demissao)
values (7, '598.038.673-99', '2026-06-07'),
(8, '938.923.397-90', '2026-05-31'),
(9, '028.984.683-00', '2026-10-09');

insert into avaliacao_fisica (aluno_id, professor_id, peso, percentual_gordura, altura)
values (4, 7, '70.80', '15.20', '1.72'),
(5, 9, '62.10', '12.60', '1.60'),
(5, 9, '67.09', '15.60', '1.60'),
(6, 8, '65.60', '17.25', '1.66'),
(6, 9, '64.33', '16.60', '1.66');

insert into plano(id, nome, preco, modalidade ,data_inicio)
values(1,'Pobrium Iron', '29.99', 'Anual','2026-06-07'),
(2,'Premium Gold Rooster', '639.99', 'Anual','2026-06-07');

insert into plano_aluno(plano_id, aluno_id)
values(1, 4),
(2, 4),
(1, 5),
(2, 6);
