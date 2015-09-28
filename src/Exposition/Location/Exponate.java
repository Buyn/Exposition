package Exposition.Location;

public class Exponate extends Location {
    //  private Exposition.Exposition.Location.Room rmRoom1;
    private String sDescription;

    public Exponate(Room rmRoom1,  String sNewName) {
        this(rmRoom1);
        this.setName(sNewName);
        setDescription("End of description");
    }

    public Exponate(Room rmRoom1,  String sNewName, String newDescription) {
        this(rmRoom1);
        if (!rmRoom1.getExponate(this)) rmRoom1.setingExponat(this);
        this.setName(sNewName);
        this.setDescription(newDescription);
    }

    public Exponate(Room rmNewRoom1) {
        setRoom(rmNewRoom1);
        setName("Nothing special");
        setDescription("End of description");
    }

    public void useObjekt(){
        System.out.println("Using " + getName());
        System.out.println("Nothing Hapend");
    }
    public void examineObjekt(){
        System.out.println(getName());
        System.out.println(getDescription());
    }


    public void setDescription(String newDescription){
        this.sDescription =newDescription;
    }
    public String getDescription() {
        return sDescription;
    }
}
    