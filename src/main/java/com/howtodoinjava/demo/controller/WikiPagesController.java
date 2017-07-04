//package com.howtodoinjava.demo.controller;
//
//
//import com.howtodoinjava.demo.dao.WikiDocDao;
//import com.howtodoinjava.demo.model.WikiDocVo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by hxu on 7/2/17.
// */
//@Controller
//@RequestMapping("/wiki-pages")
//public class WikiPagesController {
//    private static final Logger logger = LoggerFactory.getLogger(WikiPagesController.class);
//    private List<WikiDocVo> pages = new ArrayList<>();
//
//    @Autowired
//    WikiDocDao dao;
//
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public ModelAndView search() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("WikiPagesSearchNew");
//        return mav;
//    }
//
//    @RequestMapping(value="/getPages.do", method=RequestMethod.POST)
//    @ResponseBody
//    public List<WikiDocVo> getUser(@RequestBody SearchParam searchParam) {
//        if (pages.isEmpty()) {
//            pages = dao.getAllWikiDocs();
//        }
//
//        List<WikiDocVo> result;
//        if (StringUtils.isEmpty(searchParam.getWord())) {
//            result = pages.subList(1, 10);
//        } else {
//            result = new ArrayList<>();
//            for (WikiDocVo page : pages) {
//                if (page.getTitle().contains(searchParam.getWord())) {
//                    result.add(page);
//                    if (result.size() >= 10) break;
//                }
//            }
//        }
//        logger.info("search word :",searchParam.getWord());
//        return result;
//    }
//
//    @RequestMapping(value="/suggestWord.do", method=RequestMethod.POST)
//    @ResponseBody
//    public List<String> suggestWord(@RequestBody SearchParam searchParam) {
//        if (pages.isEmpty()) {
//            pages = dao.getAllWikiDocs();
//        }
//        // result 为提示集合
//        List<String> result;
//
//        // 如果搜索字符串为空，则列表为空
//        // else 初始化list
//
//        if (StringUtils.isEmpty(searchParam.getWord())) {
//            result = new ArrayList<>();
//        } else {
//            result = new ArrayList<>();
//            for (WikiDocVo page : pages) {
//                if (page.getTitle().contains(searchParam.getWord())) {
//                    result.add(page.getTitle());
//                    if (result.size() >= 10)
//                        break;
//                }
//            }
//        }
//        return result;
//    }
//}
