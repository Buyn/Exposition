package Exposition.Location;

public class Doorway extends Location {
    //  private Exposition.Exposition.Location.Room rmRoom1;
    private Room rmToRoom2;
//  private String sName;

    public Doorway(Room rmRoom1, Room rmRoom2, String sNewName) {
        setRoom(rmRoom1);
        this.rmToRoom2 = rmRoom2;
        setName(sNewName);
    }

    public Doorway(Room rmNewRoom1, Room rmNewRoom2) {
        setRoom(rmNewRoom1);
        this.rmToRoom2 = rmNewRoom2;
        setName("Nothing special");
    }

    public Room getWay(Room rmFrom){
        if (rmFrom == rmToRoom2) return this.getRoom();
        if (rmFrom == this.getRoom()) return rmToRoom2;
        System.out.println("You a not near to say ");
        return null;
    }

}
    