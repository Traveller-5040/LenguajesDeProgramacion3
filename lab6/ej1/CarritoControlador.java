package ej1;

public class CarritoControlador {
    // El controlador contiene un modelo y una vista
    private CarritoModelo modelo;
    private CarritoVista view;

    public CarritoControlador(CarritoModelo model, CarritoVista vista) {
        this.modelo = model;
        this.view = vista;
    }

    // Metodo que registra un producto nuevo validando sus datos
    public void agregarProducto(String nombre, double precio, int stock) {
        if(nombre.isEmpty() || precio <= 0 || stock < 0) {
            this.view.mostrarMensaje("Datos del producto no validos");
        } else {
            this.modelo.agregarProducto(new Producto(nombre, precio, stock));
            this.view.mostrarMensaje("Producto registrado");
        }
    }

    // Metodo que muestra los productos de la tienda, verificando que existan registros
    public void listarProductos() {
        if(this.modelo.getProductos().isEmpty()) {
            view.mostrarMensaje("No hay productos registrados");
        } else {
            view.mostrarProductos(this.modelo.getProductos());
        }
    }

    // Metodo que agrega al carrito el producto seleccionado mediante su indice
    public void agregarAlCarrito(int index) {
        if(this.modelo.getProductos().isEmpty()) {
            view.mostrarMensaje("No hay productos registrados");
            return;
        }

        // Ajusta el indice ingresado para que coincida con el sistema de numeracion base 0
        index -= 1;

        // Valida que el indice este dentro del rango de la lista
        if(index >= 0 && index < this.modelo.getProductos().size()) {
            if(this.modelo.agregarAlCarrito(index)) {
                this.view.mostrarMensaje("Producto agregado al carrito");
            } else {
                this.view.mostrarMensaje("Producto sin stock");
            }
        } else {
            this.view.mostrarMensaje("Indice no valido");
        }
    }

    // Metodo que muestra el carrito junto con el subtotal, descuento, envio y total
    public void verCarrito() {
        if(this.modelo.getCarrito().isEmpty()) {
            view.mostrarMensaje("El carrito esta vacio");
            return;
        }
        view.mostrarCarrito(this.modelo.getCarrito());
        view.mostrarMensaje("Subtotal: S/ " + String.format("%.2f", this.modelo.calcularSubtotal()));
        view.mostrarMensaje("Descuento: S/ " + String.format("%.2f", this.modelo.calcularDescuento()));
        view.mostrarMensaje("Envio: S/ " + String.format("%.2f", this.modelo.calcularEnvio()));
        view.mostrarMensaje("Total: S/ " + String.format("%.2f", this.modelo.calcularTotal()));
    }

    // Metodo que quita del carrito el producto seleccionado mediante su indice
    public void quitarDelCarrito(int index) {
        if(this.modelo.getCarrito().isEmpty()) {
            view.mostrarMensaje("El carrito esta vacio");
            return;
        }

        index -= 1;

        if(index >= 0 && index < this.modelo.getCarrito().size()) {
            this.modelo.quitarDelCarrito(index);
            this.view.mostrarMensaje("Producto quitado del carrito");
        } else {
            this.view.mostrarMensaje("Indice no valido");
        }
    }

    // Metodo que aplica el codigo de descuento ingresado
    public void aplicarDescuento(String codigo) {
        if(this.modelo.aplicarDescuento(codigo.toUpperCase())) {
            this.view.mostrarMensaje("Descuento aplicado");
        } else {
            this.view.mostrarMensaje("Codigo no valido (use DESC10 o DESC20)");
        }
    }

    public void calcularEnvio() {
        view.mostrarMensaje("Costo de envio: S/ " + String.format("%.2f", this.modelo.calcularEnvio()));
    }

    public void mostrarHistorial() {
        if(this.modelo.getHistorial().isEmpty()) {
            view.mostrarMensaje("Aun no hay compras realizadas");
        } else {
            view.mostrarHistorial(this.modelo.getHistorial());
        }
    }

    // Metodo que finaliza la compra solo si el carrito tiene productos
    public void realizarCompra() {
        if(this.modelo.getCarrito().isEmpty()) {
            view.mostrarMensaje("El carrito esta vacio");
        } else {
            double total = this.modelo.calcularTotal();
            this.modelo.realizarCompra();
            view.mostrarMensaje("Compra realizada. Total pagado: S/ " + String.format("%.2f", total));
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
                    String nombre = view.solicitarTexto("Introduzca el nombre del producto");
                    double precio = view.solicitarPrecio();
                    int stock = view.solicitarEntero("Introduzca el stock");
                    this.agregarProducto(nombre, precio, stock);
                    break;

                case "2":
                    this.listarProductos();
                    break;

                case "3":
                    this.agregarAlCarrito(view.solicitarEntero("Introduzca el indice del producto"));
                    break;

                case "4":
                    this.verCarrito();
                    break;

                case "5":
                    this.quitarDelCarrito(view.solicitarEntero("Introduzca el indice del producto del carrito"));
                    break;

                case "6":
                    this.aplicarDescuento(view.solicitarTexto("Introduzca el codigo de descuento"));
                    break;

                case "7":
                    this.calcularEnvio();
                    break;

                case "8":
                    this.mostrarHistorial();
                    break;

                case "9":
                    this.realizarCompra();
                    break;

                case "10":
                    view.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    view.mostrarMensaje("Opcion invalida, intente otra vez");
            }
        } while(!opc.equals("10"));
        this.view.cerrarScanner();
    }
}
