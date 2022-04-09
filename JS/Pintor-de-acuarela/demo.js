/*
* variables globales
*
* canvas : <canvas> DOM element, aca se pinta el dibujo
* body   : document body, then stroke Blue component in RGB
* ctx    : canvas 2D context
* data   : metadatos de la imagen a pintar (pintura.data)
* e      : (unused) parametro evento
* file   : FileReader de input
* green  : linea verde componente en RGB
* alto   : [global] altura de la imagen
* despX  : eje X + desplazamiento (brush ancho)
* despY  : eje Y + desplazamiento (brush alto)
* imagen : <img> DOM element usado para carga
* pintura: painting : canvas ImageData (ctx.getImageData)
* aux    : indice de arreglo para iteracion
* red    : stroke Red component in RGB
* source : [global] source ImageData de la imagen de entrada
* ancho  : [global] ancho de imagen
* ejeX   : stroke X
* ejeY   : stroke Y
* trazo  : camino del pincel (1+2*grosor), cambian la señal en cada linea
* grosor : ancho de la linea del dibujo
* nuevoTrazo      : valor para el punto actual al buscar un nuevo trazo
* R      : (deltaR) diferencia en R entre el canvas y la referencia
* tiempo : variable de tiempo global 1/30 source (frame count)
* V      : (bestValue) mejor valor temporal, cambia en cada bucle de trazo
* Y      : (bestY) trazo Y temporal, decide la direccion del trazo en cada bucle
*/

var body = document.getElementById("body");
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
input = document.createElement("input");
input.type = ("file");
body.insertBefore(input, canvas);
input.onchange = (e)=> {
    file = new FileReader;
    file.onload = (e)=> {
        imagen = document.createElement("img");
        imagen.src = file.result;
        imagen.onload = (e)=> {
            ctx.fillStyle = "#fff";
            ctx.fillRect(0,0, ancho, alto); // borro el dibujo anterior
            ejeX = ancho = imagen.width // establezca ejeX en el ancho de la imagen para forzar un recálculo del trazo en el primer fotograma
            alto = imagen.height;
            ctx.drawImage(imagen, 0, 0);
            source = ctx.getImageData(0, 0, ancho, alto).data;          
            ctx.fillStyle = "#fff";
            ctx.fillRect(0, 0, ancho, alto);
            pintura = ctx.getImageData(0,0,ancho,alto);
            data= pintura.data;
            ejeY=tiempo=0; 
            grosor = Math.floor(alto/80);       // grosor del pincel
            trazo = 3;	                        // paso de trazo (inicializado a ancho)
        }
    };
    file.readAsDataURL(input.files[0])
};

// Dibuja la imagen incorporada (campos de lavanda)
function primerImagen(){
    ejeX=ancho=alto=512; 
    ctx.fillStyle = "#433";
    ctx.fillRect(0,0,ancho,alto); // tierra
    ctx.fillStyle = "#fff";
    ctx.fillRect(0,0,ancho,256);    // cielo (todo blanco)
    for (j=0; j<256; j+=.02) 
        for (i=-10;i<10; ++i) {
            trazo = 6*Math.random();
            ctx.fillStyle = "#7cd";
            ctx.fillRect(i*3*j+256+j*trazo,256-j,30,.1);        // parte azul del cielo
            ctx.fillStyle = `hsl(289,80%,${30+j/4+20*Math.cos(trazo+2)}%`;
            ctx.fillRect(i*3*j+256+j*Math.cos(trazo), 3*j+256+j*Math.sin(trazo), 4, 5); // flores de lavanda
            ctx.fillStyle = `hsl(80,65%,${30+10*Math.random()}%)`; 
            ctx.fillRect(2+i*3*j+256+j*Math.cos(trazo), 3*j+256+j*Math.sin(trazo)+5, 1, j/5); // tallos de las flores
        }
}
primerImagen();
// finaliza el dibujo inicial

