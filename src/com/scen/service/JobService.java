package com.scen.service;

import com.scen.dao.JobDao;
import com.scen.entity.Job;

/**
 * job类型的业务逻辑处理层代码
 * Created by scen on 2017/4/24.
 */
public class JobService {
    JobDao jobDao = new JobDao();

    /**
     * 插入记录到数据库
     * Created by scen on 2017/4/24.
     */
    public void insertJob(Job[] job) {
        for (int i = 0; i < job.length - 2; i++) {
            jobDao.insert(job,
                    job[i].getJobName(),
                    job[i].getConpanyName(),
                    job[i].getSalRange(),
                    job[i].getPublicDate(),
                    job[i].getJobDesc(),
                    job[i].getCompanyDesc(),
                    (job[i].isValidated() ? "是" : "否"),
                    job[i].getCreateDate(),
                    job[i].getUpdateDate()
            );
        }
        System.out.println(">>>>>>>>>>>>>>恭喜您！数据成功存储到数据库！<<<<<<<<<<<<<<<<<");
    }
}

