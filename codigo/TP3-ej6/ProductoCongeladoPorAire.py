from datetime import date
from ProductoConMasDatos import ProductoConMasDatos

class ProductoCongeladoPorAire(ProductoConMasDatos):
    __porcNitrogeno: int
    __porcOxigeno: int
    __porcDioxCarb: int
    __porcVapAgua: int

    def __init__(self, nombre: str, fV: date, nL: int, fE: date, gO: str, org: str, tempM: int, pN: int, pO: int, pDC: int, pVA: int):
        super().__init__(nombre, fV, nL, fE, gO, org, tempM)
        self.__porcNitrogeno = pN
        self.__porcOxigeno = pO
        self.__porcDioxCarb = pDC
        self.__porcVapAgua = pVA

    def get_porcNitrogeno(self) -> int:
        return self.__porcNitrogeno
    def get_porcOxigeno(self) -> int:
        return self.__porcOxigeno
    def get_porcDioxCarb(self) -> int:
        return self.__porcDioxCarb
    def get_porcVapAgua(self) -> int:
        return self.__porcVapAgua

    def set_porcNitrogeno(self, nuevoPN: int):
        self.__porcNitrogeno = nuevoPN
    def set_porcOxigeno(self, nuevoPO: int):
        self.__porcOxigeno = nuevoPO
    def set_porcDioxCarb(self, nuevoPDC: int):
        self.__porcDioxCarb = nuevoPDC
    def set_porcVapAgua(self, nuevoPVA: int):
        self.__porcVapAgua = nuevoPVA

    def getEtiqueta(self) -> str:
        cadena = "| \t % Nitrogeno: " + str(self.get_porcNitrogeno) + "\n"
        cadena += "| \t % Oxigeno: " + str(self.get_porcOxigeno) + "\n"
        cadena += "| \t % Dioxido de carbono: " + str(self.get_porcDioxCarb) + "\n"
        cadena += "| \t % Vapor de agua: " + str(self.get_porcVapAgua) + "\n"
        return super().getEtiqueta() + cadena