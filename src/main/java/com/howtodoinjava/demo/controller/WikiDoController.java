package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.model.WikiDocVo;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.service.WikiDocManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 啦啦二胡 on 2017/7/2.
 */

@Controller
@RequestMapping("/wikidoc-module")
public class WikiDoController {
    @Autowired
    WikiDocManager manager;

    @RequestMapping(value = "/getAllWikiDocs", method = RequestMethod.GET)
    public ModelAndView getAllEmployees(Model model) {
        model.addAttribute("WikiDocs", manager.getAllWikiDoc());
        model.addAttribute("searchWord", new String());
        return new ModelAndView("WikiDocListDisplay", "command", new SearchParam());
    }


    @RequestMapping(value = "/searchWikiDocs", method = RequestMethod.GET)
    public ModelAndView searchWikiDocs(SearchParam searchParam, BindingResult br, Model model) {
        List<WikiDocVo> all = manager.getAllWikiDoc();
        if(!StringUtils.isEmpty(searchParam.getWord())) {
            List<WikiDocVo> result = manager.getWikiDocsByTitle(searchParam.getWord());
//                for(WikiDocVo wikiDocVo : all) {
//                if(wikiDocVo.getTitle().contains(searchParam.getWord())) {
//                    result.add(wikiDocVo);
//                }
//            }
            System.out.print(result);
            model.addAttribute("WikiDocs", result);
        } else {
            model.addAttribute("WikiDocs", all);
        }
        return new ModelAndView("WikiDocListDisplay", "command", new SearchParam());
    }
}