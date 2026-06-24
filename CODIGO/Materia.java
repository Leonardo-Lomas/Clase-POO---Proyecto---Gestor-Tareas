import java.util.ArrayList;
import java.util.List;
public class Materia implements GestionActividad{
    private String nombre;
    private String profesor;
    private List<Actividad> listaActividades;
    // private ### criteriosEvaluacion;
    private double promedio;

    //Constructores
    public Materia(){
        this.nombre = "Sin nombre";
        this.profesor = "Sin profesor";
        this.listaActividades = new ArrayList<>();
    }

    public Materia(String nombre, String profesor){
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public double calcularPromedio(){
        return 0;
    }

    // Metodos de "GestionActividad"
    @Override
    public void eliminarActividad(){


    }

    @Override
    public void agregarActividad(){


    }

    //Setters y getters
    public List<Actividad> getListaActividades() {
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
    public void setListaActividades(List<Actividad> listaActividades) {
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
