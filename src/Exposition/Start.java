package Exposition;

import Exposition.KeyWords.KeyWords;
import Exposition.Location.Exponate;
import Exposition.Location.Room;
import Exposition.Person.Person;
import Exposition.Zals.Pracktis.Sorting.ExponatPuzir;
import Exposition.Zals.Pracktis.Sorting.ExponatVstavka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//git hub addet
public class Start {
    public static void main(String[] args) throws Exception {
        BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
        Room rmHall = new Room("Big hall");
        rmHall.setingExponat("Table", "It flate");
        rmHall.setingExponat(new ExponatVstavka(rmHall
                , "Sorting Vstavka", "Sorting with back puzir Vstavka metod"));
        Room rmCooridor = new Room("Cooridor", rmHall);
        Room rmSmollHall = new Room("Smoll Hall", rmHall);
        Room rmSortig = new Room("Sorting Eksposition", rmHall);
        //Sorting Eksposition
        rmSortig.setingExponat(new ExponatPuzir(rmSortig
                , "Puzir Sorting", "Sorting with Puzir metod"));
        //rooms for Smoll Hall
        Room rmSleeping = new Room("Sleeping Room", rmSmollHall);
        Room rmWorkshop = new Room("Workshop", rmSmollHall);
        //rooms for Cooridor
        Room rmGestRoom = new Room("Gest room", rmCooridor);
        Room rmKitchen = new Room("Kitchen" , rmCooridor);
        Room rmBath = new Room("Bath" , rmCooridor);
        Room rmWC = new Room("WC" , rmCooridor);

        System.out.println("Enter You Name:");
        Person prPC = new Person(brReader.readLine(), rmHall);
        Person prMax = new Person("Max", rmHall);

        if (prPC == null || prPC.getName().equals("") || prPC.getName().equals(" ")) {
        prPC = prMax;
        }

        prPC.say("Hello world");
        prntLn(prPC.getName() + " in " + prPC.getRoom().getName());

        String sTmp = "";
        KeyWords kwEntr = KeyWords.NOTFOUND;
        String [] sCommands = new String[0];
         while (true)  {
             sTmp =brReader.readLine();
             sCommands = sTmp.split("\\s");
             if (sCommands[0] == null || sCommands.length == 0) {
                 continue;
             }
            switch (kwEntr.ifValue(sCommands[0])) {
                case EXIT:
                    return;
                case SAY:
                    if (sCommands.length >= 2) prPC.say(sCommands);
                    break;
                case LOOK:
                case L:
                    prPC.look();
                    break;
                case USE:
                case U:
                    if (sCommands != null && sCommands.length >= 2 &&  sCommands[1] !=null )
                        try {
                            prPC.use(Integer.parseInt(sCommands[1]));
                        }
                        catch (NumberFormatException e){
                            if (prPC.use())continue;
                            System.out.println("Not understand what You wont to use");
                        }
                    prPC.use();
                    break;
                case EXAMINE:
                case E:
                    if (sCommands != null && sCommands.length >= 2 &&  sCommands[1] !=null )
                        try {
                            prPC.examin(Integer.parseInt(sCommands[1]));
                        }
                        catch (NumberFormatException e){
                            if (prPC.examin())continue;
                            System.out.println("Not understand what You wont to examin");
                        }
                    prPC.examin();
                    break;
                case MOVETO:
                case MT:
                case M:
                    if (sCommands != null && sCommands.length >= 2 &&  sCommands[1] !=null )
                        try {
                            prPC.moveTo(Integer.parseInt(sCommands[1]));
                        }
                        catch (NumberFormatException e){
                            System.out.println("Not understand whear You wont to go");
                        }
                    break;
                default:
                    System.out.println("Do not understand! \nTry Again");
                    break;
            }

         }

    }

    static private void mapBilder(){

    }

    static public void  prntLn(String sLine) {
        System.out.println(sLine);
    }
    static public void prnt(String sLine) {
        System.out.print(sLine);
    }
//todo new class raice - human elf ghost

    
}