package sweeper;

 class Flag {

     private Matrix mapFlag;
     private int countOfClosedBoxes;

     void start(){

         mapFlag = new Matrix(Box.CLOSED);
         countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;
     }
     Box get (Coord coord){

         return mapFlag.get(coord);
     }

      void setOpenedToBox(Coord coord) {

       mapFlag.set (coord, Box.OPENED);
       countOfClosedBoxes--;
     }

      void toggleFlagedToBox(Coord coord){


         switch (mapFlag.get(coord)){
             case FLAGED: setClosedToBox(coord);break;
             case CLOSED: setFlagedToBox(coord);break;
         }

      }

     private void setClosedToBox(Coord coord) {

         mapFlag.set (coord, Box.CLOSED);
     }

     private void setFlagedToBox(Coord coord) {

         mapFlag.set (coord, Box.FLAGED);
     }

    int getCountOfClosesBoxes() {

         return countOfClosedBoxes;
     }

      void setBombedToBox(Coord coord) {

         mapFlag.set(coord, Box.BOMBED);
     }

     void setOpenedToClosedBombBox(Coord coord) {

        if(mapFlag.get(coord) == Box.CLOSED)
            mapFlag.set(coord, Box.OPENED);
     }

     void setNoBombToFlagedSafeBox(Coord coord) {

        if( mapFlag.get(coord) == Box.FLAGED)
            mapFlag.set(coord, Box.NOBOMB);
     }

      int getCountOfFlagedBoxesAround(Coord coord) {
         int count = 0;
         for( Coord around : Ranges.getCoordAround(coord) )
             if(mapFlag.get(around) == Box.FLAGED )
                 count++;
         return count;
     }
 }
