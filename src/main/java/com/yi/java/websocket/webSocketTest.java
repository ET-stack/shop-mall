package com.yi.java.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 小飞 on 2019/6/21.
 */
@Controller
@RequestMapping("")
public class webSocketTest {
    @RequestMapping("web")
    public String web(){
        return "admin/chat";
    }

}
