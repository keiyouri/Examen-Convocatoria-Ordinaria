# Examen-Convocatoria-Ordinaria

Enlace al repositorio: https://github.com/keiyouri/Examen-Convocatoria-Ordinaria.git

EJERCICIO 1:
Interfaz GlamourFinancial:
Define los métodos que la implementación debe proporcionar.
Incluye métodos para obtener y actualizar las cotizaciones de las acciones en diferentes mercados.
Define métodos para calcular el valor de mercado y el precio-valor en libras.

Clase GlamourFinancialImplementation:
Implementa la interfaz GlamourFinancial.
Utiliza un HashMap para almacenar las cotizaciones de las acciones en diferentes mercados.
Proporciona métodos para obtener y actualizar las cotizaciones.
Incluye métodos para calcular el valor de mercado y el precio-valor en libras.


EJERCICIO 2:
RegistroAcademico: Representa el registro académico de un empleado.
Asignatura: Representa una asignatura, con un nombre.
Curso: Representa un curso de formación, que contiene una lista de asignaturas.
Empleado: Representa un empleado, con un ID, nombre y lista de registros académicos.
RegistroAcademico: Representa el registro académico de un empleado, asociando un curso con las notas obtenidas en sus asignaturas y si se ha emitido un certificado.
SistemaFormacion: Clase singleton que gestiona a los empleados, cursos, inscripción a cursos, registro de notas y emisión de certificados.

He utilizado el patrón Singleton en la clase SistemaFormacion por varias razones: El sistema de formación maneja datos críticos como los registros académicos de los empleados, los cursos disponibles y los hitos alcanzados. Centralizar estas operaciones en una única instancia ayuda a mantener una única fuente de verdad, evitando inconsistencias y errores derivados de múltiples instancias. Asegurarse de que todas las operaciones de inscripción, registro de notas, y emisión de certificados se realicen sobre una única instancia garantiza la consistencia del estado del sistema. El patrón Singleton proporciona un punto de acceso global a la instancia de SistemaFormacion. Esto facilita la interacción con el sistema desde cualquier parte del código sin necesidad de pasar referencias de objetos entre diferentes partes de la aplicación.
Tener una única instancia reduce el consumo de recursos del sistema, también facilita el control sobre la creación y destrucción de la instancia, asegurando que los recursos se liberen adecuadamente.


EJERCICIO 3:
Documento: Representa un documento necesario para el proceso de IPO, con un nombre, tipo y estado de completado.
Requisito: Representa un requisito del proceso de IPO, con una descripción y estado de cumplimiento.
IPOProceso: Gestiona el proceso de IPO, incluyendo la lista de documentos, requisitos y hitos.
Actor: Representa un actor involucrado en el proceso de IPO, como proveedores e inversionistas.
SistemaIPO: Clase singleton que gestiona los procesos de IPO, permitiendo agregar procesos, actores, y seguir hitos.

He utilizado el patrón Singleton en el código de la clase SistemaIPO por los mismos motivos que para SistemaFormacion, es decir, para asegurar que exista una única instancia de esta clase en toda la aplicación, ya que es útil en situaciones donde es necesario controlar el acceso a recursos compartidos o centralizar la gestión de ciertas operaciones.


MVC: 
Modelo (Model)
Las clases que hemos desarrollado previamente (Asignatura, Curso, Empleado, RegistroAcademico, SistemaFormacion, Documento, Requisito, IPOProceso, Actor, SistemaIPO) forman parte del modelo.

Vista (View)
La vista proporcionará una interfaz de usuario para interactuar con el sistema. Para simplificar, usaremos la consola para la entrada y salida de datos.

Controlador (Controller)
El controlador gestionará las acciones del usuario, actualizará el modelo y cambiará la vista en consecuencia.
