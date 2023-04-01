import cv2
import pytesseract
from PIL import Image
import re

import json


img_cv = cv2.imread(r'img.jpg')

# By default OpenCV stores images in BGR format and since pytesseract assumes RGB format,
# we need to convert from BGR to RGB format/mode:
img_rgb = cv2.cvtColor(img_cv, cv2.COLOR_BGR2RGB)
readData = pytesseract.image_to_string(img_cv)

carlories = fat = sodium = 0


lineData = readData.splitlines()
for line in lineData:
    if 'Calories' in line or 'Calories' in line:
        carlories = int(re.search(r'\d+', line).group())
        print(carlories)
    elif 'Fat' in line or 'Lipides' in line:
        fat = int(re.search(r'\d+', line).group())
        print(fat)
    elif 'Sodium' in line or 'Sodium' in line:
        sodium = int(re.search(r'\d+', line).group())
        print(sodium)

# print(readData)
# # OR
# # img_rgb = Image.frombytes('RGB', img_cv.shape[:2], img_cv, 'raw', 'BGR', 0, 0)
# # print(pytesseract.image_to_string(img_rgb))

# # some JSON:
# x = '{ "name":"John", "age":30, "city":"New York"}'

# # parse x:
# y = json.loads(x)

# # the result is a Python dictionary:
# print(y["age"])

# a Python object (dict):
x = {
    "Calories": carlories,
    "Fat": fat,
    "Sodium": sodium
}

jsonData = json.dumps(x)

with open('data.json', 'w+') as f:
    f.write(jsonData)
    f.close()
#     # convert into JSON:
# y = json.dumps(x)

# # the result is a JSON string:
# print(y)
