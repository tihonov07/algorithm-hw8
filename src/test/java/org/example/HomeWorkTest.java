package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void checkFirst() {

        assertEquals(0.06, homeWork.getProfit(parseLines("BID 0.01\n" +
                "BID 10000\n" +
                "BID 5000\n" +
                "BID 5000\n" +
                "SALE 7000 3\n" +
                "DEL 5000\n" +
                "SALE 3000 3\n" +
                "SALE 0.01 3")), 0.009);
    }

    @Test
    void checkSecond(){
        assertEquals(asList(3, 4), homeWork.getLeaveOrder(parseLines("+ 1\n" +
                "+ 3\n" +
                "+ 3\n" +
                "? 2\n" +
                "+ 1\n" +
                "? 4")));
    }

    private static List<String> parseLines(String str) {
        return Arrays.stream(str.split("\n")).collect(Collectors.toList());
    }

}