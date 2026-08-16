package org.example.model;

public class Pedido {

    public int idPedido;
    public String direccionEntrega;
    public String tipoPedido;

    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    public void asignarRepartidor(){
        System.out.println("Asignando un repartidor al pedido º" + idPedido);
    }

    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("El repartidor " + nombreRepartidor
                + " fue asignado al pedido #" + idPedido);
    }

}
