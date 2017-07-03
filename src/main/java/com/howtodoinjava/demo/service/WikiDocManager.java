package com.howtodoinjava.demo.service;


import com.howtodoinjava.demo.model.WikiDocVo;

import java.util.List;

/**
 * Created by 啦啦二胡 on 2017/7/2.
 */
public interface WikiDocManager {
    public List<WikiDocVo> getAllWikiDoc();
    public List<WikiDocVo> getWikiDocsByTitle(String key);
}
