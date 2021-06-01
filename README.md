# mycd
This is my response to the coding assignment for my application as a Software Engineer Intern at SS8, Inc.

## Instructions for running
You can edit `text.txt` to add/remove test input and their expected outputs.

### Python
Run test
> python test.py

Run simulation (type exit to exit)
> python simulate.py

### Java
Run test
> javac Test.java && java Test

Run simulation 
> javac Simulate.java && java Simulate


## The Assignment
Write a program simulating a "cd" Unix command that changes a current
directory in an abstract file system. The simulated command takes two path
strings from the command line and prints either a new path or an error message.

The first path is a current directory. The second path is a new directory. To
make it simple let's assume that a directory name can only contain
alphanumeric characters. A single dot (".") indicates a current directory, and
the two consecutive dots ("..") indicate a step to a previous directory, up
from the current one. A single forward slash "/" indicates a root directory.
Multiple consecutive slashes are treated as equivalent to a single one.

The program needs to check that the second argument is a valid path without
relying on any OS system call or shell command such as chdir() for verification.
It then constructs a new path, and prints it out. You can also check the first
argument for validity, but it is not required.

Write one version of this program using C++ or Java and another using Python
(I'd like to see how creative you can get with each language). Automated unit
tests are a plus.

Please, make the simulator code buildable and runnable from a command line without
requiring IDE.


Examples ('#' is a shell prompt in Unix):
```shell
# mycd / abc
/abc

# mycd /abc/def ghi
/abc/def/ghi

# mycd /abc/def ..
/abc

# mycd /abc/def /abc
/abc

# mycd /abc/def /abc/klm
/abc/klm

# mycd /abc/def ../..
/

# mycd /abc/def ../../..
/

# mycd /abc/def .
/abc/def

# mycd /abc/def ..klm
..klm: No such file or directory

# mycd /abc/def //////
/

# mycd /abc/def ......
......: No such file or directory

# mycd /abc/def ../gh///../klm/.
/abc/klm
```