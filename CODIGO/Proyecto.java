import java.util.ArrayList;
public class Proyecto extends Actividad implements Notificar,GestionActividad{
    private ArrayList<Actividad> listaActividades;

    public Proyecto(){
        super();
        this.listaActividades = new ArrayList<>();
    }
    
    public Proyecto(String nombre, String descripcion, Date fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
        this.listaActividades = new ArrayList<>();
    }

    public int calcularCalificacion(){
        return 0;
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
