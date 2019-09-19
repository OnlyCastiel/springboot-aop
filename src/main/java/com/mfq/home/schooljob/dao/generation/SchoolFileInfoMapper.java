package com.mfq.home.schooljob.dao.generation;

import com.mfq.home.schooljob.domain.generation.SchoolFileInfo;
import com.mfq.home.schooljob.domain.generation.SchoolFileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolFileInfoMapper {
    long countByExample(SchoolFileInfoExample example);

    int deleteByExample(SchoolFileInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SchoolFileInfo record);

    int insertSelective(SchoolFileInfo record);

    List<SchoolFileInfo> selectByExample(SchoolFileInfoExample example);

    SchoolFileInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SchoolFileInfo record, @Param("example") SchoolFileInfoExample example);

    int updateByExample(@Param("record") SchoolFileInfo record, @Param("example") SchoolFileInfoExample example);

    int updateByPrimaryKeySelective(@Param("record") SchoolFileInfo record);

    int updateByPrimaryKey(SchoolFileInfo record);
}