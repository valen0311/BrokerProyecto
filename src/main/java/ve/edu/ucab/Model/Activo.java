package ve.edu.ucab.Model;


import java.util.*;


abstract class Activo {
    private String nombre;
    private String ticker;
    private double precioActual;
    private double volatilidad;

    public Activo(String nombre, String ticker, double precioActual, double volatilidad) {
        this.nombre = nombre;
        this.ticker = ticker;
        this.precioActual = precioActual;
        this.volatilidad = volatilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public double getVolatilidad() {
        return volatilidad;
    }

    public abstract void actualizarPrecio();
}

class Accion extends Activo {
    private String empresa;

    public Accion(String nombre, String ticker, double precioActual, double volatilidad, String empresa) {
        super(nombre, ticker, precioActual, volatilidad);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public void actualizarPrecio() {
        double variacion = (new Random().nextDouble() - 0.5) * getVolatilidad();
        double nuevoPrecio = getPrecioActual() * (1 + variacion);
        setPrecioActual(Math.max(nuevoPrecio, 0.01));
    }
}

class Criptomoneda extends Activo {
    private String blockchain;

    public Criptomoneda(String nombre, String ticker, double precioActual, double volatilidad, String blockchain) {
        super(nombre, ticker, precioActual, volatilidad);
        this.blockchain = blockchain;
    }

    public String getBlockchain() {
        return blockchain;
    }

    @Override
    public void actualizarPrecio() {
        double variacion = (new Random().nextDouble() - 0.5) * getVolatilidad();
        double nuevoPrecio = getPrecioActual() * (1 + variacion);
        setPrecioActual(Math.max(nuevoPrecio, 0.01));
    }
}

