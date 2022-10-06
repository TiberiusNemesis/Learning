from data import question_data
from question_model import Question
from quiz_brain import Quiz

question_list = []

for question in question_data:
    q_text = question["text"]
    q_ans = question["answer"]
    new_question = Question(q_text, q_ans)
    question_list.append(new_question)

quiz_game = Quiz(question_list)
quiz_game.start()