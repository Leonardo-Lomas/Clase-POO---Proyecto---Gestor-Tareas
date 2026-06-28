import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.time.LocalDate;

public class Menu {
  //atributos por pensar si aplica en este caso...
  private ArrayList<Materia> listaMaterias;
  private ControladorArchivos controladorArchivos;
  //metodos...
  
  /*------------------------------------------------
  Este constructor es solamente para hardcodear Materias
  y actividades, solo esta aqui para hacer pruebas, y sera
  eliminado despues
  --------------------------------------------------- */
  public Menu(int ignorar){
    listaMaterias = new ArrayList<Materia>();
    listaMaterias.add(new Materia("Matematicas","Carlos Patricio"));
  }
  
  public Menu(){
    /*---------------------------------------------
    Se crea una instancia de la clase controlador para
    obtener la lista de materias
    ------------------------------------------------ */
    ControladorArchivos ca = new ControladorArchivos();
    listaMaterias = ca.leerMaterias();
  }


  /*--------------------------------------------------------------------------------------
  IMPORTANTE: Los metodos utilizan para leer entradas de enteros el metodo menu.leerEntero(),
  este metodo retorna un 0 si el valor no es un entero y se encuentra hasta abajo en la clase. 
  Se intenta evitar dar como una opcion el 0 en los menus, asi el valor introducido se rechaza
  si es un 0. los metodos que leen cadenas o numeros sin proporcionar un menu de opciones 
  tienen su propio Try-catch dentro (Esto siempre que no se me pasara un detalle T_T)

  Los metodos menuActividad(), menuAgregarActividad() y menuTareas() se encuentran sobrecargados
  para aceptar argumentos de tipo Materia y tipo Proyecto
  ------------------------------------------------------------------------------------------ */


  public void principal(){
    int seleccion;
    System.out.println("Materias");

    /*------------------------------------
    Se imprime la lista de materias
    -------------------------------------- */
    for(int i = 0; i< listaMaterias.size(); i++){
    System.out.println((i + 1) +".- "+ listaMaterias.get(i).getNombre());

    }

    System.out.println((listaMaterias.size() + 1) + ".- Salir del programa");

    /*--------------------------------------------
    Do-while, para iterar hasta que se introdusca un
    valor valido
    -----------------------------------------------*/
    do{  
      System.out.print("Selecion: ");

      seleccion = this.leerEntero() - 1; // Se resta uno, porque en el menu se listan del 1 en adelante
      //Se checa si se eligio la opcion de salir
      if(seleccion == listaMaterias.size()){
        return;
      }

      /*-------------------------------------------------------
      Try, en caso de que no corresponda a un elemento de la lista
      --------------------------------------------------------- */
      try{

        this.menuMateria(this.listaMaterias.get(seleccion));

      }catch(IndexOutOfBoundsException ex){
        System.out.println("Seleccion no valida");
      }

    }while(true);
  }

