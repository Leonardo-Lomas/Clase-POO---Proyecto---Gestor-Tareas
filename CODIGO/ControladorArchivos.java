import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Exception.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.lang.ClassNotFoundException;
import java.io.EOFException;

public class ControladorArchivos {
  
  //valor hardcodeado
  private String archivoMaterias = "listaMaterias";
  
  //metodos para hacer las operaciones.
  
  //metodo para leer las materias.
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
