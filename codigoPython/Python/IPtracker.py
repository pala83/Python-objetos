#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
import urllib
try:
    import pygeoip as GeoIP
except ImportError:
    print(" ERROR: No PYTHON-GEOIP avaliable!!!. ") # que hacer si falla la importacion de la libreria
    pass

# La base de datos GeoLiteCity.dat debe estar en la misma ubicacion que este programa
gi = GeoIP.open(
"GeoLiteCity.dat", GeoIP.GEOIP_INDEX_CACHE | GeoIP.GEOIP_CHECK_CACHE)

# Obtiene la IP Publica
try:
    # esta URL puede ser reemplazada con otra que preste similar servicio
    ip = urllib.urlopen(
    'http://www.whatismyip.com/automation/n09230945.asp').read()
    print(ip)
except: # que hacer si falla la conectividad
    print ("ERROR: Network error!!!. ")
    pass

# Obtiene los datos de la DataBase usando la IP Publica
data = gi.record_by_name(ip)

# Imprime los datos en la linea de comandos
print(data)