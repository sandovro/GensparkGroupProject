import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void printList(ArrayList<String> newList){
        int numElements = 0;

        if (newList.size()<=19)
            numElements = 4;
        else
            numElements = 9;

        // Print elements in column format
        for (int i=0;i<numElements;i++) {
            for (int c=i;c<newList.size();c+=numElements){
                System.out.printf("%-20s",newList.get(c));
            }
            System.out.print("\n");
        }
    }

    public static HashMap<String,Integer> strToIntMap() {
        HashMap<String, Integer> newMap = new HashMap<>();
        newMap.put("Zero",0);
        newMap.put("One",1);
        newMap.put("Two",2);
        newMap.put("Three",3);
        newMap.put("Four",4);
        newMap.put("Five",5);
        newMap.put("Six",6);
        newMap.put("Seven",7);
        newMap.put("Eight",8);
        newMap.put("Nine",9);
        newMap.put("Ten",10);
        newMap.put("Eleven",11);
        newMap.put("Twelve",12);
        newMap.put("Thirteen",13);
        newMap.put("Fourteen",14);
        newMap.put("Fifteen",15);
        newMap.put("Sixteen",16);
        newMap.put("Seventeen",17);
        newMap.put("Eighteen",18);
        newMap.put("Nineteen",19);
        newMap.put("Twenty",20);
        newMap.put("Thirty",30);
        newMap.put("Forty",40);
        newMap.put("Fifty",50);
        newMap.put("Sixty",60);
        newMap.put("Seventy",70);
        newMap.put("Eighty",80);
        newMap.put("Ninety",90);
        newMap.put("Hundred",100);
        newMap.put("Thousand",1000);
        newMap.put("Million",1000000);
        newMap.put("Billion",1000000000);

        return newMap;
    }

    public static HashMap<Integer,String> intToStrMap() {
        HashMap<Integer, String> newMap = new HashMap<>();
        newMap.put(0,"Zero");
        newMap.put(1,"One");
        newMap.put(2,"Two");
        newMap.put(3,"Three");
        newMap.put(4,"Four");
        newMap.put(5,"Five");
        newMap.put(6,"Six");
        newMap.put(7,"Seven");
        newMap.put(8,"Eight");
        newMap.put(9,"Nine");
        newMap.put(10,"Ten");
        newMap.put(11,"Eleven");
        newMap.put(12,"Twelve");
        newMap.put(13,"Thirteen");
        newMap.put(14,"Fourteen");
        newMap.put(15,"Fifteen");
        newMap.put(16,"Sixteen");
        newMap.put(17,"Seventeen");
        newMap.put(18,"Eighteen");
        newMap.put(19,"Nineteen");
        newMap.put(20,"Twenty");
        newMap.put(30,"Thirty");
        newMap.put(40,"Forty");
        newMap.put(50,"Fifty");
        newMap.put(60,"Sixty");
        newMap.put(70,"Seventy");
        newMap.put(80,"Eighty");
        newMap.put(90,"Ninety");
        newMap.put(100,"Hundred");
        newMap.put(1000,"Thousand");
        newMap.put(1000000, "Million");
        newMap.put(1000000000, "Billion");

        return newMap;
    }

    public static ArrayList<Integer> convertListToInt(ArrayList<String> newList){
        ArrayList<Integer> toSort = new ArrayList<>();

        HashMap<String, Integer> newMap = strToIntMap();

        for (var c:newList){
            if (newMap.containsKey(c))
                toSort.add(newMap.get(c));
            else {
                int res = 0;
                String[] splitStr = c.split("\\s+");

                if(splitStr.length==2){
                    int first = newMap.get(splitStr[0]);
                    int second = newMap.get(splitStr[1]);
                    if (first>=20)
                        res = first+second;
                    else
                        res = first*second;
                    toSort.add(res);
                } else if(splitStr.length==3) {
                    int first = newMap.get(splitStr[0]);
                    int second = newMap.get(splitStr[1]);
                    int third = newMap.get(splitStr[2]);
                    res = first*second+third;
                    toSort.add(res);
                } else if (splitStr.length==4){
                    int first = newMap.get(splitStr[0]);
                    int second = newMap.get(splitStr[1]);
                    int third = newMap.get(splitStr[2]);
                    int fourth = newMap.get(splitStr[3]);
                    res = first*second+third+fourth;
                    toSort.add(res);
                } else if (splitStr.length==5){
                    int first = newMap.get(splitStr[0])*newMap.get(splitStr[1]);
                    int second = newMap.get(splitStr[2])*newMap.get(splitStr[3]);
                    int third = newMap.get(splitStr[4]);
                    res = first+second+third;
                    toSort.add(res);
                } else if (splitStr.length==6){
                    int first = newMap.get(splitStr[0])*newMap.get(splitStr[1]);
                    int second = newMap.get(splitStr[2])*newMap.get(splitStr[3]);
                    int third = newMap.get(splitStr[4])+newMap.get(splitStr[5]);
                    res = first+second+third;
                    toSort.add(res);
                } else if (splitStr.length==7){
                    int first = newMap.get(splitStr[0])*newMap.get(splitStr[1]);
                    int second = newMap.get(splitStr[2])*newMap.get(splitStr[3]);
                    int third = newMap.get(splitStr[4])*newMap.get(splitStr[5]);
                    int fourth = newMap.get(splitStr[6]);
                    res = first+second+third+fourth;
                    toSort.add(res);
                } else if (splitStr.length==8){
                    int first = newMap.get(splitStr[0])*newMap.get(splitStr[1]);
                    int second = newMap.get(splitStr[2])*newMap.get(splitStr[3]);
                    int third = newMap.get(splitStr[4])*newMap.get(splitStr[5]);
                    int fourth = newMap.get(splitStr[6])+newMap.get(splitStr[7]);
                    res = first+second+third+fourth;
                    toSort.add(res);
                }
            }
        }

        Collections.sort(toSort);

        return toSort;
    }

    public static ArrayList<String> reverseToString(ArrayList<Integer> holdList){
        ArrayList<String> resList = new ArrayList<>();

        HashMap<Integer,String> newMap = intToStrMap();

        for(var c:holdList) {
            String hold = "";
            if (newMap.containsKey(c)&&c<=19)
                resList.add(newMap.get(c));
            else {
                String holdInt = String.valueOf(c);

                if (c>=20&&c<100) {
                    hold=getTens(c);
                }
                // 199
                 else if(c>=100&&c<=999){
                    hold=getHundreds(c);

                } else if (c>=1000&&c<=9999){
                    hold+=newMap.get(Character.getNumericValue(holdInt.charAt(0)));
                    hold+=" Thousand ";

                    String holdStr = String.valueOf(holdInt.charAt(1))+String.valueOf(holdInt.charAt(2))+holdInt.charAt(3);
                    hold+=getHundreds(Integer.valueOf(holdStr));
                } else if (c>=10000&&c<=99999){
                    String holdStr = String.valueOf(holdInt.charAt(0))+holdInt.charAt(1);
                    hold+=getTens(Integer.valueOf(holdStr));
                    hold += " Thousand ";

                    holdStr=String.valueOf(holdInt.charAt(2))+String.valueOf(holdInt.charAt(3))+holdInt.charAt(4);
                    hold+=getHundreds(Integer.valueOf(holdStr));
                } else if (c>=100000&&c<=999999){
                    String holdStr = String.valueOf(holdInt.charAt(0)+String.valueOf(holdInt.charAt(1))+holdInt.charAt(2));
                    hold+=getHundreds(Integer.valueOf(holdStr));
                    hold += " Thousand ";

                    holdStr=String.valueOf(holdInt.charAt(3))+String.valueOf(holdInt.charAt(4))+holdInt.charAt(5);
                    hold+=getHundreds(Integer.valueOf(holdStr));
                } else if (c>=1000000&&c<=9999999){
                     // 1,001,007
                    hold+=newMap.get(Character.getNumericValue(holdInt.charAt(0)));
                    hold+=" Million ";

                    String holdStr = String.valueOf(holdInt.charAt(1))+String.valueOf(holdInt.charAt(2))+holdInt.charAt(3);
                    hold+=getHundreds(Integer.valueOf(holdStr));
                    hold += " Thousand ";

                    holdStr=String.valueOf(holdInt.charAt(4))+String.valueOf(holdInt.charAt(5))+holdInt.charAt(6);
                    hold+=getHundreds(Integer.valueOf(holdStr));
                } else if (c>=10000000&&c<=99999999) {
                    String holdStr = String.valueOf(holdInt.charAt(0))+holdInt.charAt(1);
                    hold+=getTens(Integer.valueOf(holdStr));
                    hold += " Million ";

                    holdStr = String.valueOf(holdInt.charAt(2))+String.valueOf(holdInt.charAt(3))+holdInt.charAt(4);
                    hold += getHundreds(Integer.valueOf(holdStr));
                    hold += " Thousand ";

                    holdStr = String.valueOf(holdInt.charAt(5))+String.valueOf(holdInt.charAt(6))+holdInt.charAt(7);
                    hold += getHundreds(Integer.valueOf(holdStr));
                } else if (c>=100000000&&c<=999999999) {
                    String holdStr = String.valueOf(holdInt.charAt(0))+String.valueOf(holdInt.charAt(1))+holdInt.charAt(2);
                    hold += getHundreds(Integer.valueOf(holdStr));
                    hold += " Million ";

                    holdStr = String.valueOf(holdInt.charAt(3))+String.valueOf(holdInt.charAt(4))+holdInt.charAt(5);
                    hold += getHundreds(Integer.valueOf(holdStr));
                    hold += " Thousand ";

                    holdStr = String.valueOf(holdInt.charAt(6))+String.valueOf(holdInt.charAt(7))+holdInt.charAt(8);
                    hold += getHundreds(Integer.valueOf(holdStr));
                }
                resList.add(hold);
            }
        }
        return resList;
    }

    public static String getTens(Integer newInt){
        HashMap<Integer,String> newMap = intToStrMap();
        String hold = "";
        String holdInt = String.valueOf(newInt);

        if (holdInt.length()==2) {

            hold += newMap.get(Character.getNumericValue(holdInt.charAt(0)) * 10);

            if (holdInt.charAt(1) != '0') {
                hold += " ";
                hold += newMap.get(Character.getNumericValue(holdInt.charAt(1)));
            }
        } else
            hold += newMap.get(Character.getNumericValue(holdInt.charAt(0)));

        return hold;
    }

    public static String getHundreds(Integer newInt){
        HashMap<Integer,String> newMap = intToStrMap();
        String hold = "";
        String holdInt = String.valueOf(newInt);

        if (holdInt.length()==3) {
            hold += newMap.get(Character.getNumericValue(holdInt.charAt(0)));
            hold += " Hundred";

            if (holdInt.charAt(1) != '0') {
                hold += " ";
                hold += newMap.get(Character.getNumericValue(holdInt.charAt(1)) * 10);
            }
            if (holdInt.charAt(2) != '0') {
                hold += " ";
                hold += newMap.get(Character.getNumericValue(holdInt.charAt(2)));
            }
        } else if (holdInt.length()==2) {
            hold += newMap.get(Character.getNumericValue(holdInt.charAt(0)) * 10);

            if (holdInt.charAt(1) != '0') {
                hold += " ";
                hold += newMap.get(Character.getNumericValue(holdInt.charAt(1)));
            }
        } else
            hold += newMap.get(Character.getNumericValue(holdInt.charAt(0)));

        return hold;
    }

    public static ArrayList<String> sortList(ArrayList<String> listToSort){
        // Call sortList method to sort ArrayList. Parameters: ArrayList<String>
        ArrayList<Integer> sortedList = convertListToInt(listToSort);

        // Call reverseToString method to reverse sorted Integer list back to String. Parameters: ArrayList<Integer>
        ArrayList<String> resList = reverseToString(sortedList);

        return resList;
    }
    public static void main(String[] args) {
        // Declare ArrayList to hold items from file
        ArrayList<String> newList = new ArrayList<>();

        try {
            // Load file and pass it to Scanner for processing
            File file = new File("./src/input.txt");
            Scanner scanner = new Scanner(file);

            // Get each line from file and add it to ArrayLust
            while (scanner.hasNextLine()) {
                newList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // Call sortList method to sort ArrayList. Parameters: ArrayList<String>
        ArrayList<String> resList = sortList(newList);

        // Call printList method to print ArrayList in desired format. Parameters: ArrayList<String>
        printList(resList);
    }
}