// Inicialización de trazo de pincel: mismo código que en el controlador de eventos de carga
source = ctx.getImageData(0, 0, ancho, alto).data;         
ctx.fillStyle = "#fff";
ctx.fillRect(0, 0, 2560, 2560); // prácticamente en pantalla completa, usando números como parte del esquema de empaque
pintura = ctx.getImageData(0,0,ancho,alto);
data= pintura.data;
ejeY=tiempo=0;
grosor = Math.floor(alto/80); // grosor del pincel
trazo = 3;                // paso de trazo (inicializado en altura positiva)

setInterval(e=> {
    // número de pinceladas por fotograma igual al ancho de la imagen
    // para obtener un tiempo de dibujo constante sin importar el tamaño de la imagen
    for (t=0; t<ancho; ++t) {
        if (ejeY<0||ejeX>=ancho||ejeX<0) {
            // busco la siguiente linea
            V = 0;
            for (v=0;v<alto; v+=20) 
                for (u=0;u<ancho; u+=20) {
                    despX = Math.floor(u+20*Math.random())%ancho;
                    j = Math.floor(t+v+20*Math.random())%alto;  // t para obtener una línea diferente en las imágenes en escala de grises
                    aux = despX*4+ancho*4*j;
                    red = data[aux]-source[aux]; ++aux;
                    green = data[aux]-source[aux]; ++aux;
                    body = data[aux]-source[aux]; ++aux;
                    nuevoTrazo = Math.max(red,green,body)/Math.min(red,green,body)      // valor dependiente de la saturacion
                        +(tiempo>600?Math.max(red,green,body)/25:0);       // despues de 20s, agrego el componente de la luminosidad
                        
                    if (red>0 && green>0 && body>0 && nuevoTrazo>V) {		   // mantengo el trazo solo si
                        ejeX = despX;                                 // el píxel no es más oscuro que el original
                        ejeY = j;                                 // y se mejora el valor (delta de saturación)
                        V = nuevoTrazo;
                    }
                }
            aux = ejeX*4+ancho*4*ejeY;
            red = data[aux]-source[aux]; ++aux;
            green = data[aux]-source[aux]; ++aux;
            body = data[aux]-source[aux]; ++aux;
            trazo = -trazo;                                      // invertir la dirección del pincel en cada trazo
        } // if (ejeY<0||ejeX>=ancho||ejeX<0) ... busco la siguiente linea
            
            
        // aplico el trazo del pincel
        // ancho constante => optimizo 8 bits con el Repack
        for (j=Math.max(0, ejeY-grosor+1); j<ejeY+grosor; ++j) {
            canvas = .7*Math.sqrt(1-(j-ejeY)*(j-ejeY)/grosor/grosor)/255;
            aux = ejeX*4+ancho*4*j;
            
            data[aux]-=Math.floor(canvas*data[aux]*red); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*green); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*body); ++aux;
            ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*red); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*green); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*body); ++aux;
            ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*red); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*green); ++aux;
            data[aux]-=Math.floor(canvas*data[aux]*body); ++aux;
            ++aux;
        }
        ejeX+=trazo;

        // oriento el trazo de pincel desplazando Y un píxel hacia arriba o hacia abajo
        // hacia el píxel que tiene la mayor diferencia entre la referencia y el lienzo
        Y = V = -2;	// valor del mejor match
        for (j=Math.max(0, ejeY-1);j<ejeY+2;++j) {
            canvas = .7*Math.sqrt(1-(j-ejeY)*(j-ejeY)/grosor/grosor)/255; // alpha de la pintura, 0=translucido, 1=opaco
            aux = ejeX*4+ancho*4*j;
            R = data[aux]-Math.floor(canvas*data[aux]*red) - source[aux]; ++aux;
            G = data[aux]-Math.floor(canvas*data[aux]*green) - source[aux]; ++aux;
            B = data[aux]-Math.floor(canvas*data[aux]*body) - source[aux]; ++aux;
            if (R>0 && G>0 && B>0 && R+G+B>V) {
                V = R+G+B;
                Y = j;
            }
        }
        ejeY = Y; // -2 si no se encuentra un píxel adecuado = detener el trazo actual
        
    }	// for (t ... bucle de trazo
    // blit en pantalla por cada frame => 30 fps
    ctx.putImageData(pintura, 0, 0);
    ++tiempo;
}, 33)

// END