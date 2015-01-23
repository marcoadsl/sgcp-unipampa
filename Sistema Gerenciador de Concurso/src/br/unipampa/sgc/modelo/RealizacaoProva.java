package br.unipampa.sgc.modelo;

/**
 *
 * @author Jeanzera
 */
public class RealizacaoProva {
    private String local, data, hora;
    public RealizacaoProva (int idProva, String local, String data, String hora){
        this.local = local;
        this.data = data;
        this.hora = hora;
        System.out.println("Informações gravadas:");
        System.out.println("id: " + idProva);
        System.out.println("Local: " + local);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
