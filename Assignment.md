## Project

You work for a company that is developing **multi-player card games**.  They have divided up the work among teams and your team is developing some of the foundation classes that the games will use, such as **Card**, **Pile**, **Deck**, **Hand**, and **Player**.   You do not know the details of the card games so you need to provide as much functionality in your classes as might be needed by anyone “using” your classes. . Your company is allowing motivated individuals to propose a game and develop it (EXTRA CREDIT). 

### Card

1. Write a Card class to represent a playing card. 
    1. Include instance variables above and below of type Card to hold references 
    to the cards before and after the card in a chain of cards (see UML class 
    diagram). These will have the behavior of “next” and “prev” in doubly-linked 
    lists.  Also include the cards face and suit.
    2. As usual, provide:
        1. Constructors
        2. accessor and mutator methods for all instance variables
        3. A toString method for displaying the card.
2. Test your Card class before you proceed!  
    1. This usually mean’s “include a main method in your class, with 
    object creation and method calls.” 
    2. For example, your main might look something like what is shown in the 
    textbox below:  

        public static void main(String[] args) {
            // create 2 cards 
            Card aboveC = new Card(“Nine”,”Hearts”);
            Card belowC = new Card(“Nine”,”Diamonds”);
            // connect the 2 cards
            aboveC.setBelow(belowC);
            belowC.setAbove(aboveC);
            System.out.println(aboveC.getBelow());
            System.out.println(belowC.getAbove());
            . . .   // best to test ALL methods that you write

#### UML class Diagram

    Card
        - face : String
        - suit : String
        - above : Card
        - below : Card
        + setAbove( inA : Card) : void
        + setBelow(inB : Card) : void
        + getAbove() : Card
        + getBelow() : Card
        + toString() : String
        // other Methods  ?

### Pile

1. Write a Pile class to represent a general pile of cards (see UML class diagram 
to the right).  An illustration of a pile with 3 cards is shown in Figure 1. Note 
that links between cards are made with the above and below references in 
Card (just as we have seen links make with next and prev in Node). . 
    1. Include instance variables at least for
        1. topCard – reference to the top card in the pile
        1. bottomCard – reference to the bottom card in the pile
        1. nCards - Number of cards in the pile.  
    1. As usual, provide
        1. Constructors
        1. accessor and mutator methods 
        1. A toString method in order to be able to test your class. 
    1. Include methods that represent operations on piles of 
cards that may be needed for a card game:
        1. Add methods (to the top, to the bottom)
        1. Remove (and return) methods (given a suit, a 
face, both). Some may need to return a list of 
cards. 
        1. Shuffle
        1. Search methods (face, suit). Some may need to 
return a list of cards. 
        1. Other?
1. Test your Pile class methods
    1. Include a main method with calls to test all methods

### Deck and Hand

1. Extend class Deck from Pile. 
    1. Deck should generate the 52 cards in its constructor.  Remember, Deck inherits instance variables and methods 
from Pile (please ask if you are not sure what that means). 
    1. Add any instance variables and behavior (methods) that are not already inherited from Pile. For example, you 
would need to be able to deal cards to a set of players. 
    1. Test your Deck class by including a main method that:
        1. Creates object of type Deck.
        1. Calls both Pile and Deck methods on that object.  
1. If you can think of instance variables and methods that you will need that are unique to Hand (not provided already by 
Pile) then create a Hand class also extended from Pile, otherwise just create a hand as an instance of Pile (i.e. Pile 
hand = new Pile()))  As usual, test before you proceed. 

### Player

1. Write a Player class. 
    1. Include instance variables related to players, such as
        1. name and/or ID
        1. hand - instance of either the Pile class or, if you have it, a Hand class (extended from Pile). 
        1. score.  
    1. Include methods related to players. 
1. Test your Player class.

### Game (Extra Credit this semester!)

1. Select a multiple-player card came that you would like to implement that is complex enough to require
    1. Objects from your Player, Card, Deck/Pile/Hand classes
    1. Operations provided in your classes, such as shuffling, searching, dealing, determine win,...
1. Write a Game class. 
    1. Include 
        1. An array of type Player 
        1. A Deck of cards (or more if your game requires it...).
    1. If needed, include other instance variables related to your type of game, such as
        1. A discard Pile of cards 
    1. Depending on the game that you are implementing, methods might include
        1. initialize() to set up for a new game
        1. play() to run the game. 
1. You have creative freedom to develop additional classes if they would make your implementation cleaner and/or 
more elegant.
1. Have fun playing your card game!  &#x1f642;