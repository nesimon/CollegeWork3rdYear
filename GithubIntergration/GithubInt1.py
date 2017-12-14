from github import Github

# Input your own user name and password to display info
g = Github("user", "password")
# Or input your github access code to display info
#g = Github("Github Access Code")

user = g.get_user()

for repo in user.get_repos():
    print("Repository Name = [" + repo.name + "]")
    print("Main language used = [" + repo.language + "] \n")
    for commits in repo.get_commits():
        print("The commit " + commits.sha + " was created at [" + str(commits.commit.author.date) + "]")
    print("\n")