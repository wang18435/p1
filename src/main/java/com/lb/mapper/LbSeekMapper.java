package com.lb.mapper;


import com.lb.entity.LbSeek;
import com.lb.vo.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Repository
@Mapper
public interface LbSeekMapper {
    //保存记录
    ResponseResult save(Map map, HttpSession session);

    //更新记录
    ResponseResult update(Map map, HttpSession session);

    //获取一条记录
    LbSeek findOneByPatientId(Integer patientId, Integer appointmentId, HttpSession session);
}
