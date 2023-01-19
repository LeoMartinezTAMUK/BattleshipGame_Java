import java.util.*;

public class DotComBust {

 private GameHelper helper = new GameHelper();

 private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();

 private int numOfGuesses = 0;

 private void setUpGame() {

 // first make some dot coms and give them locations
    DotCom one = new DotCom();
    one.setName("Ship One");

    DotCom two = new DotCom();
    two.setName("Ship Two");

    DotCom three = new DotCom();
    three.setName("Ship Three");

    dotComsList.add(one);
    dotComsList.add(two);
    dotComsList.add(three);

    System.out.println("Your goal is to sink all three ships.");
    System.out.println("Ship One, Ship Two, and Ship Three.");
    System.out.println("Try to sink every ship in the fewest number of guesses.");

 for (DotCom dotComToSet : dotComsList) {

   ArrayList<String> newLocation = helper.placeDotCom(3);

   dotComToSet.setLocationCells(newLocation);

    } // close for loop
  } // close setUpgame method

 private void startPlaying() {

 while(!dotComsList.isEmpty()) {

String userGuess = helper.getUserInput("Enter a guess:");

 checkUserGuess(userGuess);
  } // close while

 finishGame();
 } // close startPlaying method

 private void checkUserGuess(String userGuess) {
   numOfGuesses++;
   String result = "Miss";

 for(int x = 0; x < dotComsList.size(); x++) {

   result = dotComsList.get(x).checkYourself(userGuess);

 if (result.equals("Hit")) {
   break;
 }

 if (result.equals("Kill!")) {
   dotComsList.remove(x);
   break;
  }
 } // close for

 System.out.println(result);
 } // close method

 private void finishGame() {

   System.out.println("All ships have been taken down.");

 if (numOfGuesses <= 18) {

   System.out.println("It only took you " + numOfGuesses + " guesses.");

   System.out.println("Very solid score!");
 }
 else {

   System.out.println("Took you long enough. "+ numOfGuesses + " guesses.");

   System.out.println("Probably could have done better!");

  }
 } // close method

 public static void main (String[] args) {

   DotComBust game = new DotComBust();

   game.setUpGame();
   game.startPlaying();
  } // close method

}