  public void menuMateria(Materia materia){
    int seleccion;

    //Se imprimen los datos de la materia y el menu de opciones
    System.out.println(materia.getNombre());
    System.out.println("Profesor: "+ materia.getProfesor());
        
    System.out.println("1.- Proyectos");
    System.out.println("2.- Tareas");
    System.out.println("3.- Examenes");
    System.out.println("4.- Regresar");
    System.out.print("Seleccion: ");
    /*--------------------------------------------
    Do-while, para iterar hasta que se introdusca un
    valor valido
    -----------------------------------------------*/
    do{  

      seleccion = this.leerEntero();
      //Switch para cada una de las opciones
      switch (seleccion){
        case 1:
           this.menuProyectos(materia);
           break;
        case 2:
           this.menuTareas(materia);
           break;
        case 3:
           this.menuExamenes(materia);
           break;
        case 4:
          return;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }while(true);
  }

  //Menu encargado de mostrar la lista de examenes de una materia
  public void menuTareas(Materia materia){
    ArrayList<Actividad> actividades = materia.getListaActividades();
    int seleccion;

    /*-------------------------------------
    Se buscan y imprimen los examenes de la materia
    ------------------------------------*/    
    for(int i = 0; i<= actividades.size() - 1 ; i++){
      if(actividades.get(i) instanceof Tarea){  
        System.out.println((i + 1) + ".- " + actividades.get(i).getNombre());
      }
    }

    System.out.println("Seleccione una tarea o una opcion de las siguientes");
    System.out.println("49.- Editar Materia");
    System.out.println("50.- Agregar una nueva Tarea");
    System.out.println("51.- Regresar");
    System.out.print("Seleccion: ");
    
    /*------------------------------------------------------------ 
    El try es por si acaso se selecciona un indice fuera de la lista,
    y el do-while es para iterar hasta que se introdusca un valor
    valido
    --------------------------------------------------------------*/
    try{
    do{
      seleccion = this.leerEntero();

      if(seleccion != 0 && (seleccion==50 || seleccion==51 || seleccion == 49)){
        switch (seleccion) {
          case 49:
            this.menuEditarMateria(materia);
            break;
          case 50:
            //Se le pasa un nuevo objeto del tipo de actividad que se le agregara
            this.menuAgregarActividad(materia, new Tarea());
            break;
        
          case 51:
            return;
        }//Fin del switch

      }else{
        if(actividades.get(seleccion) instanceof Tarea){//Se comprueba que si se selecionara un examne de la lista
          this.menuActividad(materia, actividades.get(seleccion - 1)); // Se le resta uno porque en la lista se imprimen de 1 en adelante
        }
      }

    }while(true);
    }catch(IndexOutOfBoundsException ex){ System.out.println("Seleccion no valida");}
  }

  public void menuTareas(Proyecto proyecto){
    ArrayList<Actividad> actividades = proyecto.getListaActividades();
    int seleccion;

    /*-------------------------------------
    Se buscan y imprimen los examenes de la materia
    ------------------------------------*/    
    for(int i = 0; i<= actividades.size() - 1 ; i++){
      if(actividades.get(i) instanceof Tarea){  
        System.out.println((i + 1) + ".- " + actividades.get(i).getNombre());
      }
    }

    System.out.println("Seleccione un examen o una opcion de las siguientes");
    System.out.println("50.- Agregar una nueva Tarea");
    System.out.println("51.- Regresar");
    System.out.print("Seleccion: ");
    
    /*------------------------------------------------------------ 
    El try es por si acaso se selecciona un indice fuera de la lista,
    y el do-while es para iterar hasta que se introdusca un valor
    valido
    --------------------------------------------------------------*/
    try{
    do{
      seleccion = this.leerEntero();

      if(seleccion != 0 && (seleccion==50 || seleccion==51)){
        switch (seleccion) {
          case 50:
            //Se le pasa un nuevo objeto del tipo de actividad que se le agregara
            this.menuAgregarActividad(proyecto, new Tarea());
            break;
        
          case 51:
            return;
        }//Fin del switch

      }else{
        if(actividades.get(seleccion) instanceof Tarea){//Se comprueba que si se selecionara un examne de la lista
          this.menuActividad(proyecto, actividades.get(seleccion - 1)); // Se le resta uno porque en la lista se imprimen de 1 en adelante
        }
      }

    }while(true);
    }catch(IndexOutOfBoundsException ex){ System.out.println("Seleccion no valida");}
  }

  public void menuProyectos(Materia materia){
    ArrayList<Actividad> actividades = materia.getListaActividades();
    int seleccion;

      /*--------------------------------------------
      Do-while, para poder iterar hasta que se
      introdusca un valor valido o se decida regresar
      al menu anterior
      --------------------------------------------- */
    do{
      if(actividades.isEmpty() == false){
        /*-------------------------------------
        Se buscan y imprimen los proyectos
        ------------------------------------*/    
        for(int i = 0; i < actividades.size(); i++){
          if(actividades.get(i) instanceof Proyecto){  
            System.out.println((i + 1) +".- " + actividades.get(i).getNombre());
          }
        }
      }else{ System.out.println("No hay Proyectos");}
      System.out.println("50.- Agregar un nuevo proyecto");
      System.out.println("51.- Regresar");
      System.out.print("Seleccion: ");
    
      seleccion = this.leerEntero();
      
      /*------------------------------------------------------------ 
      El try es por si acaso se selecciona un indice fuera de la lista
      --------------------------------------------------------------*/
      try{
        /*------------------------------------------------------
        Se comprueba que el valor devuelto sea distinto de cero
        y luego se comprueba cual de las opciones fue seleccionada
        -------------------------------------------------------- */
        if(seleccion != 0){

          if(seleccion == 50){ this.menuAgregarActividad(materia, new Proyecto());}
          if(seleccion == 51){return;}
          
          if(actividades.get(seleccion - 1) instanceof Proyecto && seleccion != 50 && seleccion != 51){//Se comprueba que si se selecionara un proyecto de la lista
            this.menuActividad(materia, actividades.get(seleccion - 1)); // Se le resta uno porque en la lista se imprimen de 1 en adelante
          
          }
        }

      }catch(IndexOutOfBoundsException ex){
        System.out.println("Seleccion no valida");
      }

    }while(true);
  }

  //Menu encargado de mostrar la lista de examenes de una materia
  public void menuExamenes(Materia materia){
    ArrayList<Actividad> actividades = materia.getListaActividades();
    int seleccion;

    /*-------------------------------------
    Se buscan y imprimen los examenes de la materia
    ------------------------------------*/    
    for(int i = 0; i<= actividades.size() - 1 ; i++){
      if(actividades.get(i) instanceof Examen){  
        System.out.println((i + 1) + ".- " + actividades.get(i).getNombre());
      }
    }

    System.out.println("Seleccione un examen o una opcion de las siguientes");
    System.out.println("50.- Agregar un nuevo Examen");
    System.out.println("51.- Regresar");
    System.out.print("Seleccion: ");
    
    /*------------------------------------------------------------ 
    El try es por si acaso se selecciona un indice fuera de la lista,
    y el do-while es para iterar hasta que se introdusca un valor
    valido
    --------------------------------------------------------------*/
    try{
    do{
      seleccion = this.leerEntero();

      //Se comprueba que la seleccion no sea cero, y se checa si es 50 o 51
      if(seleccion != 0 && (seleccion==50 || seleccion==51)){
        switch (seleccion) {
          case 50:
            //Se le pasa un nuevo objeto del tipo de actividad que se le agregara
            this.menuAgregarActividad(materia, new Examen());
            break;
        
          case 51:
            return;
        }//Fin del switch

      }else{//Si el valor no fue un 50 o 51
        if(actividades.get(seleccion) instanceof Examen){//Se comprueba que si se selecionara un examne de la lista
          this.menuActividad(materia, actividades.get(seleccion - 1)); // Se le resta uno porque en la lista se imprimen de 1 en adelante
        }
      }

    }while(true);
    }catch(IndexOutOfBoundsException ex){ System.out.println("Seleccion no valida");}
  }






  public void menuAgregarActividad(Proyecto proyecto, Tarea nuevaTarea){

    // Se inicializan las variables que se utilizaran
    LocalDate fecha;
    Scanner sc = new Scanner(System.in);
    String entrada;

    int dia,mes,año;
    
    /*-----------------------------------------------
    El try es por si se introduce algo que no sea una
    String
    ------------------------------------------------- */
    try{
    System.out.print("Nombre de la tarea: ");
    entrada = sc.nextLine();
    nuevaTarea.setNombre(entrada);

    System.out.print("Descripcion: ");
    entrada = sc.nextLine();
    nuevaTarea.setDescripcion(entrada);

    System.out.println("Fecha de conclusion");
    System.out.println("Año: ");
    año = sc.nextInt();

    System.out.println("Mes: ");
    mes = sc.nextInt();

    System.out.println("Dia: ");
    dia = sc.nextInt();

    fecha = LocalDate.of(año, mes, dia);
    nuevaTarea.setFechaConclusion(fecha);

    proyecto.agregarActividad(nuevaTarea);
    sc.close();
    System.out.println("La tarea fue agregada correctamente");
    return;
    }catch(InputMismatchException ex){

      /*---------------------------------------------------
      En caso de una excepcion, se agrega la actividad con
      los datos que si se hayan agregado hasta ese punto,
      el resto seran los datos del constructor sin parametros
      ----------------------------------------------------- */
      System.out.println("El valor introducido no es correcto, se regresara al menu anterior");
      System.out.println("Cualquier cambio realizado a la tarea antes de este punto se efectuara");
      proyecto.agregarActividad(nuevaTarea);
      sc.close();
      return;
    }
  }

  public void menuAgregarActividad(Materia materia,Actividad actividad){
    
    try{
    LocalDate fecha;
    Scanner sc = new Scanner(System.in);
    String entrada;
    int dia,mes,año;
    
    System.out.print("Nombre: ");
    entrada = sc.nextLine();
    actividad.setNombre(entrada);

    System.out.print("Descripcion: ");
    entrada = sc.nextLine();
    actividad.setDescripcion(entrada);

    System.out.println("Fecha de conclusion");
    System.out.println("Año: ");
    año = sc.nextInt();

    System.out.println("Mes: ");
    mes = sc.nextInt();

    System.out.println("Dia: ");
    dia = sc.nextInt();

    fecha = LocalDate.of(año, mes, dia);
    actividad.setFechaConclusion(fecha);

    materia.agregarActividad(actividad);
    sc.close();
    System.out.println("La actividad fue Agregada correctamente");
    return;
    }catch(InputMismatchException ex){
      /*---------------------------------------------------
      En caso de una excepcion, se agrega la actividad con
      los datos que si se hayan agregado hasta ese punto,
      el resto seran los datos del constructor sin parametros
      ----------------------------------------------------- */
      System.out.println("El valor introducido no es correcto, se regresara al menu anterior");
      System.out.println("Cualquier cambio realizado a la actividad antes de este punto se efectuara");
      materia.agregarActividad(actividad);
      return;
    }

  }

  public void menuActividad(Materia materia,Actividad actividad){
    int seleccion;

    System.out.println(actividad.getNombre());
    System.out.println(actividad.getDescripcion());
    System.out.println(actividad.getFechaConclusion());
    System.out.println(actividad.getCalificacion());
    System.out.println(actividad.getEstado()+"\n");
      
    /*-------------------------------------------------------
    Este if comprueba si la actividad es un proyecto, y en caso
    de que lo sea, se imprime un menu distinto y tambien las tareas
    de el proyecto
    --------------------------------------------------------- */
    if(actividad instanceof Proyecto){

      System.out.println("actividades del proyecto: ");
      for(int i = 0; i < ((Proyecto) actividad).getListaActividades().size(); i++){
        System.out.println(((Proyecto) actividad).getListaActividades().get(i));
      }

      System.out.println("1.- Marcar como terminada");
      System.out.println("2.- Editar");
      System.out.println("3.- Eliminar");
      System.out.println("4.- Tareas");        
      System.out.println("5.- Regresar");
      System.out.print("Seleccion: ");
    }else{
      System.out.println("1.- Marcar como terminada");
      System.out.println("2.- Editar");
      System.out.println("3.- Eliminar");
      System.out.println("4.- Regresar");
      System.out.print("Seleccion: ");
    }

    do{
      seleccion = this.leerEntero();

      if(actividad instanceof Proyecto){
        switch (seleccion) {
          case 1:
            actividad.setEstado(true);     
            break;
          case 2:
            this.menuEditarActividad(actividad);
            break;
          case 3:
            materia.eliminarActividad(actividad);
            break;
          case 4:
            this.menuTareas((Proyecto)actividad);
            break;
          case 5:
            return;
          default:
            System.out.println("Seleccion no valida");
            break;
        }

      }else{
        switch (seleccion) {
          case 1:
            actividad.setEstado(true);     
            break;
          case 2:
            this.menuEditarActividad(actividad);
            break;
          case 3:
            materia.eliminarActividad(actividad);
            break;
          case 4:
            return;
          default:
            System.out.println("Seleccion no valida");
            break;
        }

      }

    }while(true);

  }




  public void menuActividad(Proyecto proyecto,Actividad actividad){
    int seleccion;

    System.out.println(actividad.getNombre());
    System.out.println(actividad.getDescripcion());
    System.out.println(actividad.getFechaConclusion());
    System.out.println(actividad.getCalificacion());
    System.out.println(actividad.getEstado()+"\n");

    System.out.println("1.- Marcar como terminada");
    System.out.println("2.- Editar");
    System.out.println("3.- Eliminar");
    System.out.println("4.- Regresar");
    System.out.print("Seleccion: ");

    do{
      seleccion = this.leerEntero();

      switch (seleccion) {
        case 1:
          actividad.setEstado(true);     
          break;
        case 2:
          this.menuEditarActividad(actividad);
          break;
        case 3:
          proyecto.eliminarActividad(actividad);
          break;
        case 4:
          return;
        }

    }while(true);

  }

  public void menuEditarMateria(Materia materia){
    int seleccion;
    Scanner sc = new Scanner(System.in);
    String entrada;

    System.out.println("1.- " + materia.getNombre());
    System.out.println("2.- " + materia.getProfesor());
    System.out.println("3.- Salir");

    do{
      seleccion = this.leerEntero();

      try{
      if(seleccion == 1){
        entrada = sc.nextLine();
        materia.setNombre(entrada);
      }

      if(seleccion == 2){
        entrada = sc.nextLine();
        materia.setProfesor(entrada);
      }

      if(seleccion == 3){
        sc.close();
        return;
      }

      }catch(InputMismatchException ex){System.out.println("Entrada no valida");}
    }while(true);
  }


  public void menuEditarActividad(Actividad actividad){
    int seleccion,dia,mes,año;
    double califInput;
    LocalDate fecha;
    String entrada;
    Scanner sc = new Scanner(System.in);

    System.out.println("1.- " + actividad.getNombre());
    System.out.println("2.- " + actividad.getDescripcion());
    System.out.println("3.- " + actividad.getFechaConclusion());
    System.out.println("4.- " + actividad.getCalificacion());

    System.out.println("5.- Regresar");
    System.out.print("Seleccion: ");

    do{
      seleccion = this.leerEntero();

      /*------------------------------------------------
      Por motivos de legibilidad, preferi usar un monton
      de if´s aqui, siento que el switch es horrible

      El try es en caso de que se introdusca un valor no valido
      -------------------------------------------------- */
      try{
        if(seleccion == 1){
          entrada = sc.nextLine();
          actividad.setNombre(entrada);
        }

        if(seleccion == 2){
          entrada = sc.nextLine();
          actividad.setDescripcion(entrada);
        }

        if(seleccion == 3){
          System.out.println("Año: ");
          año = sc.nextInt();

          System.out.println("Mes: ");
          mes = sc.nextInt();

          System.out.println("Dia: ");
          dia = sc.nextInt();

          fecha = LocalDate.of(año, mes, dia);
          actividad.setFechaConclusion(fecha);
        }

        if(seleccion == 4){
          califInput = sc.nextDouble();
          actividad.setCalificacion(califInput);
        }

        if(seleccion == 5){
          sc.close();
          return;
        }

      }catch(InputMismatchException ex){ System.out.println("Input no valida");}
    }while(true);

  }

  /*--------------------------------------------------------
  Metodo para leer enteros desde la terminal, asi me ahorro
  poner este try en todos los demas metodos
  --------------------------------------------------------- */
  public int leerEntero(){
    System.out.println("--------------------------");
    Scanner sc = new Scanner(System.in);
    int entrada;
    /*-------------------------------------------------------
    Try, en caso de que la entrada no sea un entero o que
    --------------------------------------------------------- */
    try{ 
      entrada = sc.nextInt();
      return entrada;
     }catch(InputMismatchException ex){return 0;}
  }

}