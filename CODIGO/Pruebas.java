import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Pruebas {
  public static void main(String[] args){
    
    ControladorArchivos ca = new ControladorArchivos();
    
    //bloque para hacer la prueba de escritura del archivo.
    ArrayList<Materia> listaMateriasOut = new ArrayList<>();
    Materia materia1 = new Materia("Leonardo","Lomas");
    Materia materia2 = new Materia("Jose","Rodriguez");
    Materia materia3 = new Materia("Luis","Aguilar");
    listaMateriasOut.add(materia1);
    listaMateriasOut.add(materia2);
    listaMateriasOut.add(materia3);
    ca.escribirMaterias(listaMateriasOut);
    
    //bloque para hacer la prueba de lectura del archivo.
    ArrayList<Materia> listaMateriasIn = ca.leerMaterias();
    for (Materia x : listaMateriasIn){
      System.out.println(x.getNombre() + " : " + x.getProfesor());
    }
  }
}
