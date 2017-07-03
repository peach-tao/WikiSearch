package com.howtodoinjava.demo.dao;


import com.howtodoinjava.demo.model.WikiDocVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啦啦二胡 on 2017/7/2.
 */
public interface WikiDocDao {
    public List<WikiDocVo> getAllWikiDocs();
    public List<WikiDocVo> getWikiDocsByTitle(String key);
}

