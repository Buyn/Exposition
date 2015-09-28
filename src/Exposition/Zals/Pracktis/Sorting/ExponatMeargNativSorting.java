package Exposition.Zals.Pracktis.Sorting;
//buble Sorting algoritm

import Exposition.Location.Exponate;
import Exposition.Location.Room;

import java.util.Arrays;
import java.util.Random;

public class ExponatMeargNativSorting extends Exponate{
//      Setings
    public static int iLength = 1000;
    public static int iRange = 1000;
    public static int iTims = 1000;
//names
    private static String nameExponat = "Merget sorted";
    private static String discribExponat = "Sorted Merging too masivs, sortit vith nativ sorting metod";
//debuging
    private static boolean deBuging = false;
    private static boolean deBuging1 = false;

//     Static  Varibles for work
    static private int[] iNumbers ;
    static private int[] matrix02 ;
    static private int  iTmp;
    static private boolean  bContinue = false;
//varibls for sorting time cikle
    static private long lStart = 0;
    static private long lEnd   = 0;
    static private long lSum   = 0;

    public ExponatMeargNativSorting(Room rmRoom1, String sNewName, String newDescription){
        super( rmRoom1,   sNewName,  newDescription);
        bContinue = false;
    }

    public ExponatMeargNativSorting(Room rmRoom1){
        this( rmRoom1,   nameExponat,  discribExponat);
    }
    public ExponatMeargNativSorting(Room rmRoom1, int[] matrix01, int[] matrix02){
        this(rmRoom1);
        iNumbers        = matrix01;
        this.matrix02   = matrix02;
    }

//    @Override
    public  void useObjekt() {
        if (iNumbers == null) iNumbers = new int[iLength];
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
        //netSorting
        //averwg netSorting
    }

    static int cicleForward(){
        int count =0;
        if (iNumbers[0] > iNumbers[1]){
            iTmp = iNumbers[0];
            iNumbers[0] = iNumbers[1];
            iNumbers[1] = iTmp;
            if (deBuging){
                System.out.print("Forward " + 0 + ": \t" );
                printMatri();
            }
        }
        for (int i = 1; i < iNumbers.length - 1; i++) {
            if (iNumbers[i] >= iNumbers[i + 1] && iNumbers[i-1] <= iNumbers[i + 1]){
                iTmp = iNumbers[i];
                iNumbers[i] = iNumbers[i + 1];
                iNumbers[i + 1] = iTmp;
                if (deBuging){
                    System.out.print("Forward " + i + ": \t" );
                    printMatri();
                }
            }
            if (iNumbers[i] > iNumbers[i + 1]){
                count++;
                pastBetwin(Arrays.binarySearch( //find where to past
                                iNumbers,       //From  arrey
                                0,              //From index
                                i,              //To index
                                iNumbers[i + 1]),   //Kay to search
                        //end arg for benarySearch
                        i + 1);             //index element to repast
                if (deBuging){
                    System.out.print("Forward " + i + ": \t" );
                    printMatri();
                }
            }
        }
        return count;
    }
//todo System.out.print(Arrays.toString)
//todo how debag information outing

    /**
     * function coping element forward from target position
     * to element position
     * on one element and placing element to empty space
     * @param target index  for  placing
     *               minus mean element not found end mast be placid in this index
     * @param element index  what be placid
     */
    private static void pastBetwin(int target, int element) {
        if (target ==0) target++;
        if (target <0) target = Math.abs(target) - 1;
        if (deBuging1){
            System.out.println(element + " : " + iNumbers[element] + " bagen pastBetwin " + target + " : \t" + iNumbers[target]);
            printMatri();
        }
        iTmp = iNumbers[element]; //save beafo copybg
        System.arraycopy(   iNumbers,   //From  arrey
                            target,     //From index
                            iNumbers,   //To  arrey
                            target+1,   //Index to past
                (element - target));//How many.
        iNumbers[target]=iTmp; //past in empty place
        if (deBuging1){
            System.out.println(element + " : " + iNumbers[element] + " End pastBetwin " + target + " : \t" + iNumbers[target]);
            printMatri();
        }

    }
    /**
     * Mostli not working
     *  first see found  or not
     *  if not then determing wher to jump
     *  and trying agean
     * @param indexSearch index to cheak betwin
     * @param indexElement index of elememt for comparing
     * @return index of sugested gess
     */
    private static int pastBinarSearch(int indexSearch , int  indexElement) {
        //if it eql one then return
        if (deBuging1){
                System.out.println(indexSearch);
                System.out.println(indexElement);
        }
        if (indexSearch == 0)return indexSearch;
        if (iNumbers[indexElement] == iNumbers[indexSearch + 1]
                ||iNumbers[indexSearch - 1] == iNumbers[indexElement])
            return indexSearch;
        //if it in bonds then return
        if (iNumbers[indexSearch - 1] <= iNumbers[indexElement] &&
                iNumbers[indexElement] <= iNumbers[indexSearch + 1])
            return indexSearch;
        //if not then deside in which side need to go
        if (iNumbers[indexElement - 1] < iNumbers[indexElement]) {
            return pastBinarSearch(indexSearch / 2, indexElement);
        }
        return pastBinarSearch((iNumbers.length - indexSearch) / 2, indexElement);
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
        if (deBuging){
            printMatri();
        }

        int count = cicleForward();
        if (deBuging){
            printMatri();
        }
        return count;
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
