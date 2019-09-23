package com.mfq.home.schooljob.service.impl;

import com.mfq.home.schooljob.dao.generation.SchoolInfoMapper;
import com.mfq.home.schooljob.domain.generation.SchoolInfo;
import com.mfq.home.schooljob.service.SchoolService;
import com.mfq.home.schooljob.util.IdWorker;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.mfq.home.schooljob.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SchoolServiceImpl implements SchoolService {


    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<SchoolInfo> findAllSchool() {
        return null;
    }

    @Override
    public SchoolInfo findSchoolById(String id) {
        return schoolInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveSchoolInfo(SchoolInfo schoolInfo) {
        Date now = new Date();
        schoolInfo.setId(IdWorker.getNextId());
        schoolInfo.setCreatedAt(now);
        schoolInfo.setUpdatedAt(now);
        return schoolInfoMapper.insertSelective(schoolInfo);
    }

    @Override
    public int updateSchoolInfo(SchoolInfo schoolInfo) {
        return 0;
    }

    @Override
    public int deleteSchoolInfo(String id) {
        return 0;
    }

}
