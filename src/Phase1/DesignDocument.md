#UofT Tinder

---
**CSC207H1F-2021 Group 51:**
* Juliana Dellaviola 1004145436
* Senan Kassem 1004500514
* Anjian Chen 1007340584
* Fei Yu Guan 1004765550
* Sheng He Xiao 1006070494
* Alexander Mathioudakis 1007359109
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
  * send messages to another user, and/or (Phase 2)
  * retrieve/view past messages. (Phase 2)
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
and use cases. The Phase1.Users package classes act as our entities which are encompassed by the use cases, interfaces, and 
controllers. The Phase1.DataAccess package classes then directly uses data from the entities to implement
use cases in Phase1.UserActions. Upcoming is how SOLID design principles are upheld in the project, and these 
explanations directly enforce clean architecture. 

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
Our project packages by the inside/outside pattern. We have the separation of the outer layers of our program and the inner layers outlined by our packaging. 
For example, our Users class are our most inner classes which are purely information, this is why they are in their own package. They are separate from packages like "Views" and "Run" which are both outer layers of our program that directly output feedback to our user. This also helps us abide by clean architecture because clean architecture uses a 
simliar philosophy, where you want to segregate the client side stuff from the back end processing and implementation for more easily.

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
repetitive changes to multiple lines of code in different classes to be made. The implementation of Controller.java 
needs to be refactored, since there are parts that break clean architecture. This is a goal for phase 2.

### Builder Design Pattern
The use-cases are aided by 'builders' to avoid duplicating code, and allowing changes to be made without any damage to 
other classes. This design makes requests to Phase1.Users which then allows the actual functionality of features to be
used in the application.
### Template Method Design Pattern
This is used in order for users to view the interface while delegating which scene is needed. This works in unison with 
the above design pattern, which then allows different actions to change the view the user sees. This allows for easy 
additions to functionality.
## Progress Report
Our team has completed more than expected for Phase 1, and are focused on more efficient functionality, refactoring, and
implementing/identifying design patterns for Phase 2.

### Questions
* We need advice on how to refactor effectively, without completely destroying our code.
* How can we more effectively use testing? 
  * We need a better understanding of the process for implementing tests
### Problems
* Healthy communication between _all_ team members
* Using ideas from other CSC courses that other members do not know/understand
* Code smells: data clumps, dead code, duplicate code
  * Result of lack of due diligence when merging, old code not being removed, and the aftermath of refactoring
* Creating multiple branches, but not fully merging to update main with all effective code from the individual branches
* The largest setback was due to lack of communication which lead to dead code, gaps in clean architecture, and wasted 
time
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
  * Implementation of use-cases and entity classes
  * Writing and tidying Javadocs
  * Organization of team meetings and communications
  * Aiding Alex in adhering to clean architecture
  * Phase 2: Implementation of use cases, refactoring Controller.java, messaging functionality,
  and continued responsibilities from phase 1
* Anjian Chen
  * Identifying design patterns to be implemented
  * Refactoring use-cases
  * Phase 2: Implementation and continuing use-case refactoring
* Fei Yu Guan
  * Controller
  * ViewBuilder (Interface functionality)
  * Main
  * Phase 2: Implementation and messaging functionality
* Sheng He Xiao
  * Data Base functionality
  * Documentation for how the data base (entity classes)
  * Phase 2: Designing messaging functionality, and continuing the implementation of design patterns and clean
  architecture
* Alexander Mathioudakis
  * Ensuring the rpoject abides by clean architecture 
  * Ensuring SOLID design principles are used
  * Implementation of Use-Cases
  * Phase 2: Refactoring controller and creating use-cases




