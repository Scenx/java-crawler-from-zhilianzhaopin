package com.scen.util;

import java.util.Scanner;

/**
 * 从键盘获取两个关键字的工具类
 * Created by scen on 2017/4/24.
 */
public class ScannerUtils {
    public static String[] sc() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n");
            System.out.println("请输入你期望工作的城市并且以回车键结束(如： 郑州)：");
            String jl = "";
            s = new Scanner(System.in);
            while (true) {
                jl = s.nextLine();
                if ("".equals(jl)) {
                    System.out.println("城市不能为空，请重新输入：");
                } else {
                    break;
                }
            }
            System.out.println("请输入你期望的工作职位并且以回车键结束（如： java）：");
            String kw = "";

            while (true) {
                kw = s.nextLine();
                if ("".equals(kw)) {
                    System.out.println("工作职位不能为空，请重新输入：");
                } else {
                    break;
                }
            }
            String[] s0 = new String[2];
            s0[0] = jl;
            s0[1] = kw;
            return s0;

        }
    }
}
