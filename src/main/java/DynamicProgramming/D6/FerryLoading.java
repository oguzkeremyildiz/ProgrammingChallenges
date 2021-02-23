package DynamicProgramming.D6;/* Created by oguzkeremyildiz on 5.08.2020 */

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class FerryLoading {

    private static boolean control(LinkedList<Node> list, int current, int ferry) {
        LinkedList<Node> port = new LinkedList<>();
        LinkedList<Node> starboard = new LinkedList<>();
        int endIndex = Integer.MAX_VALUE;
        for (int n = list.size() - 1; n > -1; n--) {
            if (list.get(n).getValue() <= current) {
                if (endIndex == Integer.MAX_VALUE) {
                    endIndex = n;
                }
                current -= list.get(n).getValue();
                port.add(list.get(n));
            }
        }
        for (int n = 0; n < endIndex; ++n) {
            if (!port.contains(list.get(n))) {
                starboard.add(list.get(n));
            }
        }
        int total1 = 0, total2 = 0;
        for (Node k : port) {
            total1 += k.getWeight();
        }
        for (Node k : starboard) {
            total2 += k.getWeight();
        }
        return ferry >= total1 && ferry >= total2;
    }

    private static void print(int[][] dp, int ferry, LinkedList<Node> list) {
        LinkedList<Node> port = new LinkedList<>();
        LinkedList<Node> starboard = new LinkedList<>();
        int totalScore = dp[list.size() - 1][ferry];
        for (int i = list.size() - 1; i > -1; i--) {
            if (list.get(i).getValue() <= totalScore) {
                totalScore -= list.get(i).getValue();
                port.add(list.get(i));
            }
        }
        int total = 0;
        for (Node i : list) {
            if (!port.contains(i)) {
                if (total + i.getWeight() > ferry) {
                    break;
                }
                total += i.getWeight();
                starboard.add(i);
            }
        }
        System.out.println(port.size() + starboard.size());
        for (Node i : list) {
            if (port.contains(i)) {
                System.out.println("port");
            } else if (starboard.add(i)) {
                System.out.println("starboard");
            }
        }
    }

    private static void dp(LinkedList<Node> list, int ferry) {
        int[][] dp = new int[list.size()][ferry + 1];
        for (int i = 0; i < ferry + 1; i++) {
            if (i >= list.getFirst().getWeight()) {
                dp[0][i] = list.getFirst().getValue();
            }
        }
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i).getWeight() < ferry + 1) {
                for (int j = 1; j < ferry + 1; ++j) {
                    if (j - list.get(i).getWeight() > -1 && dp[i - 1][j - list.get(i).getWeight()] + list.get(i).getValue() > dp[i - 1][j] && control(list, dp[i - 1][j - list.get(i).getWeight()] + list.get(i).getValue(), ferry)) {
                        dp[i][j] = dp[i - 1][j - list.get(i).getWeight()] + list.get(i).getValue();
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        print(dp, ferry, list);
    }

    private static int setValues(LinkedList<Integer> values) {
        if (values.isEmpty()) {
            values.add(1);
        } else {
            int total = 1;
            for (Integer value : values) {
                total += value;
            }
            values.add(total);
        }
        return values.get(values.size() - 1);
    }

    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Ferry.txt"));
            LinkedList<Node> list = new LinkedList<>();
            int times, ferry, index;
            times = source.nextInt();
            for (int i = 0; i < times; i++) {
                index = 0;
                ferry = source.nextInt();
                int current = Integer.MAX_VALUE;
                LinkedList<Integer> values = new LinkedList<>();
                while (current != 0) {
                    current = source.nextInt();
                    if (current != 0) {
                        index++;
                        int value = setValues(values);
                        list.add(new Node(value, current));
                    }
                }
                if (list.get(0).getWeight() <= ferry * 100) {
                    dp(list, ferry * 100);
                } else {
                    System.out.println("0");
                }
                System.out.println();
                list.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
