from mycd import mycd

line = ""
while line != "exit":
    line = input("# ")
    args = line.split()

    if len(args) < 3 or args[0] != "mycd":
        continue

    print(mycd(args[1], args[2]))
    print()