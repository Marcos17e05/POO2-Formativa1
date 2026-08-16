package org.example.model;

public class PedidoComida extends Pedido{

    private boolean MochilaTermica;

    public PedidoComida(int idPedido, String direccionEntrega, boolean tieneMochilaTermica) {

        super(idPedido, direccionEntrega, "Comida");

        MochilaTermica = tieneMochilaTermica;
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println(
                "Repartidor seleccionado: " + nombreRepartidor
        );

        System.out.println(MochilaTermica
                ? "Pedido de comida #" + idPedido + " asignado correctamente."
                : "Validación: el repartidor debe contar con mochila térmica. Pedido no asignado");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println(
                "Buscando repartidor para su pedido de comida nº" + idPedido
        );

    }
}
