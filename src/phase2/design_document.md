UofT Tinder
===========
UofT Tinder is the prototype for a dating application that appeals to CS students, gamers,
and the general University of Toronto population. This application allows students to complete
problem sets while simultaneously meeting their future life partner.

## Updated Specification
* Running the application allows a new user to register with the specified parameters, including a UTorID, to then
  access the following functionality.
* After registration, the user's data will be stored in our database, and the user can navigate the interface to do
  any of the following:
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
* Since this application is still a prototype, users can send messages, but will not receive
  messages from other users.
    * The framework would be easily adaptable to a web source database, due to the adherence to SOLID
      design principles and choice of design patterns.

## maybe class diagram
## Design Decisions
1. Refactoring Use Cases
    + Initial problem: Use cases relied completely on functionality of controller, causing an overloaded class.
      The orchestration of connecting entities to controllers had a sole reliance on
      the controller.
    + Solution: Separating each use case via class separation, and creating controller classes that interact
      with each respective use case.
        + `LogInController`+`LogInCase`
        + `SwipeController`+`SwipeCase`+`ImageMaker`
        + `ProfileController`+`ProfileCase`


2. Refactoring Controllers
    + Initial problem: Overloading our single controller class to handle the presentation and facilitation.
    + Solution: Separating common actions into packages for controllers, presenters, and data accessors. Each package
      is to now contain classes required for our user interface functionality.
        + Classes for _viewing_ purposes are in `package.phase2.presenters`
        + Classes for _creation/updating_ purposes are in `package.phase2.controllers`
        + Classes facilitating _backend_ updating are in `package.phase2.dataaccess`


3. Interactors
    + Initial problem: Duplicate code being used to build/interact with multiple use cases.
    + Solution: As a result of refactoring controllers, interactors for enhanced flow between entities
      and controllers were implemented. By eliminating over dependency on a single controller, 
   the interactors have a single use for assisting the flow of data to and from the controller package.
   
##Clean Architecture

## SOLID Design
The building of this application was centred at the implementation and adherence to clean architecture and SOLID design
principles. Examples and descriptions of how specific classes and the general project meet this expectation are
described in the following sections.

### Single Responsibility
Each class serves a direct and explicit purpose as described in its documentation, therefore a change in the way it uses
other data does not cause an unwanted change in another class. This is also noted by only integral use of overriding
functions. For example, consider the interactors in `package.userbuilders`. The classes are only used to assist the flow
of data from entities `package.users` to controller classes. Additionally, our `package.usecase` separates each use case 
by `LogInCase`, `ProfileCase`,`SwipeCase`, and `ImageMaker` to ensure each class only handles data required for the 
individual duties.

### Open-Closed
Each of our classes are protected from changes within their respective collaborators independently of the collaborating 
classes implementation. All collaborative classes depend on a respective protected classes if needed, to prevent 
unwanted changes. For example, our `package.dataaccess` is the direct link between implementing any changes requested by
other classes. Each method within class `DataBaseAccess` is also split into private helpers and public accessors to 
ensure no private attributes are changed without permission; this is an example of directional control via inversion. 
Class `DataBaseAccess` also exemplifies information hiding by manipulating the parameters of each method, without 
adjusting any information that is to remain static.

### Liskov Substitution
By including multiple classes with different forms of handling parameters, depending on the desired instantiation/definition
of a parameter, our program avoids repetitive and unnecessary mechanisms. This is exemplified by our need for 2 user 
definitions.
Consider `package.userbuilders`, each class within the package interacts with a specific 
use case partner. Since this program is based on interactions between multiple users, the definition of a current user
and an opposing user had some similar identities, but with different requirements for implementation. Both `SelfUserBuilder`
and `OtherUserBuilder` are subclasses of `UserBuilder`, where abstract parent definitions for methods are defined in 
`UserBuilder`. This allows for subclasses of `UserBuilder` to use the super classes definition, while adding
differing functionality depending on type `OtherUserBuilder` and `SelfUserBuilder`.

### Interface Segregation
In the above subsection it is noted that the application relies on actions from the user. Each action needs
similar functionality, but there are also uncommon methods/parameters required between the possible commands. By
choosing not to implement a common interface for each, the application avoids unnecessary implementations of methods,
while still avoiding repetition within each class. One problem our program has is repetitive code, approximately 7-20 lines
long, within classes that follow similar processes to execute their purpose. In phase 2 this can be solved by adding the
repeated method/code in a parent class or creating a new parent class to do so.

### Dependency Inversion
Each class depends on some interface or static class, whether directly via implementation or by inheritance. The classes
do not change, and are the root of each class. By creating interfaces based on our specifications, each implementation
is used effectively without the need to add or adjust the interface. This not only increases stability, but avoids
time-consuming coupling in the architecture. While our project is currently a prototype, the abidance to 
Dependency Inversion would allow for an easy addition of web adaptation, since high level modules would not
rely on the low level classes defined for each package.

