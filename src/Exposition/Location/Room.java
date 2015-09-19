package Exposition.Location;

import java.util.ArrayList;
import Exposition.Name;
import Exposition.Start;

public class Room extends Name {

    /**
     * extends from Exposition.Name
     * */
    private ArrayList <Doorway> alRoomWay = new ArrayList<Doorway>();
    private ArrayList <Exponate> alExponats = new ArrayList<Exponate>();
    //todo chege to Set
    //todo cheng to kay map to store all objects in room
    //todo фукции взятия и установки
    //todo проверкана уникальность элементов

    /**
     * Room construktors block
     * @param sNewName
     */
    public Room(String sNewName) {
        setName(sNewName);
    }
    public Room(String sNewName, Room rmRoom) {
        setName(sNewName);
        addWay(rmRoom);
    }
    /**
     * Block of privat metods adding and deleting objeckt fro arreilist
     *Adding and delating New  in Room with help of privat metods
     */
    //for doorways
    private void addDoorWay(Doorway dwNewWay){
        alRoomWay.add(dwNewWay);
    }
    private void delDoorWay(Doorway dwDoorToRemove){
        alRoomWay.remove(dwDoorToRemove);
    }
    //for Exponats
    private void addExponat(Exponate exponatNew){
        alExponats.add(exponatNew);
    }
    private void removExponat(Exponate exponatToRemove){
        alExponats.remove(exponatToRemove);
    }
    /**
     * Adding and delating New Exits in Room with help of privat metod addDoorWay
     * using addWay in addway whith name
     */
    public Doorway addWay(Room rmRoom) {
        Doorway dwNewWay = new Doorway(this, rmRoom);
        addDoorWay(dwNewWay);
        rmRoom.addDoorWay(dwNewWay);
        return dwNewWay;
    }

    public Doorway addWay(Room rmRoom, String sName){
        Doorway dwNewWay = addWay(rmRoom);
        dwNewWay.setName(sName);
        return dwNewWay;
    }
    public void delWay (Doorway dwDoorToRemove){
        alRoomWay.remove(dwDoorToRemove);
        if (dwDoorToRemove != null) dwDoorToRemove.getWay(this).delWay(dwDoorToRemove);
        dwDoorToRemove = null;
    }
     /**
     * Adding and delating New Exponats in Rooms
     */
    public Exponate setingExponat() {
        Exponate exponateNew = new Exponate(this);
        addExponat(exponateNew);
        return exponateNew;
    }
    public Exponate setingExponat(String sName) {
        Exponate exponateNew = setingExponat();
        exponateNew.setName(sName);
        return exponateNew;
    }

    public Exponate setingExponat(String sName, String sDiscrition) {
        Exponate exponateNew = setingExponat(sName);
        exponateNew.setDescription(sDiscrition);
        return exponateNew;
    }
    public Exponate setingExponat(Exponate exponateToADD) {
        addExponat(exponateToADD);
        return exponateToADD;
    }
    public void delatingExponat (Exponate exponateToDelating){
        removExponat(exponateToDelating);
    }

    /**
     * Reterns Exits from the room
     * @return sum of exits
     */
    public int lookWays (){
        for (int i = 0; i < alRoomWay.size() ; i++) {
            System.out.println((i+1)+". to " + alRoomWay.get(i).getWay(this).getName());
        }
        return alRoomWay.size();
    }
    /**
     * Returns Exponats in room
     * @return sum of exponats
     */
    public int lookExponats (){
        if (alExponats.size() == 0) {
            System.out.println("No Exponats here");
            return 0;
        }
        System.out.println("Exponats here:");
        for (int i = 0; i < alExponats.size() ; i++) {
            System.out.println((i+1)+"." + alExponats.get(i).getName());
        }
        return alRoomWay.size();
    }

    public int countExponats() {
        return alExponats.size();
    }

    public Exponate getExponate(int iWay){
        if (iWay > alExponats.size()) {
            System.out.println("No such exponat");
            return null;
        }
        return alExponats.get(iWay-1);
    }


    public Doorway getDoorWay(int iWay){
        if (iWay > alRoomWay.size()) {
            System.out.println("No way whear You wont to go! \n Choose another direction");
            return null;
        }
        return alRoomWay.get (iWay-1);
    }
}