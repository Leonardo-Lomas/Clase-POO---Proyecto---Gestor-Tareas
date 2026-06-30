import java.util.ArrayList;
import java.io.Serializable;
public class Materia implements GestionActividad, Serializable{
    private String nombre;
    private String profesor;
    private ArrayList<Actividad> listaActividades;
    // private ### criteriosEvaluacion;
    private double promedio;

    //Constructores
    public Materia(){
        this.nombre = "Sin nombre";
        this.profesor = "Sin profesor";
        this.listaActividades = new ArrayList<Actividad>();
    }

    public Materia(String nombre, String profesor){
        this.nombre = nombre;
        this.profesor = profesor;
        this.listaActividades = new ArrayList<Actividad>();
    }
    
    public Materia(String nombre, String profesor, ArrayList<Actividad> listaActividades){
        this.nombre = nombre;
        this.profesor = profesor;
        this.listaActividades = listaActividades;
    }
    
    public double calcularPromedio(){
        return 0;
    }

    // Metodos de "GestionActividad"
    @Override
    public void eliminarActividad(Actividad actividad){
        this.listaActividades.remove(actividad);
    }

    @Override
    public void agregarActividad(Actividad actividad){
        this.listaActividades.add(actividad);
    }

    //Setters y getters
    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
    public String getNombre() {
        return nombre;
    }
    public String getProfesor() {
        return profesor;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setListaActividades(ArrayList<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
