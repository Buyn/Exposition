package Exposition.Location;
import Exposition.Name;

public abstract class Location extends Name {
  // todo orientation

  private Room rmRoom;
  
  public Room getRoom(){
    return rmRoom;
  }
  
  public void setRoom (Room rmNewRoom){
    rmRoom = rmNewRoom;
  }

}
  