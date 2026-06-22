# Objetivos del Sistema

* **Crear, organizar y gestionar:** Otorgar un espacio centralizado donde sea posible administrar desde tareas simples hasta proyectos complejos.
* **Sistema de alertas:** Implementar una funcionalidad de recordatorios en forma de notificaciones para garantizar el cumplimiento de los plazos.

# Arquitectura del Sistema
El sistema tiene una super clase llamada **Tarea** y que cuenta con los atributos y metodos basicos para una tarea, y las clases **TareaSimple**
y **TareaProyecto** heredan de esa superclase

La clase **Proyecto** cuenta con una relacion de integracion con la clase **TareaProyecto**, ya que uno de sus atributos es una lista de objetos de tipo **TareaProyecto**

Las clases **Proyecto** y **TareaSimple** implementan las interfaces **notificacion** y **posponer**

## SuperClases

### Tarea
* **Atributos:**
  * `- String` nombre
  * `- String` descripcion
  * `- boolean` estado
  * `- Date` fecha
* **Métodos:**
  * `+ terminarTarea()`
  * `+ posponer(Date)`

### Proyecto
* **Atributos:**
  * `- String` nombre
  * `- String` descripcion
  * `- boolean` estado
  * `- List` listTareas

---

## Interfaces

### Notificacion
* **Métodos:**
  * `+ notificar()`

### Posponer
* **Métodos:**
  * `+ Posponer()`

---

## Clases que heredan de Tarea

### TareaSimple
* *Implementa:* `Posponer` y `Notificar`

### TareaProyecto

---

## Relacion de tipo composicion en Proyecto
* La clase **Proyecto** cuenta con una lista de objetos de tipo **TareaProyecto**.
* La clase de **TareaProyecto** no tiene métodos para notificar o posponer fechas de finalización.
* Por lo tanto, estos objetos solo funcionan dentro de un objeto de tipo **Proyecto**.
