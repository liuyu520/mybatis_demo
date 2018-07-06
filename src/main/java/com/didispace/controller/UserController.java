package com.didispace.controller;

import com.common.util.SystemHWUtil;
import com.didispace.domain.User;
import com.didispace.domain.UserMapper;
import com.io.hw.json.HWJacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user", produces = SystemHWUtil.RESPONSE_CONTENTTYPE_JSON_UTF)
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private int count = 0;

    @ResponseBody
    @RequestMapping(value = "/add/json")
    public String jsonAdd2(Model model, HttpServletRequest request, HttpServletResponse response
    ) {
        userMapper.insert("AAA" + count, 20);
        User u = userMapper.findByName("AAA" + count);
        count++;
        return HWJacksonUtils.getJsonP(u);
    }
}
