from github import Github
import csv
from itertools import zip_longest

# Or input your github access code to display info
g = Github("873ce35699f41cdb3bd2bfe2145ac1697e99bfe0")
user = g.get_user(login= "facebook")

list1 = []
list2 = []

repo = user.get_repo("react")
for contributors in repo.get_stats_contributors():
      list1.append(contributors.author.login)
      list2.append(contributors.total)

d = [list1, list2]
export_data = zip_longest(*d, fillvalue = '')
with open('Data.csv', 'w', encoding="ISO-8859-1", newline='') as myfile:
      wr = csv.writer(myfile)
      wr.writerow(("Developer", "Commits"))
      wr.writerows(export_data)
myfile.close()