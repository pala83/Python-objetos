import turtle

t = turtle.Turtle()
s = turtle.Screen()
s.bgcolor('black')

list1 =["purple", "red", "orange", "blue", "green"]
for i in range (200):
    t.color(list1[i%5])
    t.pensize(i/10+1)
    t.forward(i)
    t.left(59)