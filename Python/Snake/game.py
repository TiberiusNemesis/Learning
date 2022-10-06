from turtle import Screen
from food import Food
from scoreboard import Scoreboard
from snake import Snake
import time

class Game:
    def __init__(self, screen):
        self.playing = True
        self.screen = screen
        self.generate_assets()
        self.scoreboard = Scoreboard()
        self.play_game()

    def reset_game(self):
        del(self.snake)
        del(self.food)
        self.play_game()

    def generate_assets(self):
        self.food = Food()
        self.snake = Snake()
        
    def play_game(self):
        self.screen.listen()
        self.screen.onkeypress(self.snake.up, "Up")
        self.screen.onkeypress(self.snake.down, "Down")
        self.screen.onkeypress(self.snake.left, "Left")
        self.screen.onkeypress(self.snake.right, "Right")
        while self.playing:
            self.screen.update()
            time.sleep(0.09)
            self.snake.move()
            if (self.snake.head.distance(self.food) < 16):
                self.food.refresh()
                self.scoreboard.increase_score()
                self.snake.extend()
            if (self.snake.head.xcor() < -290 or self.snake.head.xcor() > 290 or self.snake.head.ycor() > 290 or self.snake.head.ycor() < -290):
                self.scoreboard.end_game()
                self.screen.listen()
                self.screen.onkeypress(self.reset_game, "Y")
                self.screen.onkeypress(self.reset_game, "y")
                time.sleep(5)
            
            for segment in self.snake.body:
                if segment == self.snake.head:
                    pass
                elif self.snake.head.distance(segment) < 10:
                    self.scoreboard.end_game()
                    self.screen.onkeypress(self.reset_game, "Y")
                    self.screen.onkeypress(self.reset_game, "y")
                    time.sleep(5)
    
                
