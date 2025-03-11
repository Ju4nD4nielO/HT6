public class Pokemon {
    private String nombre;
    private int numero;
    private String type1;
    private String type2;
    private String clasificacion;
    private int altura;
    private int peso;
    private String habilidad;
    private int gen;
    private boolean legendario;

    public Pokemon(String nombre, int numero, String type1, String type2, String clasificacion, int altura, int peso, String habilidad, int gen, boolean legendario) {
        this.nombre = nombre;
        this.numero = numero;
        this.type1 = type1;
        this.type2 = type2;
        this.clasificacion = clasificacion;
        this.altura = altura;
        this.peso = peso;
        this.habilidad = habilidad;
        this.gen = gen;
        this.legendario = legendario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public int getGen() {
        return gen;
    }

    public boolean isLegendario() {
        return legendario;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "numero" + numero + ", Tipo1: " + type1 + ", Tipo2: " + type2 +
               ", Clasificacion: " + clasificacion + ", Altura: " + altura + ", Peso: " + peso +
               ", Habilidades: " + habilidad + ", Generacion: " + gen + "Legendario: " + legendario;
    }

}
