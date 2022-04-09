import turtle
import colorsys

t = turtle.Turtle()
s = turtle.Screen()
s.bgcolor('black')

t.speed(0)
n = 150
h = 0
for i in range(1000):
    c = colorsys.hsv_to_rgb(h, 1, 0.8)
    h+=1/n
    t.color(c)
    t.forward(i)
    t.right(98)


