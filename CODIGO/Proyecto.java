import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
/**
 * 
 * Proyecto Clase, representa los proyectos del sistema.
 */

public class Proyecto extends Actividad implements Notificar,GestionActividad, Serializable{

    private ArrayList<Actividad> listaActividades;

    /**
     * Constructos para inicializar los valores vacios.
     */
    public Proyecto(){
        super();
        this.listaActividades = new ArrayList<>();
    }
    
    /**
     * Constructor para inicializar los valores de la instancia.
     * 
     * @param nombre nombre del Proyecto.
     * @param descripcion descripcon del Proyecto.
     * @param fechaConclusion fecha de cierre del Proyecto.
     */
    public Proyecto(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
        this.listaActividades = new ArrayList<>();
    }

    /**
     * Calcula la calificacion total del proyecto en base a las calificaciones de cada actividad.
     * @return el valor de la calificacion del proyecto
     */
    public double calcularCalificacion(){
        double calificacion = 0.0;
        for (int i=0;i<listaActividades.size();i++){
          calificacion += listaActividades.get(i).getCalificacion();
        }
        this.calificacion = calificacion;
        return calificacion;
    }

    public ArrayList<Actividad> getListaActividades(){
        return listaActividades;
    }

    // Metodos de "GestionActividad"
    @Override
    public void eliminarActividad(Actividad tarea){
        this.listaActividades.remove(tarea);
    }

    @Override
    public void agregarActividad(Actividad tarea){
        this.listaActividades.add(tarea);
    }

    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
