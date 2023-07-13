public class OceanMap {

    public String[][] ocean;
    OceanMap(){
         this.ocean= new String[10][10];    // - initialise 2x2 null string array 10-col and 10-row
                                            // - because the value is not initialised, the value will be set to null
    }//end oceanMap Constructor;

    // - using this method to create a map to the console based on the value present in the array
    // - null element will result in an empty space being printed to the console
    // - if a character is present at the location, the character will be displayed to the console instead
    // - this method create a 2D map, at the start, it will be an empty 2D map
    public void printMap() {
        System.out.println("  0123456789  ");
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(row + "|");            //  -printing row number follow by |, eg. 1|
            for (int col = 0; col < 10; col++) {    // - accessing the column element
                if (ocean[row][col] == null) {      // - for every null element in the string array
                    System.out.print(" ");          //   print an empty string to the console
                } else {
                    System.out.print(ocean[row][col]);  // - other than that print what ever value we have set at that
                }                                       //   location or found in that location to the console
            }
            System.out.println("|" + row);          // - end the row with | and row number eg. |1
        }
        System.out.println("  0123456789  ");       // -
    }//end of print map
    public boolean isEmpty(int coorX,int coorY){    // - Checking whether the location is null or is there any character
        return ocean[coorX][coorY] == null;         //   present at the location
    }//end isEmpty
    public void markOcean(int coorX,int coorY,String marks){    // - This method will insert/replace/fill  specified
        ocean[coorX][coorY]=marks;                              // - character/marks (X,x,!,-,@ etc..)  and
    }//end MarkOcean                                            // - the specified location

    public String getShipAtLocation(int coorX,int coorY){       // - get the character/type of ships(Computer/player)
        return ocean[coorX][coorY];                             // - even null value at the specified location
    }
}//end OceanMap
