from Comida import Comida


class ComidaSimple(Comida):

    def __init__(self, nombre, tipo, modoPreparacion, aceptar, caloria, precio, tPreparacion):  # constructor
        super().__init__(nombre, tipo, modoPreparacion, aceptar)
        self.__caloria = caloria
        self.__precio = precio
        self.__tPreparacion = tPreparacion

    def get_precio(self):
        return self.__precio

    def get_calorias(self):
        return self.__caloria

    def get_preparacion(self):
        return self.__tPreparacion
