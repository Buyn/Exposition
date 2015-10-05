package Exposition.Zals.Pracktis.Sorting;
//buble Sorting algoritm

import Exposition.Location.Exponate;
import Exposition.Location.Room;

import java.util.Arrays;
import java.util.Random;

public class ExponatCopyMeargUnSorted extends Exponate{
//      Setings
    public static int iLength = 1000;
    public static int iRange = 1000;
    public static int iTims = 10000;
//names
    private static String nameExponat = "Merging unsorted";
    private static String discribExponat = " Merging too unSorted masivs, sortig thrm vith nativ sorting metod afte Merging";
//debuging
    private static boolean deBuging = false;
    private static boolean deBuging1 = false;

//     Static  Varibles for work
    static private int[] iNumbers =null;
    static private int[] matrix02 =null;
    static private int[] result =null;
    static private int  iTmp;
    static private boolean  bContinue = false;
    //varibls for sorting time cikle
    static private long startCikl = 0;
    static private long lastCikl = 0;
    static private long sumCikl   = 0;

    public ExponatCopyMeargUnSorted(Room rmRoom1, String sNewName, String newDescription){
        super( rmRoom1,   sNewName,  newDescription);
        bContinue = false;
    }

    public ExponatCopyMeargUnSorted(Room rmRoom1){
        this( rmRoom1,   nameExponat,  discribExponat);
    }
    public ExponatCopyMeargUnSorted(Room rmRoom1, int[] matrix01, int[] matrix02){
        this(rmRoom1);
        iNumbers        = matrix01;
        this.matrix02   = matrix02;
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
        System.out.println("Net sorting Total Milisecunds = " + sumCikl);
        System.out.println("Net Averedg sorting Milisecunds = " + (sumCikl / iTims ));
        System.out.println("Last Net sorting Milisecunds = " + (lSum / iTims ));
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

    private int mainCicle(){
        if (iNumbers == null && matrix02== null) initMatrix();
        if (deBuging){
            printMatri();
        }
        startCikl= System.currentTimeMillis();
        int count = SortAndMearg();
//        int count = cicleForward();
        if (deBuging){
            printMatri();
        }
        lastCikl = System.currentTimeMillis() - startCikl;
        sumCikl += lastCikl;
        iNumbers = null;
        matrix02 = null;
        return count;
    }

    private int SortAndMearg() {
        result = new int[iNumbers.length + matrix02.length];
        System.arraycopy(iNumbers, 0,result,0,iNumbers.length);
        System.arraycopy(matrix02, 0,result,iNumbers.length,matrix02.length);
        Arrays.sort(result);
        return 0;
    }

    private void initMatrix() {
        Random rGenerator =new Random();
        iNumbers = new int[iLength];
        //seting random numbers
        for (int i = 0; i < iLength; i++) {
            iNumbers[i] = rGenerator.nextInt(iRange);
        }
        //matrix02
        iTmp = 0;
        while (iTmp <= 1) iTmp = rGenerator.nextInt(iLength);
        matrix02 = new int[iTmp];
        for (int i = 0; i < matrix02.length; i++) {
            matrix02[i] = rGenerator.nextInt(iRange);
        }

    }


    public static void printMatri(){
        System.out.print("iNumbers |");
        for (int i = 0; i < iNumbers.length; i++) {
            System.out.print(iNumbers[i] + "; ");
        }
        System.out.println("|");
        System.out.print("matrix02 |");
        for (int i = 0; i < matrix02.length; i++) {

            System.out.print(matrix02[i] + "; ");
        }
        System.out.println("|");
        System.out.print("result |");
        if (result != null && result.length > 0 ){
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + "; ");
            }
            System.out.println("|");
        }
    }

}
