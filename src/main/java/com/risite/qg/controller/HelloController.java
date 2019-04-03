package com.risite.qg.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/zousiqi")
    public String zousiqi() {
        return "1zousiqi";
    }
    @RequestMapping("/pickCoin")
    public String pickCoin() {
        return "2pickCoin";
    }
    @RequestMapping("/tictactoe")
    public String tictactoe() {
        return "3tictactoe";
    }
    @RequestMapping("/biesiniu")
    public String biesiniu() {
        return "4biesiniu";
    }
    @RequestMapping("/index0")
    public String index0() {
        return "5index0";
    }

    @ResponseBody
    @RequestMapping("/user/1")
    public JSONObject hello() {
        JSONObject json = new JSONObject();
        json.put("id","1");
        json.put("name","Tom");
        json.put("age","12");
        return json;
    }

    public static void main(String[] args) {
        /**
         * 对Map的遍历
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("天猫双11", 1024);
        map.put("京东双11", 1024);
        // ①简写式
        map.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
        // ②判断式
        map.forEach((k, v) -> {
            System.out.println("key:" + k + ", value:" + v);
            if (StringUtils.contains(k, "京东")) {
                System.out.println("skr~");
            }
        });
    }
}
