package MyAplicationWebGrupo04.modelo.entity;

import jakarta.persistence.*; // Librerías JPA para las anotaciones

@Entity
@Table(name = "clientes") // Nombre real de la tabla en tu BD
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiClie")
    private int codiClie;

    @Column(name = "nombClie", length = 45)
    private String nombClie;

    @Column(name = "apePaClie", length = 45)
    private String apePaClie;

    @Column(name = "apeMaClie", length = 45)
    private String apeMaClie;

    @Column(name = "celuClie", length = 9)
    private String celuClie;

    @Column(name = "usuaClie", length = 45, unique = true, nullable = false)
    private String usuaClie;

    @Column(name = "contClie", length = 45, nullable = false)
    private String contClie;

    // Relación con Producto
    @ManyToOne
    @JoinColumn(name = "codiProd") // Foreign Key
    private Producto producto;

    // Constructor vacío
    public Cliente() {}

    // Constructor completo
    public Cliente(int codiClie, String nombClie, String apePaClie, String apeMaClie,
                   String celuClie, String usuaClie, String contClie, Producto producto) {
        this.codiClie = codiClie;
        this.nombClie = nombClie;
        this.apePaClie = apePaClie;
        this.apeMaClie = apeMaClie;
        this.celuClie = celuClie;
        this.usuaClie = usuaClie;
        this.contClie = contClie;
        this.producto = producto;
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

    public String getContClie() {
        return contClie;
    }

    public void setContClie(String contClie) {
        this.contClie = contClie;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codiClie=" + codiClie +
                ", nombClie='" + nombClie + '\'' +
                ", apePaClie='" + apePaClie + '\'' +
                ", apeMaClie='" + apeMaClie + '\'' +
                ", celuClie='" + celuClie + '\'' +
                ", usuaClie='" + usuaClie + '\'' +
                ", contClie='" + contClie + '\'' +
                ", producto=" + producto +
                '}';
    }
}