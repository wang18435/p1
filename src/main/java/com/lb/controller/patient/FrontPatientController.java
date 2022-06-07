package com.lb.controller.patient;

import com.lb.common.Global;
import com.lb.entity.LbAppointment;
import com.lb.entity.LbMedicalHistory;
import com.lb.entity.LbPatient;
import com.lb.entity.LbUser;
import com.lb.mapper.LbAppointmentMapper;
import com.lb.mapper.LbHospitalizationMapper;
import com.lb.mapper.LbMedicalHistoryMapper;
import com.lb.mapper.LbPatientMapper;
import com.lb.utils.PDFUtils;
import com.lb.vo.QueryVo;
import com.lb.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/patient")
public class FrontPatientController {
    @Value("${filepath.appointpdf}")
    private String appointPath;

    @Autowired
    private LbAppointmentMapper lbAppointmentMapper;
    @Autowired
    private LbPatientMapper lbPatientMapper;
    @Autowired
    private LbMedicalHistoryMapper lbMedicalHistoryMapper;
    @Autowired
    private LbHospitalizationMapper lbHospitalizationMapper;

    /**
     * 患者主页面，显示当前患者的预约记录
     */
    @RequestMapping("/index")
    public String index(HttpSession session, QueryVo queryVo, Model model) {
        //查询当前登录用户的预约记录
        LbUser user = (LbUser) session.getAttribute("user");
        queryVo.setUserId(user.getId());
        PageQuery<LbAppointment> page = lbAppointmentMapper.findList(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("path","/patient/index");
        return "patient/appointmentHistory";
    }

    /**
     * 预约表单
     */
    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String form(HttpSession session,Model model) {
        LbUser user = (LbUser) session.getAttribute("user");
        LbPatient patient = lbPatientMapper.findOneByUserId(user.getId());
        //将患者的信息放到model
        model.addAttribute("patient",patient);
        return "patient/appointmentForm";
    }

    /**
     * 预约保存
     */
    @ResponseBody
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public ResponseResult save(@RequestBody LbAppointment appointment) {
        appointment.setStatus(Global.SEEK_CODE_NONE);
        Integer appointmentId = lbAppointmentMapper.insertReturnId(appointment);
        LbPatient patient = new LbPatient();
        patient.setId(appointment.getPatientId());
        patient.setAppointmentId(appointmentId);
        lbPatientMapper.updatePatient(patient);
        return new ResponseResult(Global.SAVE_CODE_SUCCESS,Global.SAVE_APPOINTMENT_SUCCESS);
    }

    /**
     * 生成挂号单
     */
    @ResponseBody
    @RequestMapping(value = "/appointment/createPDF",method = RequestMethod.POST)
    public ResponseResult createPDF(HttpSession session) {
        //获取当前用户最近一次的预约记录
        LbUser user = (LbUser) session.getAttribute("user");
        LbPatient patient = lbPatientMapper.findOneByUserId(user.getId());
        LbAppointment appointment = lbAppointmentMapper.findOne(patient.getAppointmentId());
        return new ResponseResult(Global.APPOINTMENT_CODE_SUCCESS, PDFUtils.createAppointment(appointment,appointPath));
    }

    /**
     * 查询
     */
    @RequestMapping("/search")
    public String search() {
        return "patient/search";
    }

    /**
     * 查询信息
     */
    @ResponseBody
    @RequestMapping("/searchInfo")
    public Map<String, List> searchInfo(String type,String name) {
        return lbPatientMapper.findInfo(type,name);
    }

    /**
     * 查看既往病史
     */
    @RequestMapping("/medicalHistory")
    public String medicalHistory(QueryVo queryVo,HttpSession session, Model model) {
        LbUser user = (LbUser) session.getAttribute("user");
        queryVo.setUserId(user.getId());
        PageQuery<LbMedicalHistory> page = lbMedicalHistoryMapper.findList(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("path","/patient/medicalHistory");
        return "patient/medicalHistory";
    }

    /**
     * 查询最近一次住院记录
     */
    @RequestMapping("/hospitalization")
    public String hospitalization(HttpSession session, Model model) {
        LbUser user = (LbUser) session.getAttribute("user");
        model.addAttribute("hospitalization",lbHospitalizationMapper.findOneByUserId(user.getId()));
        return "patient/hospitalization";
    }
}
