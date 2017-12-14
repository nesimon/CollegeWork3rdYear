from github import Github
import csv
from itertools import zip_longest

# Input your own user name and password to display info
g = Github("username", "Password")
# Or input your github access code to display info
#g = Github("Github Access Code")

# This code gets the top 10 developers in the React repo of facebook and converts it to a csv file.
user = g.get_user(login= "facebook")

list1 = []
list2 = []

repo = user.get_repo("react")
line = 0
for contributors in repo.get_stats_contributors():
    if line >= 91:
        list1.append(contributors.author.login)
        list2.append(contributors.total)
    line +=1
d = [list1, list2]
export_data = zip_longest(*d, fillvalue = '')
with open('Data.csv', 'w', newline='') as myfile:
      wr = csv.writer(myfile)
      wr.writerow(("Developer", "Commits"))
      wr.writerows(export_data)
myfile.close()