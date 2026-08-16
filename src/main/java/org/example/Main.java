package org.example;

import org.example.model.PedidoComida;
import org.example.model.PedidoEncomienda;
import org.example.model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        PedidoComida comida = new PedidoComida(
                1,
                "Almirante Palomo",
                false
        );

        PedidoEncomienda encomienda = new PedidoEncomienda(
                2,
                "Baquedano 233",
                40
        );

        PedidoExpress express = new PedidoExpress(
                3,
                "Pasaje Pudu 3244",
                60
        );


        System.out.println("===== PEDIDO COMIDA =====");

        comida.asignarRepartidor();
        comida.asignarRepartidor("Juan");


        System.out.println("\n===== PEDIDO ENCOMIENDA =====");

        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("Samira");


        System.out.println("\n===== PEDIDO EXPRESS =====");

        express.asignarRepartidor();
        express.asignarRepartidor("Pablo");
    }
}