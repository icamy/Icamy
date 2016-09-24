-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PRESTADOR`
-- -----------------------------------------------------
INSERT INTO T_ICM_PRESTADOR (nm_prestador, ds_tipo_pessoa, nr_documento, nr_telefone, ds_email, ds_senha, tx_apresentacao, dt_nascimento)
VALUES
	('Once Beauty', 'J', 45242581000191, 11909226734, 'onceb@teste.net', 'abc', 
		'Cuidando da sua beleza com muita atenção e dedicação.', NULL),
    ('Luri Esmalteria', 'J', 27900748000100, 1125843232, 'luri@teste.net', 'abc', 
		'Com atendimento personalizado, a Luri Esmalteria realiza as mais sofisticadas técnicas de unhas artísticas, no local de sua preferência.', NULL),
	('Regina Cabeleireira', 'F', 25509878655, 11998180564, 'regina@teste.net', 'abc', 
		'Atuando há mais de 15 anos na região da Zona Leste, oferecendo serviços de corte, escova, luzes e hidratação com a mais alta qualidade e preço justo.', DATE_FORMAT('1981-01-25', '%Y-%m-%d')),
	('Neli Fagundes', 'F', 15515422371, 11991197878, 'neli@teste.net', 'abc', 
		'Neli Fagundes é uma profissional especializada na valorização do olhar como forma de ressaltar a essência de cada pessoa. Apaixonada pelo que faz e altamente qualificada na arte de embelezar o olhar.', DATE_FORMAT('1975-12-25', '%Y-%m-%d')),
	('Paschoal Dupré', 'J', 27121038000100, 1141166581, 'paschoal@teste.net', 'abc', 
		'Cuidando da sua beleza com muita atenção e dedicação.', DATE_FORMAT('1981-01-25', '%Y-%m-%d'));


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CLIENTE`
-- -----------------------------------------------------
INSERT INTO T_ICM_CLIENTE (nm_cliente, nr_cpf, nr_telefone, ds_email, ds_senha, dt_nascimento, ds_sexo)
VALUES
	('Cristiana Cerqueira Gomes', 22587509281, 119916283637, 'cristiana@teste.net', 'abc', DATE_FORMAT('1981-01-25', '%Y-%m-%d'), 'F'),
	('Carla Frederico Cirino', 31684903582, 11964773091, 'carla@teste.net', 'abc', DATE_FORMAT('1992-05-05', '%Y-%m-%d'), 'F'),
	('Thais Carneiro de Lacerda', 19037845389, 11945674532, 'thais@teste.net', 'abc', DATE_FORMAT('1998-12-04', '%Y-%m-%d'), 'F'),
	('Priscila Ramos Eloy', 20098619233, 119700188422, 'priscila@teste.net', 'abc', DATE_FORMAT('1983-06-07', '%Y-%m-%d'), 'F'),
	('Andrea Arrais', 19025489917, 11925250945, 'andrea@teste.net', 'abc', DATE_FORMAT('1989-11-25', '%Y-%m-%d'), 'F'),
	('Larissa do Rosario Barbosa', 23390456631, 11956874028, 'larissa@teste.net', 'abc', DATE_FORMAT('1988-09-22', '%Y-%m-%d'), 'F'),
	('Patrícia Henriques da Costa', 18936740248, 11983085736, 'patricia@teste.net', 'abc', DATE_FORMAT('1974-03-12', '%Y-%m-%d'), 'F'),
	('Maria Paula Reuther', 10098365912, 11920374500, 'maria@teste.net', 'abc', DATE_FORMAT('1975-10-15', '%Y-%m-%d'), 'F'),
	('Beatriz Fernandes Branco', 22747867990, 119883999115, 'beatriz@teste.net', 'abc', DATE_FORMAT('1994-08-31', '%Y-%m-%d'), 'F'),
	('Willian Santana de Barros', 300988475511, 11924240577, 'willian@teste.net', 'abc', DATE_FORMAT('1997-02-24', '%Y-%m-%d'), 'M');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PORTFOLIO`
-- -----------------------------------------------------
-- FALTA INSERIR



-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_ESTADO`
-- -----------------------------------------------------
INSERT INTO T_ICM_ESTADO (ds_nome, ds_sigla)
VALUES
	('SP', 'São Paulo'),
    ('RJ', 'Rio de Janeiro'),
    ('MG', 'Minas Gerais'),
    ('DF', 'Distrito Federal'),
    ('BA', 'Bahia');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CIDADE`
-- -----------------------------------------------------
INSERT INTO T_ICM_CIDADE (cd_estado, nm_cidade)
VALUES
	(1, 'São Paulo'),
    (1, 'Guaruhos'),
    (1, 'Campinas'),
    (2, 'Rio de Janeiro'),
    (2, 'Niterói'),
    (2, 'Duque de Caxias'),
    (3, 'Belo Horizonte'),
    (3, 'Juiz de Fora'),
    (3, 'Uberlândia');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_BAIRRO`
