insert into usuario (username, nome, senha, role, ativo, data_criacao)
values ('admin', 'Ana Paula','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ADMIN', 'true', '2020-02-06 08:00:00'),
('user', 'Clara Maria','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ATENDENTE', 'true', '2021-05-31 08:00:00'),
('vitor', 'Vitor Silva','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ATENDENTE', 'true', '2018-10-27 08:00:00'),
('marial', 'Maria Lopes','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2025-11-15 08:00:00'),
('esantos', 'Eduarda Santos','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2023-09-23 08:00:00'),
('gperez', 'Gabirela Perez','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ALUNO', 'true', '2023-06-24 08:00:00'),
('sdias', 'Sara Dias','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-01-20 08:00:00'),
('pilha', 'Pietra Ilha','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-11-16 08:00:00'),
('rmartins', 'Ricardo Martins','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_PROFESSOR', 'true', '2023-11-24 08:00:00');

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
(6, 7, '65.60', '17.25', '1.66'),
(5, 9, '62.10', '12.60', '1.60');
