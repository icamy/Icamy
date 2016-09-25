-- NAC 2: SCRIPTS DML (MASSA DE DADOS PARA TESTE)
-- INTEGRANTES DO GRUPO:
-- 76007 - BIANCA CESAR TURCO
-- 77329 - LUCAS TAVARES DA ROCHA
-- 74426 - MAXWELL MARTINS LIMA
-- 76190 - RENÊ FERNANDES BARBOSA
-- 77150 - THIAGO TADEU BETTIOL FRATINI


-- -----------------------------------------------------
-- Schema icamydb
-- -----------------------------------------------------
USE `icamydb` ;


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
	('Sofia Santana de Barros', 300988475511, 11924240577, 'sofia@teste.net', 'abc', DATE_FORMAT('1997-02-24', '%Y-%m-%d'), 'F');


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PORTFOLIO`
-- -----------------------------------------------------
-- FALTA INSERIR ARQUIVOS PARA VALIDAR URL'S
INSERT INTO T_ICM_PORTFOLIO (cd_prestador, ds_url, nm_arquivo)
VALUES
	(1, 'https://www.instagram.com/p/BKxtnlrDg6y/', 'Sobrancelha'),
    (1, 'https://www.instagram.com/p/BKxjjvehabM/', 'Cílios'),
    (1, 'https://www.instagram.com/p/BKvye9kAlwN/', 'roxo esfumaçado'),
    (2, 'https://www.instagram.com/p/BKyq8mkAmFG/', 'serviço'),
    (2, 'https://www.instagram.com/p/BKyqEWJAT_J/', 'em_casa'),
    (2, 'https://www.instagram.com/p/BKyqGEmB5S5/', 'olhar'),
    (3, 'https://www.instagram.com/p/BKyocA4BxWc/', 'make'),
    (3, 'https://www.instagram.com/p/BKyoOGCA_zi/', 'peeling'),
    (3, 'https://www.instagram.com/p/BKynyUND08H/', 'promoção'),
    (4, 'https://www.instagram.com/p/BKynxmIgPom/', 'design de sobrancelhas'),
    (4, 'https://www.instagram.com/p/BKymjg-hLir/', 'unhas'),
    (4, 'https://www.instagram.com/p/BKymkgjAf94/', 'taller facial'),
    (5, 'https://www.instagram.com/p/BKyme_1DTsO/', 'makeover'),
    (5, 'https://www.instagram.com/p/BKymAQHBkpn/', 'pés perfeitos'),
    (5, 'https://www.instagram.com/p/BKylSF1ghkP/', 'cachos');



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
	(1, 'Esmaltação Comum', 1, 'Serviço de manicure/pedicure com aplicação de esmalte comum'),
    (1, 'Esmaltação em Gel', 1, 'Serviço de manicure/pedicure com aplicação de esmalte gel'),
    (1, 'Podologia', 1, 'zzz'),
    (2, 'Corte', 1, 'zzz'),
    (2, 'Escova', 1, 'zzz'),
    (2, 'Hidratação Capilar', 1, 'zzz'),
    (3, 'Design de Sobrancelha', 1, 'zzz'),
    (3, 'Limpeza de Sobrancelha', 1, 'zzz'),
    (3, 'Coloração de Sobrancelha', 1, 'zzz'),
    (4, 'Limpeza de Pele', 1, 'zzz'),
    (4, 'Drenagem Linfática', 1, 'zzz'),
    (4, 'Tratamento Anticelulite', 1, 'zzz'),
    (5, 'Depilação de Pernas', 1, 'zzz'),
    (5, 'Depilação de Axilas', 1, 'zzz'),
    (5, 'Depilação de Virilha', 1, 'zzz'),
    (6, 'Maquiagem Simples', 1, 'zzz'),
    (6, 'Maquiagem para Festa', 1, 'zzz'),
    (6, 'Dermopigmentação', 1, 'zzz'),
    (7, 'Massagem Relaxante', 1, 'zzz'),
    (7, 'Massagem Redutora', 1, 'zzz'),
    (7, 'Acupuntura', 1, 'zzz');
    

-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_OFERTA`
-- -----------------------------------------------------
INSERT INTO T_ICM_OFERTA (cd_servico, cd_prestador, ds_titulo, vl_oferta, ds_prazo, tx_oferta)
VALUES
	(1, 1, 'Manicure Express', 20.00, '7 dias', 'Cutilagem e esmaltação.'),
    (2, 2, 'Gel top gloss', 37.00, '7 dias', 'Unhas lindas e mais fortes.'),
    (3, 2, 'Pedicure com base gel', 130.00, '7 dias', 'Esmaltação em gel'),
    (4, 5, 'Corte feminino', 69.00, '3 dias', 'Promoção para o mês de novembro. Não percam!!!'),
    (4, 3, 'Corte feminino', 45.00, '3 dias', 'Serviço de corte de cabelo em camadas, franjas em diagonal, degradês, cortes retos, curtos, médios ou longos.
 Valor sujeito a alteração após avaliação do comprimento dos fios.'),
    (5, 3, 'Escova cabelo curto', 30.00, '5 dias', 'Secagem com escova para alisar o cabelo.'),
    (5, 3, 'Escova cabelo comprido', 45.00, '5 dias', 'Secagem com escova para alisar o cabelo.'),
    (5, 5, 'Escova modeladora', 60.00, '7 dias', 'A escova modelada, ao contrário da tradicional, deixa o cabelo com ondas naturais. Fica entre um babyliss bem cacheado e uma escova lisa. As raízes baixas e as pontas com volume deixam os fios com uma aparência bem natural e é um ótimo look para o dia a dia ou festas durante a noite.'),
    (5, 5, 'Escova modeladora com hidratação', 90.00, '7 dias', 'Você mais #diva!'),
    (7, 4, 'Design de sobrancelhas', 35.00, '7 dias', 'Depilação personalizada das sobrancelhas para deixá-las com um desenho que valorize o rosto.'),
    (9, 4, 'Design + Coloração de Sobrancelhas', 100.00, '7 dias', 'Promoção imperdível');


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
INSERT INTO T_ICM_AVALIACAO (cd_contratacao, ds_parte_avaliada, vl_nota, tx_comentario)
VALUES
	(1, 'P', 4, 'Gostei muito do serviço da OnceBeauty, só me incomodou um pouco a falta de pontualidade do profissional que me atendeu.'),
    (2, 'P', 4, 'Preço justo, serviço ok. E ser atendida em casa é maravilhoso!!!'),
    (3, 'P', 2, 'Express só no nome... Demora pra agendar, demora durante o serviço. Se soubesse, teria ido na manicure da minha rua mesmo...'),
    (4, 'P', 3, 'Esperava um acabamento melhor do esmalte, mas ele dura mesmo! Daqui pra frente, só uso gel'),
    (5, 'P', 5, 'Gente, a Bárbara, da Luri, sabe mesmo o que faz. Recomendo muito o serviço dela e espero recebê-la muitas outras vezes na minha casa.'),
    (6, 'P', 5, 'Tive um problema de saúde na família e não tinha condições de ir em salão. Amei a facilidade oferecida pela Icamy de levar o profissional até a minha residência. Foi minha primeira contratação e fiquei bastante satisfeita, o serviço foi muito bem realizado!'),
    (7, 'P', 2, 'Demorou muito pra confirmar meu agendamento e chegou na minha casa com quase UMA HORA de atraso!!! Já tive experiências com outros serviços daqui da Icamy, todos muito bem executados, mas com a Luri a coisa não foi muito bem.'),
    (8, 'P', 4, 'Muito bom!!!'),
    (9, 'P', 5, 'Espera em salão de beleza? Horas caçando estacionamento? Nunca mais, agora só marco com o Paschoal na minha casa. Quem conhece, sabe que é um dos melhores profissionais da cidade'),
    (10, 'P', 5, 'Cortar com o Paschoal na minha própria casa: NÃO TEM PREÇO!'),
    (11, 'P', 1, 'Profissional impaciente, se acha estrela demais... Se eu quisesse ser maltratada, teria gasto meu tempo em qualquer salão de quinta. Decepção.'),
    (12, 'P', 5, 'Olha, confesso que na hora achei que a Regina tinha errado a mão e tirado demais no corte. Mas no dia seguinte me senti linda!'),
    (13, 'P', 5, 'Já conhecia a Regina antes da Icamy, sempre trabalhou muito bem! Recomendo muito!'),
    (14, 'P', 5, 'Amei meu novo visual, a mulher é uma artista das tesouras!'),
    (15, 'P', 4, 'Pelo preço, o serviço é excelente!'),
    (21, 'P', 2, 'Não vi diferença no visual'),
    (23, 'P', 5, 'Meu namorado disse que meu olhar ficou muito mais sensual!!! Muito obrigado, Neli!');
    


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PROPOSTA_AGENDAMENTO`
-- -----------------------------------------------------
INSERT INTO T_ICM_PROPOSTA_AGENDAMENTO (cd_contratacao, ds_parte_proponente, dt_sugerida, tx_mensagem, st_proposta)
VALUES
	(1, 'C', '2016-09-25 14:30:00', 'Olá! Você tem disponibilidade para esse horário? Tenho uma certa urgência no serviço.', 0),
    (1, 'P', '2016-09-25 14:30:00', 'Claro! Tudo certo então pro dia 25/09, devo chegar com 10 minutos de antecedência, ok?', 1),
    (5, 'C', '2016-09-29 19:30:00', 'Boa tarde! Aguardo confirmação do agendamento', 0),
    (5, 'P', '2016-09-30 18:30:00', 'Boa tarde, querida! Infelizmente, não tenho agenda para o dia 29. Pode ser no dia 30?', 1),
    (10, 'C', '2016-10-13 10:00:00', 'Como funciona isso? É só colocar o horário que já tá agendado?', 0),
    (10, 'P', '2016-10-13 10:00:00', 'Muito bom dia, Priscila! A data informada é uma solicitação de agendamento. Estou confirmando o dia/horário solicitados. nos vemos no dia 13/10 às 10 da manhã! Você tem um cômodo bem iluminado em sua casa?', 1),
    (15, 'C', '2016-10-08 18:00:00', 'Regina, minha tia já cortou com você e disse que dava pra marcar nesse horário. Como faz?', 0),
    (15, 'P', '2016-10-08 18:30:00', 'Infelizmente acabaram de marcar comigo nesse mesmo horário. Não podemos deixar pras 18:30?', 1),
    (20, 'C', '2016-10-19 13:00:00', 'Preciso deste serviço neste horário, é meu horário de almoço e só terei esse intervalo durante a semana.', 0),
    (20, 'P', '2016-10-25 13:00:00', 'Pode deixar querida! Tudo combinado!', 1),
    (21, 'C', '2016-10-04 14:30:00', 'Você chega muito tempo antes do horário?', 0);


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PAGAMENTO`
-- -----------------------------------------------------
INSERT INTO T_ICM_PAGAMENTO (cd_contratacao, cd_modalidade, vl_operacao, st_pagamento, cd_identificador)
VALUES
	(1, 3, 20.00, 1, 'a76924e13ba68bb54e294bea07acd3f13ce5adab'),
    (5, 3, 37.00, 1, 'fad9a0a6f25df623a055091fe7e403534c7e9536'),
    (10, 3, 69.00, 1, '10c25665e49274c39b8e8f7ad6e2a3d0b0bc5052'),
    (15, 3, 30.00, 1, 'f23d94b2a735b6193d3882ae31308d2e41e8282b'),
    (20, 3, 90.00, 1, '0706025b2bbcec1ed8d64822f4eccd96314938d0'),
    (21, 3, 35.00, 1, '2a69ed80e5dfa142aa29c01680eb65649b12b9b6');

-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_REPASSE`
-- -----------------------------------------------------
INSERT INTO T_ICM_REPASSE (cd_pagamento, vl_repasse, st_repasse)
VALUES
	(1, (20.00*0.85), 1),
    (2, (37.00*0.85), 1),
    (3, (69.00*0.85), 1),
    (4, (30.00*0.85), 1),
    (5, (90.00*0.85), 1),
    (6, (35.00*0.85), 1);

