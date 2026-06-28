import java.util.ArrayList;
import java.time.LocalDate;
public class Proyecto extends Actividad implements Notificar,GestionActividad{
    private ArrayList<Actividad> listaActividades;

    public Proyecto(){
        super();
        this.listaActividades = new ArrayList<>();
    }
    
    public Proyecto(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
        this.listaActividades = new ArrayList<>();
    }

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
