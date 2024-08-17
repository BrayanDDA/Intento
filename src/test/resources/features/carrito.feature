# language: es
@primerafuncionalidad
Característica: Funcionalidad del carrito de compra

  @smoke1
  Escenario: Compra de un product
    Dado que la web esta operativa
    Cuando se genera el numero de trajeta
    Y selecciona la cantidad "5"
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
      | cantidad | mensaje              |
      | 2        | Payment successfull! |
      | 1        | Payment successfull! |
      | 3        | Payment as!          |

  @regresion2
  Escenario: Validacion de trajeta en blanco
    Dado que la web esta operativa
    Cuando selecciona la cantidad "5"
    Y realiza la compra del producto
    Y selecciona el mes "04"
    Y selecciona el anio "2024"
    Y paga el producto
    Entonces validar el mensaje del cuadro de dialogo "Check card number is 16 digits!"