package com.yoler.grape.service.browser.patient;

import java.util.Map;

/**
 * Created by zhangyu on 2019/3/13 10:30
 */
public interface RegisterGuJingboService {
    /**
     * @param intentionDate 意向就诊时间
     * @param patientName   姓名
     * @param patientSex    性别
     * @param patientAge    性别
     * @param patientPhone  手机号
     * @param patientIntro  介绍人
     * @param firstFlag     初诊or复诊
     * @return
     */
    Map<String, Object> register4GuJingbo(String intentionDate, String patientName, String patientSex, String patientAge, String patientPhone, String patientIntro, String firstFlag);

    /**
     * 获取意向就诊日期（只获取1-9条）
     *
     * @return
     */
    Map<String, Object> getIntentionDateAndWeek();

    /**
     * 获取某日的挂号详情
     *
     * @param intentionDate
     * @return
     */
    Map<String, Object> getRegisterDetail(String intentionDate);

    /**
     * 大夫登录
     *
     * @param account
     * @param password
     * @return
     */
    Map<String, Object> registerSignIn(String account, String password);
}
