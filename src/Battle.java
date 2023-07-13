public class Battle {

    OceanMap ocean;
    Ship computerShip;
    Ship playerShip;

    //initialising the ocean and creating the object for Computer and player Ship
    // this game is 1on1, so only one computerShip and playerShip in instantiated
    public Battle(){
    ocean=new OceanMap();
    computerShip=new ComputerShip(ocean);   //   the ocean is passed to both ships,
    playerShip=new PlayerShip(ocean);       //  they are both will be placed in the same oceanMap
    }//end Battle

    //printing welcome message
    public void intro(){
        System.out.println("**** Welcome to Battle Ship game ****");
        System.out.println("Right now, the sea is empty");
        ocean.printMap();
    }//end intro

    //placing ship inside the ocean
    public void placingShip(){
        System.out.println("\n");
        System.out.println("Lets Start placing the ship in the Ocean");
        playerShip.setShipCoordinate();
        computerShip.setShipCoordinate();
    }//end placingShip

    // this method will provide us with the currentShipCount
    public void currentShipsCount(){
        System.out.println(computerShip.getShipName() +" : "+computerShip.getShipCount()+" | "+playerShip.getShipName()+" : "+playerShip.getShipCount());
    }//end currentShipCount

    // method explaining the symbol use in the game
    public void printSymbolMeaning(){
        System.out.println("#################################################################");
        System.out.println("! awesome! computer ship it hit (either by you or on its own)");
        System.out.println("x you hit your own ship or computer hit your ship");
        System.out.println("- you missed and ^ computer missed");
        System.out.println("################################################################# \n");
    }//end printSymbolMeaning

    // this will be the primary function, to play this game,
    // the Battle object only need to invoke this function.
    public void startBattle(){
        intro();                // printing welcome message
        currentShipsCount();    // display initial shipCount
        placingShip();          // start asking user to enter the location of the ship
        ocean.printMap();       // print the map
        System.out.println("\n");
        printSymbolMeaning();   // describe the symbol used in the game

        // The guessing battle will continue until either one of the parties has no ships left in the ocean
        while(playerShip.getShipCount() >0 && computerShip.getShipCount() >0){
            playerShip.guessEnemyShipLocation(computerShip);    // - prompting the player to guess the location of enemyShip
            currentShipsCount();                                // - this will update te shipCount based on the result of the guess
            computerShip.guessEnemyShipLocation(playerShip);    // - Computer turn to make a random guess
            currentShipsCount();                                // - update shipCount
            ocean.printMap();                                   // - an updated map is printed to the console after both
            System.out.println("\n");                           //   side have made their guesses
        }
        if(computerShip.getShipCount()==0){                     // - computerShipCount has reach zero
            ocean.printMap();                                   //   player has won
            currentShipsCount();
            System.out.println("You have won the game");
        }

        else if (playerShip.getShipCount()==0) {                // - playerShipCount reaches 0 first
            ocean.printMap();                                   // - computer has won
            currentShipsCount();
            System.out.println("Sorry, the computer won the game");
        }
    }//end startBattle

}