-- -----------------------------------------------------
INSERT INTO T_ICM_BAIRRO (cd_cidade, nm_bairro, ds_regiao)
VALUES
	(1, 'Sé', 'Centro'),
    (1, 'Liberdade', 'Centro'),
    (1, 'Tatuapé', 'Zona Leste'),
    (1, 'Penha', 'Zona Leste'),
    (1, 'Santana', 'Zona Norte'),
    (1, 'Freguesia do Ó', 'Zona Norte'),
    (1, 'Lapa', 'Zona Oeste'),
    (1, 'Pinheiros', 'Zona Oeste'),
    (1, 'Jabaquara', 'Zona Sul'),
    (1, 'Santo Amaro', 'Zona Sul');

-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_LOGRADOURO`
-- -----------------------------------------------------
INSERT INTO T_ICM_LOGRADOURO (cd_bairro, cd_cliente, nr_cep, nm_logradouro, nr_logradouro, ds_complemento)
VALUES
	(1, 1, 01000100, 'Rua Tabatinguera', 100, 'Bloco A Apto 25'),
    (3, 1, 03025250, 'Rua Melo Freire', 1524, 'Conjunto 136'),
    (6, 2, 02035254, 'Avenida Nossa Senhora do Ó', 325, ''),
    (10, 4, 05512890, 'Avenida Vereador Abel Diniz', 3800, 'Casa B'),
    (8, 4, 04541300, 'Praça do Por do Sol', null, ''),
    (5, 7, 02580100, 'Avenida Braz Leme', 771, 'Cj 333'),
    (2, 9, 01354200, 'Rua dos Estudantes', 13, ''),
    (4, 10, 03911020, 'Avenida Tiquatira', 5412, 'Apto 88');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PRESTADOR_BAIRRO`
