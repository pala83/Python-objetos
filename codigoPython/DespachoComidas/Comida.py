from abc import ABC


class Comida(ABC):
    __nombre: str
    __tipo: str
    __modoPreparacion: str
    __aceptar: bool


def __init__(self, nombre, tipo, modoPreparacion, aceptar):       # constructor
    self.__nombre = nombre
    self.__tipo = tipo
    self.modoPreparacion = modoPreparacion
    self.__aceptar = aceptar


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


def get_precio():
    pass


def get_calorias():
    pass


def get_preparacion():
    pass
