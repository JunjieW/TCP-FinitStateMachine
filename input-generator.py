from random import randint

f = open('input.txt', 'w')
# token = []
tokens = ["PASSIVE", "ACTIVE", "SYN", "SYNACK", "ACK", "RDATA", "SDATA", "FIN", "CLOSE", "TIMEOUT"]

for i in range(100):
    s = tokens[randint(0, len(tokens)-1)]
    print s
    f.write(s + "\n")

f.close()
