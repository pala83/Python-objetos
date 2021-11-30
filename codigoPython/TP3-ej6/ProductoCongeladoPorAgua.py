from datetime import date
from ProductoConMasDatos import ProductoConMasDatos

class ProductoCongeladoPorAgua(ProductoConMasDatos):
    __gramosSalXLitro : int

    def __init__(self, nombre: str, fV: date, nL: int, fE: date, gO: str, org: str, tempM: int, gramSXL: int):
        super().__init__(nombre, fV, nL, fE, gO, org, tempM)
        self.__gramosSalXLitro = gramSXL
    
    def get_gramosSalXLitro(self) -> int:
        return self.__gramosSalXLitro

    def set_gramosSalXLitro(self, nuevoGSXL: int):
        self.__gramosSalXLitro = nuevoGSXL
    
    def getEtiqueta(self) -> str:
        cadena = "| \t % Gramos de sal por litro: " + str(self.get_gramosSalXLitro) + "\n"
        return super().getEtiqueta() + cadena