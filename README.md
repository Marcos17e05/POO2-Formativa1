![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🚚 Sistema de Gestión de Pedidos

## 👤 Autor del proyecto

* **Nombre:** Marcos Alexis Escobar Ávila
* **Carrera:** Analista Programador Computacional
* **Sección:** 001A
* **Asignatura:** Desarrollo Orientado a Objetos II

---

## 📝 Descripción general

Este proyecto corresponde a un ejercicio de **Programación Orientada a Objetos en Java**, enfocado principalmente en la aplicación de **sobrecarga de métodos**, junto con el uso de **herencia** y **sobrescritura**.

El sistema representa distintos tipos de pedidos de una aplicación de reparto. Todos los pedidos comparten información general, pero cada tipo necesita realizar validaciones distintas al momento de asignar un repartidor.

Los tipos de pedido implementados son:

- 🍔 **Pedido de comida**
- 📦 **Pedido de encomienda**
- ⚡ **Pedido express**

Para esto se utiliza una clase base llamada `Pedido` y tres clases especializadas que heredan de ella.

---

## 🎯 Objetivo

El objetivo principal del proyecto es practicar la **sobrecarga del método `asignarRepartidor()`**, permitiendo utilizar el mismo nombre de método con diferentes parámetros.

También se aplica **sobrescritura**, ya que las clases hijas modifican el comportamiento heredado para adaptarlo a las necesidades de cada tipo de pedido.

---

## 📂 Estructura del proyecto

```text
src/
└── main/
    └── java/
        └── org/
            └── example/
                ├── Main.java
                └── model/
                    ├── Pedido.java
                    ├── PedidoComida.java
                    ├── PedidoEncomienda.java
                    └── PedidoExpress.java
```

---

## 🧩 Clases del sistema

### `Pedido`

Es la clase base del proyecto.

Contiene los datos comunes que necesita cualquier pedido:

```java
public int idPedido;
public String direccionEntrega;
public String tipoPedido;
```

Su constructor recibe:

```java
Pedido(int idPedido, String direccionEntrega, String tipoPedido)
```

Además, contiene las dos versiones del método `asignarRepartidor()` utilizadas para demostrar la **sobrecarga**.

#### Primera versión

```java
public void asignarRepartidor()
```

Realiza una asignación general sin recibir información adicional.

#### Segunda versión

```java
public void asignarRepartidor(String nombreRepartidor)
```

Recibe directamente el nombre del repartidor que será asignado al pedido.

---

### 🍔 `PedidoComida`

La clase `PedidoComida` hereda de `Pedido`.

Además de los datos generales, posee el atributo:

```java
private boolean MochilaTermica;
```

Este valor permite verificar si el pedido puede ser asignado correctamente.

Cuando se utiliza:

```java
asignarRepartidor(String nombreRepartidor)
```

el sistema comprueba si se cuenta con mochila térmica.

Si la condición se cumple, el pedido se asigna correctamente. En caso contrario, se informa que el repartidor debe contar con una mochila térmica.

También sobrescribe:

```java
asignarRepartidor()
```

para mostrar un mensaje específico indicando que se está buscando un repartidor para un pedido de comida.

---

### 📦 `PedidoEncomienda`

La clase `PedidoEncomienda` también hereda de `Pedido`.

Añade el atributo:

```java
private double peso;
```

Este atributo permite realizar una validación relacionada con el transporte de la encomienda.

Cuando se asigna un repartidor indicando su nombre, el sistema verifica el peso:

- Si el peso es mayor a **20 kg**, se solicita un vehículo con mayor capacidad.
- Si el peso es igual o inferior a **20 kg**, puede ser transportado normalmente.

De esta forma, el comportamiento del método se adapta al tipo de pedido.

---

### ⚡ `PedidoExpress`

La clase `PedidoExpress` representa pedidos que deben ser entregados dentro de un tiempo determinado.

Agrega el atributo:

```java
private int tiempoMaximoEntrega;
```

Cuando se asigna un repartidor, el programa informa el tiempo máximo disponible para completar la entrega.

Por ejemplo:

```text
Validación Express: debe entregar el pedido en un máximo de 60 minutos.
```

Esto permite que el pedido express tenga una lógica propia sin modificar la estructura general definida en `Pedido`.

---

## 🔁 Sobrecarga de métodos

La **sobrecarga** ocurre cuando existen varios métodos con el mismo nombre, pero con una lista de parámetros diferente.

En este proyecto se utiliza:

```java
public void asignarRepartidor()
```

y:

```java
public void asignarRepartidor(String nombreRepartidor)
```

Ambos métodos realizan una acción relacionada con la asignación de repartidores, pero se utilizan de manera diferente.

Ejemplo:

```java
comida.asignarRepartidor();
comida.asignarRepartidor("Juan");
```

En la primera llamada no se entrega ningún parámetro.

En la segunda llamada se proporciona el nombre del repartidor.

Java puede identificar automáticamente qué método debe ejecutar según los argumentos utilizados en la llamada.

---

## 🔄 Sobrescritura de métodos

Además de la sobrecarga, el proyecto utiliza **sobrescritura** mediante `@Override`.

La sobrescritura ocurre cuando una clase hija redefine un método que ya existe en la clase padre manteniendo la misma firma.

Por ejemplo:

```java
@Override
public void asignarRepartidor() {
    System.out.println(
        "Buscando repartidor para su pedido de comida nº" + idPedido
    );
}
```

Gracias a esto, cada clase puede utilizar el mismo método, pero ejecutar una acción diferente.

Esto permite que:

- `PedidoComida` valide la mochila térmica.
- `PedidoEncomienda` valide el peso.
- `PedidoExpress` considere el tiempo máximo de entrega.

---

## 🧬 Herencia

Las clases:

```java
PedidoComida
PedidoEncomienda
PedidoExpress
```

heredan de:

```java
Pedido
```

mediante:

```java
extends Pedido
```

Esto permite reutilizar atributos y métodos comunes sin repetirlos en cada clase.

Los constructores de las clases hijas utilizan `super(...)` para inicializar los datos definidos en la clase padre.

Ejemplo:

```java
super(idPedido, direccionEntrega, "Comida");
```

---

## ▶️ Funcionamiento de `Main`

La clase `Main` crea un objeto de cada tipo de pedido:

```java
PedidoComida comida
PedidoEncomienda encomienda
PedidoExpress express
```

Luego se prueban las dos formas del método `asignarRepartidor()`.

Ejemplo:

```java
comida.asignarRepartidor();
comida.asignarRepartidor("Juan");
```

También se realizan pruebas equivalentes para encomiendas y pedidos express.

De esta forma se puede observar directamente cómo un mismo nombre de método puede trabajar con diferentes parámetros y cómo cada subclase modifica su comportamiento.

---

## 🧪 Datos utilizados en las pruebas

### Pedido de comida

```text
ID: 1
Dirección: Almirante Palomo
Mochila térmica: false
Repartidor: Juan
```

### Pedido de encomienda

```text
ID: 2
Dirección: Baquedano 233
Peso: 40 kg
Repartidor: Samira
```

### Pedido express

```text
ID: 3
Dirección: Pasaje Pudu 3244
Tiempo máximo: 60 minutos
Repartidor: Pablo
```

---

## 💡 Conceptos de POO aplicados

Durante el desarrollo del ejercicio se utilizan los siguientes conceptos:

### Sobrecarga

Permite crear métodos con el mismo nombre pero diferentes parámetros.

```java
asignarRepartidor()
asignarRepartidor(String nombreRepartidor)
```

### Sobrescritura

Permite modificar en una clase hija el comportamiento de un método heredado.

```java
@Override
```

### Herencia

Permite que las distintas clases de pedido reutilicen la estructura de `Pedido`.

```java
extends Pedido
```

### Encapsulamiento

Los datos específicos de cada tipo de pedido, como el peso o el tiempo máximo de entrega, se mantienen como atributos privados.

```java
private double peso;
private int tiempoMaximoEntrega;
```

---

## 🛠️ Tecnologías utilizadas

* Java.
* Programación Orientada a Objetos.
* IntelliJ IDEA.

---

## ▶️ Ejecución

1. Descargar o clonar el proyecto.
2. Abrir el proyecto en **IntelliJ IDEA**.
3. Verificar que el JDK esté configurado correctamente.
4. Abrir la clase `Main`.
5. Ejecutar el método:

```java
public static void main(String[] args)
```

6. Revisar en consola las distintas asignaciones y validaciones realizadas por cada tipo de pedido.

---

## ✅ Conclusión

Este ejercicio permite comprender cómo Java puede utilizar un mismo nombre de método para realizar diferentes operaciones mediante **sobrecarga**, dependiendo de los parámetros recibidos.

Al mismo tiempo, el uso de **herencia y sobrescritura** permite que cada tipo de pedido mantenga una lógica específica sin perder la estructura común definida por la clase `Pedido`.

La combinación de estos conceptos permite crear programas más organizados, reutilizables y fáciles de ampliar, ya que nuevos tipos de pedido podrían incorporarse posteriormente heredando de `Pedido` y definiendo sus propias reglas de asignación.

---

**Repositorio:** [https://github.com/Marcos17e05/POO2-Formativa1]

**Fecha de entrega:** [16/08/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones
