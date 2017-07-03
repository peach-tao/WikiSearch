package com.howtodoinjava.demo.model;

import java.io.Serializable;

/**
 * Created by 啦啦二胡 on 2017/7/2.
 */
public class WikiDocVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String url;
    private String Dabstract;
    private String a_abstract;


    public String getA_abstract() {
        return a_abstract;
    }

    public void setA_abstract(String a_abstract) {
        this.a_abstract = a_abstract;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDabstract() {
        return Dabstract;
    }

    public void setDabstract(String dabstract) {
        Dabstract = dabstract;
    }

    @Override

    public String toString() {
        return "WikiDocVo [id=" + id + ", title=" + title
                + ", url=" + url + ", Dabstract=" + Dabstract + "]";
    }


}
