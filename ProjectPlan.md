# Project Plan

### Week 2
- [X] Create project repository on GitHub
- [X] Create project structure in intellij and push
- [X] Add link to list of indie projects in student repo.
- [X] Complete Problem Statement
- [X] Weekly time log journal

### Week 3
- [X] Research possible Web Services/APIs to use
- [X] List technologies, versions and how they will be used
- [X] Write project plan
- [X] Document user stories and select MVP stories 
- [X] Confirm MVP stories meet Ent Java indie project objectives
- [X] Design screens (complete 2/6, with some changes necessary)
- [X] Triple-check for Checkpoint 1
- [X] Update time log journal

### Week 4 - Hibernate
#### User story focus: Find written session by name 
- [X] Start up database design
- [X] Create the dev version of the database - User table
- [X] Create User entity
- [X] Create a class to perform CRUD on session records - UserDao 
- [X] Create the config files for the DB connection info (dev and test)
- [X] Create a test version of the database for unit testing
- [X] Create unit tests for the UserDao
- [X] Test the UserDao
- [X] Create a class for the DB connection business
- [X] Create JSP for finding sessions
- [X] Create JSP for session search results
- [X] Create controller - send to session search results jsp
- [X] Create controller - search sessions
- [X] Update time log journal
- [X] Research ways to incorporate AI prompts

### Week 5 - One-to-many Hibernate
#### User story focus: View session goals
- [X] Start up database design for writing sessions
- [X] Create the dev version of the database - NudgeSession table
- [X] Create NudgeSession entity
- [X] Create a class to perform CRUD on Goals - GoalDao 
- [X] Create the config files for the DB connection info (dev and test)
- [X] Create unit tests for the NudgeSessionDao
- [X] Create a class for the DB connection business
- [X] Add session results to User search results JSP
- [X] Update time log journal
- [X] Determine feasibility/confirm goals for Create Long Term Writing Goals user story 
- [X] Work out logic that could work for grace period countdown
- [X] Work out code to implement text field for nudge sessions


### Week 6 - AWS
- [X] Create controller - send to NudgeSession search results jsp
- [ ] Replicate above steps for Goals (possible many-to-many with NudgeSession in the middle)
- [X] Fully test SessionDao - implementing Hibernate
- [X] Fully test GoalDao - implementing Hibernate
- [X] Implement Log4J for logging
- [X] Continue research on Web Services to incorporate
- [X] Update time log journal

### Week 7 - Authentication
#### Checkpoint 2 is Due: Database designed and created, at least one DAO with full CRUD (create, read, update, delete) implemented with Hibernate, DAO is fully unit tested, Log4J is implemented (no System.out.printlns)
- [X] Double-check all checkpoint 2 items (above) are complete and visible in github.
- [X] Set up Authentication in indie project 
- [X] Create project DB on AWS.
- [X] Update project config files for AWS as needed
- [X] Deploy project to AWS
- [X] Add deployed link to indie project list in student repo (as of 3/25 may need to update again)
- [X] Update time log journal

### Week 8 - Web Services
#### User story focus: Generate Story Prompts 
- [X] Consume RESTful Web Service in IntelliJ 
- [ ] Expand on active Session modes - Zen and Accountability
- [X] Implement "punishment" for Session grace period timeout (sound)
- [X] Update time log journal

### Week 9 (Start of the team project)
#### Checkpoint 3 is Due: Deployed to AWS, at least one JSP that displays data from the database is implemented, authentication implemented, add AWS deployed app link to indie project list in student repo.
- [ ] Double-check all checkpoint 3 items (above) are complete and visible in github.
- [ ] Fully upgrade to GenericDao
- [ ] create Goals entity and unit test the dao
- [ ] Review methods to erase text during the session - to incorporate for second punishment 
- [ ] Update time log journal

### Week 10 - Team project work
- [ ] Review and incorporate REST best practices
- [ ] decide on CSS theming
- [ ] create homepage - if user is not signed in, prompt sign in to save session (>sign in page) or start session (>session settings page). For signed in user, only "start session"
- [ ] create session settings page. User can create a new Goal or choose an existing one (including Default), and choose their desired settings for the session. (Begin Session > session page)
- [ ] create session page - minimal text box/countdown. User can continue past time limit. Actual word count stored separately from at-time wcg. (Complete session > completion page)
- [ ] create session completion page. For anonymous user, give option to copy text to clipboard. Display average wpm, total word count. For known user, option to redirect to session list page
- [ ] Update time log journal

### Week 11 - Team project work
- [ ] create sign in page and redirect (successful sign in > homepage)
- [ ] create sign out and redirect (successful sign out > homepage)
- [ ] create session list page: display individual sessions, including stats, on session list page. This will be a jquery table with child rows that display an optional summary of the session or a preview of the session writing, along with a link to an individual page where the full session can be viewed. (Child rows in jquery: https://datatables.net/examples/api/row_details.html). Sessions should be searchable by title, session content, and Goals.
- [ ] Create option for ChatGPT to provide writing prompts based on Session content on Session page (do not implement yet)
- [ ] Update time log journal

### Week 12
- [ ] create Goals page, which displays a list of goals, click through to individual Goals page
- [ ] Create individual Goals display page, which shows Goal progress (if start/end date is set) and associated Nudge Sessions
- [ ] Clean up CSS/ page views
- [ ] (optional) draw vector art for "storyline" positive reinforcement
- [ ] Update time log journal

### Week 13 - Enterprise Java Beans
- [ ] (optional) user can add an offsite Session to Goals page on a date of choice
- [ ] (optional) incorporate JavaScript graphs to display statistics
- [ ] (optional) user does not receive "complete session" option until at-time wcg is met
- [ ] (optional) session summary
- [ ] Update time log journal


### Week 14
- [ ] Project review time!
- [ ] Code quality check
- [ ] Update time log journal

### Week 15
- [ ] Implement Feedback from Week 14 review
- [ ] Final Presentation
- [ ] Create video, add video link to readme.md
- [ ] Finalize all documentation
- [ ] Code quality check
- [ ] Update time log journal

### Week 16
- [ ] Update time log journal
- [ ] Final touches before code complete
