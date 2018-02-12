package com.scen.util;

import com.scen.entity.Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

/**
 * 抓取网页数据类
 * Created by scen on 2017/4/24.
 */
public class ParseUtils {
    private ParseUtils() {
    }

    public static Job[] parseWebData(String jl, String kw) {
        Job[] array_job = null;
        String url = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl="
                + jl + "&kw=" + kw;
        String detailUrl = "";
        Document doc0 = null;
        Document docr = null;
        try {
            doc0 = Jsoup.connect(url).get();
            String d = doc0.toString();
            Document doc = Jsoup.parse(d, "UTF-8");
            Elements content = doc.getElementsByClass("newlist");//标签内容
            Job job = null;
            array_job = new Job[content.size()];
            int index = 0;
            for (Element e : content) {//第一次抓取表面信息并且获取二级页面的url
                String jobName = e.getElementsByClass("zwmc").text();
                String conpanyName = e.getElementsByClass("gsmc").text();
                String salRange = e.getElementsByClass("zwyx").text();
                String publicDate = e.getElementsByClass("gxsj").text();
                String test = e.getElementsByClass("zwmc").toString();
                Document doc2 = Jsoup.parse(test, "UTF-8");
                Elements links = doc2.getElementsByTag("a");
                for (Element link : links) {   //抓取二级页面的详细信息并封装
                    String linkHref = link.attr("href");
                    if (linkHref.startsWith("http://jobs.zhaopin.com/")) {
                        detailUrl = linkHref;
                        docr = Jsoup.connect(detailUrl).get();
                        String dr = docr.toString();
                        Document docc = Jsoup.parse(dr, "UTF-8");
                        Elements contentr = docc.getElementsByClass("tab-inner-cont");
                        String jobDesc = contentr.text();
                        String jobDescDemo = jobDesc.substring(0, jobDesc.indexOf("其他职位"));
                        String companyDesc = jobDesc.substring(jobDesc.indexOf("其他职位"), jobDesc.indexOf("全选"));
                        companyDesc = companyDesc.replace("其他职位", "");
                        /**System.out.println(companyDesc);*/
                        if (jobName.equals("职位名称") == false) {
                            if (conpanyName.equals("公司名称") == false) {
                                if (salRange.equals("职位月薪") == false) {
                                    if (publicDate.equals("发布日期") == false) {
                                        job = new Job();
                                        boolean validated = true;
                                        job.setJobName(jobName);//从网络上获取下来的
                                        job.setConpanyName(conpanyName);//从网络上获取下来的
                                        job.setSalRange(salRange);//从网络上获取下来的
                                        job.setPublicDate(publicDate);//从网络上获取下来的
                                        job.setJobDesc(jobDescDemo);//从网络上获取下来的
                                        job.setCompanyDesc(companyDesc);//从网络上获取下来的
                                        String currentDate = DateUtils.fornatDate(new Date());
                                        job.setCreateDate(currentDate);//默认取本机当前系统时间
                                        job.setUpdateDate(currentDate);//默认取本机当前系统时间
                                        job.setValidated(validated);//默认有效
                                        //job=new Job(jobName,companyDesc,salRange,publicDate,jobDesc,companyDesc,currentDate,currentDate,validated);
                                        array_job[index] = job;
                                        index++;
                                    }
                                }
                            }

                        }
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array_job;//返回承载着所需信息的数组
    }
}
