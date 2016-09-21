package br.com.icamy.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Servico;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

public class ServicoDAO extends DAO {

    public ServicoDAO() throws Exception {
        super();
    }

    public int insert(Servico servico) throws Exception {
        String query = "insert into servico (nm_servico, ds_servico, st_servico) ";
        query += "('" + servico.getNome() + "', '" + servico.getDescricao() + "', '" + servico.getStatus() + "');";

        return executeAndGetKey(query);
    }

    public int update(Servico servico) throws Exception {
        String query = "update servico set nm_servico = '" + servico.getNome() + "', ds_servico = '"
                + servico.getDescricao() + "', ";
        query += "st_servico = " + servico.getStatus() + " where cd_servico = " + servico.getCodigo() + ";";

        return execute(query);
    }

    public int delete(Servico servico) throws Exception {
        String query = "delete from servico where cd_servico = " + servico.getCodigo() + ";";

        return execute(query);
    }

    public Servico get(int codigo) throws Exception {
        String sql = "select * from servico where cd_servico = " + codigo + ";";

        ResultSet result = retrieve(sql);

        if (result != null) {
            return new Servico(result.getInt("cd_servico"), result.getString("nm_servico"),
                    result.getBoolean("st_servico"), result.getString("ds_servico"));
        } else {
            throw new RegistroNaoEncontradoException("Serviço " + codigo + " não encontrado");
        }
    }

    public List<Servico> getAll() throws Exception {
        String sql = "select * from servico;";
        ResultSet result = retrieve(sql);
        List<Servico> servicos = new ArrayList<Servico>();

        while (result.next()) {
            servicos.add(new Servico(result.getInt("cd_servico"), result.getString("nm_servico"),
                    result.getBoolean("st_servico"), result.getString("ds_servico")));
        }

        return servicos;
    }
}