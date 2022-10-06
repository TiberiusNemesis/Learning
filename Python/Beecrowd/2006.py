# Identifying Tea, beecrowd 2006

count = 0
tea_type = int(input())
contestant_answers = input().split(' ')
contestant_answers_list = list(map(int, contestant_answers))

for answer in contestant_answers_list:
    if answer == tea_type:
        count += 1
print(count)
