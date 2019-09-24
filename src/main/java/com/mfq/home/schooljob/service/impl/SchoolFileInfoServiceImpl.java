package com.mfq.home.schooljob.service.impl;

import com.mfq.home.schooljob.dao.generation.SchoolFileInfoMapper;
import com.mfq.home.schooljob.domain.generation.SchoolFileInfo;
import com.mfq.home.schooljob.domain.generation.SchoolFileInfoExample;
import com.mfq.home.schooljob.service.SchoolFileInfoService;
import com.mfq.home.schooljob.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchoolFileInfoServiceImpl implements SchoolFileInfoService {


    @Autowired
    SchoolFileInfoMapper schoolFileInfoMapper;


    @Override
    public List<SchoolFileInfo> getSchoolFileInfoListBySchoolId(String schoolId) {
        if(StringUtils.isEmpty(schoolId)){
            return null;
        }
        SchoolFileInfoExample example = new SchoolFileInfoExample();
        SchoolFileInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSchoolIdEqualTo(schoolId);
        example.setOrderByClause("created_at desc");
        return schoolFileInfoMapper.selectByExample(example);
    }

    @Override
    public SchoolFileInfo getLastSchoolFileInfoBySchoolId(String schoolId) {
        List<SchoolFileInfo> fileInfoList = getSchoolFileInfoListBySchoolId(schoolId);
        if(fileInfoList != null &&fileInfoList.size() > 0){
            return fileInfoList.get(0);
        }
        return null;
    }

    @Override
    public int saveSchoolFileInfo(SchoolFileInfo schoolFileInfo) {
        schoolFileInfo.setId(IdWorker.getNextId());
        return schoolFileInfoMapper.insertSelective(schoolFileInfo);
    }
}
