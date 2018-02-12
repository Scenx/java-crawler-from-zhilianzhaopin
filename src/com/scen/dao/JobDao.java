package com.scen.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.scen.entity.Job;

import java.sql.SQLException;

import com.scen.util.DataBaseUtils;

/**
 * 数据处理
 * Created by scen on 2017/4/21.
 */
public class JobDao {

    public int insert(Job[] job,
                      String a,
                      String b,
                      String c,
                      String d,
                      String e,
                      String f,
                      String g,
                      String h,
                      String i) {  //带有10个参数的数据库插入方法
        Connection conn = DataBaseUtils.getConn();
        int p = 0;
        String sql = "insert into jobs (jobname,companyname,salrange,publicdate,jobdesc,companydesc,validated,createdate,updatedate) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try { //向表里添加数据
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setString(4, d);
            pstmt.setString(5, e);
            pstmt.setString(6, f);
            pstmt.setString(7, g);
            pstmt.setString(8, h);
            pstmt.setString(9, i);
            p = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return p;
    }

}