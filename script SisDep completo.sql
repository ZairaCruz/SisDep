DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS patrimonio;
DROP TABLE IF EXISTS baixa;
 
CREATE TABLE usuario (
   id SERIAL,
   nome VARCHAR,
   login VARCHAR,
   senha VARCHAR,
   tipo VARCHAR,
   PRIMARY KEY (id),
   UNIQUE (login)
);
 
create table patrimonio(
	id SERIAL primary key,
	nome varchar(50),
	dataAquisicao date,
	categoria varchar(20),
	vidaUtil numeric,
	bemUsado varchar(3),
	valorAquisicao numeric,
	taxaResidual numeric,
	turnos numeric,
	tempodeuso numeric
);

create table baixa(
	idBaixa SERIAL primary key,
	idPatrimonio integer,
	dataBaixa date,
	valorBaixa numeric,
	FOREIGN KEY (idPatrimonio) REFERENCES patrimonio (id)
);


Inserir patrimônio:
insert into patrimonio(nome, dataAquisicao, categoria, vidaUtil, bemUsado, valorAquisicao, taxaResidual, turnos)
values ('Mesa redonda', '2010-05-05', 'Móvel', 4, 'não', 350, 10, 1);

Inserir usuário:
INSERT INTO usuario (nome, login, senha, tipo)
VALUES ('admin', 'admin', 'admin', 'administrador');

Inserir baixa de patrimônio:
insert into baixa(idPatrimonio, dataBaixa, valorBaixa, gp, valorgp)
values (1, '2016-04-12', 200, 'ganho', 115);

Alterar patrimônio:
update patrimonio set bemusado = ?, tempodeuso =?, nome = ?, dataaquisicao = ?, categoria = ?, vidautil = ?, 
valoraquisicao = ?, taxaresidual = ?, turnos = ? WHERE id = ?;

Buscar patrimônio por id:
select * from patrimonio WHERE id = ? ;

Listar Baixados
select * from patrimonio inner join baixa on patrimonio.id = baixa.idpatrimonio order by nome;

Listar Ativos
select * from patrimonio where id not in (select idpatrimonio from baixa) order by id;

Conferir login:
select id, nome, tipo FROM usuario WHERE login = ? AND senha = ?;

