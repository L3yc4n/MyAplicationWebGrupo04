package MyAplicationWebGrupo04.modelo.dto;

public class ClienteDTO {

    //Este DTO no incluye la contraseña (contClie) por motivos de seguridad

    private int codiClie;
    private String nombClie;
    private String apePaClie;
    private String apeMaClie;
    private String celuClie;
    private String usuaClie;
    private int codiProd;         // Solo el ID del producto, notodo el objeto

    // Constructor vacío
    public ClienteDTO() {}

    // Constructor completo
    public ClienteDTO(int codiClie, String nombClie, String apePaClie, String apeMaClie,
                      String celuClie, String usuaClie, int codiProd) {
        this.codiClie = codiClie;
        this.nombClie = nombClie;
        this.apePaClie = apePaClie;
        this.apeMaClie = apeMaClie;
        this.celuClie = celuClie;
        this.usuaClie = usuaClie;
        this.codiProd = codiProd;
    }

    // Getters y Setters
    public int getCodiClie() {
        return codiClie;
    }

    public void setCodiClie(int codiClie) {
        this.codiClie = codiClie;
    }

    public String getNombClie() {
        return nombClie;
    }

    public void setNombClie(String nombClie) {
        this.nombClie = nombClie;
    }

    public String getApePaClie() {
        return apePaClie;
    }

    public void setApePaClie(String apePaClie) {
        this.apePaClie = apePaClie;
    }

    public String getApeMaClie() {
        return apeMaClie;
    }

    public void setApeMaClie(String apeMaClie) {
        this.apeMaClie = apeMaClie;
    }

    public String getCeluClie() {
        return celuClie;
    }

    public void setCeluClie(String celuClie) {
        this.celuClie = celuClie;
    }

    public String getUsuaClie() {
        return usuaClie;
    }

    public void setUsuaClie(String usuaClie) {
        this.usuaClie = usuaClie;
    }

    public int getCodiProd() {
        return codiProd;
    }

    public void setCodiProd(int codiProd) {
        this.codiProd = codiProd;
    }
}
