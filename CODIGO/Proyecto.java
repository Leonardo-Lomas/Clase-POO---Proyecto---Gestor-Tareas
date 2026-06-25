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

    public int calcularCalificacion(){
        double calificacion = 0.0;
        for (int i=0;i<listaActividades.length;i++){
          calificacion += listaActividad[i].getCalificacion();
        }
        this.calificacion = calificacion;
        return calificacion;
    }

    // Metodos de "GestionActividad"
    @Override
    public void eliminarActividad(){


    }

    @Override
    public void agregarActividad(){


    }

    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
