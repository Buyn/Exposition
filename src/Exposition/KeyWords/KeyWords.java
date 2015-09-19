package Exposition.KeyWords;

/**
 * Created by Browser on 21.07.14.
 */
public enum KeyWords {
    EXIT,
    SAY,
    LOOK,
    L,
    MOVETO,
    MT,
    M,
    NOTFOUND,
    PICKUP,
    USE,
    U,
    EXAMINE,
    E;


    public  KeyWords ifValue (String sCommand){
        if (sCommand != null)
            try {
                return this.valueOf(sCommand.toUpperCase());
            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
                return NOTFOUND;
            }
        return NOTFOUND;

    }
}