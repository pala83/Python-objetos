from django.db import models
from django.db.models.fields import DateTimeField

# Create your models here.

class Servicio(models.Model):
    titulo = models.CharField(max_length=50)    # texto
    contenido = models.CharField(max_length=50) # texto
    imagen = models.ImageField(upload_to='servicios') # imagen
    created = DateTimeField(auto_now_add=True)  # fecha
    updated = DateTimeField(auto_now_add=True)  # fecha

    class Meta:
        verbose_name='servicio'
        verbose_name_plural='servicios'
    
    def __str__(self):
        return self.titulo
        