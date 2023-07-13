import java.util.Scanner;

public class PlayerShip extends Ship{
    int[][] playerCoordinate= new int[5][2];
    public static Scanner input = new Scanner(System.in);

    // When instantiating the player ship
    // ocean object will be passed to the player ship
    // All ship will be deployed on the same oceanMap
    PlayerShip(OceanMap ocean){
        this.ocean=ocean;
        this.name="Player Ship";
        this.shipCount=0;
    }// end of constructor

    @Override
    public void setShipCoordinate() {

        // the code will continue to loop until the shipCount  is equal to 5
        while (shipCount < 5) {
            System.out.print("Enter X coordinate for your ship: ");
            int coorX = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int coorY = input.nextInt();
            // condition 1 : out of bound
            if (coorX > 9 || coorY > 9) {
                System.out.println("Coordinate is out of bound");
            }
            // condition 2 : the location is already occupied
            else if (!ocean.isEmpty(coorX,coorY)) {
                System.out.println("The location you have entered is already occupied");
            }
            // condition 3: all the above condition is passed, then we are going to place the
            // character @ at the chosen location
            else {
                System.out.println("location " + (shipCount + 1) + ":(" + coorX + "," + coorY + ")");
                ocean.markOcean(coorX,coorY,"@");
                shipCount++;
            }
        }
    }//end setShipCoordinate
    public int getShipCount(){  // get the current number of ship
        return this.shipCount;
    }//end getShipCount

    @Override
    public String getShipName() {   // get the shipName
        return this.name;
    }//end getShipName

    //function use to locate the location of enemy ship by asking user to enter the coordinate
    // if the guess is correct, the enemy shipCount will be reduced by 1
    // Passing the enemyShip object allow us to access the enemyShip properties(ComputerShip - count,name etc.).
    @Override
    public void guessEnemyShipLocation(Ship enemyShip) {
        //entering coordinate of the enemy ship
        System.out.println("Player Turn to sink the ships!");
        System.out.print("guess X coordinate of the computer ships : ");
        int coorX = input.nextInt();
        System.out.print("guess Y coordinate of the computer ships : ");
        int coorY = input.nextInt();

        // if there is no ship deployed at location specified above
        // fill the location with character -
        if(ocean.getShipAtLocation(coorX,coorY)==null){
            ocean.markOcean(coorX,coorY,"-");
            System.out.println("you missed, better luck next time!");
        }
        // X is the location of the enemy ship
        // change the character to !, indicating that enemy ship is destroyed
        // this will cause the enemyShipCount to be reduced by one
        else if(ocean.getShipAtLocation(coorX, coorY).equals("X")){
            ocean.markOcean(coorX,coorY,"!");
            enemyShip.shipCount--; // the enemyShipCount(computerShip) is reduced by 1
            System.out.println("Boom! you sunk the ship");
        }
        // @ is playerShip location
        // player guess his own ship location, cause the player shipCount to be reduced by 1
        else if(ocean.getShipAtLocation(coorX, coorY).equals("@")){
            ocean.markOcean(coorX,coorY,"x");
            shipCount--;// reducing the shipCount by 1
            System.out.println("Oh nooo! you sunk your own ship");
        }
        // other than that, the player has guessed the same location again
        else{
            System.out.println("You have hit this location before");
        }
    }//end guessEnemyShipLocation
}//end of PlayerShip
