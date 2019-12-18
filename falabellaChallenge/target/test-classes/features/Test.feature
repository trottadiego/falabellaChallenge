Feature: Compra de producto online
Como usuario de falabella quiero comprar un producto con garantia extendida para obetener mi comprobante de compra
 
  Scenario: Ingresar a la pagina de falabella
    Given El usuario ingreso en la pagina de falabella a travez de google
    When Busco un producto
    And Entro al detalle del producto
    And Agrego el producto a la bolsa
    And Ingreso a la bolsa de compra
    And Incrementa en un prodcuto y agrega una gatanria extendida
    And Hace click en ir a comprar
    Then Se debe haber redirigido a la pantalla de envio