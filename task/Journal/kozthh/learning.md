# Learning Journal — Aligned to Fullstack Roadmap

This journal is reorganized to match the sections in `Fullstack.md`. Entries below are grouped under the roadmap phases; at the end is a list of topics not yet visited so you can prioritize next steps.

## Tech Stack (from Fullstack roadmap)
- Java
- Spring Boot
- JWT / Authentication
- REST APIs / GraphQL
- HTML / CSS / JavaScript / TypeScript / React
- PostgreSQL / MongoDB / JPA / Hibernate
- Tools: Git, Maven, Gradle, Docker, IntelliJ, VS Code

---

## Recent Work Log

### 7/31/2026
- Reviewed the study-plan layout and checked how the PDF folders map to the roadmap.
- Added detailed study plans for Part D DSA and Part E Career Interview Readiness.
- Started aligning the study-plan index so each PDF has a matching 30-day tracker and checklist.

### 8/1/2026
- Updated the frontend study-plan folder to match the new Frontend Engineering and Audit PDF.
- Renamed the frontend plan structure to include audit and review habits, not just UI building.
- Verified the new frontend study-plan files and cleaned up the folder naming so it matches the new PDF title.

### 8/2/2026
- Expanded the Topics section into detailed subfolders so the roadmap phases are no longer flat.
- Added subtopic READMEs for Java, Git, OOP, core Java, Spring, databases, frontend, React, integrations, DSA, career prep, and the capstone.
- Aligned the topic pages with the PDF study tracks and validated the structure with a diff check.

### 8/3/2026
- Practiced terminal commands and reviewed the basics of command-line fundamentals.
- Installed WSL and set up the environment for further learning.
- Plan to continue studying Linux commands and Java compilation through the terminal.

### 8/4/2026
- Learned basic command-line navigation and file management: `cd` / `cd..`, `dir`, `mkdir`, `del`, `copy`, `move`, `type`, and `REM`.
- Practiced output/input redirection and piping with `>`, `>>`, `<`, and `|`, plus basic permissions with `icacls`.
- Reviewed Java CLI basics: `javac Main.java` compiles source code, `java Main` runs the class, and Java is case-sensitive (`Main` is not the same as `main`).

### 8/5/2026
- Reviewed files added/modified today in the workspace (notable items):
  - `.idea/` workspace files (IDE metadata)
  - `Skycrapers/README.md`
  - `Skycrapers/.devcontainer/devcontainer.json`
  - Updated PDFs and study materials in `Skycrapers/DevLessons/`:
    - `git-cheatsheet.html`
    - `git-cheatsheet.pdf`
    - `Part_D_DSA_Curriculum_Integrated.pdf`
    - `ShopFlow_PartB_Frontend_Engineering_and_Audit_2026.pdf`
    - `ShopFlow_PartE_Career_Interview_Readiness_v2.pdf`
  - `Skycrapers/Journal/learning.md` (this journal)

- What I learned/practiced today:
  - How to copy a repo to a local IDE: used `git clone <repo-url>` to copy the repository locally, then opened the project in IntelliJ/VS Code (File → Open / Open Folder).
  - Useful Git commands I practiced: `git clone`, `git status`, `git branch`, `git checkout <branch>` / `git switch <branch>`, `git checkout -b <new-branch>`, `git fetch`, `git pull`, `git merge`, `git rebase` (when needed), `git add .`, `git commit -m "msg"`, and `git push`.
  - How to update branches safely: create a topic branch (`git checkout -b feature/...`), pull latest changes from `origin` (`git fetch` + `git pull`), merge or rebase the branch onto `origin/main` to keep it up-to-date, resolve conflicts, then push back to remote.
  - Updated several PDF study materials in `DevLessons/` — verified file names and updated the folder index where necessary.

- Action items / next steps:
  - Commit any local edits and push feature branches to the remote origin.
  - Consider adding a short Git cheatsheet to this journal with the exact commands you use most.
  - Review updated PDFs and note any changes to study schedules or priorities.

---

## Phase 0 — Java Foundations
- (No dedicated entries yet) — plan: practice syntax, methods, compilation, small exercises.

