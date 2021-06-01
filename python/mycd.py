import re

def mycd(fromdir, todir):
    path = fromdir
    if todir[0] == "/":
            path = todir
    else:
        for d in todir.split("/"):
            if d in [".", ""]:
                pass
            elif d == "..":
                temp = path.split("/")
                temp.pop()
                path = "/".join(temp)
            elif d.isalnum():
                path += "/"+d
            else:
                return f"{todir}: No such file or directory"
    return tidy_path(path)

def tidy_path(path):
    path = re.sub("\/+", "/", path)
    return ("" if path.startswith("/") else "/") + path