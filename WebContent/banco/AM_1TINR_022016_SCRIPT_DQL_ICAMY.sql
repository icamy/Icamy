-- SCRIPTS DQL
-- INTEGRANTES DO GRUPO:
-- 76007 - BIANCA CESAR TURCO
-- 77329 - LUCAS TAVARES DA ROCHA
-- 74426 - MAXWELL MARTINS LIMA
-- 76190 - RENÊ FERNANDES BARBOSA
-- 77150 - THIAGO TADEU BETTIOL FRATINI


USE icamydb;
##################################################################################################################################################



-- DML:



-- OfertaDAO.insert()
-- String sql = "INSERT INTO t_icm_oferta
-- 					(cd_servico, cd_prestador, ds_titulo, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade)
-- 				VALUES 
-- 					(?, ?, ?, ?, ?, ?, ?)"
INSERT INTO t_icm_oferta 
	(cd_servico, cd_prestador, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade) 
VALUES 
	(19, 3, 'Trabalhamos com a verdadeira técnica oriental da acupuntura', 100.00, 15, 30);


    
-- OfertaDAO.update():
-- String sql = "UPDATE t_icm_oferta 
-- 				SET cd_servico=?, cd_prestador=?, ds_titulo=?, tx_oferta=?, vl_oferta=?, nr_minutos_execucao=?, nr_dias_validade=? 
-- 				WHERE cd_oferta=?"
UPDATE t_icm_oferta 
SET cd_servico=3, cd_prestador=2, tx_oferta='Esmaltação em gel com super brilho!', vl_oferta=90.00, nr_minutos_execucao=20, nr_dias_validade=90 
WHERE cd_oferta=3;



-- OfertaDAO.delete():
-- String sql = "DELETE FROM t_icm_oferta 
-- 				WHERE cd_oferta=?"
DELETE FROM t_icm_oferta 
WHERE cd_oferta=38;



-- ContratacaoDAO.insert():
-- String sql = "INSERT INTO t_icm_contratacao (cd_oferta, cd_cliente, vl_contratacao, st_contratacao) 
-- 				VALUES (?, ?, ?, ?)";
INSERT INTO t_icm_contratacao (cd_oferta, cd_cliente, vl_contratacao, st_contratacao) 
VALUES (16, 2, 56.00, 1);



-- PagamentoDAO.insert():
-- String sql = "INSERT INTO t_icm_pagamento 
-- 					(cd_contratacao, cd_modalidade, vl_operacao, st_pagamento, cd_identificador) 
-- 				VALUES (?, ?, ?, ?, ?)";
INSERT INTO t_icm_pagamento 
	(cd_contratacao, cd_modalidade, vl_operacao, st_pagamento, cd_identificador) 
VALUES (37, 1, 56.00, 1, 'ZZZZZZZZ-D243-4372-A7D2-C81C2AD96623');



##################################################################################################################################################



-- DQL:



-- PrestadorDAO.selectWherePrestador():
-- String sql = "SELECT cd_prestador, nm_prestador, ds_tipo_pessoa, nr_documento, nr_telefone, 
-- 				ds_email, ds_senha, tx_apresentacao, dt_nascimento, ds_url_foto 
-- 				FROM  t_icm_prestador 
-- 				WHERE cd_prestador = ?";
SELECT cd_prestador, nm_prestador, ds_tipo_pessoa, nr_documento, nr_telefone, ds_email, ds_senha, tx_apresentacao, dt_nascimento, ds_url_foto 
FROM  t_icm_prestador 
WHERE cd_prestador = 5;



-- PrestadorDAO.selectWhereServicoBairro():
-- String sql = "SELECT DISTINCT cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto 
-- 					FROM t_icm_prestador 
-- 					INNER JOIN t_icm_prestador_bairro USING (cd_prestador) 
-- 					INNER JOIN t_icm_bairro USING (cd_bairro) 
-- 					INNER JOIN t_icm_oferta USING (cd_prestador) 
-- 					INNER JOIN t_icm_servico USING (cd_servico) 
-- 					WHERE cd_servico = ? AND nm_bairro = ?";
SELECT DISTINCT cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto 
FROM t_icm_prestador 
INNER JOIN t_icm_prestador_bairro USING (cd_prestador) 
INNER JOIN t_icm_bairro USING (cd_bairro) 
INNER JOIN t_icm_oferta USING (cd_prestador) 
INNER JOIN t_icm_servico USING (cd_servico) 
WHERE cd_servico = 1 AND nm_bairro = 'Liberdade';



-- ServicoDAO.selectWhereCategoria():
-- String sql = "SELECT cd_servico, nm_servico FROM t_icm_servico 
-- 				NATURAL JOIN t_icm_categoria_servico 
-- 				WHERE cd_categoria=?";
SELECT cd_servico, nm_servico FROM t_icm_servico 
NATURAL JOIN t_icm_categoria_servico 
WHERE cd_categoria=2;


-- OfertaDAO.selectWherePrestador()
-- 	String sql = "SELECT cd_oferta, nm_servico, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade, nm_categoria 
-- 					FROM  t_icm_oferta 
-- 					NATURAL JOIN t_icm_servico 
-- 					NATURAL JOIN t_icm_categoria_servico 
-- 					NATURAL JOIN t_icm_prestador 
-- 					WHERE cd_prestador = ?";
SELECT cd_oferta, nm_servico, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade, nm_categoria 
FROM  t_icm_oferta 
NATURAL JOIN t_icm_servico 
NATURAL JOIN t_icm_categoria_servico 
NATURAL JOIN t_icm_prestador 
WHERE cd_prestador = 4;