# language: es
Característica: Funcionalidad del carrito de compra version 2
@smoke
  Escenario: Compra de un product
    Dado que la web esta operativa
    Cuando se genera el numero de trajeta
    Y selecciona la cantidad "1"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "Payment successfull!"
@regresion
  Esquema del escenario: : Compra de un producto con varias cantidades
    Dado que la web esta operativa
    Cuando se genera el numero de trajeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "<mensaje>"
    Ejemplos: Tabla de cantidades
    |cantidad|mensaje|
    |2       |Payment successfull!|
    |3       |Payment successfull!|
    |7       |Payment as!|