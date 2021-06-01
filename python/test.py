from mycd import mycd

with open("../test.txt") as f:
    inputline = ""
    total_tests = 0
    total_passed = 0

    for line in f:
        if line.startswith("# mycd ") and len(line.split()) >= 4:
            inputline = line.replace("\n", "")
        elif inputline != "":
            args = inputline.split()
            result = mycd(args[2], args[3])
            expected = line.replace("\n", "")
            passed = result == expected

            print(f"INPUT    : {inputline}")
            print(f"OUTPUT   : {result}")
            print(f"EXPECTED : {expected}")
            print(f"RESULT   : {'OK' if passed else 'INCORRECT'}")
            print()
            print()
            inputline = ""

            total_tests += 1
            if passed:
                total_passed += 1
    
    print(f"PASSED {total_passed}/{total_tests} TESTS")
