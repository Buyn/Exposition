package Exposition.Zals.Pracktis.Sorting;
//buble Sorting algoritm
//todo сортировак используяшая сортировку пузырьком и выборочную с одноврменым обменом наибольшенр и наименьшего
// todo чередовать напрвление пузырька
import Exposition.Location.Exponate;
import Exposition.Location.Room;

import java.util.Date;
import java.util.Random;

public class ExponatPuzirBarer extends Exponate{
//      Setings
    public static int iLength = 10;
    public static int iRange = 1000;
    public static int iTims = 1;
//     Static  Varibles for work
    static int  iTmp;
    static boolean  bContinue = false;

    public ExponatPuzirBarer(Room rmRoom1, String sNewName, String newDescription){
        super( rmRoom1,   sNewName,  newDescription);
//     Static  Varibles for work
        bContinue = false;
    }

//    @Override
    public  void useObjekt() {
        double iLastCicls   = 0;
        double iSumCikls    = 0;
        long lStart = 0;
        long lEnd   = 0;
        long lSum   = 0;
        for (int i = 0; i <= iTims; i++) {
            lStart = System.currentTimeMillis();
            iLastCicls= countCicls();
            iSumCikls += iLastCicls;
            lEnd = System.currentTimeMillis();
            lSum += (lEnd - lStart);
        }
        System.out.println("Last cicle = " + iLastCicls);
        System.out.println("Averedg for " + iTims + " : " + (iSumCikls / iTims));
        System.out.println("Procent of Length for " + iLength + " : " + ((iSumCikls / iTims)/iLength)*100 + "%");
        System.out.println("Last sorting Milisecunds = " + ( lEnd - lStart  ));
        System.out.println("Averedg sorting Milisecunds = " + (lSum / iTims));
    }

    static void cicleForward(int[] iNumbers){
        for (int i = 0; i < iLength - 1; i++) {
            if (iNumbers[i] > iNumbers[i + 1]){
                iTmp = iNumbers[i];
                iNumbers[i] = iNumbers[i + 1];
                iNumbers[i + 1] = iTmp;
                bContinue = true;
            }
        }
    }
    static void cicleBack(int[] iNumbers){
        for (int i = iLength; i >= 1; i--) {
            if (iNumbers[i] < iNumbers[i - 1]){
                iTmp = iNumbers[i - 1];
                iNumbers[i - 1] = iNumbers[i];
                iNumbers[i] = iTmp;
                bContinue = true;
            }
        }
    }

public static int countCicls(){
    int iCount =0;

    Random rGenerator =new Random();
    int[] iNumbers = new int[iLength];
    //seting random numbers
    for (int i = 0; i < iLength; i++) {
        iNumbers[i] = rGenerator.nextInt(iRange);
    }
    printMatri(iNumbers);
//        sorting cicle
    int barier = iLength -1;
    counting:
    while (true) {
        bContinue = false;
        for (int i = 0; i < barier; i++) {
            if (iNumbers[i] > iNumbers[i + 1]){
                iTmp = iNumbers[i];
                iNumbers[i] = iNumbers[i + 1];
                iNumbers[i + 1] = iTmp;
                bContinue = true;
            }
        }
        System.out.print(barier+" : ");
        barier--;
        printMatri(iNumbers);
        if (bContinue != true) break counting;
        iCount++;
    }
    return iCount;
}

    public static void printMatri(int[] iNubers){
        for (int i = 0; i < iNubers.length; i++) {
            System.out.print(iNubers[i] + "; ");
        }
        System.out.println("|");
    }
}
