package com.scen.util;

import com.scen.entity.Job;

/**
 * 格式化数组打印输出
 * Created by scen on 2017/4/25.
 */
public class PrintArrayUtils {
    private PrintArrayUtils(){}
    public static void printArray(Job[] job){
           for(int i=0;i<job.length-1;i++){
               System.out.println(job[i]);
           }
        System.out.println(">>>>>>>>>>>>>>恭喜您！数据采集完毕！<<<<<<<<<<<<<<<<<");
    }
}
