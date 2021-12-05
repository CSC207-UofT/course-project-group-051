UofT Tinder
===========

UofT Tinder is the prototype for a dating application that appeals to CS students, gamers, 
and the general University of Toronto population. This application allows students to complete
problem sets while simultaneously meeting their future life partner.

##Updated Specification
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
  design principles choice of design patterns.
  
##maybe class diagram
##Design Decisions
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
   and controllers were implemented. By eliminating over dependency on a single controller, the interactors now provide 
   a single use to contribute to the overall functionality of c.
    + 
##Clean Architecture
##SOLID Design Principles
##Packaging Strategies
##Design Patterns
##Progress Report
