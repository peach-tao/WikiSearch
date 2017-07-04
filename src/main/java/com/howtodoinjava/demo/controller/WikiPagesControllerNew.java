package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.dao.WikiDocDao;
import com.howtodoinjava.demo.model.WikiDocVo;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by 啦啦二胡 on 2017/7/4.
 */
@Controller
@RequestMapping("/wiki-pages")
public class WikiPagesControllerNew {
    //连接redis
    Jedis  redis = new Jedis ("127.0.0.1",6379);

    private static final Logger logger = LoggerFactory.getLogger(WikiPagesControllerNew.class);
    private List<WikiDocVo> pages = new ArrayList<>();

    @Autowired
    WikiDocDao dao;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("WikiPagesSearchNew");
        return mav;
    }

    @RequestMapping(value="/getPages.do", method=RequestMethod.POST)
    @ResponseBody
    public List<WikiDocVo> getUser(@RequestBody SearchParam searchParam) {
        // 如果页面为空 --> 页面获取所有doc
        // if用户输入的数据为空  那么list取10条
        // else 从保存在内存中的pages中找 ， 把包含关键词的文档加入list

        if (pages.isEmpty()) {
            pages = dao.getAllWikiDocs();
        }
        List<WikiDocVo> result;
        if (StringUtils.isEmpty(searchParam.getWord())) {
            result = pages.subList(1, 10);
        } else {
            result = new ArrayList<>();
            for (WikiDocVo page : pages) {
                if (page.getTitle().contains(searchParam.getWord())) {
                    result.add(page);
                    if (result.size() >= 10) break;
                }
            }
        }
        logger.info("search word :",searchParam.getWord());
        return result;
    }

    @RequestMapping(value="/suggestWord.do", method=RequestMethod.POST)
    @ResponseBody
    public List<String> suggestWord(@RequestBody SearchParam searchParam) {
        if (pages.isEmpty()) {
            pages = dao.getAllWikiDocs();
        }
        List<String> result;
        if (StringUtils.isEmpty(searchParam.getWord())) {
            result = new ArrayList<>();
        } else {
            result = new ArrayList<>();
            Set<String> set1 = new HashSet();
            for (WikiDocVo page : pages) {
                String wordSearch = searchParam.getWord();
                if(searchParam.getWord().length()==1){
                    char a1 = searchParam.getWord().charAt(0);
                    char a2 ;
                    if(a1=='z'||a1=='Z') {
                        set1 = redis.zrangeByLex("wordset", "[" + a1, "("+a1+'a');
                    }
                    else{
                        a2 = (char)(a1+1);
                        set1 = redis.zrangeByLex("wordset", "[" + a1, "(" + a2);
                    }
                    for (String str :set1){

                        result.add(str);

                        if (result.size() >= 10)
                            break;
                    }
                    break;
                }
                else {
                    char ca = wordSearch.charAt(wordSearch.length() - 1);
                    ca = (char) (ca + 1);
                    String wordNext = wordSearch.substring(0, wordSearch.length() - 1) + ca;
                    set1 = redis.zrangeByLex("wordset", "[" + wordSearch, "(" + wordNext);
                    for (String str :set1){
                        result.add(str);

                        if (result.size() >= 10)
                            break;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
