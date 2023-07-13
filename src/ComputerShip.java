
import java.util.*;
public class ComputerShip extends Ship{
    int[][] computerCoordinate= new int[5][2];
    // initialising the creation of computerShip object
    // we are going to pass the same OceanMap object to the computer and player ship
    ComputerShip(OceanMap ocean){
        this.ocean=ocean;
        this.name="Computer Ship";
        this.shipCount=0;
    }// end of constructor

    @Override
    public void setShipCoordinate() {
        System.out.println("Computer turn to deploy the ship, deploying..........");
        //This will generate 5 different coordinate to place the Ship
        while (shipCount < 5) {
            int coorX = (int) (Math.random() * 10);
            int coorY = (int) (Math.random() * 10);     // using random number between 0 and 9 as teh coordinate for the ship
            if (ocean.isEmpty(coorX,coorY)) {           // if the map(2d array f string) is null
                System.out.println((shipCount+1)+" Computer ship is deployed"+"("+coorX+","+coorY+")");
                ocean.markOcean(coorX,coorY,"X");   // marks or fill the location with character X
                shipCount++;
            }
        }
    }//end setShipCoordinate
    public int getShipCount(){      // get a shipCount
        return this.shipCount;
    }//end getShipCount

    @Override
    public String getShipName() {   // get shipName
        return this.name;
    }

    // function use to locate the location of enemy ship by randomly generating the coordinate
    // if the guess is correct, the enemy shipCount will be reduced by 1
    // Passing the enemyShip object allow us to access the enemyShip properties(PlayerShip- count,name etc.).
    @Override
    public void guessEnemyShipLocation(Ship enemyShip) {
        System.out.println("Computer Turn to sink the ships!");
        int coorX = (int) (Math.random() * 10);
        int coorY = (int) (Math.random() * 10);

        // 1. there is no ship in that location
        if(ocean.getShipAtLocation(coorX,coorY)==null) { // null, no ship in that location
            ocean.markOcean(coorX, coorY, "-");
            System.out.println("you are lucky!computer miss");
        }
        // 2. there is an enemy ship in that location
        else if(ocean.getShipAtLocation(coorX, coorY).equals("@")){ //@ is the location of the playerShip
            ocean.markOcean(coorX,coorY,"x");
            System.out.println("Boom! computer sunk your ship");
            enemyShip.shipCount--;  //this enabled us to access the shipCount attribute of the enemy ship(playerShip)
                                    //this reduced the enemy shipCount by one
        }
        // 3. guess its own coordinate
        else if(ocean.getShipAtLocation(coorX, coorY).equals("X")){ // X is location of own ship
            ocean.markOcean(coorX,coorY,"x");
            shipCount--;            // this reduce computerChipCount by one
            System.out.println("What!! Computer sunk its own ship!");
        }
        // 4. guessing the same coordinate again
        else{
            System.out.println("come on?! same location again, you can do better computer!");
        }
    }//end guessEnemyShipLocation
}//end ComputerShip
