package cl.salmonttapp.model;

public class Centro_de_Cultivos {
    private String nombre;
    private String comuna;
    private int toneladas;

    public Centro_de_Cultivos(String nombre, String comuna, int toneladas) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.toneladas = toneladas;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getToneladas() {
        return toneladas;
    }
    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return "Centro: " + nombre + " | Comuna: " + comuna + " | Toneladas producidas: " + toneladas;
    }
}
