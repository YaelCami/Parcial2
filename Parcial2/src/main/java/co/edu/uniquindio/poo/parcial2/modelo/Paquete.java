package co.edu.uniquindio.poo.parcial2.modelo;

public class Paquete {

    private String codigo;
    private TipoEntrega tipo;
    private int peso;

    public Paquete(String codigo, TipoEntrega tipo, int peso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoEntrega getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrega tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paquete " + codigo + ". Tipo: " + tipo + ". Peso: " + peso + "KG.";
    }
}
