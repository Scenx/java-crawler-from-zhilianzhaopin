package com.scen.test;


/**
 * 单元测试
 * 测试Utils包中的工具类
 * Created by scen on 2017/4/22.
 */
public class Test {
    public static void main(String[] args) {
        int se=0;
        for(int i=0;i<100;i++){
            if(i%2!=0){
                se+=i;
            }
        }
        System.out.println("1到100内的奇数和为："+se);
    }

}
