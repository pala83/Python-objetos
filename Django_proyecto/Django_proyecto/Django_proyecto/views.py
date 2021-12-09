from django.http import HttpResponse
import datetime
from django.template import Template, Context

def saludo(request):

    nombre= "juan"

    temasDelCurso=["One","Two","Three","Four","Five"]

    doc_externo=open("E:/Git/Python-objetos/Django_proyecto/Django_proyecto/Django_proyecto/template/miplantilla.html")

    plt=Template(doc_externo.read())

    doc_externo.close()

    ctx=Context({"nombre_persona":nombre, "temas":temasDelCurso})

    documento=plt.render(ctx)

    return HttpResponse(documento)

def despedida(request):

    return HttpResponse("Hasta luego")

def dame_fecha(request):
    fecha_actual=datetime.datetime.now()

    documento = """
                <html>
                <body>
                <h2>
                        fecha y hora actuales %s
                </h2>
                </body>
                </html>
                """ % fecha_actual

    return HttpResponse(documento)

