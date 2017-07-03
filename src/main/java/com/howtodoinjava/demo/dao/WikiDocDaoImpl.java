package com.howtodoinjava.demo.dao;

import com.howtodoinjava.demo.model.WikiDocVo;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啦啦二胡 on 2017/7/2.
 */
@Repository
public class WikiDocDaoImpl implements WikiDocDao{
    public List<WikiDocVo> getAllWikiDocs() {
        List<WikiDocVo> wikis = new ArrayList<WikiDocVo>();
        Connection conn = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webapp", "root", "t_miss_h");
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from wikidoc  ");
            while (rs.next()) {
                WikiDocVo wiki = new WikiDocVo();
                wiki.setId(rs.getInt(1));
                wiki.setTitle(rs.getString(2));
                wiki.setUrl(rs.getString(3));
                wiki.setA_abstract(rs.getString(4));
                wikis.add(wiki);
            }
            return wikis;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WikiDocVo> getWikiDocsByTitle(String key) {
        List<WikiDocVo> wikis = new ArrayList<WikiDocVo>();
        Connection conn = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webapp", "root", "t_miss_h");
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select * from wikidoc where title like '%"+key+"%'");
            while (rs.next()) {
                WikiDocVo wiki = new WikiDocVo();
                wiki.setId(rs.getInt(1));
                wiki.setTitle(rs.getString(2));
                wiki.setUrl(rs.getString(3));
                wiki.setA_abstract(rs.getString(4));
                wikis.add(wiki);
            }
            return wikis;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
