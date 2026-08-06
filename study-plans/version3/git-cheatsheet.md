# Git Quick Reference — Clone, Branches & Commands

---

## 1. Clone a Repository

### Basic clone (most common)

```bash
pwd                              # see where you are
cd /c/Users/kenneth/Projects     # go where you want the repo
git clone https://github.com/username/repo-name.git
cd repo-name
ls
```

Creates a folder `repo-name` with all files and history. **No `git init` needed.**

### Clone into a folder you already made

```bash
mkdir my-project
cd my-project
git clone https://github.com/username/repo-name.git .
```

The `.` means "clone into this folder." Folder must be **empty**. Still **no `git init`**.

### Clone a specific branch directly

```bash
git clone -b hello https://github.com/username/repo-name.git
```

Lands you on branch `hello` immediately. Branch names are **case-sensitive** (`hello` ≠ `Hello`).

---

## 2. Know Where You Are

| Command | What it does |
|---------|--------------|
| `pwd` | Show current folder |
| `ls` | List files |
| `ls -la` | List all files including hidden (`.git`) |
| `cd folder` | Go into a folder |
| `cd ..` | Go up one level |
| `cd ~` | Go to home folder |

**Important:** Git commands only work **inside the repo folder** (where `.git` exists).

```
Wrong:  ~/skyscraper          (parent folder, not a repo)
Right:  ~/skyscraper/Skycrapers   (actual repo)
```

Error if you're in the wrong place: `fatal: not a git repository`

---

## 3. Branches

### See branches

```bash
git branch           # local branches (* = current)
git branch -a        # local + remote branches
git status           # shows current branch at top
```

### Switch to an existing branch (already on GitHub)

```bash
git checkout hello
# or
git switch hello
```

### Create a NEW branch and switch to it

```bash
git checkout -b my-new-branch
# or
git switch -c my-new-branch
```

### Push a branch to GitHub

```bash
git push -u origin hello
```

---

## 4. Daily Workflow

```bash
cd /path/to/repo              # 1. go into repo
git status                    # 2. see branch + changes
git pull                      # 3. get latest from GitHub
# ... edit files ...
git add filename              # 4. stage specific file (safer)
git commit -m "Your message"  # 5. save locally
git push                      # 6. send to GitHub
```

---

## 5. Git Command List

### Setup & Clone

| Command | What it does |
|---------|--------------|
| `git --version` | Check Git is installed |
| `git clone <url>` | Copy repo from GitHub |
| `git clone -b <branch> <url>` | Clone and checkout specific branch |
| `git init` | Create new empty repo (don't use with clone) |

### Navigation & Status

| Command | What it does |
|---------|--------------|
| `pwd` | Show current folder |
| `git status` | Branch, modified/staged/untracked files |
| `git log` | Commit history |
| `git log --oneline` | Short commit history |
| `git diff` | See unstaged changes |
| `git diff --staged` | See staged changes |

### Branches

| Command | What it does |
|---------|--------------|
| `git branch` | List local branches |
| `git branch -a` | List all branches (local + remote) |
| `git checkout <branch>` | Switch to existing branch |
| `git checkout -b <branch>` | Create new branch and switch |
| `git switch <branch>` | Switch branch (newer syntax) |
| `git switch -c <branch>` | Create + switch (newer syntax) |
| `git branch -d <branch>` | Delete local branch |

### Save Changes

| Command | What it does |
|---------|--------------|
| `git add <file>` | Stage one file |
| `git add .` | Stage everything (use carefully!) |
| `git reset` | Unstage all files |
| `git commit -m "msg"` | Commit staged changes |
| `git restore <file>` | Discard unstaged changes to file |

### Remote (GitHub)

| Command | What it does |
|---------|--------------|
| `git pull` | Download + merge latest from GitHub |
| `git push` | Upload commits to GitHub |
| `git push -u origin <branch>` | Push new branch and set tracking |
| `git fetch` | Download remote info without merging |
| `git remote -v` | Show remote URLs |

---

## 6. File Status Meanings

| Status | Meaning |
|--------|---------|
| **modified** | Existing file changed |
| **untracked** | New file Git doesn't track yet |
| **staged** | Ready to commit (`git add` done) |
| **committed** | Saved in Git history |

IDE labels: **M** = modified, **A** = added, **D** = deleted

---

## 7. Things to Avoid

| Don't | Do instead |
|-------|------------|
| `git init` then `git clone` | Just `git clone <url>` |
| `git add .` blindly | `git add specific-file` |
| Commit `.iml` / `.idea/` files | Ignore them (IntelliJ config) |
| Run git in parent folder | `cd` into repo with `.git` |
| `git checkout -b hello` if branch exists | `git checkout hello` |

---

## 8. One-Page Example (Start to Finish)

```bash
# Clone
cd ~/Projects
git clone -b hello https://github.com/username/Skycrapers.git
cd Skycrapers

# Check state
pwd
git status
git branch

# Work on a new branch
git checkout -b my-feature
# edit files...
git add topics/some-file/README.md
git commit -m "Update README"
git push -u origin my-feature
```

---

## Quick Reference Card

```
CLONE     git clone <url>
          git clone -b <branch> <url>

WHERE     pwd / cd <folder> / ls

BRANCH    git branch
          git checkout <branch>        (switch existing)
          git checkout -b <branch>     (create new)

WORKFLOW  git status → git add → git commit → git push
```
