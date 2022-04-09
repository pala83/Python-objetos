import keyboard as ky
import pyautogui as pg

while True:
    if ky.is_pressed("a"):
        pg.press("return")
        print("hola")
        break