import os
RootDir = "C:\\Users\\admin\\Desktop\\zhiyinKotlinCopy"
def change_name(sourceDir):
    for f in os.listdir(sourceDir):
        sourceF = os.path.join(sourceDir, f)
        if os.path.isfile(sourceF):
            do_change_name(sourceF)
        print (sourceF)
        if os.path.isdir(sourceF):
            change_name(sourceF)

def do_change_name(src_file):
    portion = os.path.splitext(src_file)
    if portion[1] ==".py0":
        new_name = portion[0]+".java"
    elif portion[1] ==".py1":
        new_name = portion[0]+".c"
    elif portion[1] ==".py2":
        new_name = portion[0]+".cpp"
    elif portion[1] ==".py3":
        new_name = portion[0]+".so"
    elif portion[1] ==".py4":
        new_name = portion[0]+".h"
    elif portion[1] == ".py5":
        new_name = portion[0] + ".DOCX"
    elif portion[1] == ".py6":
        new_name = portion[0] + ".kt"
    else:
        new_name = src_file
    os.rename(src_file, new_name)

if __name__ == "__main__":
    change_name(RootDir)