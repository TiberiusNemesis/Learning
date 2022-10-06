from turtle import Screen

def generate_window():
        screen = Screen()
        screen.setup(width=600, height=600)
        screen.bgcolor("black")
        screen.title("TIBERIAN SNAKE")
        screen.tracer(0)
        return screen