---

## Git & GitHub Essentials
- Notes: repo fixes were performed (see Bug & Fixes below). Consider adding explicit Git practice entries (branches, PRs, rebasing).

---

## Phase 1 — Object-Oriented Programming (Journal Entries)

### Abstractions
- 7/16/2026: Built a simple abstraction project for parking lot payment methods and added notifications; work in progress to polish behavior and naming.

### Encapsulation
- 6/27/2026: Practiced using validation inside constructors.
- 6/28/2026: Studied access modifiers and when to use them.
- 6/30/2026: Learned appropriate uses for getters and setters; noted when setters are unnecessary (e.g., immutable IDs).

### Inheritance
- 6/31/2026: Fixed repo issues and started studying inheritance to prepare for projects.
- 7/1/2026: Recalled object-oriented logic and built a small inheritance practice project to gain comfort.
- 7/6/2026: Implemented dynamic binding in an employee paycheck example (method overriding).
- 7/7/2026: Planned to apply inheritance to the car dealership project.
- 7/13–7/14/2026: Designed and instantiated classes for the car dealership example; resolved instantiation details.

### Constructors
- 7/3/2026: Reviewed constructor basics, data passing, validation, and exceptions.
- 7/4/2026: Practiced overloaded constructors and single-responsibility patterns; explored how data flows through composed objects.

### Polymorphism
- 7/20/2026: Studied polymorphism and dynamic method binding; want to apply this in larger projects.

### Bug & Fixes (Repo maintenance)
- **Major:** Fixed class/file naming mismatches, package placement, added missing parent classes for the car dealership, renamed files to match public classes, moved shared exceptions into packages, standardized payroll method names, simplified payment abstraction logic.
- **Minor:** Removed duplicate/unused imports, added default messages for unsupported payment types, fixed constructor logic for deposit/withdrawal to use current balance, and cleaned formatting/whitespace.

---

## Phase 2 — Core Java Toolkit
- (No entries yet) — suggested practice: Collections, Generics, Streams, File I/O, JDBC, Maven/Gradle, JUnit, Mockito, Logging, Concurrency.

## Phase 3 — Spring Boot & APIs
- (No entries yet) — suggested: Spring Boot, DI, REST APIs, GraphQL, Validation, JWT, Testing.

## Phase 4 — Databases
- (No entries yet) — suggested: PostgreSQL, MongoDB, JPA/Hibernate, Transactions, Indexing, Flyway.

## Phase 5 — Frontend Foundations
- (No entries yet) — suggested: HTML, CSS, Bootstrap/Tailwind, JavaScript, TypeScript.

## Phase 6 — React Development
- (No entries yet) — suggested: React, Router, Context, Axios, Auth, API integration, deployment.

## Phase 7 — Third-Party Integrations
- (No entries yet) — suggested: Stripe, PayMongo, Google OAuth, SendGrid, Cloudinary, Maps API, OpenAI API.

## Phase 8 — Data Structures & Algorithms
- (No entries yet) — suggested: Arrays, Linked Lists, Trees, Graphs, Hash Tables, Sorting, Dynamic Programming.

## Phase 9 — Career Preparation
- (No entries yet) — suggested: System Design basics, OWASP security, resume & portfolio, interview prep, LeetCode.

---

## Topics Not Yet Visited (prioritized)
- Spring Boot & Dependency Injection
- REST APIs, GraphQL, and API validation
- JWT Authentication and Security flows
- Core Java toolkit: Collections, Streams, Concurrency
- Build tools & testing: Maven/Gradle, JUnit, Mockito
- Databases: PostgreSQL, MongoDB, JPA/Hibernate
- Frontend: HTML/CSS/JavaScript/TypeScript fundamentals
- React & related ecosystem
- Docker, CI/CD, Deployment
- Data Structures & Algorithms (DSA)
- System Design basics and interview prep

---

## Next Steps
- Start Phase 2 (Core Java) or Git & GitHub exercises. Tell me which you prefer and I will create a study checklist and a few concrete practice tasks.
