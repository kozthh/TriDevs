# ShopFlow Part A - Backend Engineering (C++)

## Study Rhythm
- 6 study/coding days per week
- 2 to 3 hours per day
- Day 7: retrospective, notes cleanup, and catch-up

## Study Method
- Learn structure first (framework docs, project layout), then implementation detail.
- Always finish a session with one written summary and one question.
- Treat the framework/tooling docs as both a knowledge source and a checklist of engineering habits.
- Build a single running project across all four weeks — a small REST backend in C++.

## Week 1: Backend overview and system thinking
Goal: understand a C++ backend's purpose, scope, and major responsibilities.

Day 1:
- Set up your toolchain (compiler, CMake) and confirm it builds a trivial program.
- Note the major backend categories you'll need: HTTP layer, routing, business logic, data layer.
- List the questions you want this project to answer (how does routing work, how is JSON handled, etc.).

Day 2:
- Read the quickstart of your chosen framework (Crow, Drogon, or Pistache) carefully.
- Summarize what the backend is responsible for in your project.
- Write a short distinction between backend work and frontend work.

Day 3:
- Capture the main C++ backend concepts in short definitions: RAII, ownership, smart pointers, move semantics.
- List unfamiliar terms, architecture ideas, or libraries you encounter.
- Write a plain-language explanation for each term.

Day 4:
- Build a minimal HTTP server with a single endpoint.
- Rewrite the request lifecycle in your own words, from socket to response.
- Note where the framework emphasizes threading, async I/O, or simplicity.

Day 5:
- Build a glossary for C++ backend-specific terms.
- Group terms by APIs, services, data, reliability, or workflow.
- Mark the terms that keep appearing (ownership, lifetime, exception safety).

Day 6:
- Recreate your request-lifecycle diagram from memory.
- Give a 2-minute explanation of your project's purpose and structure.
- List the areas that need a slower second pass.

Day 7 retrospective:
- Which backend responsibilities are clear now?
- Which topics still feel too abstract (async, ownership, framework internals)?
- What example would make the ideas easier to retain?
- What should next week concentrate on?

## Week 2: API design and request flow
Goal: understand how requests move through a C++ backend and how APIs should be shaped.

Day 1:
- Revisit your week 1 notes before adding new code.
- Focus on request handling and route design.
- Decide the API-related conventions you'll follow (naming, status codes).

Day 2:
- Trace a request from entry point to response in your actual code.
- Write each step as a numbered flow.
- Note where validation, routing, or JSON transformation happens.

Day 3:
- Study service-boundary design: separate handlers (controllers) from business logic (services).
- Write what belongs inside a service and what should stay in the handler.
- Refactor at least one endpoint to follow this separation.

Day 4:
- Review REST naming, endpoint, and contract conventions.
- Summarize the rules in short, reusable statements.
- Add examples of good and bad API shape from your own code.

Day 5:
- Sketch one full backend interaction from client request to response, including errors.
- Annotate where errors, validation, and success states appear in your code.
- Compare the sketch to what you actually implemented.

Day 6:
- Recap API design principles from memory.
- Write a short note on what makes an API easy to use.
- List any questions that still need concrete examples.

Day 7 retrospective:
- Can I describe request flow without looking at the code?
- What part of API design still feels uncertain?
- Which naming or boundary rule should I remember?
- What would I change in a real service after this week?

## Week 3: Data, validation, and reliability
Goal: understand how C++ backend systems stay correct, stable, and maintainable.

Day 1:
- Add a database driver (libpqxx or mongocxx) and connect to a local database.
- Identify reliability topics you need: connection handling, transactions, integrity.
- Mark anything related to consistency or durability.

Day 2:
- Add input validation and input-safety checks to your handlers.
- Summarize where validation should happen and why.
- Write examples of invalid-input handling in plain language.

Day 3:
- Focus on error handling and failure states (exceptions vs error codes vs `std::optional`/`std::expected`).
- List the types of failures your app can hit (bad input, DB error, not found).
- Note what your code does — and should do — when things break.

Day 4:
- Review resilience ideas: retry, timeout, connection limits.
- Write each mechanism as a purpose-plus-effect pair.
- Add basic timeout or retry handling to one network/DB call.

Day 5:
- Summarize maintainability practices from the week.
- Note design choices that make your code easier to change (interfaces, dependency injection, small classes).
- Highlight any patterns that reduce complexity.

Day 6:
- Do a recall session focused on data and reliability.
- Rebuild your reliability checklist from memory.
- Test yourself on ownership, exception-safety, and error-handling tradeoffs.

Day 7 retrospective:
- What reliability habits are now clear?
- Which failure scenarios need more attention?
- What rules should become part of my default thinking?
- What deserves a second pass next week?

## Week 4: Applied review and synthesis
Goal: turn your project into a reusable C++ backend reference.

Day 1:
- Review all prior summaries and code.
- Identify the top 5 backend ideas you want to keep.
- Note any repeated recommendations across the weeks.

Day 2:
- Re-read/re-code the weakest areas only.
- Rewrite them more simply, removing raw pointers or unclear ownership.
- Remove vague phrasing from your notes.

Day 3:
- Create a C++ backend principles sheet.
- Include API shape, service boundaries, ownership/memory rules, and reliability practices.
- Keep each principle short and actionable.

Day 4:
- Build one practical feature that uses multiple ideas from the project (e.g., paginated, validated, DB-backed endpoint).
- Describe the flow, data, and error handling in the feature.
- Record what building it taught you.

Day 5:
- Review your entire project from memory first.
- Then compare your memory notes to the actual source.
- Correct anything inaccurate or incomplete.

Day 6:
- Write a final backend study summary.
- Include the main concepts, the design rules, and the biggest lessons.
- Add one action item for future practice (auth, tests, deployment).

Day 7 retrospective:
- Which backend ideas now feel practical rather than theoretical?
- Which notes should be kept as a reference sheet?
- What topic should be repeated before moving on?
- What will I do differently in the next study cycle?
