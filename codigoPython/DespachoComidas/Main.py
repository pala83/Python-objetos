from CodigoPython.DespachoComidas import ComidaSimple


def main():
    print("Comienza el main")
    nuevo = ComidaSimple.ComidaSimple("sdf", "sdfsd", "", True, "cc", "precio", "")
    print(nuevo.get_precio())


if __name__ == '__main__':
    main()
