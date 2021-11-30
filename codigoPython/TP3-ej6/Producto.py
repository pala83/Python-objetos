from datetime import date

""" Clase Producto en Python"""

class Producto():

    __nombre: str                             # Atributos privados 
    __fechaVencimiento: date
    __nroLote: int
    __fechaEnvasado: date
    __granjaOrigen: str

    def __init__(self, nombre:str, fv:date,  nL: int, fe:date, gO:str):        # Constructor
        self.__nombre = nombre
        self.__fechaVencimiento = fv
        self.__nroLote = nL
        self.__fechaEnvasado = fe
        self.__granjaOrigen = gO

    # Getters    
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
    
    # Setters
    def setNombre(self, nuevoNombre: str):
        self.__nombre = nuevoNombre
    
    def setFechaVencimiento(self, nuevoFV: date):
        self.__fechaVencimiento = nuevoFV
    
    def setNumeroLote(self, nuevoNL: int):
        self.__nroLote = nuevoNL
    
    def setFechaEnvasado(self, nuevoFE: date):
        self.__fechaEnvasado = nuevoFE
    
    def setGranjaOrigen(self, nuevoGO: str):
        self.__granjaOrigen = nuevoGO
    

    def getEtiqueta(self) -> str:
        cadena = "| \t Producto: " + self.get_nombre() + "\n"
        cadena += "| \t FechaVencimiento: " + str(self.__fechaVencimiento) + "\n"
        cadena += "| \t Numero de lote: " + str(self.getNumeroLote()) + "\n"
        cadena += "| \t FechaEnvasado: " + str(self.getFechaEnvasado()) + "\n"
        cadena += "| \t Granja de origen: " + self.getGranjaOrigen() + "\n"
        return cadena
