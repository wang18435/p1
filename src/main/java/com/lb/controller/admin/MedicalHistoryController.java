package com.lb.controller.admin;

import com.lb.entity.LbDoctor;
import com.lb.entity.LbMedicalHistory;
import com.lb.entity.LbPatient;
import com.lb.mapper.LbDoctorMapper;
import com.lb.mapper.LbMedicalHistoryMapper;
import com.lb.mapper.LbPatientMapper;
import com.lb.vo.QueryVo;
import com.lb.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin/medicalHistory")
public class MedicalHistoryController {
    @Autowired
    private LbMedicalHistoryMapper lbMedicalHistoryMapper;
    @Autowired
    private LbPatientMapper lbPatientMapper;
    @Autowired
    private LbDoctorMapper lbDoctorMapper;

    @ModelAttribute("doctors")
    public List<LbDoctor> getDoctors() {
        return lbDoctorMapper.findAll();
    }
    @ModelAttribute("patients")
    public List<LbPatient> getPatients() {
        return lbPatientMapper.findAll();
    }

    @RequestMapping("/manage")
    public String manage(QueryVo queryVo, Model model) {
        //分页查询
        PageQuery<LbMedicalHistory> page = lbMedicalHistoryMapper.findList(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("patientName",queryVo.getPatientName());
        model.addAttribute("doctorName",queryVo.getDoctorName());
        model.addAttribute("path","/admin/medicalHistory/manage");
        return "admin/medicalHistoryManage";
    }

    /**
     * 新增
     */
    @RequestMapping("/")
    public String addForm(LbMedicalHistory lbMedicalHistory,Model model) {
        model.addAttribute("medicalHistory",lbMedicalHistory);
        return "admin/MedicalHistoryForm";
    }

    /**
     * 编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("medicalHistory",lbMedicalHistoryMapper.findOne(id));
        return "admin/medicalHistoryForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseResult insert(@RequestBody LbMedicalHistory lbMedicalHistory) {
        return lbMedicalHistoryMapper.insertMedicalHistory(lbMedicalHistory);
    }

    /**
     * 异步更新记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody LbMedicalHistory lbMedicalHistory) {
        return lbMedicalHistoryMapper.updateMedicalHistory(lbMedicalHistory);
    }

    /**
     * 异步删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Integer id){
        return lbMedicalHistoryMapper.deleteById(id);
    }
}
