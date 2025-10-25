package MyAplicationWebGrupo04.modelo.dto;

public class ProductoDTO {
    private int codiProd;
    private String nombProd;
    private double precProd;
    private int stocProd;
    private int version;

    public ProductoDTO() {
    }

    // Constructor con parámetros
    public ProductoDTO(int codiProd, String nombProd, double precProd, int stocProd, int version) {
        this.codiProd = codiProd;
        this.nombProd = nombProd;
        this.precProd = precProd;
        this.stocProd = stocProd;
        this.version = version;
    }

    public int getCodiProd() {
        return codiProd;
    }

    public void setCodiProd(int codiProd) {
        this.codiProd = codiProd;
    }

    public String getNombProd() {
        return nombProd;
    }

    public void setNombProd(String nombProd) {
        this.nombProd = nombProd;
    }

    public double getPrecProd() {
        return precProd;
    }

    public void setPrecProd(double precProd) {
        this.precProd = precProd;
    }

    public int getStocProd() {
        return stocProd;
    }

    public void setStocProd(int stocProd) {
        this.stocProd = stocProd;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Producto02TO{" +
                "codiProd=" + codiProd +
                ", nombProd='" + nombProd + '\'' +
                ", precProd=" + precProd +
                ", stocProd=" + stocProd +
                ", version=" + version +
                '}';
    }
}