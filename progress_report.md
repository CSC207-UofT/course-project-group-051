# Progress Report

## Specification Summary:
Our app (as of 10/14/2021) is a high-level implementation of a user-based match-maker. Users can upload 
information about themselves: name, hobbies, location, etc. The user will also input the age, gender, and maximum
distance that interests them, to enable the app to provide a list of possible matches. After finding
matches, the user can then use the interface to 'interact' with matches. Users will also be notified of
matches and messages.

## CRC Summary:
Our CRC is currently a base to meet our specifications, while ensuring all possible scenarios are accounted for
via methods and variable names. Additionally, we are aware that our User class is overloaded, but we need
to ask our TA for advice on cleanly splitting up our User entity into 2 entities.

## Scenario Walk-Through Summary:
1. The user creates a new profile
2. The user inputs their personal information and preferences in a possible match
3. The user then accesses a list via the interface to swipe on a list of those with matching preferences
4. They can then swipe left and right (yes or no) to define who they like
   1. Swiping right on a profile saves that profile to a list of the current users likes
5. When the user leaves the card view of swiping and switches to the list of matches view the program immediately checks
for matches.
6. When the user chooses a match to chat with, the interface displays the chat view.
7. The user can then switch back to card view to see an updated list of possible matches. 

## Skeleton Code:
Our skeleton code utilizes our CRC cards, by implementing the methods and variables required
to meet the specifications. As the project continues, we expect the structure of the code to be adjusted.
Additionally, we need to create test-cases to efficiently develop our app.

## Questions:
Our group mainly questions the extent of our app's ability. We completed Phase 0 with
the impression that the app would not implement an AI, or high-quality visuals.

The following are coding style questions:
* How do we efficiently split up an overloaded entity class (User) without losing clean architecture

## Group 51's Strategies:
Our team has worked virtually via Discord over live chat and screen share. Additionally,
acknowledging the busy schedules of our team allows us to create internal deadlines that are
achievable. By implicitly defining a leader to add code/work and share their screen, our team can
work collaboratively without confusion. Our group has the intention of providing our best work
without compromising in other courses, so each of us work directly on aspects that compliment our strengths.

Alexander Mathioudakis: Idea generation and implicit leader (screen sharing and implementing ideas)

Shenghe Xiao: Idea generation and implicit leader (screen sharing and implementing ideas)

Fei Yu Guan: Idea generation and explicit coding/java knowledge.

Senan Kassem: Implementing ideas in code.

Anjian Chen: Implementing ideas in code.

Juliana Dellaviola: Administrative (md files and setting meeting times), and code implementation.
