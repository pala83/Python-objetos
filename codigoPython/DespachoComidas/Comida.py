from abc import ABC, abstractmethod


class Comida(ABC):

    def __init__(self, nombre, tipo, modoPreparacion, aceptar):       # constructor
        self.__nombre = nombre
        self.__tipo = tipo
        self.__modoPreparacion = modoPreparacion
        self.__aceptar = aceptar
        super().__init__()

    def __str__(self):
        cadena = "Nombre : " + self.get_nombre() + "\n"
        cadena += "|\tTipo: " + self.get_tipo() + "\n"
        cadena += "|\tModo de preparacion: " + self.get_modopreparacion() + "\n"
        cadena += "|\tEs aceptada: " + str(self.__aceptar) + "\n-------------------------------"
        return cadena

    def aceptar_comida(self):
        self.__aceptar = True

    def se_acepto(self):
        return self.__aceptar

    def get_nombre(self):
        return self.__nombre

    def set_nombre(self, nombre):
        self.__nombre = nombre

    def get_tipo(self):
        return self.__tipo

    def set_tipo(self, tipo):
        self.__tipo = tipo

    def get_modopreparacion(self):
        return self.__modoPreparacion

    def set_modopreparacion(self, preparacion):
        self.__modoPreparacion = preparacion

    @abstractmethod
    def get_precio(self):
        pass

    @abstractmethod
    def get_calorias(self):
        pass

    @abstractmethod
    def get_preparacion(self):
        pass
