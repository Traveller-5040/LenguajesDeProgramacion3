package ej2;

public class InventarioController {
    // El controlador contiene un modelo y una vista
    private InventarioModel modelo;
    private InventarioView view;

    public InventarioController(InventarioModel model, InventarioView vista) {
        this.modelo = model;
        this.view = vista;
    }

    // Metodo que registra un item nuevo validando sus datos
    public void agregarItem(String nombre, String opcionTipo, String descripcion, int cantidad) {
        // Convierte la opcion elegida (1 o 2) en el texto del tipo
        String tipo;
        if(opcionTipo.equals("1")) {
            tipo = "Arma";
        } else if(opcionTipo.equals("2")) {
            tipo = "Pocion";
        } else {
            this.view.mostrarMensaje("Tipo no valido");
            return;
        }

        if(nombre.isEmpty() || cantidad <= 0) {
            this.view.mostrarMensaje("Nombre vacio o cantidad no valida");
        } else {
            this.modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
            this.view.mostrarMensaje("Item registrado");
        }
    }

    // Metodo que elimina un item buscandolo por su nombre
    public void eliminarItem(String nombre) {
        Item item = this.modelo.buscarItem(nombre);
        if(item == null) {
            this.view.mostrarMensaje("No se encontro el item");
        } else {
            this.modelo.eliminarItem(item);
            this.view.mostrarMensaje("Item eliminado");
        }
    }

    // Metodo de instancia que muestra todos los items registrados
    public void verInventario() {
        view.mostrarInventario(this.modelo.obtenerItems());
    }

    // Metodo que muestra los detalles de un item buscandolo por su nombre
    public void mostrarDetalles(String nombre) {
        Item item = this.modelo.buscarItem(nombre);
        if(item == null) {
            this.view.mostrarMensaje("No se encontro el item");
        } else {
            this.view.mostrarDetallesItem(item);
        }
    }

    public void buscarItem(String nombre) {
        Item item = this.modelo.buscarItem(nombre);
        if(item == null) {
            this.view.mostrarMensaje("No se encontro el item");
        } else {
            this.view.mostrarMensaje("Encontrado: " + item.getNombre() + " x" + item.getCantidad());
        }
    }

    // Metodo que usa un item del inventario (UsarItem de la clase Item)
    public void usarItem(String nombre) {
        Item item = this.modelo.buscarItem(nombre);
        if(item == null) {
            this.view.mostrarMensaje("No se encontro el item");
        } else if(item.usarItem()) {
            this.view.mostrarMensaje("Usaste: " + item.getNombre());
        } else {
            this.view.mostrarMensaje("No quedan unidades de " + item.getNombre());
        }
    }

    // Metodo que inicia el programa con un bucle do-while hasta que el usuario decida salir
    public void iniciar() {
        String opc;
        do {
            view.mostrarMensaje(" ");
            view.mostrarMenu();
            opc = view.solicitarOpcion();
            switch (opc) {
                case "1":
                    String nombre = view.solicitarTexto("Introduzca el nombre");
                    String tipo = view.solicitarTexto("Introduzca el tipo (1 = Arma, 2 = Pocion)");
                    String desc = view.solicitarTexto("Introduzca la descripcion");
                    int cantidad = view.solicitarEntero("Introduzca la cantidad");
                    this.agregarItem(nombre, tipo, desc, cantidad);
                    break;

                case "2":
                    this.verInventario();
                    break;

                case "3":
                    this.eliminarItem(view.solicitarTexto("Introduzca el nombre del item"));
                    break;

                case "4":
                    this.buscarItem(view.solicitarTexto("Introduzca el nombre a buscar"));
                    break;

                case "5":
                    this.mostrarDetalles(view.solicitarTexto("Introduzca el nombre del item"));
                    break;

                case "6":
                    this.usarItem(view.solicitarTexto("Introduzca el nombre del item"));
                    break;

                case "7":
                    view.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    view.mostrarMensaje("Opcion invalida, intente otra vez");
            }
        } while(!opc.equals("7"));
        this.view.cerrarScanner();
    }
}
