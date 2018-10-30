package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.patient.BrowserPatientService;
import com.yoler.grape.util.GsonUtil;
import com.yoler.grape.util.ImportExcelUtil;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
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
    private String patientAddPage = "modules/patientAddPage.jsp";

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

    @RequestMapping(value = "importPatient", method = RequestMethod.POST)
    public String importPatient(Model model, @RequestParam("patientInfoFile") MultipartFile patientInfoFile) {
        CommonsMultipartFile file = (CommonsMultipartFile) patientInfoFile;
        String fileName = file.getFileItem().getName();
        String fileType = null;
        int fileTypeIndex = fileName.lastIndexOf(".");
        if (fileTypeIndex > 0) {
            fileType = fileName.substring(fileTypeIndex + 1).toLowerCase();
            if (!fileType.equals("xls") && !fileType.equals("xlsx")) {
                return null;
            }
        }
        try {
            List<List<String>> toImportDatas = ImportExcelUtil.importExcel(file.getInputStream(), fileType);
            logger.debug(GsonUtil.objectToJson(toImportDatas));
            browserPatientService.saveToImportConsilia(toImportDatas);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return patientListPage;
    }

    @RequestMapping(value = "addPatientPage", method = RequestMethod.POST)
    public String addPatient(Model model, @RequestParam("patientInfoId") String patientInfoId, @RequestParam("patientName") String patientName, @RequestParam("patientSex") String patientSex, @RequestParam("patientAge") String patientAge) {
        model.addAttribute("patientInfoId", patientInfoId);
        model.addAttribute("patientName", patientName);
        model.addAttribute("patientSex", patientSex);
        model.addAttribute("patientAge", patientAge);
        return patientAddPage;
    }

}
