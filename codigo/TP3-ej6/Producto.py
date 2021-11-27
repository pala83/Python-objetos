from datetime import date

class Producto():
    
    __nombre: str
    __fechaVencimiento: date
    __nroLote: int
    __fechaEnvasado: date
    __granjaOrigen: str

    def __init__(self, nombre:str, fV: date, nL: int, fE:date, gO:str):
        self.__nombre = nombre
        self.__fechaVencimiento = fV
        self.__nroLote = nL
        self.__fechaEnvasado = fE
        self.__granjaOrigen = gO

    def get_nombre(self) -> str:
        return self.__nombre
    def getFechaVencimiento(self) -> date:
        return self.__fechaVencimiento
    def getNumeroLote(self) -> int:
        return self.__nroLote
    def getFechaEnvasado(self) -> date:
        return self.__fechaEnvasado
    def getGranjaOrigen(self):
        return self.__granjaOrigen
    
    def setNombre(self, nuevoNombre: str):
        self.__nombre = nuevoNombre
    def setNombre(self, nuevoFV: date):
        self.__fechaVencimiento = nuevoFV
    def setNombre(self, nuevoNL: int):
        self.__nroLote = nuevoNL
    def setNombre(self, nuevoFE: date):
        self.__fechaEnvasado = nuevoFE
    def setNombre(self, nuevoGO: str):
        self.__granjaOrigen = nuevoGO
    
    def getEtiqueta(self) -> str:
        cadena = "| \t Producto: " + self.get_nombre + "\n"
        cadena += "| \t Fecha de vencimiento: " + str(self.getFechaVencimiento) + "\n"
        cadena += "| \t Numero de lote: " + str(self.getNumeroLote) + "\n"
        cadena += "| \t Fecha de envasado: " + str(self.getFechaEnvasado) + "\n"
        cadena += "| \t Granja de origen: " + self.getGranjaOrigen + "\n"
        return cadena