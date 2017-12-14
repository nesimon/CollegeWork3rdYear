from github import Github
import csv
from itertools import zip_longest

# Input your own user name and password to display info
g = Github("username", "password-")
# Or input your github access code to display info
#g = Github("Github Access Code")

# This code gets the top 10 developers in the React repo of facebook and converts it to a csv file.
user = g.get_user(login= "facebook")

list = []


for repo in user.get_repos():
        list.append(repo.language)


dicta = {c: 0 for c in list}
for items in list:
    dicta[items] += 1
totalno = sum([dicta[x] for x in dicta])
print(totalno)
for x in dicta:
    if x == "Jupyter Notebook":
        dicta["Jupyter"] = dicta["Jupyter Notebook"]
        del dicta["Jupyter Notebook"]
    if x is None:
        dicta["None"] = dicta[None]
        del dicta[None]
print(dicta)
d = [[x for x in dicta], [dicta[x]/totalno for x in dicta]]
print(d)
export_data = zip_longest(*d, fillvalue = '')
with open('Data2.csv', 'w', newline='') as myfile:
      wr = csv.writer(myfile)
      wr.writerow(("Language", "Frequency"))
      wr.writerows(export_data)
myfile.close()
