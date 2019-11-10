/*
    Date: 11/09
    Author: Unknown

    Description:
    here will be implemented something cool
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import static java.lang.Math.*;

import org.apache.commons.collections4.iterators.CollatingIterator;

import javax.swing.text.html.Option;

public class mainScr {

    public final static int CM_CONST  = 123456;

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
        String stErr = switch (errorCode) {
            case 404 ->  "error 404";
            case 500 ->  "error 500";
            default -> getDefaultSwitch();
        };
        System.out.println(stErr);

        System.exit(2);
    }

    public static String getDefaultSwitch(){
        return "undefined";
    }
}
