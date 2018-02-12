package com.scen.entity;

/**
 * javabean（pojo）
 * 来承接重网页中提取的数据
 * Created by scen on 2017/4/21.
 */
public class Job {
    /*成员变量*/
    private int id;  //身份id
    private String jobName;  //工作名字
    private String conpanyName; //公司名字
    private String salRange;  //工资范围
    private String publicDate; //发布时间
    private String jobDesc; //工作描述
    private String companyDesc;  //公司简介
    private String createDate;  //创建时间
    private String updateDate;  //更新时间
    private boolean validated;  //本份工作是否有效

    //构造方法
    //成员方法（属性） getter和setter
    //重写toString（）方法


    public Job() {    //构造方法
        super();
    }


    //构造方法
    public Job(int id, String jobName, String conpanyName, String salRange, String publicDate, String jobDesc, String companyDesc, String createDate, String updateDate, boolean validated) {
        this.id = id;
        this.jobName = jobName;
        this.conpanyName = conpanyName;
        this.salRange = salRange;
        this.publicDate = publicDate;
        this.jobDesc = jobDesc;
        this.companyDesc = companyDesc;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.validated = validated;
    }


    //构造方法
    public Job(String jobName, String conpanyName, String salRange, String publicDate, String jobDesc, String companyDesc, String createDate, String updateDate, boolean validated) {
        this.jobName = jobName;
        this.conpanyName = conpanyName;
        this.salRange = salRange;
        this.publicDate = publicDate;
        this.jobDesc = jobDesc;
        this.companyDesc = companyDesc;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.validated = validated;
    }

    //get set开始
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getConpanyName() {
        return conpanyName;
    }

    public void setConpanyName(String conpanyName) {
        this.conpanyName = conpanyName;
    }

    public String getSalRange() {
        return salRange;
    }

    public void setSalRange(String salRange) {
        this.salRange = salRange;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    //get set 结束
    @Override  //重写toString（）方法
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", conpanyName='" + conpanyName + '\'' +
                ", salRange='" + salRange + '\'' +
                ", publicDate='" + publicDate + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", companyDesc='" + companyDesc + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", validated=" + validated +
                '}';
    }
}