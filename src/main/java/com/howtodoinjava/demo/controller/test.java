package com.howtodoinjava.demo.controller;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by 啦啦二胡 on 2017/7/4.
 */
public class test {
    public static void main(String[] args){

        //连接redis
        Jedis redis = new Jedis ("127.0.0.1",6379);

        String wordSearch = "happy";
        char ca = wordSearch.charAt(wordSearch.length()-1);
        System.out.println(ca);
        ca = (char) (ca+1);
        String wordNext = wordSearch.substring(0,wordSearch.length()-1)+ca;
        System.out.println(wordNext);
        String a1 ="a";
        String a2 ="b";

        Set<String> set = redis.zrangeByLex("wordset", "["+a1, "("+a2);
        for(String str : set){
            System.out.println(str);
        }




    }
}
