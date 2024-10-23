import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Cheese Adventure!", 1000, 1500);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 0, 0);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("NoCheese.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("Welcome " + ourHero.getName() + " to your great cheese adventure!\nHow many crackers would you like to bring? Please enter a number: ");
    input = inScanner.nextLine();
    int inputNum = Integer.parseInt(input);
    ourHero.setCrackers(inputNum);
    System.out.println("Great, you have " + ourHero.getCrackers() + " crackers\nBUT you still need " + ourHero.getCheeseNeeded() + " pieces of cheese");
    GetCheese();
  }
  private void GetCheese(){
    console.setImage("CheeseMagazine.jpg");
    System.out.println("Where would you like to acquire this cheese (please enter the number that corresponds with your choice)");
    System.out.println("1: Go to the supermarket\n2: Go to the moon     ");
    String input = inScanner.nextLine();
    int inputNum = Integer.parseInt(input);
    if (inputNum == 1){
      enterZone1();
    }else if (inputNum == 2){
      enterZone2();
    }else{
      System.out.println("Sorry, that is not an option");
      DryCrackers();
    }
  }
  private void DryCrackers(){
    console.setImage("Crackers.jpg");
    System.out.println("Well, guess you're eating your crackers dry");
    gameEnd();
  }
  private void BuyCheese(int pieces){
    if (pieces > ourHero.getCheeseNeeded()){
      console.setImage("LotsOfCheese.png");
      System.out.println("This would give you more cheese than crackers\nGood for you");
      System.out.println("Good job!\nYou have completed your cheese adventure");
      gameEnd();
    }
    else if (pieces == ourHero.getCheeseNeeded()){
      console.setImage("RightCheese.png");
      System.out.println("You have gotten just enough cheese!");
      System.out.println("Good job!\nYou have completed your cheese adventure");
      gameEnd();
    }
    else{
      ourHero.setCheese(ourHero.getCheese()+pieces);
      System.out.println("You now have " + ourHero.getCheese() + " pieces of cheese");
      System.out.println("Now you only need " + ourHero.getCheeseNeeded() + " pieces of cheese");
      GetCheese();
    }
  }
  private void enterZone1()
  {
    console.setImage("CheeseAisle.jpg");
    System.out.println("That was a very smart decision.\nWelcome to the supermarket " + ourHero.getName());
    System.out.println("You've walked to the cheese aisle but you see that there is not that much cheese left");
    System.out.println("Please enter a type of cheese to see if it is in stock: ");
    String cheese = inScanner.nextLine();
    Shopping(cheese);
  }
  private void Shopping(String cheese){
    cheese = cheese.toLowerCase();
    if (cheese.equals("feta") || cheese.equals("cheddar") || cheese.equals("parmesan") || cheese.equals("mozzarella")){
      System.out.println("Congratulations! " + cheese.substring(0,1).toUpperCase() + cheese.substring(1) + " is in stock\nHow many pieces would you like to buy? Please enter a number: ");
      String input = inScanner.nextLine();
      BuyCheese(Integer.parseInt(input));
    }
    else if (cheese.equals("brie")){
      //console.setImage("OutOfStock.png");
      System.out.println("Sorry, brie is not in stock. \nIt is on the moon though! Would you like to go there? (Enter y/n): ");
      String input = inScanner.nextLine();
      if (input.equals("y")){
        enterZone2();
      }
      else if (input.equals("n")){
        System.out.println("Would you like to choose another cheese then? (Enter y/n): ");
        input = inScanner.nextLine();
        if (input.equals("y")){
          console.setImage("CheeseAisle.jpg");
          System.out.println("Please enter a type of cheese to see if it is in stock: ");
          input = inScanner.nextLine();
          Shopping(input);
        }
        else if (input.equals("n")){
          DryCrackers();
        }
        else{
          System.out.println("That's not an option");
          DryCrackers();
        }
      }
      else{
        System.out.println("That's not an option");
        DryCrackers();
      }
    }
    else if (cheese.equals("ricotta") || cheese.equals("camembert") || cheese.equals("provolone") || cheese.equals("gouda")){
      console.setImage("OutOfStock.jpg");
      System.out.println("Sorry, this cheese is not in stock.");
      System.out.println("Would you like to choose another cheese then? (Enter y/n): ");
      String input = inScanner.nextLine();
      if (input.equals("y")){
        console.setImage("CheeseAisle.jpg");
        System.out.println("Please enter a type of cheese to see if it is in stock: ");
        input = inScanner.nextLine();
        Shopping(input);
      }
      else if (input.equals("n")){
          DryCrackers();
      }
      else{
          System.out.println("That's not an option");
          DryCrackers();
      }
    }
    else{
      console.setImage("OutOfStock.jpg");
      System.out.println("Are you sure that's even a cheese?\nAnyway, it's definitely not in stock.");
      System.out.println("Would you like to choose another cheese then? (Enter y/n): ");
      String input = inScanner.nextLine();
      if (input.equals("y")){
        console.setImage("CheeseAisle.jpg");
        System.out.println("Please enter a type of cheese to see if it is in stock: ");
        input = inScanner.nextLine();
        Shopping(input);
      }
      else if (input.equals("n")){
          DryCrackers();
      }
      else{
          System.out.println("That's not an option");
          DryCrackers();
      }
    }
  }
  private void enterZone2()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }
  private void gameEnd()
  {
    // ADD CODE HERE

    inScanner.close();
  }
}