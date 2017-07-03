package com.howtodoinjava.demo.service;


import com.howtodoinjava.demo.dao.WikiDocDao;
import com.howtodoinjava.demo.model.WikiDocVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 啦啦二胡 on 2017/7/2.
 */
@Service
public class WikiDocManagerImpl implements WikiDocManager {

    @Autowired
    WikiDocDao dao;
    public List<WikiDocVo> getAllWikiDoc() {
        return dao.getAllWikiDocs();
    }

    public List<WikiDocVo> getWikiDocsByTitle(String key){
        return dao.getWikiDocsByTitle(key);
    }


}
