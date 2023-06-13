package com.web.servlet.fenye;

import java.util.Scanner;

public class DoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer count = 101;
        String str = "[1][2][3][4][5][6][7][8][9]";
        System.out.println(str);
        while (true) {
            System.out.println("请输入当前页:");
            Integer pageIndex = sc.nextInt();
            Integer mid = 5;
            if (pageIndex > mid) {
                mid = pageIndex;
                str = "";
                for (int i = 4; i >= 1; i--) {
                    str += ("[" + (mid - i) + "]");
                }
                str += ("[" + (mid) + "]");
                for (int i = 1; i <= 4; i++) {
                    if (mid + i > count) {
                        break;
                    }
                    str += ("[" + (mid + i) + "]");
                }
            }
            System.out.println(str);
        }

    }
}
