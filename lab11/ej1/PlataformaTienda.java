package ej1;

import java.util.ArrayList;
import java.util.List;

class PlataformaTienda {
    // Se declara una lista como atributo para almacenar los observadores
    private List<SObserver> usuariosSuscritos = new ArrayList<>();

    // Se crea el metodo suscribir el cual agregara instancias de la clase
    // Usuario no sin antes verificar si ya se encuentran dentro de la lista
    public void suscribir(SObserver usuario) {
        if (!usuariosSuscritos.contains(usuario)) {
            usuariosSuscritos.add(usuario);
        }
    }

    // Se crea el metodo desuscribir, el cual remueve de la lista al usuario
    // enviado
    public void desuscribir(SObserver usuario) {
        usuariosSuscritos.remove(usuario);
    }

    // Metodo que notificara a todos los observadores sobre un evento
    public void publicarEvento(String tipo, String mensaje) {
        Notificacion notif = new Notificacion(tipo, mensaje);
        for (SObserver usuario : usuariosSuscritos) {
            usuario.recibirNotificacion(notif);
        }
    }
}