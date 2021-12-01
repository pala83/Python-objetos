from CodigoPython.DespachoComidas import ComidaSimple


def main():
    print("Comienza el main")
    nuevo = ComidaSimple.ComidaSimple("Milanesas", "Almuerzo", "Agil", True, 1777, 55.60, None)
    print(nuevo.get_nombre())
    print(nuevo.get_tipo())
    print(nuevo.get_modopreparacion())
    print(nuevo.se_acepto())
    print(nuevo.get_calorias())
    print(nuevo.get_precio())
    print(nuevo.get_preparacion())


if __name__ == '__main__':
    main()
