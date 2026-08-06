# ShopFlow Part A - Backend Engineering (C++): 30-Day Study Tracker

## How to use this tracker
- Study 2 to 3 hours per day.
- Use 6 days for active study/coding and 1 day for retrospective.
- Maintain one notes page for APIs, one for memory/data/reliability, and one for open questions.
- Aim for one concrete deliverable (code or notes) each day.
- Suggested toolchain: g++/clang++, CMake, a REST framework (Crow, Drogon, or Pistache), nlohmann/json, and a database driver (libpqxx for Postgres or mongocxx for MongoDB).

## Week 1: Backend orientation in C++

Day 1:
- Install a C++ toolchain (compiler, CMake) and confirm `g++ --version` / `cmake --version` work.
- Create a topic map of what a C++ backend needs: build system, HTTP layer, business logic, data layer.
- Write the core question you're trying to answer: "How does a request become a response in C++?"

Day 2:
- Read the docs/quickstart of one C++ web framework (e.g., Crow or Drogon).
- Summarize the framework's role: routing, request/response objects, server loop.
- Distinguish backend responsibilities (compute, persistence) from frontend concerns in your own words.

Day 3:
- Capture core C++ backend concepts as short definitions: RAII, smart pointers, move semantics, const-correctness.
- Add unfamiliar terms (e.g., `std::shared_ptr`, `std::unique_ptr`, `std::optional`) to a glossary.
- Write one plain-language explanation for each term.

Day 4:
- Build a "Hello World" HTTP server with your chosen framework.
- Rewrite the request lifecycle as a step-by-step flow (socket → parse → route → handler → response).
- Note where the framework handles threading or async I/O.

Day 5:
- Group your notes into categories: routing, request handling, memory management, data access.
- Organize a project skeleton: `src/`, `include/`, `CMakeLists.txt`.
- Mark the concepts that keep repeating (ownership, lifetime, error handling).

Day 6:
- Rebuild the request lifecycle diagram from memory.
- Explain your project's purpose in two minutes, out loud or in writing.
- Identify the topics that need a slower second pass (likely memory management or async).

Day 7:
- Retrospective day.
- Write what feels clear and what still feels abstract.
- Pick the next topic to revisit before Week 2.

## Week 2: APIs and request flow in C++

Day 8:
- Re-open your project skeleton.
- Add 2-3 REST endpoints (e.g., GET /items, POST /items).
- Write the major design decisions you're making (route naming, status codes).

Day 9:
- Trace a request from entry point to response in your own code.
- Write each stage as a numbered flow (parse → validate → handle → serialize → respond).
- Note where JSON parsing/serialization happens (nlohmann/json).

Day 10:
- Study service boundaries: separate route handlers from business logic classes.
- Write what belongs in a "service" class vs a "controller"/handler.
- Refactor one endpoint to call into a separate service function.

Day 11:
- Review REST naming and status-code conventions.
- Summarize the rules as short statements (e.g., "POST returns 201 on create").
- Add one example of a good endpoint shape and one of a bad one from your own code.

Day 12:
- Sketch a sample request-response cycle for a POST with validation.
- Annotate error, validation, and success paths in your handler code.
- Add a basic error-response JSON shape (e.g., `{"error": "..."}`).

Day 13:
- Recap API design principles from memory.
- Write a short note on what makes an API easy to use.
- List any remaining questions (auth, pagination, versioning).

Day 14:
- Retrospective day.
- Review all request-flow notes and code.
- Decide what to refactor or reread before moving on.

## Week 3: Data, validation, and reliability in C++

Day 15:
- Add a database driver (libpqxx or mongocxx) to your project.
- Identify reliability topics: connection pooling, transactions, retries.
- Mark anything related to consistency or data integrity.

Day 16:
- Add input validation to your POST/PUT handlers.
- Summarize where validation should happen (handler vs service vs model).
- Write examples of invalid-input handling with proper HTTP status codes.

Day 17:
- Add error handling using exceptions or `std::expected`/error-code patterns.
- List the failure modes in your app (bad input, DB down, not found).
- Note what your code does when something breaks — and what it should do.

Day 18:
- Review resilience ideas: retries, timeouts, connection limits.
- Write each mechanism as a purpose-plus-effect pair (e.g., "timeout: prevents hung requests").
- Add basic timeout handling to a DB or network call if feasible.

Day 19:
- Review memory management in your code: who owns what, smart pointer usage.
- Note design choices that make the code easier to change (dependency injection, interfaces).
- Highlight patterns that reduce complexity (RAII wrappers, small focused classes).

Day 20:
- Do a closed-book recap focused on data and reliability.
- Rebuild your reliability checklist from memory.
- Test your understanding of ownership and error-handling tradeoffs.

Day 21:
- Retrospective day.
- Write the top reliability habits you want to keep.
- Choose the weakest area (memory, error handling, or DB) to revisit.

## Week 4: Applied review and synthesis

Day 22:
- Review all prior notes and code.
- Identify the top C++ backend ideas to keep permanently (RAII, smart pointers, clear boundaries).
- Note repeated recommendations from docs/tutorials you used.

Day 23:
- Re-read/re-code the weakest area only.
- Rewrite that part of your project more simply.
- Remove any raw `new`/`delete` or unclear ownership from your code.

Day 24:
- Create a C++ backend principles sheet.
- Include API shape, service boundaries, memory/ownership rules, and reliability practices.
- Keep each principle short and actionable.

Day 25:
- Extend your project with one more feature that uses multiple ideas (e.g., a paginated list endpoint with DB query and validation).
- Describe the flow, data, and error handling for that feature.
- Record what building it taught you.

Day 26:
- Review your entire project from memory first (what does each file do?).
- Then compare your memory notes to the actual code.
- Correct anything inaccurate or incomplete in your understanding.

Day 27:
- Write the final backend study summary.
- Include the main concepts, design rules, and biggest lessons from building in C++.
- Add one action item for future practice (e.g., add auth, add tests).

Day 28:
- Run a final closed-book self-test: explain your project's architecture from memory.
- Mark the remaining weak spots.

Day 29:
- Review the self-test results.
- Fix the mistakes in your notes or code.
- Write the last unresolved question.

Day 30:
- Final retrospective.
- Summarize what you learned overall about C++ backend engineering.
- Decide how you will revisit or extend the project later.