## Packaging Strategies
Our project packages by the inside/outside pattern. We have the separation of the outer layers of our program and 
the inner layers outlined by our packaging.
For example, `package.users` classes are our most inner classes which are purely informational, so they are in their 
own package. They are completely separate from `package.presenters` and `package.controllers` which are both outer layers of our
program that directly output feedback to our user. This also forces an abidance to clean architecture; clean architecture
uses a similar philosophy of segregating client details from the back end processing and implementation. This packaging 
strategy adds a clear definition of our entities, use cases, controllers, and user interface, which allows for
efficient and readable code.

## Design Patterns
From Phase 1, UofT Tinder lacked the explicit definitions of design patterns. This phase allowed for an improved sense of
code organization, decrease of code smells, and an increased efficiency of work allocation. Below are the design patterns
applied, and examples of their usage in our code. By focussing on only a few patterns, the team was able 
to utilize all the benefits from Singleton, Factory, and Builder design patterns, whereas our phase 1 lacked focus. This 
strategy enabled proper implementation of design patterns.

### Simple Factory Design Pattern
This pattern is used for aiding the interactions between the user interface and controllers. When users provide 
context, the program activates only the necessary controllers. Consider `package.controllers` and `package.presenters`:
their use depends on the desired action inputted by the user via the interface, without requiring any unnecessary flow of 
data through irrelevant use cases. In Phase 1, we aimed to refactor our original controllers completely, and the 
utilization of this pattern allowed us to meet that goal, while adding more organized code for future development.

### Builder Design Pattern
This pattern is used for aiding the flow of data from `package.users` to `package.controllers` and `package.presenters`.
As mentioned in the Liskov Substitution subsection, our program needs definitions for a current and opposing user.
By adding interactors in `package.userbuilders`, the responsibility of user entities is purely informational, while the 
controllers are only providing functionality that directly applies to the user interface. Code smells of duplicate code
are also easily eliminated when using this patter, as each build has separate subclasses.

## Progress Report
Our team developed more civil and productive communication, while respecting the abilities and constraints of each 
individual member. Throughout phase 2, communication via discord video/voice calls during scheduled meeting times enabled
a more even spread of the workload. The rest of this report describes remaining questions, issues, team work strategies that
benefited our group, and a summary of each team members' contribution.

### Questions
+ A constant issue was determining what the entities, use cases, and controllers should do or not do to abide by 
clean architecture
  + This is a resolved issue, but possibly adding more information on this during lectures would be helpful

### Issues
+ GitHub: while the tutorial sessions during the first semester were helpful, our team still had unanswered questions about 
how to utilize the commit, checkout, push, and pull features.
  + What is the expected process for multiple developers working on a single branch?
  + How can we reverse changes, if something goes wrong?
  + Is it unprofessional to have many branches?
  + After a pull request is approved, can anyone merge the branches?
+ Healthy Communication: our team worked heavily on this after phase 1 marks came out, but there were times when 
members were misunderstood or off-track.
  + Should our team have had a designated 'HR' person that dealt with inner conflict?
  + How should initial meetings run, to avoid the amount of miscommunication we had throughout each phase?

### Team Strategies
+ Since our GitHub abilities were lacking, the team ensured during phase 2 that multiple members needed to 
approve pull requests.
+ To avoid miscommunications, we shut down any conversations that did not directly affect the task at hand.
+ Our team preferred to be on a voice call while merging large commits, to ensure no code was lost or merged incorrectly.
+ Focusing on only a few design patterns that each member was confident with allowed for a proper implementation, and 
helped avoid more code smells.
+ Using more descriptive/direct naming schemes for packages and builders allowed each member to fully understand
the project organization.

### Members Contributions
* Juliana Dellaviola
    * Design Document
    * Styling/Cleaning code
    * Identifying code smells and design patterns
* Senan Kassem
    * Implementation of use-cases and entity classes
    * Writing and tidying Javadocs
    * Organization of team meetings and communications
    * Aiding Alex in adhering to clean architecture
    * Refactoring controllers and use cases
* Anjian Chen
    * Identifying design patterns to be implemented
    * Refactoring use-cases
    * Implementation and continuing use-case refactoring
* Fei Yu Guan
    * Controller refactoring
    * User interface refactoring
* Sheng He Xiao
    * Data Base functionality and refactoring
    * Leader for explaining project organization each meeting
    * Designing messaging functionality, and continuing the implementation of design patterns with clean
      architecture
* Alexander Mathioudakis
    * Ensuring the project abides by clean architecture
    * Ensuring SOLID design principles are used
    * Implementation of Use-Cases
    * Refactoring controller and creating use-cases
    * Adding functionality of messaging