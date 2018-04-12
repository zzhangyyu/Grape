package com.yoler.grape.controller.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理端病人controller
 */
@Controller
@RequestMapping(value = "/console/")
public class BrowserPatientController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String patientListPage = "modules/patientListPage.jsp";

    /**
     * 病人列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "patientListPage", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return patientListPage;
    }


}
