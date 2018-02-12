package com.scen.web;

import com.scen.entity.Job;
import com.scen.service.JobService;
import com.scen.util.ParseUtils;
import com.scen.util.PrintArrayUtils;
import com.scen.util.ScannerUtils;


/**
 * 该项目的入口类
 * Created by scen on 2017/4/21.
 */
public class Starter {
    public static void main(String[] args) {
        /**
         * startup
         * 从键盘获取两个关键字的值
         */
        System.out.println(">>>>>>>>>>>>>>欢迎使用招聘数据采集项目<<<<<<<<<<<<<<<<<");
        String[] jlAndkw = ScannerUtils.sc();
        String jl = jlAndkw[0];
        String kw = jlAndkw[1];
        System.out.println(">>>>>>>>>>>>>>正在采集请稍等<<<<<<<<<<<<<<<<<");

        /**
         * 第一步：将网页中的数据，提取出来，对象转数组
         */

        Job[] array = ParseUtils.parseWebData(jl, kw);
        PrintArrayUtils.printArray(array);
        /**
         * 第二步：将数组的数据传递给业务逻辑层处理（数组循环取出job的变量值并且insert进mysql）
         */
        JobService jobService = new JobService();
        jobService.insertJob(array);
        /**
         * 第三步：采集完毕
         */
        System.exit(0);
    }
}



