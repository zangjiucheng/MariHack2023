from sys import argv, exit
from cv2 import imread, cvtColor, COLOR_BGR2RGB
import pytesseract
from re import search
from json import dumps
from os import system


def get_argus():
    import getopt
    imageDir = ''

    try:
        opts, arg = getopt.getopt(argv[1:], "i:", ["image="])
    except getopt.GetoptError:
        print('Error: orc.py -i <img_dir>')
        print('   or: orc.py --image=<img_dir>')
        exit(-1)
    for opt, arg in opts:
        if opt in ("-i", "--image"):
            imageDir = arg
    if imageDir == '':
        print('Error: orc.py -i <img_dir>')
        print('   or: orc.py --image=<img_dir>')
        exit(-1)
    return imageDir


def tranform_image(imageDir):
    if imageDir.endswith('.heic') or imageDir.endswith('.HEIC'):
        system('magick ' + imageDir + ' img.jpg')
    else:
        raise Exception('Image format not supported')


def readImage():
    img_cv = imread(r'img.jpg')
    # img_cv = cvtColor(img_cv, COLOR_BGR2RGB)
    readData = pytesseract.image_to_string(img_cv, lang='eng')

    calories = fat = sodium = sugars = Protein = -1

    lineData = readData.splitlines()
    for line in lineData:
        if 'Calories' in line or 'Calories' in line:
            try:
                calories = int(search(r'\d+', line).group())
                if (calories < 9):
                    calories = -1
            except:
                pass

        elif 'Fat' in line or 'Lipides' in line:
            try:
                fat = int(search(r'\d+', line).group())
            except:
                pass

        elif 'Sodium' in line or 'Sodium' in line:
            try:
                sodium = int(search(r'\d+', line).group())
                if (sodium < 5):
                    sodium = -1
            except:
                pass

        elif 'Sugars' in line or 'Sucres' in line:
            try:
                sugars = int(search(r'\d+', line).group())
            except:
                pass
        elif 'Protein' in line or 'Proteines' in line:
            try:
                Protein = int(search(r'\d+', line).group())
            except:
                pass

    dictFood = {
        "Calories": calories,
        "Fat": fat,
        "Sodium": sodium,
        "Sugars": sugars,
        "Protein": Protein
    }
    return dictFood


def writeJson():
    jsonData = dumps(readImage())

    with open('data.json', 'w+') as f:
        f.write(jsonData)
        f.close()


if __name__ == '__main__':
    imageDir = get_argus()
    tranform_image(imageDir)
    writeJson()
