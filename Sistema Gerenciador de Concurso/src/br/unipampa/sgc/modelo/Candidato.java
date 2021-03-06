package br.unipampa.sgc.modelo;

import java.sql.SQLException;

public class Candidato extends DML {

    private String nome;
    private String sexo;
    private String data_nasc;

    public Candidato() {
        super.table = "candidato";
    }

    public Candidato(String nome, String sexo, String data_nasc) {
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        super.table = "candidato";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    @Override
    public boolean inserir(Object objeto) {
        Candidato candidatoTemp = null;
        int idConcurso = 0;
        if (objeto instanceof Object[]) {
            Object[] objects = (Object[]) objeto;
            if (objects.length == 2) {
                idConcurso = (Integer) objects[0];
                candidatoTemp = (Candidato) objects[1];
                try {
                    String sql = "insert into " + super.table + "(nome, dataNascimento, sexo, Concurso_ministerio) values(?,?,?,?);";
                    super.conecta = ConectaBD.getInstance();
                    super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                    super.preparedStatement.setString(1, candidatoTemp.getNome());
                    super.preparedStatement.setString(2, candidatoTemp.getData_nasc());
                    super.preparedStatement.setString(3, candidatoTemp.getSexo());
                    super.preparedStatement.setInt(4, idConcurso);
                    super.preparedStatement.execute();
                    super.preparedStatement.close();
                    return true;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    super.conecta.encerrarConexao();
                }
            }
        }

        return false;
    }

    @Override
    public boolean editar(int id, Object objeto) {
        return false;
    }

    @Override
    public boolean deletar(int id, Object objeto) {
        return false;
    }

    @Override
    public Object buscar(int id) {
        return null;
    }

    @Override
    public int recuperarId(Object objeto) {
        return 0;
    }

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        return false;
    }

}
