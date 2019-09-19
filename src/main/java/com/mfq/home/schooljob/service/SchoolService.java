package com.mfq.home.schooljob.service;

import com.mfq.home.schooljob.domain.generation.SchoolInfo;

import java.util.List;

public interface SchoolService {

    List<SchoolInfo> findAllSchool();

    SchoolInfo findSchoolById(String id);

    int saveSchoolInfo(SchoolInfo schoolInfo);

    int updateSchoolInfo(SchoolInfo schoolInfo);

    int deleteSchoolInfo(String id);

}
