/*
    Date: 11/09
    Author: Unknown

    Description:
    here will be implemented something cool
 */

import POCs.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.floorMod;

public class mainScr {

    private final static int CM_CONST  = 123456;

    public static void main(String[] args) {
        int a = 12;
        int[] iList={1,2,3,4,5,6,7};
        //make some logic here
        System.out.println("string3");
        System.out.println("[a] \u2192 " + a);
        System.out.println((float)mainScr.CM_CONST);
        System.out.println(Double.isInfinite(15/0.0));

        System.out.println(Arrays.stream(iList).filter((p)->p<5).max().getAsInt());
        int[] nList=Arrays.stream(iList).filter((p)->p<5).toArray();
        System.out.print(Arrays.toString(nList));
        Arrays.stream(nList).map((p)->p*2).forEach(System.out::print);

        System.out.println();
        System.out.println(-11%2);
        System.out.println(floorMod(-11,2));

        String str="hashdasda sadfsdaf sadf sadfsaf";

        System.out.println("abc".join("/","1234","456","789"));

        String str2="1234";
        String str3= Optional.ofNullable(str2).orElseGet(()->"");
        List strList= str3.codePoints().boxed().collect(Collectors.toList());

        String result =  str2
                .codePoints()
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        double d = 10_000 / 3.0;
        System.out.printf("%8.2f",d);
        System.out.println("BigNumbers test: "+BigDecimal.valueOf(10_000).divide(BigDecimal.valueOf(3.0), RoundingMode.CEILING));
        System.out.println();
       /* try
        {
            fileIO.readFile("C:\\java\\test.txt").forEach(System.out::println);
            fileIO.writeFile("C:\\java\\test.txt","some new row",false);
        }
        catch (IOException ex)
        {
            System.out.println("File IO error: "+ex.toString());
        }
        */
        int errorCode=501;
        int[] errorCodesPack={1,2,3,501};

        if (Arrays.stream(errorCodesPack).anyMatch(x->x==errorCode)){
            System.out.println("Error in errorPack");
        }

        String stErr = switch (errorCode) {
            case 404 ->  "error 404";
            case 500 ->  "error 500";
            case 501, 502 -> "error 50x";
            default -> getDefaultSwitch();
        };
        System.out.println(stErr);


        forBlock:
        for(int i=0;i<100;i++) {
            System.out.println(i);

            while (true) {
                break forBlock;
            }
        }

        for(int k : iList){
            System.out.println(k);
        }

        IntStream.range(0,iList.length).forEach((i)->System.out.println("Index: "+ i+", value: "+iList[i]));

        Map<Integer,Integer> map =
                IntStream.range(0,iList.length)
                        .boxed()
                        .collect(Collectors.toMap (i -> i, i -> iList[(int) i]));
        System.out.println(map);

        //array copying
        int[] nArray=Arrays.copyOf(iList,iList.length);
        Arrays.sort(nArray);
        int[][] mArray = new int[][]{{10,20},{40,50},{70,80,90}};
        int[][] mArray2 = new int[3][4];
        mArray2[1][2]=15;
        System.out.println(Arrays.deepToString(mArray));
        System.out.println(Arrays.deepToString(mArray2));

        //classSrc.getEmployees();
        //classSrc.getManagers();
        //classSrc.getMixed();
        //classSrc.getMixedArray();
        classSrc.getDiffPersons();

        Runtime.getRuntime().addShutdownHook(new Thread(()->logExit()));

        System.exit(2);
    }

    public static void logExit(){
        System.out.println("Exit logged");
    }

    public static String getDefaultSwitch(){
        return "undefined";
    }
}
