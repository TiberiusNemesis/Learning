from threading import Thread
from turtle import Turtle
import time

SCOREBOARD_POSITION = (0, 220)
FONT = ("Courier", 24, "normal")

class Scoreboard(Turtle):
    def __init__(self):
        super().__init__()
        self.score = 0
        self.high_score = 0
        self.penup()
        self.color("white")
        self.hideturtle()
        self.goto(SCOREBOARD_POSITION)
        self.update_score()
        
    def update_score(self):
        self.write(f"Score: {self.score}", align="center", font = FONT)

    def increase_score(self):
        self.score += 1
        self.clear()
        self.update_score()
    
    def reset(self):
        self.clear()
        if self.score > self.high_score:
            self.high_score = self.score
        self.score = 0
        self.goto(SCOREBOARD_POSITION)
        self.update_score()
    
    def end_game(self):
        self.clear()
        self.goto(0,30)
        self.write(" Oh no!\nYou lost!", align="center", font = FONT)
        self.goto(0, -30)
        self.write(f"Final score: {self.score}", align="center", font=FONT)
        self.goto(0, -60)
        self.write("Try again? y/n", align="center", font = FONT)
        self.goto(0, -80)
        Thread(target = self.countdown()).start()
            
    def countdown(self):
        time.sleep(2)
        self.clear()
        for i in range (5, 0, -1):
            self.write(f"Exiting in {i}.", align="center", font = FONT)
            time.sleep(1)
            self.clear()
        