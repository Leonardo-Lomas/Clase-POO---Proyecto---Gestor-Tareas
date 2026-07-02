import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.lang.ClassNotFoundException;
import java.io.EOFException;

/**
 * 
 * Manipula los datos de los archivos, I/O Archivos.
 * 
 * @see Menu
 */

public class ControladorArchivos {

  //valor hardcodeado
  private String archivoMaterias = "listaMateriasYActividades";
  
  //metodos para hacer las operaciones.
  
  //metodo para leer las materias.
  /**
   * Metodo que lee de un archivo origen los datos a mostrar en el menu.
   * @return Lista de las materias con sus actividades leidas del archivo origen.
   */
  
  @SuppressWarnings("unchecked")
  public ArrayList<Materia> leerMaterias(){
    //bloque try para atrapar las excepciones.
    try {
      
      FileInputStream fis = new FileInputStream(archivoMaterias);
      ObjectInputStream os = new ObjectInputStream(fis);
      
      ArrayList<Materia> materiaAux = (ArrayList<Materia>) os.readObject();
      
      return materiaAux;
      //cosas para debugiar despues si hay errores.
    } catch (EOFException ex){
      System.out.println(ex.getMessage());
      
    } catch (ClassNotFoundException ex){
      System.out.println(ex.getMessage());
    
    } catch (IOException ex){
      System.out.println(ex.getMessage());
    
    } 
    ArrayList<Materia> aux = new ArrayList<>();
    return aux;
  }

  /**
   * Metodo que escribe en el archivo origen la nueva lista de materias con sus actividades que se obtiene del menu
   * @param listaMaterias lista de las materias con sus actividades a escribir en el archivo origen.
   */

  @SuppressWarnings("unchecked")
  public void escribirMaterias(ArrayList<Materia> listaMaterias){
    try {
      FileOutputStream fos = new FileOutputStream(archivoMaterias);
      ObjectOutputStream ois = new ObjectOutputStream(fos);
      
      ois.writeObject(listaMaterias);
      
    } catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }
  
  
}
