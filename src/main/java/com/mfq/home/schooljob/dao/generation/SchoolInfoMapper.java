package com.mfq.home.schooljob.dao.generation;

import com.mfq.home.schooljob.domain.generation.SchoolInfo;
import com.mfq.home.schooljob.domain.generation.SchoolInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolInfoMapper {
    long countByExample(SchoolInfoExample example);

    int deleteByExample(SchoolInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SchoolInfo record);

    int insertSelective(SchoolInfo record);

    List<SchoolInfo> selectByExample(SchoolInfoExample example);

    SchoolInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByExample(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByPrimaryKeySelective(@Param("record") SchoolInfo record);

    int updateByPrimaryKey(SchoolInfo record);
}