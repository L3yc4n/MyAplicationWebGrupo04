package MyAplicationWebGrupo04.modelo.entity;

import jakarta.persistence.*;

// Indicamos que es una entidad JPA y que mapea a la tabla Producto02
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiProd")
    private int codiProd;

    @Column(name = "nombProd", length = 45, nullable = false)
    private String nombProd;

    @Column(name = "precProd", nullable = false)
    private double precProd;

    @Column(name = "stocProd", nullable = false)
    private int stocProd;

    // Campo de control de concurrencia (optimistic locking)
    @Version
    @Column(name = "version")
    private int version;

    // Constructor vacío requerido por JPA
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(int codiProd, String nombProd, double precProd, int stocProd, int version) {
        this.codiProd = codiProd;
        this.nombProd = nombProd;
        this.precProd = precProd;
        this.stocProd = stocProd;
        this.version = version;
    }

    // Getters y Setters
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

