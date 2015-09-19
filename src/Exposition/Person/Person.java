package Exposition.Person;

import Exposition.Location.Exponate;
import Exposition.Location.Location;
import Exposition.Location.Room;

public class Person extends Location {

//    private Room rmRoom;
    private int fockus = 0;

    public Person(String sNewName, Room rmLocal) {
        super.setName(sNewName);
        setRoom(rmLocal);
    }


    public void say(String sText) {
        System.out.println(this.getName() + " say - \"" + sText + "\"");
    }

    public void say(String[] sTexts) {
        if (sTexts == null) return;
        StringBuffer sbText = new StringBuffer();
        for (int i = (sTexts[0].equalsIgnoreCase("say") ? 1 : 0) ; i < sTexts.length; i++) {
            sbText.append(sTexts[i]);
            if (sTexts.length != i-1) sbText.append(" ");
        }
        this.say(sbText.toString());
    }

    public void look() {
        System.out.println(this.getName() + " look around ");
        System.out.println("You are in " + this.getRoom().getName());
        this.getRoom().lookExponats();
        System.out.println("Ways from hear ");
        this.getRoom().lookWays();
    }

    /**
     * Examin function using  metod in exponat class
     * to see discription
     * and change propertis
     */
    public Exponate examin(int iObjeckt) {
        if (iObjeckt <= 0 || this.getRoom().countExponats() < iObjeckt) {
            System.out.println("No such exponat!");
            return null;
        }
        Exponate exObject = null;
        try {
            exObject = this.getRoom().getExponate(iObjeckt);//  For too easy undestend kod
            System.out.println(this.getName() + " examine " + exObject.getName());
            System.out.println(exObject.getName());
            System.out.println(exObject.getDescription());
        } catch (NullPointerException e) {
            look();
            return exObject;
        }
        setFockus(iObjeckt);
        System.out.println(this.getName() + " fockused on " + exObject.getName());
        return exObject;
    }

    /**
     * Using function in exponant class
     */
    public Exponate use(int iObjeckt) {
        if (iObjeckt <= 0 || this.getRoom().countExponats() < iObjeckt) {
            System.out.println("No such exponat!");
            return null;
        }
        Exponate exObject = null;
        try {
            exObject = this.getRoom().getExponate(iObjeckt); //  too easy undestend kod
            System.out.println(this.getName() + " try to use " + exObject.getName());
            exObject.useObjekt();
        } catch (NullPointerException e) {
            look();
            return exObject;
        }
        System.out.println(this.getName() + " end using "+ exObject.getName());
        return exObject;
    }

    public Room moveTo(int iDoor){
        if (iDoor <= 0) {
            System.out.println("No such room!");
            return null;
        }
        System.out.println("Moving...");
        setFockus(0);
        // спрашиваем у комнаты дверь под номером, а затем удвери - в каую комноту она ведёт если мы в такоойто
        try {
            setRoom(this.getRoom().getDoorWay(iDoor).getWay(getRoom()));
        } catch (NullPointerException e) {
            look();
            return getRoom();
//            e.printStackTrace();
        }
        System.out.println("You are enter in " + getRoom().getName());
        look();
        return getRoom();
    }

    public void setFockus(int fockus) {
        this.fockus = fockus;
    }
    public int getFockus() {
        return fockus;
    }

    public boolean use() {
        if (getFockus()>0){
            use(getFockus());
            return true;
        }
        return false;
    }

    public boolean examin() {
        if (getFockus()>0){
            examin(getFockus());
            return true;
        }
        return false;
    }
}
  
