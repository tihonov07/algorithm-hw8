package org.example;


import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1316">https://acm.timus.ru/problem.aspx?space=1&num=1316</a>
     */
    public Double getProfit(List<String> actionList) {
        var treap = new Treap<>();
        double result = 0.0;
        for (var input: actionList) {
            var parts = input.split(" ");
            if ("BID".equals(parts[0]) && parts.length == 2) {
                treap.add(Double.parseDouble(parts[1]));
            }
            if ("SALE".equals(parts[0]) && parts.length == 3) {
                var price = Double.parseDouble(parts[1]);
                var count = Integer.parseInt(parts[2]);
                var bids = treap.findMoreThenKey(price);
                for (int i = 0; i < bids.size() && count > 0; i++) {
                    result += 0.01;
                    count--;
                }
            }
            if ("DEL".equals(parts[0]) && parts.length == 2) {
                treap.remove(Double.parseDouble(parts[1]));
            }
        }
        return result;
    }

    /**
     * <h1>Задание 2.</h1>
     * Решить задачу <br/>
     * <a href="https://informatics.msk.ru/mod/statements/view.php?id=1974&chapterid=2782#1">https://informatics.msk.ru/mod/statements/view.php?id=1974&chapterid=2782#1</a><br/>
     */
    public List<Integer> getLeaveOrder(List<String> actionList) {
        var treap = new Treap<>();
        var result = new ArrayList<Integer>();
        int lastAnswer = -1;
        int add;
        for (var input: actionList) {
            var parts = input.split(" ");

            if ("+".equals(parts[0]) && parts.length == 2) {
                if (lastAnswer != -1) {
                    add = (Integer.parseInt(parts[1]) + lastAnswer) % 1_000_000_000;
                } else {
                    add = Integer.parseInt(parts[1]);
                }
                treap.add(add);
                lastAnswer = -1;
            }

            if ("?".equals(parts[0]) && parts.length == 2) {
                lastAnswer = (Integer) treap.findNext(Integer.parseInt(parts[1]));
                result.add(lastAnswer);
            }
        }
        return result;
    }

}
