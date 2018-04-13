package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.user.BrowserUserService;
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
 * 管理端通用controller
 */
@Controller
@RequestMapping(value = "/console/")
public class BrowserCommonController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String signInPage = "modules/signInPage.jsp";
    private String overviewPage = "modules/overviewPage.jsp";

    @Autowired
    BrowserUserService browserUserService;

    /**
     * 总览页
     *
     * @param userName
     * @param password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "overViewPage", method = RequestMethod.POST)
    public String overView(@RequestParam String userName, @RequestParam String password, Model model, HttpServletRequest request) {
        Map<String, Object> signInResult = browserUserService.signIn(userName, password);
        String status = (String) signInResult.get("status");
        String msg = (String) signInResult.get("msg");
        if ("200".equals(status)) {
//            request.getSession().setAttribute("resoList", "");
            return overviewPage;
        } else if ("500".equals(status)) {
            model.addAttribute("errorMsg", msg);
            return signInPage;
        } else {
            model.addAttribute("errorMsg", "服务器错误");
            return signInPage;
        }
    }

    @RequestMapping(value = "overViewPage", method = RequestMethod.GET)
    public String overView(Model model, HttpServletRequest request) {
        return overviewPage;
    }
}
