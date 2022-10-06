from turtle import Turtle
import time

STARTING_POSITIONS = [(0,0), (-20, 0)]        
MOVE_DISTANCE = 20
UP = 90
LEFT = 180
DOWN = 270
RIGHT = 0

class Snake:
    def __init__(self):
        self.body = []         
        self.generate_snake()
        self.head = self.body[0]

    def generate_snake(self):
        for position in STARTING_POSITIONS:
            self.add_body_segment(position)
        
    def add_body_segment(self, position):
        snake_body_segment = Turtle("square")
        snake_body_segment.color("green")
        snake_body_segment.penup()
        snake_body_segment.goto(position)
        self.body.append(snake_body_segment)
    
    def extend(self):
        self.add_body_segment(self.body[-1].position())
    
    def move(self):
        for body_seg in range(len(self.body)-1, 0, -1):
            new_x = self.body[body_seg-1].xcor()
            new_y = self.body[body_seg-1].ycor()
            self.body[body_seg].goto(new_x, new_y)
        self.head.forward(20)
        
    def up(self):
        if self.head.heading() != DOWN:
            self.head.setheading(UP)    
    def left(self):
        if self.head.heading() != RIGHT:
            self.head.setheading(LEFT)
    def down(self):
        if self.head.heading() != UP:
            self.head.setheading(DOWN)
    def right(self):
        if self.head.heading() != LEFT:
            self.head.setheading(RIGHT)