package Exposition.Zals.Pracktis.Sorting;
//buble Sorting algoritm

import Exposition.Location.Exponate;
import Exposition.Location.Room;

import java.util.Random;

public class ExponatVstavkaSlid extends Exponate{
//      Setings
    public static int iLength = 1000;
    public static int iRange = 1000;
    public static int iTims = 1000;
//     Static  Varibles for work
    static int[] iNumbers = new int[iLength];
    static int  iTmp;
    static boolean  bContinue = false;

    public ExponatVstavkaSlid(Room rmRoom1, String sNewName, String newDescription){
        super( rmRoom1,   sNewName,  newDescription);
        //iLength = 10;
       // iRange = 1000;
        //iTims = 1;
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
        for (int i = 0; i < iTims; i++) {
            lStart = System.currentTimeMillis();
            iLastCicls= mainCicle();
            iSumCikls += iLastCicls;
            lEnd = System.currentTimeMillis();
            lSum += (lEnd - lStart);
        }
        System.out.println("Last cicle = " + iLastCicls);
        System.out.println("Averedg for " + iTims + " : " + (iSumCikls / iTims ));
        System.out.println("Procent of Length for " + iLength + " : " + ((iSumCikls / iTims)/iLength)*100 + "%");
        System.out.println("Last sorting Milisecunds = " + ( lEnd - lStart  ));
        System.out.println("Averedg sorting Milisecunds = " + (lSum / iTims ));
    }

    static void cicleForward(){
        for (int i = 0; i < iLength - 1; i++) {
            //System.out.print("Forward " + i + ": \t" );
            //printMatri();
            if (iNumbers[i] > iNumbers[i + 1]){
                iTmp = iNumbers[i];
                iNumbers[i] = iNumbers[i + 1];
                iNumbers[i + 1] = iTmp;
                cicleBack(i);
            }
        }
    }

    static void cicleBack(int bagen){
        for (int i = bagen; i >= 1; i--) {
            //System.out.print("Back " + i + "\t: \t" );
            //printMatri();
            if (iNumbers[i] < iNumbers[i - 1]){
                iTmp = iNumbers[i - 1];
                iNumbers[i - 1] = iNumbers[i];
                iNumbers[i] = iTmp;
            }else
                break;
        }
    }

    private int mainCicle(){
        initMatrix();
        //uncomment to print
        //printMatri();
        cicleForward();
         //   cicleBack();
        return 0;
    }

    private void initMatrix() {
        Random rGenerator =new Random();
        //seting random numbers
        for (int i = 0; i < iLength; i++) {
            iNumbers[i] = rGenerator.nextInt(iRange);
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
    //uncomment to print
//    printMatri(iNumbers);
//        sorting cicle
    counting:
    while (true) {
        bContinue = false;
        for (int i = 0; i < iLength - 1; i++) {
            if (iNumbers[i] > iNumbers[i + 1]){
                iTmp = iNumbers[i];
                iNumbers[i] = iNumbers[i + 1];
                iNumbers[i + 1] = iTmp;
                bContinue = true;
            }
        }
//        printMatri(iNumbers);
        if (bContinue != true) break counting;
        iCount++;
    }
    return iCount;
}


    public static void printMatri(){
        for (int i = 0; i < iNumbers.length; i++) {
            System.out.print(iNumbers[i] + "; ");
        }
        System.out.println("|");
    }

}
