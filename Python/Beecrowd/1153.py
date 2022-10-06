# Simple factorial, beecrowd 1153

n = int(input("Enter the number to be factorialized: \n"))
sum = 1
for i in range(1, n):
    sum += sum*(n-i)

print("The number {}! is equal to {}".format(n, sum))
