import random as r

class Quiz:
    
    def __init__(self, question_list):
        self.questions = question_list
        self.question_count = len(question_list)
        self.score = 0
        self.chances = 2
    
    def start(self):
        print("Welcome to the Quiz Brain!")
        random_num = r.randint(0, len(self.questions) - 1)
        first_question = self.questions[random_num]
        print(f"For our first trivia question of the night: \n{first_question.text}")
        user_answer = self.get_user_answer()
        self.check_answer(first_question, user_answer)
        self.questions.pop(random_num)
        
        while len(self.questions) > 0:
            self.next_question()
        
        self.win_game()

    def next_question(self):
        random_num = r.randint(0, len(self.questions) - 1)
        current_question = self.questions[random_num]
        print(f"And for our next question: \n{current_question.text}")
        user_answer = self.get_user_answer()
        self.check_answer(current_question, user_answer)
        self.questions.pop(random_num)

    def get_user_answer(self):
        ans = input("Press T for True, F for false: ")
        if (ans.strip().lower() == "t"):
            return "True"
        elif (ans.strip().lower() == "f"):
            return "False"
        else:
            print("\nInvalid answer. Try again!")
            return self.get_user_answer()

    def check_answer(self, question, answer):
        if (question.answer == answer):
            print("Correct! 1 point to Gryffindor.")
            self.score += 1
        else: 
            print(f"Wrong! The correct answer was: {question.answer}")
            self.print_remaining_chances()
    
    def print_remaining_chances(self):
        match self.chances:
            case 2:
                print("Two chances left.")
                self.chances -= 1
            case 1:
                print("One chance left.")
                self.chances -= 1
            case 0:
                print("Last chance!")
                self.chances -= 1
            case _:
                print("You lose! Game over.")
                self.end_game()
    
    def end_game(self):
        print("Shutting down.")
        exit(0)
    
    def win_game(self):
        print(f"Congratulations! You got {self.score} questions correct out of {self.question_count}.")
        print("YOU WIN!\n\n\n\n")
        self.end_game()
        