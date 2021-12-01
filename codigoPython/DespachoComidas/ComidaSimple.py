from Comida import Comida


class ComidaSimple(Comida):

    def __init__(self, nombre, tipo, modoPreparacion, aceptar, caloria, precio, tPreparacion):  # constructor
        super().__init__(nombre, tipo, modoPreparacion, aceptar)
        self.__caloria = caloria
        self.__precio = precio
        self.__tPreparacion = tPreparacion

    def __str__(self):
        cadena = "Nombre : " + self.get_nombre() + "\n"
        cadena += "|\tTipo: " + self.get_tipo() + "\n"
        cadena += "|\tModo de preparacion: " + self.get_modopreparacion() + "\n"
        cadena += "|\tCalorias: " + str(self.__caloria) + "\n"
        cadena += "|\tPrecio: $" + str(self.__precio) + "\n"
        cadena += "|\tTiempo de preparacion: " + str(self.__tPreparacion) + "\n"
        cadena += "|\tEs aceptada: " + str(self.aceptar_comida()) + "\n-------------------------------"
        return cadena

    def get_precio(self):
        return self.__precio

    def get_calorias(self):
        return self.__caloria

    def get_preparacion(self):
        return self.__tPreparacion
