package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 管理端用户controller
 */
@Controller("browserSignInController")
@RequestMapping(value = "/console/")
public class SignInController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    /**
     * 用户登录页
     *
     * @return
     */
    @RequestMapping(value = "signInPage", method = RequestMethod.GET)
    public String signInPage() {
        return "signIn";
    }

    @RequestMapping(value = "welcomePage", method = RequestMethod.POST)
    public String welcome(@RequestParam String userName, @RequestParam String password, Model model, HttpServletRequest request) {
        Map<String, Object> signInResult = userService.signIn(userName, password);
        String status = (String) signInResult.get("status");
        String msg = (String) signInResult.get("msg");
        if ("200".equals(status)) {
            request.getSession().setAttribute("userName", userName);
            request.getSession().setAttribute("password", password);
            return "welcome";
        } else if ("500".equals(status)) {
            model.addAttribute("errorMsg", msg);
            return "signIn";
        } else {
            model.addAttribute("errorMsg", "服务器错误");
            return "signIn";
        }
    }
}
