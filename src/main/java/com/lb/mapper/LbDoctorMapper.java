package com.lb.mapper;


import com.lb.entity.LbDoctor;
import com.lb.vo.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LbDoctorMapper {
    //查医生集合
    PageQuery<LbDoctor> findList(Integer pageNo, Integer pageSize, String name, String certId);

    //查询所有
    List<LbDoctor> findAll();

    /**
     * 保存
     */
    ResponseResult insertDoctor(LbDoctor lbDoctor);

    /**
     * 更新记录
     */
    ResponseResult updateDoctor(LbDoctor lbDoctor);

    /**
     * 根据主键id查询医生
     */
    LbDoctor findOne(Integer id);

    /**
     * 删除医生
     */
    ResponseResult deleteDoctor(Integer id);

    /**
     * 根据部门id获取医生
     */
    List<LbDoctor> getListByDepartment(String department);

    /**
     * 根据userID查询医生
     */
    LbDoctor findOneByUserId(Integer userId);
}
