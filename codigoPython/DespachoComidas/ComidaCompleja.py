from Comida import Comida
from ComidaSimple import ComidaSimple
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
        for comida in self.__comidas:
            retorno += comida.get_precio()
        return retorno

    def get_calorias(self):
        retorno = 0
        for i in self.__comidas:
            retorno += i.get_calorias()
        return retorno

    def get_preparacion(self):
        return "dfsdf"

    def __str__(self):
        cadena = super().__str__() + "\n"
        for i in self.__comidas:
            cadena += i.__str__()
        return cadena

nuevo = ComidaCompleja("alfajor", "chocolate", "industrial", True)
otro = ComidaCompleja("otro alfajor", "chocolate", "industrial", True)
nuevo.agregar_comida(otro)
nuevo.agregar_comida(otro)
elemento = nuevo.get_lista_comidas()[0]
elemento1 = nuevo.get_lista_comidas()[1]
#print(elemento.get_nombre())
#print(elemento1.get_nombre())
print(nuevo)
for a in nuevo.get_lista_comidas():
    print(a.get_nombre())
#Prueba get_precio
cs1 = ComidaSimple("pizza", "napolitana", "horno", True, 57, 25, 49)
cs2 = ComidaSimple("pizza", "anchoas", "parrilla", True, 48, 12, 98)
cc = ComidaCompleja("pizza compleja", "de carne", "frita", True)
cc.agregar_comida(cs1)
cc.agregar_comida(cs2)
#cadena = cc.get_nombre() + " tipo: " + cc.get_tipo() + "\n"
#cadena += "precio: " + str(cc.get_precio()) + " calorias: " + str(cc.get_calorias()) + "\n"
#print(cadena)
#print(cc)
#print(cs1)