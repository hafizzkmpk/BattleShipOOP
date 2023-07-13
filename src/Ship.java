public abstract class Ship { // using polymorphism

        int shipCount;
        String name;
        // all inheriting class will inherit an object reference to the OceanMap object. OceanMap object will
        // be pass to the constructor of child classes of Ship

        OceanMap ocean;
        public abstract void setShipCoordinate(); // place ship inside the 2D array (Array of String)
        public abstract int getShipCount(); // get the current number of ships
        public abstract String getShipName(); // get the ship name
        //public abstract String revealAllShipsCoordinate();
        public abstract void guessEnemyShipLocation(Ship enemyShip);    // this is ise to access the shipCount attribute
                                                                        // of another object enemy for playerShip is
                                                                        // ComputerShip and vice versa
}
