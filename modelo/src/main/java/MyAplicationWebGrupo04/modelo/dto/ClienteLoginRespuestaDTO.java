package MyAplicationWebGrupo04.modelo.dto;

public class ClienteLoginRespuestaDTO {
    private int codiClie;
    private String usuaClie;
    private String nombreCompleto;

    public ClienteLoginRespuestaDTO() {
    }

    public ClienteLoginRespuestaDTO(int codiClie, String usuaClie, String nombClie, String apePaClie, String apeMaClie) {
        this.codiClie = codiClie;
        this.usuaClie = usuaClie;
        this.nombreCompleto = nombClie + " " + apePaClie + " " + apeMaClie;
    }

    public int getCodiClie() {
        return codiClie;
    }

    public void setCodiClie(int codiClie) {
        this.codiClie = codiClie;
    }

    public String getUsuaClie() {
        return usuaClie;
    }

    public void setUsuaClie(String usuaClie) {
        this.usuaClie = usuaClie;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

}
