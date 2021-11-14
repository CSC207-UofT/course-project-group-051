#UofT Tinder

---
**CSC207H1F-2021 Group 51:**
* Juliana Dellaviola 1004145436
* Senan Kassem
* Anjian Chen
* Fei Yu Guan
* Sheng He Xiao
* Alexander Mathioudakis
* Artur Kuramshin (Teaching Assistant)
---

## Specification 
* Running the application allows a new user to register with the specified parameters to then use all of the features.
* After registration, their data will be stored in our database, and the user can navigate the interface to do any of the following:
  * add/adjust public-facing information as specified by the interface (name, age, gender, image, and location),
  * temporarily view possible matches by swiping left or right based on pre-existing preferences from 
  registration/profile updates,
  * view a list of their matches,
  * view the profile of a match,
  * unmatch users, 
  * send messages to another user, and/or
  * retrieve/view past messages.
* The application must store, adjust, and actively update the database with new matches, admirers, unmatches, 
and messaging threads.
### Updates 
In comparison to our original specifications of Phase 0, we have moved from a purely demonstration-based implementation 
to a more functioning interactive application. Areas that have remained demonstrative include image display, messaging,
and interactions between 2 users. These areas need a web-based memory allowing for real-time interactions.

Key changes include the level of functionality of the interface and how users can interact with it, the ability to 
create demonstrative messaging threads with other matches, the display of other users information while interacting,
and the ability to add/change actual images. An important note on the ability to add/change images is that it is purely 
demonstrative; the image is stored by file location in the running computers storage, not by
a public web-based memory.

## Design Decisions
The majority of decision-making for the application occurred in Phase 0 while determining a realistic scope. With a 
clear understanding of the specifications, the design decisions were minor; our decisions had more to do with detailed 
architecture to abide by SOLID and clean practices, rather than the actual design of the application. Additionally, all 
group members had pre-existing experience/knowledge on how a Tinder-like program functioned.

A key decision in Phase 0 was to limit the functionality to be demonstrative for the interaction between users. This
was made to ensure the focus of the functionality was in storing, adjusting, and transferring data, rather than the
aesthetics of a user-based app. This is exemplified in the ability of users to achieve the initial action of a command, 
but not continue a real-time interaction from user to user; the application only satisfies the specifications 
commencing this document, not the implementation of a fully functioning dating app.

## Clean Architecture
As defined in Phase 0 via our CRC cards, entities, use cases, interfaces, and controllers have explicit relationships 
and dependencies. The project utilizes its entities without relying directly on them for functionality via controllers 
and use cases. The 'DataAccess' classes act as our entities which are encompassed by the use cases, interfaces, and 
controllers. The Controller class then directly uses data from the entities to implement use cases in 'UserActions'.
Upcoming is how SOLID design principles are upheld in the project, and these explanations directly enforce
clean architecture. 

## SOLID Design
The building of this application was centred at the implementation and adherence to clean architecture and SOLID design 
principles. Examples and descriptions of how specific classes and the general project meet this expectation are
described in the following sections.
###Single Responsibility
Each class serves a direct and explicit purpose as described in its documentation, therefore a change in the way it uses
other data does not cause an unwanted change in another class. This is also noted by only integral use of overriding 
functions. For example, by looking at classes BuildProfileUser, ProfileUser, and ProfileAction, the facade pattern
is used to avoid merging and any over extension of the 'UserBuilders' classes.
###Open-Closed
Each class needing to be protected from changes within other collaborators does not depend on the collaborating classes.
All collaborative classes depend on a respective protected classes if needed, to prevent unwanted changes.For example,
our DataBase is the direct link between implementing any changes requested by other classes. Each method inside 
DataBase is also split into private and public parts to ensure no private attributes are changed without permission; 
this is an example of directional control via inversion. This class also exemplifies information hiding by manipulating 
the parameters of each method, without adjusting any information that is to remain static.

###Liskov Substitution
Our application relies on the interaction of the user and the interface. There are 4 main actions a user can take and
each must be handled differently. By including multiple classes with different forms of handling parameters, depending 
on the desired action, our program avoids repetitive and unnecessary mechanisms. We also utilize an event handler which 
determines what state the application is in, and if it can legally execute the users command. This also ensures the 
interface is not used incorrectly, without adding try/exception statements to each 'UserActions' class.
###Interface Segregation
In the above subsection it is noted that the application relies on actions from the user. Each action needs
similar functionality, but there are also uncommon methods/parameters required between the possible commands. By 
choosing not to implement a common interface for each, the application avoids unnecessary implementations of methods, 
while still avoiding repetition within each class. One problem our program has is repetitive code, approximately 7-20 lines
long, within classes that follow similar processes to execute their purpose. In phase 2 this can be solved by adding the 
repeated method/code in a parent class or creating a new parent class to do so.
###Dependency Inversion
Each class depends on some interface or static class, whether directly via implementation or by inheritance. The classes
do not change, and are the root of each class. By creating interfaces based on our specifications, each implementation
is used effectively without the need to add or adjust the interface. This not only increases stability, but avoids
time-consuming coupling in the architecture.
## Packaging
idk
## Design Patterns
The following identified design patterns are either currently implemented or can potentially be added. The project may
have others implemented without notice, but should be enhanced for Phase 2 to reem the benefits of each pattern. This
summary describes the 4 main patterns in the application.
###Observer Design Pattern
This pattern is utilized within the dependency of matches and messaging ability. Users can only message those they have 
matched with, and the ability to unmatch requires an updated list of matches to be generated. This list of matches needs
to be used to determine the legality of messaging. The loose coupling of these two functions demands a consistent update,
but does not need a full update of every data member in the entity.

###Strategy Design Pattern
This pattern is not well utilized, but can be a goal for Phase 2 regarding 'UserBuilders'. Each builder uses similar 
contexts, with various concrete strategies. Separating the implementation of each class and the implementation of each
algorithm/strategy involved can enhance the efficiency/readability of the project.

###Facade Design Pattern
The most utilized pattern in our code is the facade. Via Controller.java, an event handler allocates parameters to be 
used in each use case without forcing the class to be responsible for each one individually. This also prevents 
repetitive changes to multiple lines of code in different classes to be made. 

## Progress Report
Our team has completed more than expected for Phase 1, and are focused on more efficient functionality, refactoring, and
implementing/identifying design patterns for Phase 2.

### Questions
### Problems
* Healthy communication between _all_ team members
* Using ideas from other CSC courses that other members do not know/understand
* Code smells: data clumps, dead code, duplicate code
  * Result of lack of due diligence when merging, old code not being removed, and the aftermath of refactoring
* Creating multiple branches, but not fully merging to update main with all effective code from the individual branches
### Successes
Our design presents clean architecture mainly in our class definition, insurance of privacy, and explicit required
dependency. Each member is able to identify and code smells, the importance of git-branches, and generally abides
by styling guidelines. Working individually and setting internal meetings to code together on classes also enables 
each member to more fully understand the project as a whole, which is something we struggled with in Phase 0. The 
addition of mandatory meetings each week, has also promoted the effectiveness of internal deadlines.
### Individual Responsibilities
* Juliana Dellaviola
  * Design Document
  * Documentation of use-cases
  * Styling of use-cases
  * Implementation of a use-case
  * Phase 2: Further identification of code smells and refactoring, and a general continuation of Phase 1 
  responsibilities

* Senan Kassem
  * 
* Anjian Chen
  * 
* Fei Yu Guan
  * 
* Sheng He Xiao
  * 
* Alexander Mathioudakis
  * 




