from datetime import date, time
from ProductoConMasDatos import ProductoConMasDatos

class ProductoCongeladoPorNitrogeno(ProductoConMasDatos):
    __informacion: str
    __tiempo : time

    def __init__(self, nombre: str, fV: date, nL: int, fE: date, gO: str, org: str, tempM: int, inf: str, tiemp: time):
        super().__init__(nombre, fV, nL, fE, gO, org, tempM)
        self.__informacion = inf
        self.__tiempo = tiemp
    
    def get_informacion(self) -> str:
        return self.__informacion
    def get_tiempo(self) -> time:
        return self.__tiempo

    def set_informacion(self, nuevoI: str):
        self.__informacion = nuevoI
    def set_tiempo(self, nuevoT: time):
        self.__tiempo = nuevoT
    
    def getEtiqueta(self) -> str:
        cadena = "| \t Informacion: " + self.get_informacion + "\n"
        cadena += "| \t Tiempo: " + str(self.get_tiempo) + "\n"
        return super().getEtiqueta() + cadena