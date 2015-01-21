package br.unipampa.sgc.modelo;

import java.sql.SQLException;

public class Banca extends DML {

    private Examinador[] examinadores;

    public Banca() {
        super.table = "banca";
    }

    @Override
    public boolean inserir(Object objeto) {
        int count = 0;
        if (objeto instanceof Examinador[]) {
            examinadores = (Examinador[]) objeto;
            int[] ids = new int[examinadores.length];
            for (Examinador examinador : examinadores) {
                ids[count] = examinador.recuperarId(examinador.getNome());
                count++;
            }
            if (examinadores.length == ids.length) {
                try {
                    String sql = "insert into " + super.table + "(Examinador_idExaminador,Examinador_idExaminador1,Examinador_idExaminador2) values(?,?,?);";
                    super.conecta = ConectaBD.getInstance();
                    super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                    super.preparedStatement.setInt(1, ids[0]);
                    super.preparedStatement.setInt(2, ids[1]);
                    super.preparedStatement.setInt(3, ids[2]);
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
        if(objeto instanceof Examinador[]){
            Examinador[] examinadores= (Examinador[]) objeto;
            int count=0, id=0;
            int[] ids= new int[examinadores.length];
            
            for(Examinador examinadorTemp: examinadores){
                ids[count]= examinadorTemp.recuperarId(examinadorTemp.getNome());
                count++;
            }
            if(ids.length==examinadores.length){
            String sql = "select idBanca from " + super.table + " where Examinador_idExaminador=" +
                    ids[0] + " and Examinador_idExaminador1="+ids[1]+" and Examinador_idExaminador2="+ids[2]+";";
        try {
            this.conecta = ConectaBD.getInstance();
            super.statement = this.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);
            while (super.resultSet.next()) {
                id= super.resultSet.getInt(1);
            }
            super.resultSet.close();
            super.statement.close();
            return id;
        } catch (SQLException sqlErro) {
            sqlErro.printStackTrace();
        }
        }
        return 0;
        }
        return 0;
    }

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        return false;
    }

    public Examinador[] getExaminadores(){
        return this.examinadores;
    }
}
