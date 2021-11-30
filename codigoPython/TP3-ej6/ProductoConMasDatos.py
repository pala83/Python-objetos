from datetime import date
from Producto import Producto

class ProductoConMasDatos(Producto):
    __organismo: str
    __tempMantenimiento: int

    def __init__(self, nombre: str, fV: date, nL: int, fE: date, gO: str, org: str, tempM: int):
        super().__init__(nombre, fV, nL, fE, gO)
        self.__organismo = org
        self.__tempMantenimiento = tempM

    def get_organismo(self) -> str:
        return self.__organismo
    def get_tempMantenimiento(self) -> int:
        return self.__tempMantenimiento
    
    def set_organismo(self, nuevoOrg: str):
        self.__organismo = nuevoOrg
    def set_tempMantenimiento(self, nuevoTemp: int):
        self.__tempMantenimiento = nuevoTemp

    def getEtiqueta(self) -> str:
        cadena = "| \t Organismo: " + self.get_organismo + "\n"
        cadena += "| \t Temperatura de mantenimiento: " + str(self.get_tempMantenimiento) + "\n"
        return super().getEtiqueta() + cadena