import java.util.ArrayList;
public class Pruebas {
  public static void main(String[] args){
    ControladorArchivos ca = new ControladorArchivos();
    ArrayList<Materia> listaMaterias = ca.leerMaterias();
    for(Materia x : listaMaterias){
      System.out.println(x.getNombre() + " : " + x.getProfesor());
    }
  }
}
