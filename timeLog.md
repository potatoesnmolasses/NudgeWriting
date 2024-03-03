### Week 1
1/19 - 1-2 hours VMWare setup

1/21 - 1-2 hours troubleshooting VM network.  Reached out in Slack, re-downloaded VM and completed setup again.

1/22 - 2 hours activity 1

### Week 2
1/23 - 30 minutes Activity 2

1/24 - 30 minutes elevator pitch

1/28 - moved to primary desktop, had to reconfigure VM again.  Initialized and mostly completed Activity 3

1/31
    Worked for about a cumulative hour and a half on the Week 3 exercise.  Not too many issues while following along with 
    the course videos.  I did wait to watch the puzzle walkthrough until I'd mostly completed the puzzle.  I did need to 
    review a bit to figure out the FileNotFound exception test but otherwise not too many issues
    
### Week 3 
2/6 - 3 hours.  Created screen images for indie project using iPad app and worked on project plan

2/8 - 1 hour.  Completed tentative project plan.  See below for potential resources to use for project:
  * https://dev.to/kennymark/best-free-services-for-web-developers-2g2g#:~:text=6%20free%20services%20for%20web%20developers%201%20Upstash,4%20Nodemation%205%20Calendso%206%20Caprover%207%20Conclusion
  * https://free-web-services.com/
  * Still on the hunt for story prompt generation 
  
### Week 4
2/10 - 2 hours.  Reconfiguring VM again and watching lecture videos.  Set up SessionDao - would later change to NudgeSessionDao.

2/11 - ~3 hours.  Did the bulk of the work for the Week 4 exercise.  Changed to NudgeSessionDao.
 * had to update class name in hibernate properties - was getting a ClassNotFound exception while running unit tests, saying the Session class could not be found. This was after I had renamed it from Session to NudgeSession so as not to conflict with the already existing Session/SessionFactory classes. Eventually I re-watched the course video and found that hibernate properties was the only place I had not updated
 * source file - for a time I was noticing that IntelliJ wasn't notifying me of quick fixes or properly color coding with errors. A google search told me that this could be resolved by marking the Java folder as the source file. Easy peasy.
 * wrong Database import - While unit testing I could not get the Database class to cooperate. Eventually I realized that the import statement was pointing to Hibernate's Database class (I believe it was imported automatically via Quick Fix). I swapped it out and all ran smoothly
 
 2/12 - about a half an hour finishing out the prompt and turning in the exercise
 
### Week 5
 2/13 - 1 hour, watched the lecture videos (one was not accessible, but it was unit testing so not an immediate issue)
 
 2/14 - 30 minutes watching the remaining one-to-many lecture video
 
 2/18 - ~3 hours.  After considering my options, for now I've set the NudgeSessionDao as the 'many' to the User 'one' for the database.  If I decide to incorporate the GoalsDao that may change, but would first like to focus on getting everything working.  Setup of the User class and changing the existing Dao had no issues.
 
### Week 6
2/20 - 1 hour, watching AWS Elastic Beanstalk video lectures
2/22 - 30 minutes, researching AI for prompt generation
2/24 - 1.5 hour, met with Oscar for project reviews
2/25 - 2 hours, deployed to AWS

### Week 7
2/26 - noticed I am accruing AWS charges, ~2 hours of troubleshooting.  Reached out to AWS support.
2/27 - spoke with AWS Support.  Still accruing charges.  1 hour watching Cognito video lectures.  Will set it up once I have billing issue resolved
2/29 - 1 hour researching and writing JS code for project.  The wordcount code is implemented.
3/1 - 2 hours writing JS code for project.  Not yet implemented but grace period/ "punishment" in progress.
3/2 - Still accruing charges.  ~3 hours of working on those issues.  Was able to resolve by making DB private - can't connect to DB via IntelliJ but still can through the deployed app.  If charges no longer occur I can live with it.  :)
