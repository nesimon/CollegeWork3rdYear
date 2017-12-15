from github import Github, BadCredentialsException

loggedIn = False
while not loggedIn:
    try:
        # Input your own user name and password to display info
        username = input("Github username: ")
        password = input("Github password: ")
        g = Github(username, password)
        # Or input your github access code to display info
        # g = Github("Github Access Code")
        user = g.get_user(login = username)
        loggedIn = True
    except BadCredentialsException:
        print("Incorrect username or password!")

for repo in user.get_repos():
    print("Repository Name = [" + repo.name + "]")
    print("Main language used = [" + repo.language + "] \n")
    for commits in repo.get_commits():
        print("The commit " + commits.sha + " was created at [" + str(commits.commit.author.date) + "]")
    print("\n")