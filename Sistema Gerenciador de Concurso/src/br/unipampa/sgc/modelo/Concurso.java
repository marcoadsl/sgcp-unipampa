package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Concurso extends DML {

    public static int ID_CONCURSO;
    private String ministerio;
    private String area;
    private String data;
    private String edital;
    private int cabecalho;
    private Classe classe;
    private Banca banca;
    private Universidade universidade;
    private LinkedList<Candidato> candidatos;
    private Resolucao resolucao;
    private Examinador[] examinador;
    private static Concurso myInstance;

    private Concurso() {
        super.table = "concurso";
    }

    public static Concurso getMyInstance() {
        if (myInstance == null) {
            myInstance = new Concurso();
        }
        return myInstance;
    }

    @Override
    public boolean inserir(Object objeto) {
        if (objeto instanceof Concurso) {
            super.conecta = ConectaBD.getInstance();
            Concurso concurso = (Concurso) objeto;
            /*Adicionar Examinadores no Banco*/
            Examinador[] examinadores = concurso.getExaminador();
            for (Examinador examinador : examinadores) {
                examinador.inserir(examinador);
            }
            /*Adicionar Banca no Banco*/
            Banca banca = new Banca();
            banca.inserir(examinadores);
            int idBanca = banca.recuperarId(banca.getExaminadores());
            /*Registrar Concurso*/
            try {
                String sql = "insert into " + super.table + "(ministerio,universidade,campus,area,data,edital,classe,Banca_idBanca) values(?,?,?,?,?,?,?,?);";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setString(1, concurso.getMinisterio());
                super.preparedStatement.setString(2, concurso.getUniversidade().getNome());
                super.preparedStatement.setString(3, concurso.getUniversidade().getCampus());
                super.preparedStatement.setString(4, concurso.getArea());
                super.preparedStatement.setString(5, concurso.getData());
                super.preparedStatement.setString(6, concurso.getEdital());
                super.preparedStatement.setString(7, concurso.getClasse().getTitulo());
                super.preparedStatement.setInt(8, idBanca);
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
                return false;
            } finally {
                super.conecta.encerrarConexao();
            }
            int idConcurso = recuperarId(concurso);
            if (idConcurso != 0) {
                /*Cadastrar candidatos e setar o id do concurso*/
                for (Candidato canditadoTemp : candidatos) {
                    Object[] objetos = new Object[2];
                    objetos[0] = idConcurso;
                    objetos[1] = canditadoTemp;
                    canditadoTemp.inserir(objetos);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void registrarSessao(int idDaSessao) {
        String sql = "update " + super.table + " set sessaoInicialAbertura=? where idConcurso=" + ID_CONCURSO + ";";
//        update aluno set tcc_idtcc= 25 where idaluno=1;
        super.conecta = ConectaBD.getInstance();
        try {
            super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
            super.preparedStatement.setInt(1, idDaSessao);
            super.preparedStatement.execute();
            super.preparedStatement.close();
        } catch (SQLException ex) {
        }
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

    public ArrayList<Object> buscarTodosConcursos() {
        String sql = "select idConcurso, ministerio, universidade, campus, area, data, edital, classe "
                + "from concurso;";
        ArrayList<Object> dados = new ArrayList<Object>();

        try {
            super.conecta = ConectaBD.getInstance();
            super.statement = super.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);

            while (super.resultSet.next()) {
                dados.add(super.resultSet.getInt("idConcurso"));
                dados.add(super.resultSet.getString("ministerio"));
                dados.add(super.resultSet.getString("universidade"));
                dados.add(super.resultSet.getString("campus"));
                dados.add(super.resultSet.getString("area"));
                dados.add(super.resultSet.getString("data"));
                dados.add(super.resultSet.getString("edital"));
                dados.add(super.resultSet.getString("classe"));
            }
            return dados;
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public int recuperarId(Object objeto) {
        if (objeto instanceof Concurso) {
            Concurso concurso = (Concurso) objeto;
            int id = 0;
            String sql = "select idConcurso from " + super.table + " where ministerio=\""
                    + concurso.getMinisterio() + "\" and universidade=\"" + concurso.getUniversidade().getNome() + "\" and "
                    + "campus= \"" + concurso.getUniversidade().getCampus() + "\" and area=\"" + concurso.getArea() + "\" and "
                    + "data=\"" + concurso.getData() + "\";";
            try {
                this.conecta = ConectaBD.getInstance();
                super.statement = this.conecta.getConnection().createStatement();
                super.resultSet = super.statement.executeQuery(sql);
                while (super.resultSet.next()) {
                    id = super.resultSet.getInt(1);
                    Concurso.ID_CONCURSO = id;
                }
                super.resultSet.close();
                super.statement.close();
                return id;
            } catch (SQLException sqlErro) {
                sqlErro.printStackTrace();
            }
            return id;
        }
        return 0;
    }

    public int recuperarIDSessao() {
        String sql = "select sessaoInicialAbertura "
                + "from concurso where idConcurso=" + ID_CONCURSO + ";";

        try {
            super.conecta = ConectaBD.getInstance();
            super.statement = super.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);

            while (super.resultSet.next()) {
                return super.resultSet.getInt("sessaoInicialAbertura");

            }
        } catch (SQLException ex) {
        }
        return 0;
    }

    public String getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(String ministerio) {
        this.ministerio = ministerio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public int getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(int cabecalho) {
        this.cabecalho = cabecalho;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public LinkedList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(LinkedList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Resolucao getResolucao() {
        return resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }

    public Examinador[] getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador[] examinador) {
        this.examinador = examinador;
    }

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
