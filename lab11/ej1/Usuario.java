package ej1;

class Usuario implements SObserver {
    private String nombre;
    private String correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Se sobreecribe el metodo de la interfaz
    @Override
    public void recibirNotificacion(Notificacion notificacion) {
        System.out.println("Usuario: " + nombre + " (" + correo + ") recibio -> " + notificacion);
    }
}
