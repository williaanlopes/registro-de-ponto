insert into curso (nome) values ('Computacao');
insert into curso (nome) values ('G.T.I.');

insert into disciplina (nome, periodo, descricao, id_curso) values ('IHC', 9, '', 1);
insert into disciplina (nome, periodo, descricao, id_curso) values ('Algoritmos', 1, '', 1);
insert into disciplina (nome, periodo, descricao, id_curso) values ('Calculo', 2, '', 1);
insert into disciplina (nome, periodo, descricao, id_curso) values ('Dispositivos Moveis', 8, '', 1);


insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (1, 'Noite', 'Segunda-feira', '18:50', '20:30');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (1, 'Noite', 'Terca-feira', '20:30', '22:10');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (2, 'Noite', 'Segunda-feira', '18:50', '20:30');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (2, 'Noite', 'Quarta-feira', '20:30', '22:10');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (2, 'Manha', 'Terca-feira', '07:30', '08:30');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (4, 'Noite', 'Quinta-feira', '18:50', '22:10');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (3, 'Noite', 'Sexta-feira', '18:50', '22:10');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (3, 'Noite', 'Quarta-feira', '18:50', '22:10');
insert into disciplina_horario (id_disciplina, turno, dia, de_horario, ate_horario) values (3, 'Manha', 'Terca-feira', '08:30', '10:50');

insert into professor (nome, sobre_nome, matricula) values ('Cynara', 'Carvalho', '123456');
insert into professor (nome, sobre_nome, matricula) values ('Carlos', 'Alberto', '456789');
insert into professor (nome, sobre_nome, matricula) values ('Tonny', 'Santos', '789456');
insert into professor (nome, sobre_nome, matricula) values ('Cleber', 'Marcelo', '456123');