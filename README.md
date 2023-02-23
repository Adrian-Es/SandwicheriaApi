# Índice
* [Info](#info)
* [Application.properties](#applicationproperties)
* [DTO´s](#dtos)
* [Controllers](#controllers)
* [Correcciones y agregados a implementar](#correcciones-y-agregados-a-implementar)
* [Versiones](#versiones)

# Info
API REST simple que atiende las necesidades de un local de sanguches.

Brinda la capacidad de guardar en una base de datos: Los ingredientes disponibles, los proveedores contratados, los repartos que se hicieron (qué proveedor, cuándo y los ingreidientes comprados) y los pedidos que se realizaron al local, dando estos la fecha y direccion de entrega; además de los detalles de cada sanguche solicitado.

Las tecnologías usadas en este proyecto son: Java 17, Spring Boot 3.0, MySQL y Hibernate.

# Application.Properties
Las configuraciones básicas que aplico para el archivo application.properties son:

* spring.jpa.database= //db que utilices
* spring.jpa.show-sql=true
* spring.jpa.hibernate.ddl-auto=update
* spring.datasource.url= //url a tu db, con formato jdbc:dbUtilizada://url
* spring.datasource.driver-class-name= //driver correspondiente a tu dv
* spring.datasource.username=
* spring.datasource.password= 

# DTO's
La API implementa distintos tipos de dto en base al fácil ingreso de datos a la bd. A continuación dejo la lista de estos dto's y las propiedades que contienen cada uno

#### Índice Dto:
* [IngredienteDto](#ingredientedto)
* [ProveedorDto](#proveedordto)
* [RepartosCompletosDto](#repartoscompletosdto)
* [DetalleRepartosBasicoDto](#detallerepartosbasicodto)
* [PedidosCompletosDto](#pedidoscompletosdto)
* [SanguchesPedidoDto](#sanguchespedidodto)
* [DetalleSangucheDto](#detallesanguchedto)

## IngredienteDto
* String nombre: Nombre del ingrediente
* Integer cantidadTotal: Este valor indica la cantidad total disponible del ingrediente, se suman en cada reparto y se restan en cada pedido

## ProveedorDto
* String nombre: Nombre de la empresa o persona que provee los ingredientes
* String direccion: Dirección del mismo
* String telefono: Contacto del mismo

## RepartosCompletosDto
* Integer id_proveedor: Es quien realiza la entrega de ingredientes
* String fecha: La fecha debe tener formato: año/mes/día
* Set < DetalleRepartosBasicoDto > detalles: Es la lista de ingredientes recibidos

## DetalleRepartosBasicoDto
* Integer id_ingrediente: Ingrediente recibido
* Integer cantidad: Cantidad que se agrega en la bd
* Float coste: Coste unitario por ingrediente

## PedidosCompletosDto
* String direccionEntrega: Dirección donde se hace la entrega
* String fecha: Se respeta el formato antes mencionado
* Set < SanguchesPedidoDto > sanguches: Lista de todos los sanguches a entregar

## SanguchesPedidoDto
* Set < DetalleSangucheDto > detalles: Lista de los ingredientes de cada sanguche 

## DetalleSangucheDto
* Integer idIngrediente: Ingrediente utilizado
* Integer cantidad: Cantidad utilizada

# Controllers
Por último, en cuanto a documentación para el uso de esta API, voy a dejar una lista de los controllers que se aplican, las funciones y retornos que hace cada uno cuando cumplen exitosamente con su función:

#### Índice Controllers
* [IngredienteController](#ingredientecontroller)
* [ProveedorController](#proveedorcontroller)
* [RepartosCompletosController](#repartoscompletoscontroller)
* [PedidoController](#pedidocontroller)
    
## IngredienteController
@RequestMapping: "/ingredientes"

Funciones:

#### create(@RequestBody IngredienteDto):
     * @PostMapping = ""
     * Return: ResponseEntity<Object>(HttpStatus.CREATED)
     * Descripcion: recibe un IngredienteDto, lo transforma en un ingredienteModel y lo almacena en la base de datos.
 
#### update(@RequestBody IngredienteDto, @PathVariable Integer id):
     * @PutMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: recibe un IngredienteDto y el id del ingrediente que se quiere actualizar en la db, verifica que existe y lo actualiza en la base de datos. 
  
#### findAll():
     * @GetMapping = "/all"
     * Return: ResponseEntity<List<IngredienteDto>>(List<IngredienteDto>, HttpStatus.OK)
     * Descripcion: Retorna todos los ingredientes almacenados en la base de datos
  
#### findById(@PathVariable Integer id):
     * @GetMapping = "/{id}"
     * Return: ResponseEntity<IngredienteDto>(IngredienteDto, HttpStatus.OK)
     * Descripcion: Busca el ingrediente pedido en la base de datos y si existe lo retorna.
  
  
#### delete(@PathVariable Integer id):
     * @DeleteMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: Busca el ingrediente pedido en la base de datos y si existe lo elimina de la bd.
  
## ProveedorController
@RequestMapping: "/proveedores"

Funciones:

#### create(@RequestBody ProveedorDto):
     * @PostMapping = ""
     * Return: ResponseEntity<Object>(HttpStatus.CREATED)
     * Descripcion: recibe un ProveedorDto, lo transforma en un ProveedorModel y lo almacena en la base de datos.
 
#### update(@RequestBody ProveedorDto, @PathVariable Integer id):
     * @PutMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: recibe un ProveedorDto y el id del proveedor que se quiere actualizar en la db, verifica que existe y lo actualiza en la base de datos. 
  
#### findAll():
     * @GetMapping = "/all"
     * Return: ResponseEntity<List<ProveedorDto>>(List<ProveedorDto>, HttpStatus.OK)
     * Descripcion: Retorna todos los proveedores almacenados en la base de datos
  
#### findById(@PathVariable Integer id):
     * @GetMapping = "/{id}"
     * Return: ResponseEntity<ProveedoreDto>(ProveedorDto, HttpStatus.OK)
     * Descripcion: Busca el proveedor pedido en la base de datos y si existe lo retorna.
  
#### delete(@PathVariable Integer id):
     * @DeleteMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: Busca el proveedor pedido en la base de datos y si existe lo elimina de la bd.
  
## RepartosCompletosController
@RequestMapping: "/repartos"

Funciones:

#### create(@RequestBody RepartosCompletosDto):
     * @PostMapping = ""
     * Return: ResponseEntity<Object>(HttpStatus.CREATED)
     * Descripcion: recibe un RepartosCompletosDto, lo transforma en un RepartoModel y un Set<DetalleRepartoModel> y almacena los registros en la base de datos.
  
#### findAll():
     * @GetMapping = "/all"
     * Return: ResponseEntity<List<RepartosCompletosDto>>(List<RepartosCompletosDto>, HttpStatus.OK)
     * Descripcion: Retorna todos los repartos almacenados en la base de datos
  
#### findById(@PathVariable Integer id):
     * @GetMapping = "/{id}"
     * Return: ResponseEntity<RepartosCompletosDto>(RepartosCompletosDto, HttpStatus.OK)
     * Descripcion: Busca el reparto pedido en la base de datos y si existe lo retorna.
 
#### findByProveedor(@PathVariable Integer id):
     * @GetMapping = "/proveedor/{id}"
     * Return: ResponseEntity<List<RepartosCompletosDto>>(List<RepartosCompletosDto>, HttpStatus.OK)
     * Descripcion: Retorna todos los repartos encontrados hechos por el proveedor solicitado.
  
#### delete(@PathVariable Integer id):
     * @DeleteMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: Busca el Reparto pedido en la base de datos y si existe lo elimina de la bd.
  
## PedidoController
@RequestMapping: "/pedidos"
  
Funciones:
  
#### create(@RequestBody PedidoCompletoDto):
     * @PostMapping = ""
     * Return: ResponseEntity<Object>(HttpStatus.CREATED)
     * Descripcion: recibe un PedidoCompletoDto, lo transforma en un PedidoModel, un Set<SanguchesPedidoModel> y un set<DetalleSangucheModel> para almacenar los registros en la base de datos.
  
#### findAll():
     * @GetMapping = ""
     * Return: ResponseEntity<List<PedidoCompletoDto>>(List<PedidoCompletoDto>, HttpStatus.OK)
     * Descripcion: Retorna todos los pedidos almacenados en la base de datos
  
#### findById(@PathVariable Integer id):
     * @GetMapping = "/{id}"
     * Return: ResponseEntity<PedidoCompletoDto>(PedidoCompletoDto, HttpStatus.OK)
     * Descripcion: Busca el pedido solicitado en la base de datos y si existe lo retorna.

#### delete(@PathVariable Integer id):
     * @DeleteMapping = "/{id}"
     * Return: ResponseEntity<Object>(HttpStatus.OK)
     * Descripcion: Busca el pedido solicitado en la base de datos y si existe lo elimina de la bd.

# Correcciones y agregados a implementar
* Introducir DTO's de salida: los dto actualmente sirven perfectamente para ingresar datos, pero son poco practicos para leerlos en la salida (casos como la lista de ingredientes o proveedores, que no indican la id de cada registro; y otros como DetalleSanguche o RepartosCompletos, que indican id´s pero sin saber más informacion al respecto).
* Añadir la variable "costeUnitario" a ingredientes, para indicar el coste de venta. A su vez, esto da pie a la implementacion de "precio" en SanguchePedido (ya que se podría calcular bien el precio de cada sanguche) y la correcta utilización de la variable "total" en Pedidos.
* Perfeccionar los controladores (evitar, en las clases compuestas, que se generen registros de una tabla pero no en otra debido a errores).
* Manejar mejor los errores devueltos, retornar quizás más ResponseEntity's que excepciones

# Versiones
* 1.0: primer versión subida, se verificó previamente que todos los controladores (si se ingresaban los objetos con valores válidos para el sistema) funcionaban perfectamente
* 1.1: correción de variables, se implementó en todo el código el uso de variables más descriptivas, dejando de lado el uso inicial de siglas en pos de un entendimiento más fácil del código.
