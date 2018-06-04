package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.patient.BrowserPatientService;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * 管理端病人controller
 */
@Controller
@RequestMapping(value = "/console/")
public class BrowserPatientController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BrowserPatientService browserPatientService;

    private String patientListPage = "modules/patientListPage.jsp";

    /**
     * 病人列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "patientListPage", method = RequestMethod.GET)
    public String patientListPage(Model model) {
        List<BrowserPatientBriefInfoVo> browserPatientBriefInfoList = browserPatientService.getBrowserPatientBriefInfo(1, 20);
        model.addAttribute("browserPatientBriefInfoList", browserPatientBriefInfoList);
        return patientListPage;
    }

    @RequestMapping(value = "importPatientInfo", method = RequestMethod.POST)
    public String importPatientInfo(Model model, @RequestParam("patientInfoFile") MultipartFile patientInfoFile) {
        CommonsMultipartFile file = (CommonsMultipartFile) patientInfoFile;
        return patientListPage;
    }

}
