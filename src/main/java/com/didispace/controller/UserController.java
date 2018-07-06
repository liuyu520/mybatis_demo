package com.didispace.controller;

import com.common.util.SystemHWUtil;
import com.didispace.domain.User;
import com.didispace.domain.UserXmlMapper;
import com.io.hw.json.HWJacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/user", produces = SystemHWUtil.RESPONSE_CONTENTTYPE_JSON_UTF)
public class UserController {
    @Autowired
    private UserXmlMapper userXmlMapper;
    private int count = 0;

    @ResponseBody
    @RequestMapping(value = "/add/json")
    public String jsonAdd2(Model model, HttpServletRequest request, HttpServletResponse response
    ) {
        int id = userXmlMapper.insert("AAA" + count, 20);
        System.out.println("id :" + id);
        List<User> users = userXmlMapper.findByName("AAA" + count);
        count++;
        return HWJacksonUtils.getJsonP(users);
    }
}
