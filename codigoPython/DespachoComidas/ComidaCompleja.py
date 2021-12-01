from Comida import Comida
from typing import List

class ComidaCompleja(Comida):
    __comidas: List[Comida]

    def __init__(self, nombre, tipo, modoPrepcion, aceptar):
        super().__init__(nombre, tipo, modoPrepcion, aceptar)
        self.__comidas = []

    def agregar_comida(self, nuevaComida):
        self.__comidas.append(nuevaComida)

    def get_lista_comidas(self) -> List[Comida]:
        return self.__comidas.copy()

    def get_precio(self):
        retorno = 0
        for i in self.__comidas:
            retorno += i.get_precio()
        return retorno

    def get_calorias(self):
        retorno = 0
        for i in self.__comidas:
            retorno += i.get_calorias()
        return retorno

    def get_preparacion(self):
        return "dfsdf"









nuevo = ComidaCompleja("alfajor", "chocolate", "industrial", True)
otro = ComidaCompleja("otro alfajor", "chocolate", "industrial", True)
nuevo.agregar_comida(otro)
nuevo.agregar_comida(otro)
elemento = nuevo.get_lista_comidas()[0]
elemento1 = nuevo.get_lista_comidas()[1]
print(elemento.get_nombre())
print(elemento1.get_nombre())
print(nuevo)
for a in nuevo.get_lista_comidas():
    print(a.get_nombre())
