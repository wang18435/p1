package com.lb.controller.admin;


import com.lb.entity.LbAppointment;
import com.lb.mapper.LbAppointmentMapper;
import com.lb.mapper.LbPatientMapper;
import com.lb.vo.QueryVo;
import com.lb.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/appointment")
public class AppointmentController {
    @Autowired
    private LbAppointmentMapper lbAppointmentMapper;
    @Autowired
    private LbPatientMapper lbPatientMapper;

    @RequestMapping("/manage")
    public String manage(QueryVo queryVo, Model model) {
        //查询预约记录
        PageQuery<LbAppointment> page = lbAppointmentMapper.findList(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("patientName",queryVo.getPatientName());
        model.addAttribute("doctorName",queryVo.getDoctorName());
        model.addAttribute("path","/admin/appointment/manage");
        return "admin/appointmentManage";
    }

    /**
     * 新增
     */
    @RequestMapping("/")
    public String doctorAddForm(LbAppointment lbAppointment,Model model) {
        model.addAttribute("patientList",lbPatientMapper.findAll());
        model.addAttribute("appointment",lbAppointment);
        return "admin/appointmentForm";
    }

    /**
     * 编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doctorEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment",lbAppointmentMapper.findOne(id));
        return "admin/appointmentForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseResult insert(@RequestBody LbAppointment lbAppointment) {
        return lbAppointmentMapper.insertAppointment(lbAppointment);
    }

    /**
     * 异步更新记录
     * @param lbAppointment
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody LbAppointment lbAppointment) {
        return lbAppointmentMapper.updateAppointment(lbAppointment);
    }

    /**
     * 异步删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Integer id){
        return lbAppointmentMapper.deleteById(id);
    }
}
