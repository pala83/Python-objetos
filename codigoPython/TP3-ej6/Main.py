import Producto
from datetime import date

def main():
    print("Comienza el main")
    dd = Producto.Producto("dsfsdf", date.today(), 10, date.today(), "sdfdf")
    print(dd.getEtiqueta())
    dd.setNombre("Pay")
    print(dd.getEtiqueta())


if __name__ == '__main__':
    main()
