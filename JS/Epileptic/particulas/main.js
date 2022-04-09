const canvas = document.getElementById("c");
const ctx = canvas.getContext("2d");
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
let numeroDeParticulas = 800;
const arregloDeParticulas = [];
let matriz = 0;

class Particula{
    constructor(){
        this.x = Math.random() * canvas.width;
        this.y = Math.random() * canvas.height;
        this.radio = (Math.random()*10) +2;
        this.velocidadX = (Math.random()*3) -1.5;
        this.velocidadY = (Math.random()*3) -1.5;
    }
    dibujo(){
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radio, 0, Math.PI*2);
        ctx.fillStyle = 'hsl('+matriz+',100%,50%)';
        ctx.fill();
        ctx.strokeStyle = 'hsl('+matriz+6+',100%,50%)';
        ctx.stroke();
    }
    actualizar(){
        this.x += this.velocidadX;
        this.y += this.velocidadY;
        if(this.x + this.radio > canvas.width ||
           this.x - this.radio < 0){
           this.velocidadX = -this.velocidadX;
        }
        if(this.y + this.radio > canvas.height ||
           this.y + this.radio < 0){
           this.velocidadY = -this.velocidadY;
        }
        this.dibujo();
    }
}
function init(){
    for(let i=0; i<numeroDeParticulas; i++){
        arregloDeParticulas.push(new Particula());
    }
}
function animar(){
    //ctx.clearRect(0,0,canvas.width,canvas.height);
    ctx.fillStyle = "rgba(255,255,255,0.01)"
    ctx.fillRect(0,0,canvas.width,canvas.height);
    for(let i = 0; i<arregloDeParticulas.length; i++){
        arregloDeParticulas[i].actualizar();
    }
    matriz+=1;
    requestAnimationFrame(animar);
}
init();
animar();