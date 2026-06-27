import java.time.LocalDate;
public abstract class Actividad {
    protected String nombre;
    protected String descripcion;
    protected boolean estado;
    protected LocalDate fechaConclusion;
    protected double calificacion;

    public Actividad(String nombre,String descripcion,LocalDate fechaConclusion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaConclusion = fechaConclusion;
        this.estado = false;
    }

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
