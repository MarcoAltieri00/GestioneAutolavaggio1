package it.rf.autolavaggio.model.dto;

public class  RecuperoInfoDTO {


    private String cfCliente;
    private String targa;
    private String nTelaio;

    public RecuperoInfoDTO(String cfCliente,String targa,String nTelaio) {

        this.cfCliente=cfCliente;
        this.nTelaio=nTelaio;
        this.targa=targa;

    }


    public String getCfCliente() {
    return cfCliente;
    }
    public void setCfCliente(String cfCliente) {
        this.cfCliente = cfCliente;
    }
    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public String getnTelaio() {
        return nTelaio;
    }
    public void setnTelaio(String nTelaio) {
        this.nTelaio = nTelaio;
    }


}