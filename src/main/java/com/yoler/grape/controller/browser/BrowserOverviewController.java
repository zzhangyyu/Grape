package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.patient.BrowserPatientService;
import com.yoler.grape.service.browser.user.BrowserUserService;
import com.yoler.grape.util.GsonUtil;
import com.yoler.grape.vo.browser.BrowserMounthDatasVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 管理端通用controller
 */
@Controller
@RequestMapping(value = "/console/")
public class BrowserOverviewController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String overviewPage = "modules/overviewPage.jsp";

    @Autowired
    BrowserUserService browserUserService;

    @Autowired
    BrowserPatientService browserPatientService;

    /**
     * 总览页
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "overViewPage", method = RequestMethod.GET)
    public String overView(Model model, HttpServletRequest request) {
        return overviewPage;
    }

    @RequestMapping(value = "getMounthDatas", method = RequestMethod.POST)
    public @ResponseBody
    String getMounthDatas(@RequestBody String reqJson) {
        Map<String, Object> resultMap = browserPatientService.getBrowserMounthDatas();
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug(result);
        return result;
//        return "{\"content\":[{\"visitingDate\":\"2017-05-06\",\"visitingCnt\":\"5\"},{\"visitingDate\":\"2017-05-07\",\"visitingCnt\":\"10\"},{\"visitingDate\":\"2017-05-08\",\"visitingCnt\":\"8\"},{\"visitingDate\":\"2017-05-09\",\"visitingCnt\":\"6\"}],\"status\":\"200\"}";
    }
}
