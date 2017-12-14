from github import Github

# Input your own user name and password to displa info
#g = Github("user", "password")
g = Github("92cc88158b67be82b0dd4dabd1bf7b6ec4dce0bd")

user = g.get_user()

for repo in user.get_repos():
    print(repo.name)
    for repo in repo.get_commit("master"):
        print(repo.name)
