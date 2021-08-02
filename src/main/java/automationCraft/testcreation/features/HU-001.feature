Feature: HU-001 Buscador de productos
  Como usuario No logeado
  Quiero hacer búsquedas de productos por atributos
  Para encontrar con precisión lo que necesito comprar

  Background:
    Given el usuario se encuentra en la pagina de inicio

  @demo
  Scenario: Busqueda por nombre de producto
    Given existen productos registrados
    When se realiza una busqueda de producto por nombre "teclado"
    Then se deben mostrar todos los productos por nombre "teclado"
  @demo
  Scenario: Filtrar por disponibilidad de producto
    Given existen varios productos registrados
    When se realiza la busqueda filtrando por "Disponible"
    Then se deben mostrar solo los productos segun el filtro indicado.
  @demo
  Scenario: Filtrar por tipo de producto
    Given existen varios productos por tipo registrados.
    When se realiza la busqueda filtrando por tipo "PC"
    Then se deben mostrar solo los productos según el filtro de tipo indicado