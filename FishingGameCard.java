//Hau Pham
//Program manipulate 2 decks a standard and a royal flush. With function to insert or delete,etc...
//There is a second phase, game play fishy.

import java.util.Random;
import java.util.Scanner;

public class Progrm4 {
    static Scanner kb = new Scanner(System.in);
    public static void mainPhase1() {
        char again = 'n';
        int selection;
        VegasDeck deck1 = new VegasDeck();
        for (int suit = 1; suit <= 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck1.insertCard(new PokerCard(suit, value));
            }
        }
        //System.out.println(deck1);

        VegasDeck royalFlush = new VegasDeck();
        int royalSuit = 1;
        for (int value = 10; value < 13; value++) {
            royalFlush.insertCard(new PokerCard(royalSuit, value));
        }
        royalFlush.insertCard(new PokerCard(royalSuit, 1));
            System.out.println("Which deck you want to manipulate?: ");
            System.out.print("Enter 1 for a standard deck, or 2 for royal flush deck:  ");
            int choice = kb.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.print("Please enter a valid choice: ");
                choice = kb.nextInt();
            }
            if (choice == 1) {
                selection = 0;
                do {
                    System.out.println("Display operations:");
                    System.out.println("1. Initialize an empty VegasDeck.\n" +
                            "2. Insert a given PokerCard in the deck.\n" +
                            "3. Delete one PokerCard with a given value from the deck and return the deleted instance.\n" +
                            "4. Delete one PokerCard selected at random from the deck and return the deleted instance.\n" +
                            "5. Return the number of times a given value occurs in deck.\n" +
                            "6. Return the number of PokerCards in the deck.\n" +
                            "7. Display the entire contents of the deck.\n" +
                            "0. Exit to main menu");
                    System.out.print("Enter your choice: ");
                    selection = kb.nextInt();
                    while (selection < 0 || selection > 7) {
                        System.out.print("Please enter a valid choice: ");
                        selection = kb.nextInt();
                    }
                    if (selection == 1) {
                        deck1 = new VegasDeck();
                        System.out.println("Done");
                    } else if (selection == 2) {
                        System.out.print("Enter the value: ");
                        int givenValue = kb.nextInt();
                        while (givenValue < 1 || givenValue > 13) {
                            System.out.print("Please enter a valid value: ");
                            givenValue = kb.nextInt();
                        }
                        System.out.print("Enter the suit: ");
                        int givenSuit = kb.nextInt();
                        while (givenSuit < 1 || givenSuit > 4) {
                            System.out.print("Please enter a valid suit(according to the instruction at the beginning): ");
                            givenSuit = kb.nextInt();
                        }
                        deck1.insertCard(new PokerCard(givenSuit, givenValue));
                    } else if (selection == 3) {
                        if (deck1.getSize() > 0) {
                            System.out.print("Value of one card you want to delete: ");
                            int givenValue = kb.nextInt();
                            while (givenValue < 1 || givenValue > 13) {
                                System.out.print("Please enter a valid value: ");
                                givenValue = kb.nextInt();
                            }
                            if (deck1.deleteTarget(givenValue) != null) {
                                System.out.println("Delete successful");
                            } else {
                                System.out.println("There is no card has the given value in the deck.");
                            }
                        } else {
                            System.out.println("Cannot delete from the empty deck");
                        }
                    } else if (selection == 4) {
                        if (deck1.deleteAny() != null) {
                            System.out.println("Delete successful");
                        } else {
                            System.out.println("The deck is empty");
                        }

                    } else if (selection == 5) {
                        if (deck1.getSize() > 0) {
                            System.out.print("Enter the card value you want to count in the deck: ");
                            int cardValue = kb.nextInt();
                            System.out.print("There is(are)" + deck1.countCard(cardValue) + " card(s) with the value of " + cardValue);
                        } else {
                            System.out.println("The deck is empty, so you cannot count number of given value card");
                        }
                    } else if (selection == 6) {
                        System.out.println("Number of card(s) in the deck: " + deck1.getSize());

                    } else if (selection == 7) {
                        System.out.println(deck1);
                    }
                } while (selection != 0);
            }
            if (choice == 2) {
                selection = 0;
                do {

                    System.out.println("Display operations:");
                    System.out.println("1. Initialize an empty RoyalFlush Deck.\n" +
                            "2. Insert a given PokerCard in the Royal Flush.\n" +
                            "3. Delete one PokerCard with a given value from the Royal Flush deck and return the deleted instance.\n" +
                            "4. Delete one PokerCard selected at random from the Royal Flush deck and return the deleted instance.\n" +
                            "5. Return the number of times a given value occurs in the Royal Flush Deck.\n" +
                            "6. Return the number of PokerCards in the Royal FLush deck.\n" +
                            "7. Display the entire contents of the Royal Flush deck.\n" +
                            "0. Exit to main menu.");
                    System.out.print("Enter your choice: ");
                    selection = kb.nextInt();
                    while (selection < 0 || selection > 7) {
                        System.out.print("Please enter a valid choice: ");
                        selection = kb.nextInt();
                    }
                    if (selection == 1) {
                        royalFlush = new VegasDeck();
                        System.out.println("Done");
                    } else if (selection == 2) {
                        System.out.print("Enter the value: ");
                        int givenValue = kb.nextInt();
                        while (givenValue < 1 || givenValue > 13) {
                            System.out.print("Please enter a valid value: ");
                            givenValue = kb.nextInt();
                        }
                        System.out.print("Enter the suit: ");
                        int givenSuit = kb.nextInt();
                        while (givenSuit < 1 || givenSuit > 4) {
                            System.out.print("Please enter a valid suit(according to the instruction at the beginning): ");
                            givenSuit = kb.nextInt();
                        }
                        royalFlush.insertCard(new PokerCard(givenSuit, givenValue));
                    } else if (selection == 3) {
                        if (royalFlush.getSize() > 0) {
                            System.out.print("Value of one card you want to delete: ");
                            int givenValue = kb.nextInt();
                            while (givenValue < 1 || givenValue > 13) {
                                System.out.print("Please enter a valid value: ");
                                givenValue = kb.nextInt();
                            }
                            if (royalFlush.deleteTarget(givenValue) != null) {
                                System.out.println("Delete successful");
                            } else {
                                System.out.println("There is no card has the given value in the deck.");
                            }
                        } else {
                            System.out.println("Cannot delete from empty deck");
                        }
                    } else if (selection == 4) {
                        if (royalFlush.deleteAny() != null) {
                            System.out.println("Delete successful");
                        } else {
                            System.out.println("The deck is empty");
                        }

                    } else if (selection == 5) {
                        if (royalFlush.getSize() > 0) {
                            System.out.print("Enter the card value you want to count in the deck: ");
                            int cardValue = kb.nextInt();
                            System.out.print("There is(are)" + royalFlush.countCard(cardValue) + " card(s) with the value of " + cardValue);
                        } else {
                            System.out.println("The deck is empty, so you cannot count number of given value card");
                        }
                    } else if (selection == 6) {
                        System.out.println("Number of card(s) in the deck: " + royalFlush.getSize());

                    } else if (selection == 7) {
                        System.out.println(royalFlush);
                    }

                } while (selection != 0);
            }

            }


    public static void main(String[] args) {
        //////variables declaration
        char again;
        System.out.println("Suit in this program is presented by number: 1 is Club, 2 is Diamonds, 3 is Hearts and 4 is Spades");
        System.out.println("1 is Aces, 11 is Jack, 12 is Queen, and 13 is King");
        //Phase II
        do {
            System.out.println("Main Menu:");
            System.out.println("(1) Test the VegasDeck");
            System.out.println("(2) Play Go Fishy");
            System.out.println("(3) Quit the main menu");
            System.out.print("Enter your choice: ");
            int menuChoice = kb.nextInt();

            if (menuChoice == 1) {
                do {
                    mainPhase1();
                    System.out.print("Do you want to run the option 1 again?(y/n): ");
                    again = kb.next().charAt(0);
                    while (again != 'y' && again != 'Y' && again != 'n' && again != 'N') {
                        System.out.print("Please enter yes or no (Y/N or y/n):  ");
                        again = kb.next().charAt(0);
                    }

                } while (again == 'y' || again == 'Y');
            }else if (menuChoice == 2) {
                    int numUserNovellas = 0;             //keep track of nuvella
                    int numComNovellas = 0;
                    char playAgain;
                    do {
                        //crete stock
                        VegasDeck stock = new VegasDeck();
                        for (int suit = 1; suit <= 4; suit++) {
                            for (int value = 1; value <= 13; value++) {
                                stock.insertCard(new PokerCard(suit, value));
                            }
                        }

                        // create two players' hands and deal 8 cards to each.
                        VegasDeck userHand = new VegasDeck();
                        VegasDeck computerHand = new VegasDeck();
                        for (int i = 0; i < 8; i++) {
                            userHand.insertCard(stock.deleteAny());
                            computerHand.insertCard(stock.deleteAny());
                        }

                        while (stock.getSize() > 0 && (userHand.getSize() > 0 || computerHand.getSize() > 0)) {
                            // user's turn

                            int turnDecide;
                            do {
                                turnDecide = 0;
                                System.out.println("Your turn:");
                                System.out.print(userHand);
                                System.out.print("The card you want to ask:  ");
                                int userChoice = kb.nextInt();
                                while (userHand.countCard(userChoice) == 0) {
                                    System.out.print("You do not have that card, please ask for a card that you have at least one: ");
                                    userChoice = kb.nextInt();
                                }
                                System.out.println("You: Computer, give me your " + PokerCard.getValueName(userChoice));
                                turnDecide = userHand.transferCard(computerHand, userHand, userChoice);
                                if (turnDecide == 0) {
                                    System.out.println("Computer: Go Fishy");
                                    PokerCard drawnCard = stock.deleteAny();
                                    userHand.insertCard(drawnCard);
                                    if (drawnCard.get_value() == userChoice) {
                                        System.out.println("You drew a " + drawnCard);
                                        System.out.println("You got a match! You get another turn.");
                                        //it's the computer's turn
                                        // Continue the user's turn
                                        turnDecide++;
                                    }
                                }
                            } while (turnDecide != 0);
                            // Check for novellas
                            for (int cardValue = 1; cardValue <= 13; cardValue++) {         //check for Novella after every turn
                                int count = userHand.countCard(cardValue);
                                if (count >= 3) {
                                    numUserNovellas++;
                                    computerHand.deleteTarget(cardValue);
                                    stock.deleteTarget(cardValue);
                                    for (int i = 0; i < count; i++) {
                                        userHand.deleteTarget(cardValue);
                                    }
                                    System.out.println("Novella " + PokerCard.getValueName(cardValue) + "s collected and discarded.");
                                }
                            }


                            do {
                                //computer's turn
                                turnDecide = 0;
                                System.out.println("Computer turn:");
                                //System.out.print(computerHand);
                                Random rand = new Random();
                                int randomInd = rand.nextInt(computerHand.getSize());
                                PokerCard randomCard = computerHand.getCardAtIndex(randomInd);
                                int cardValue = randomCard.get_value();

                                System.out.println("Computer: Player, give me your " + PokerCard.getValueName(cardValue));
                                turnDecide = computerHand.transferCard(userHand, computerHand, cardValue);
                                if (turnDecide == 0) {
                                    System.out.println("Player: Go Fishy");
                                    PokerCard drawnCard = stock.deleteAny();
                                    computerHand.insertCard(drawnCard);
                                    if (drawnCard.get_value() == cardValue) {
                                        System.out.println("Computer drew a " + drawnCard);
                                        System.out.println("Computer got a match! Computer get another turn.");
                                        // it's the computer's turn
                                        turnDecide++;
                                        //Continue the computer's turn
                                    }
                                }

                            } while (turnDecide != 0);
                            for (int cardValue = 1; cardValue <= 13; cardValue++) {         //check for Novella after every turn
                                int count = computerHand.countCard(cardValue);
                                if (count >= 3) {
                                    numComNovellas++;
                                    userHand.deleteTarget(cardValue);
                                    stock.deleteTarget(cardValue);
                                    for (int i = 0; i < count; i++) {
                                        computerHand.deleteTarget(cardValue);
                                    }
                                    System.out.println("Novella " + PokerCard.getValueName(cardValue) + "s collected and discarded.");
                                }
                            }

                        }

                        // Determine the winner
                        System.out.println("Game Over!");
                        System.out.println("User's Novellas: " + numUserNovellas);
                        System.out.println("Computer's Novellas: " + numComNovellas);
                        if (numUserNovellas > numComNovellas) {
                            System.out.println("You win!");
                        } else if (numUserNovellas < numComNovellas) {
                            System.out.println("Computer wins!");
                        } else {
                            System.out.println("It's a tie!");
                        }
                        System.out.print("Do you want to play again?:");
                        playAgain = kb.next().charAt(0);
                        while (playAgain != 'y' && playAgain != 'Y' && playAgain != 'n' && playAgain != 'N') {
                            System.out.print("Please enter yes or no (Y/N or y/n):  ");
                            playAgain = kb.next().charAt(0);
                        }
                    } while (playAgain == 'y' || playAgain == 'Y');

                }

                System.out.print("Do you want to run the whole program again?(y/n): ");
                again = kb.next().charAt(0);
                while (again != 'y' && again != 'Y' && again != 'n' && again != 'N') {
                    System.out.print("Please enter yes or no (Y/N or y/n):  ");
                    again = kb.next().charAt(0);
                }
            } while (again == 'y' || again == 'Y') ;
        }


    }

    class PokerCard {
        private int _suit;
        private int _value;

        public PokerCard(int suit, int value) {                //constructor to create new card with given suit and value
            _suit = suit;
            _value = value;
        }

        public int get_suit() {
            return _suit;
        }

        public int get_value() {
            return _value;
        }

        public static String getValueName(int cardValue) {
            String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

            if (cardValue >= 1 && cardValue <= 13) {
                return values[cardValue - 1];
            } else {
                return "Invalid Card Value";
            }
        }

        public String toString() {
            String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
            String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
            return values[_value - 1] + " of " + suits[_suit - 1];
        }
    }

    class VegasDeck {
        private static Random rand = new Random();
        private final int ALLOC = 52;
        private int size;
        private PokerCard[] bagOfPokerCards;

        public VegasDeck() {
            bagOfPokerCards = new PokerCard[ALLOC];                       //create a new empty bag of card
            size = 0;
        }

        public void insertCard(PokerCard card) {             //use data type of pockercard
            if (size == bagOfPokerCards.length) {                        //if the position number is equal to data size then expand the size then add
                PokerCard[] temp = new PokerCard[size + ALLOC];
                for (int i = 0; i < size; i++) {
                    temp[i] = bagOfPokerCards[i];
                }
                bagOfPokerCards = temp;
            }
            bagOfPokerCards[size] = card;                       //insert the card
            size++;
        }

        public PokerCard deleteTarget(int target) {
            if (target < 1 || target > 13) return null;
            for (int i = 0; i < size; i++) {                              //loop to find the card has same value
                if (bagOfPokerCards[i].get_value() == target) {
                    PokerCard save = bagOfPokerCards[i];                 //delete the first card come up with same value
                    for (int j = i; j < size - 1; j++) {                   // Shift cards to fill the gap
                        bagOfPokerCards[j] = bagOfPokerCards[j + 1];
                    }
                    size--;
                    return save;                 //return the card
                }
            }
            return null;
        }

        public PokerCard deleteAny() {
            if (size > 0) {
                int randomInd = rand.nextInt(size);                   //random an index number from 0 to size -1
                PokerCard save = bagOfPokerCards[randomInd];         //save the card of the random index
                for (int i = randomInd; i < size - 1; i++) {
                    bagOfPokerCards[i] = bagOfPokerCards[i + 1];              //shift to fill the deleted card
                }
                size--;
                return save;
            }
            return null;
        }

        public int countCard(int targetValue) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (bagOfPokerCards[i].get_value() == targetValue) {
                    count++;
                }
            }
            return count;

        }

        public int getSize() {
            return size;
        }

        public String toString() {
            String result = "";
            for (int i = 0; i < size; i++) {
                result = result + bagOfPokerCards[i].toString() + "\n";
            }
            return result;
        }

        public PokerCard getCardAtIndex(int index) {
            if (index >= 0 && index < size) {
                return bagOfPokerCards[index];
            }
            return null;
        }


        public int transferCard(VegasDeck from, VegasDeck to, int value) {
            int transfer = 0;
            for (int i = 0; i < from.countCard(value); i++) {
                to.insertCard(from.deleteTarget(value));
                transfer++;
            }
            return transfer;
        }

}


