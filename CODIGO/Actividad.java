import java.time.LocalDate;
import java.io.Serializable;
/**
 * 
 * Actividad
 * 
 * Clase abstracta, representa una actividad (Examen, Tarea, Proyecto).
 * 
 * @see Proyecto
 * @see Tarea
 * @see Examen
 */

public abstract class Actividad implements Serializable{
    /**
     * Nombre de la actividad.
     */
    protected String nombre;
    /**
     * Descripcion de la actividad.
     */
    protected String descripcion;
   /**
    * Estado de la actividad, completado o no.
    */
    protected boolean estado;
    /**
     * Fecha de cierre de la actividad.
     */
    protected LocalDate fechaConclusion;
    /**
     * Calificacion de la actividad.
     */
    protected double calificacion;

    /**
     * 
     * @param nombre nombre de la actividad.
     * @param descripcion descripcion de la actividad.
     * @param fechaConclusion fecha de cierre de la actividad.
     */
    public Actividad(String nombre,String descripcion,LocalDate fechaConclusion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaConclusion = fechaConclusion;
        this.estado = false;
        //this.calificacion = -1.0;
    }

    /**
     * Constructor vacio.
     */
    public Actividad(){
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripcion";
        this.estado = false;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaConclusion() {
        return fechaConclusion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechaConclusion(LocalDate fechaConclusion) {
        this.fechaConclusion = fechaConclusion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado(){
        return estado;
    }
}