-- -----------------------------------------------------
INSERT INTO T_ICM_PRESTADOR_BAIRRO (cd_prestador, cd_bairro)
VALUES
	(1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (2, 2),
    (2, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (3, 3),
    (3, 4),
    (3, 5),
    (3, 6),
    (3, 7),
    (4, 4),
    (4, 5),
    (4, 6),
    (4, 7),
    (4, 8),
    (5, 5),
    (5, 6),
    (5, 7),
    (5, 8),
    (5, 9),
    (5, 10);


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CATEGORIA`
-- -----------------------------------------------------
INSERT INTO T_ICM_CATEGORIA (nm_categoria)
VALUES 
	('Unhas'),
    ('Cabelo'),
    ('Sobrancelhas'),
    ('Estética'),
    ('Depilação'),
    ('Maquiagem'),
    ('Massagem');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_SERVICO`
-- -----------------------------------------------------
INSERT INTO T_ICM_SERVICO (cd_categoria, nm_servico, st_servico, ds_servico)
VALUES
	(1, 'Esmaltação Comum', 'A', 'zzz'),
    (1, 'Esmaltação em Gel', 'A', 'zzz'),
    (1, 'Podologia', 'A', 'zzz'),
    (2, 'Corte', 'A', 'zzz'),
    (2, 'Escova', 'A', 'zzz'),
    (2, 'Hidratação Capilar', 'A', 'zzz'),
    (3, 'Design de Sobrancelha', 'A', 'zzz'),
    (3, 'Limpeza de Sobrancelha', 'A', 'zzz'),
    (3, 'Coloração de Sobrancelha', 'A', 'zzz'),
    (4, 'Limpeza de Pele', 'A', 'zzz'),
    (4, 'Drenagem Linfática', 'A', 'zzz'),
    (4, 'Tratamento Anticelulite', 'A', 'zzz'),
    (5, 'Depilação de Pernas', 'A', 'zzz'),
    (5, 'Depilação de Axilas', 'A', 'zzz'),
    (5, 'Depilação de Virilha', 'A', 'zzz'),
    (6, 'Maquiagem Simples', 'A', 'zzz'),
    (6, 'Maquiagem para Festa', 'A', 'zzz'),
    (6, 'Dermopigmentação', 'A', 'zzz'),
    (7, 'Massagem Relaxante', 'A', 'zzz'),
    (7, 'Massagem Redutora', 'A', 'zzz'),
    (7, 'Acupuntura', 'A', 'zzz');
    

-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_OFERTA`
-- -----------------------------------------------------
INSERT INTO T_ICM_OFERTA (cd_servico, cd_prestador, ds_titulo, vl_oferta, ds_prazo, tx_oferta)
VALUES
	(1, 1, 'Manicure Express', 20.00, '7 dias', 'lorem'),
    (2, 2, 'Gel top gloss', 37.00, '7 dias', 'lorem'),
    (3, 2, 'Pedicure com base gel', 130.00, '7 dias', 'lorem'),
    (4, 5, 'Corte feminino', 69.00, '3 dias', 'lorem'),
    (4, 3, 'Corte feminino', 45.00, '3 dias', 'lorem'),
    (5, 3, 'Escova cabelo curto', 30.00, '5 dias', 'lorem'),
    (5, 3, 'Escova cabelo comprido', 45.00, '5 dias', 'lorem'),
    (5, 5, 'Escova modeladora', 60.00, '7 dias', 'lorem'),
    (5, 5, 'Escova modeladora com hidratação', 90.00, '7 dias', 'lorem'),
    (7, 4, 'Design de sobrancelhas', 35.00, '7 dias', 'lorem'),
    (9, 4, 'Design + Coloração de Sobrancelhas', 100.00, '7 dias', 'lorem');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_MODALIDADE_PGTO`
-- -----------------------------------------------------
INSERT INTO T_ICM_MODALIDADE_PGTO (nm_modalidade)
VALUES
	('Cartão de Crédito'),
    ('Débito automático'),
    ('PagSeguro');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CONTRATACAO`
-- -----------------------------------------------------
INSERT INTO T_ICM_CONTRATACAO (cd_oferta, cd_cliente, vl_contratacao, st_contratacao)
VALUES
	(1, 1, 20.00, 1),
    (1, 7, 20.00, 1),
    (1, 10, 20.00, 1),
    (2, 1, 37.00, 1),
    (2, 2, 37.00, 1),
    (3, 7, 130.00, 1),
    (2, 9, 37.00, 1),
    (3, 10, 130.00, 1),
    (4, 2, 69.00, 1),
    (4, 4, 69.00, 1),
    (4, 7, 69.00, 1),
    (5, 1, 45.00, 1),
    (6, 2, 30.00, 1),
    (5, 7, 45.00, 1),
    (6, 10, 30.00, 1),
    (7, 1, 45.00, 1),
    (7, 10, 45.00, 1),
    (8, 2, 60.00, 1),
    (8, 4, 60.00, 1),
    (9, 7, 90.00, 1),
    (10, 2, 35.00, 1),
    (10, 4, 35.00, 1),
    (11, 10, 100.00, 1);


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_AVALIACAO`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PROPOSTA_AGENDAMENTO`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PAGAMENTO`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_REPASSE`
-- -----------------------------------------------------
