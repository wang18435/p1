package com.lb.controller.admin;


import com.lb.entity.LbDrugs;
import com.lb.mapper.LbDrugsMapper;
import com.lb.vo.ResponseResult;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/drugs")
public class DrugsController {
    @Autowired
    private LbDrugsMapper lbDrugsMapper;

    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String type,
                         Model model) {
        //分页查询
        PageQuery<LbDrugs> page = lbDrugsMapper.findList(pageNo,pageSize,name,type);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("name",name);
        model.addAttribute("type",type);
        model.addAttribute("path","/admin/drugs/manage");
        return "admin/drugsManage";
    }

    /**
     * 新增
     */
    @RequestMapping("/")
    public String addForm(LbDrugs lbDrugs,Model model) {
        model.addAttribute("drugs",lbDrugs);
        return "admin/drugsForm";
    }

    /**
     * 编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("drugs",lbDrugsMapper.findOne(id));
        return "admin/drugsForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseResult insert(@RequestBody LbDrugs lbDrugs) {
        return lbDrugsMapper.insertDrugs(lbDrugs);
    }

    /**
     * 异步更新记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody LbDrugs lbDrugs) {
        return lbDrugsMapper.updateDrugs(lbDrugs);
    }

    /**
     * 异步删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable Integer id){
        return lbDrugsMapper.deleteDrugs(id);
    }
}
