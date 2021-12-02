from django.http import HttpResponse

def saludo(request):

    return HttpResponse("Mi primera Vista")

def despedida(request):

    return HttpResponse("Hasta luego")