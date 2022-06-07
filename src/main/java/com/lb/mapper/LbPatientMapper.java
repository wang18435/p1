package com.lb.mapper;


import com.lb.entity.LbPatient;
import com.lb.vo.QueryVo;
import com.lb.vo.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LbPatientMapper {
    //查集合
    PageQuery<LbPatient> findList(QueryVo queryVo);

    /**
     * 查询所有病人
     */
    List<LbPatient> findAll();

    /**
     * 保存
     */
    ResponseResult insertPatient(LbPatient lbPatient);

    /**
     * 更新记录
     */
    ResponseResult updatePatient(LbPatient lbPatient);

    /**
     * 根据主键id查询
     */
    LbPatient findOne(Integer id);

    /**
     * 删除
     */
    ResponseResult deleteById(Integer id);

    /**
     * 根据userid获取患者信息
     */
    LbPatient findOneByUserId(Integer userId);

    /**
     * 查询信息（医生、疾病、药品）
     */
    Map<String,List> findInfo(String type, String name);
}
