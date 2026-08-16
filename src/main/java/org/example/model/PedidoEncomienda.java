package org.example.model;

public class PedidoEncomienda extends Pedido {
    private double peso;

    public PedidoEncomienda(int idPedido,
                            String direccionEntrega,
                            double peso) {

        super(idPedido, direccionEntrega, "Encomienda");

        this.peso = peso;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println(
                "Buscando repartidor para encomienda º" + idPedido
        );
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println(
                "Repartidor seleccionado: " + nombreRepartidor
        );
        if (peso > 20) {
            System.out.println(
                    "Validación: la encomienda pesa "
                            + peso
                            + " kg. Se requiere un vehículo con mayor capacidad."
            );
        } else {
            System.out.println(
                    "Peso validado: "
                            + peso
                            + " kg. Puede ser transportada normalmente."
            );
        }
        System.out.println(
                "Encomienda #" + idPedido + " asignada correctamente."
        );
    }
}