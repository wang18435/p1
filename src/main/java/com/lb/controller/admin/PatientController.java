package com.lb.controller.admin;


import com.lb.entity.LbPatient;
import com.lb.mapper.LbPatientMapper;
import com.lb.vo.QueryVo;
import com.lb.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/patient")
public class PatientController {
    @Autowired
    private LbPatientMapper lbPatientMapper;

    @RequestMapping("/manage")
    public String manage(QueryVo queryVo, Model model) {
        //查询患者的集合数据
        PageQuery<LbPatient> page = lbPatientMapper.findList(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("name",queryVo.getPatientName());
        model.addAttribute("certId",queryVo.getCertId());
        model.addAttribute("path","/admin/patient/manage");
        return "admin/patientManage";
    }

    /**
     * 病人新增
     */
    @RequestMapping("/")
    public String doctorAddForm(LbPatient lbPatient,Model model) {
        model.addAttribute("patient",lbPatient);
        return "admin/patientForm";
    }

    /**
     * 病人编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doctorEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("patient",lbPatientMapper.findOne(id));
        return "admin/patientForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseResult insert(@RequestBody LbPatient lbPatient) {
        return lbPatientMapper.insertPatient(lbPatient);
    }

    /**
     * 异步更新记录
     * @param lbPatient
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody LbPatient lbPatient) {
        return lbPatientMapper.updatePatient(lbPatient);
    }

    /**
     * 异步删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Integer id){
        return lbPatientMapper.deleteById(id);
    }
}
