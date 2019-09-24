package com.mfq.home.schooljob.service;

import com.mfq.home.schooljob.domain.generation.SchoolFileInfo;

import java.util.List;

public interface SchoolFileInfoService {

    List<SchoolFileInfo> getSchoolFileInfoListBySchoolId(String schoolId);

    SchoolFileInfo getLastSchoolFileInfoBySchoolId(String schoolId);

    int saveSchoolFileInfo(SchoolFileInfo schoolFileInfo);
}
