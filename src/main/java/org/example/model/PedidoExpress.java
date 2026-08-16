package org.example.model;

public class PedidoExpress extends Pedido {

    private int tiempoMaximoEntrega;

    public PedidoExpress(int idPedido,
                         String direccionEntrega,
                         int tiempoMaximoEntrega) {

        super(idPedido, direccionEntrega, "Express");

        this.tiempoMaximoEntrega = tiempoMaximoEntrega;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println(
                "Buscando repartidor disponible inmediatamente para pedido express º" + idPedido
        );
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {

        System.out.println(
                "Repartidor seleccionado: " + nombreRepartidor
        );

        System.out.println(
                "Validación Express: debe entregar el pedido en un máximo de "
                        + tiempoMaximoEntrega
                        + " minutos."
        );

        System.out.println(
                "Pedido express #" + idPedido + " asignado correctamente."
        );
    }
}