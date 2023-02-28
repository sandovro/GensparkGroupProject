import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void strToIntMapTest() {
        // Arrange
        HashMap<String, Integer> expectedOutput = new HashMap<>();

        // Act
        expectedOutput.put("Zero",0);
        expectedOutput.put("One",1);
        expectedOutput.put("Two",2);
        expectedOutput.put("Three",3);
        expectedOutput.put("Four",4);
        expectedOutput.put("Five",5);
        expectedOutput.put("Six",6);
        expectedOutput.put("Seven",7);
        expectedOutput.put("Eight",8);
        expectedOutput.put("Nine",9);
        expectedOutput.put("Ten",10);
        expectedOutput.put("Eleven",11);
        expectedOutput.put("Twelve",12);
        expectedOutput.put("Thirteen",13);
        expectedOutput.put("Fourteen",14);
        expectedOutput.put("Fifteen",15);
        expectedOutput.put("Sixteen",16);
        expectedOutput.put("Seventeen",17);
        expectedOutput.put("Eighteen",18);
        expectedOutput.put("Nineteen",19);
        expectedOutput.put("Twenty",20);
        expectedOutput.put("Thirty",30);
        expectedOutput.put("Forty",40);
        expectedOutput.put("Fifty",50);
        expectedOutput.put("Sixty",60);
        expectedOutput.put("Seventy",70);
        expectedOutput.put("Eighty",80);
        expectedOutput.put("Ninety",90);
        expectedOutput.put("Hundred",100);
        expectedOutput.put("Thousand",1000);
        expectedOutput.put("Million",1000000);
        expectedOutput.put("Billion",1000000000);

        // Assert
        assertEquals(expectedOutput,Main.strToIntMap());
    }

    @Test
    void intToStrMapTest() {
        // Arrange
        HashMap<Integer, String> expectedOutput = new HashMap<>();
        
        // Act
        expectedOutput.put(0,"Zero");
        expectedOutput.put(1,"One");
        expectedOutput.put(2,"Two");
        expectedOutput.put(3,"Three");
        expectedOutput.put(4,"Four");
        expectedOutput.put(5,"Five");
        expectedOutput.put(6,"Six");
        expectedOutput.put(7,"Seven");
        expectedOutput.put(8,"Eight");
        expectedOutput.put(9,"Nine");
        expectedOutput.put(10,"Ten");
        expectedOutput.put(11,"Eleven");
        expectedOutput.put(12,"Twelve");
        expectedOutput.put(13,"Thirteen");
        expectedOutput.put(14,"Fourteen");
        expectedOutput.put(15,"Fifteen");
        expectedOutput.put(16,"Sixteen");
        expectedOutput.put(17,"Seventeen");
        expectedOutput.put(18,"Eighteen");
        expectedOutput.put(19,"Nineteen");
        expectedOutput.put(20,"Twenty");
        expectedOutput.put(30,"Thirty");
        expectedOutput.put(40,"Forty");
        expectedOutput.put(50,"Fifty");
        expectedOutput.put(60,"Sixty");
        expectedOutput.put(70,"Seventy");
        expectedOutput.put(80,"Eighty");
        expectedOutput.put(90,"Ninety");
        expectedOutput.put(100,"Hundred");
        expectedOutput.put(1000,"Thousand");
        expectedOutput.put(1000000, "Million");
        expectedOutput.put(1000000000, "Billion");

        // Assert
        assertEquals(expectedOutput,Main.intToStrMap());
    }

    @Test
    void convertListToIntTest() {
        // Arrange
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<Integer> expectedOutput = new ArrayList<>();

        // Act
        inputList.add("One Million Two Thousand Seven Hundred Ninety Seven");
        inputList.add("One Hundred Twenty Five");

        expectedOutput.add(125);
        expectedOutput.add(1002797);

        // Assert
        assertEquals(expectedOutput,Main.convertListToInt(inputList));
    }

    @Test
    void reverseToStringTest() {
        // Arrange
        ArrayList<Integer> inputList = new ArrayList<>();
        ArrayList<String> expectedOutput = new ArrayList<>();

        // Act
        inputList.add(125);
        inputList.add(1002797);

        expectedOutput.add("One Hundred Twenty Five");
        expectedOutput.add("One Million Two Thousand Seven Hundred Ninety Seven");

        // Assert
        assertEquals(expectedOutput,Main.reverseToString(inputList));
    }

    @Test
    void getTensTest() {
        // Arrange and Act
        int inputInt = 27;
        String expectedOutput = "Twenty Seven";

        // Assert
        assertEquals(expectedOutput,Main.getTens(inputInt));
    }

    @Test
    void getHundredsTest() {
        // Arrange and Act
        int inputInt = 227;
        String expectedOutput = "Two Hundred Twenty Seven";

        // Assert
        assertEquals(expectedOutput,Main.getHundreds(inputInt));
    }

    @Test
    void sortList() {
        // Arrange
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<String> expectedOutput = new ArrayList<>();

        // Act
        inputList.add("Twenty");
        inputList.add("Ten");
        inputList.add("One Thousand Seventy Eight");

        expectedOutput.add("Ten");
        expectedOutput.add("Twenty");
        expectedOutput.add("One Thousand Seventy Eight");

        // Assert
        assertEquals(expectedOutput,Main.sortList(inputList));
    }
}