package br.unipampa.sgc.modelo;

public class Prova extends DML {

    private boolean eliminatoria;

    private double nota_minima;

    protected int peso;

    public Prova(){
        
    }
    public Prova(int peso){
        this.peso=peso;
    }
    public Double gerarNota() {
        return null;
    }

    public void registrarPeso() {
       
    }

    @Override
    public boolean inserir(Object objeto) {
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
