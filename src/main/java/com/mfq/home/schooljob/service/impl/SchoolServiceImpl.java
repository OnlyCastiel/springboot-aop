package com.mfq.home.schooljob.service.impl;

import com.mfq.home.schooljob.dao.generation.SchoolInfoMapper;
import com.mfq.home.schooljob.domain.generation.SchoolFileInfo;
import com.mfq.home.schooljob.domain.generation.SchoolInfo;
import com.mfq.home.schooljob.domain.generation.SchoolInfoExample;
import com.mfq.home.schooljob.service.SchoolFileInfoService;
import com.mfq.home.schooljob.service.SchoolService;
import com.mfq.home.schooljob.util.IdWorker;
import com.mfq.home.schooljob.util.MailUtil;
import com.mfq.home.schooljob.util.RecruitFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Method;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {


    @Autowired
    private SchoolFileInfoService schoolFileInfoService;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<SchoolInfo> findAllSchool() {
        SchoolInfoExample example = new SchoolInfoExample();
        return schoolInfoMapper.selectByExample(example);
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


    public void invokeSchoolInfo(){
        try {
            List<SchoolInfo> allSchool = findAllSchool();
            for(SchoolInfo schoolInfo : allSchool){
                log.info("解析{}{}信息开始",schoolInfo.getSchoolName(),schoolInfo.getSchoolNamecCh());
                if(StringUtils.isEmpty(schoolInfo.getMethodName())){
                    log.warn("该学校未部署对应解析方法");
                    continue;
                }
                //查询该校已有最新解析文件内容
                SchoolFileInfo oldFile = schoolFileInfoService.getLastSchoolFileInfoBySchoolId(schoolInfo.getId());


                //解析最新公布内容
                Method method = RecruitFileUtil.class.getMethod(schoolInfo.getMethodName(),SchoolInfo.class);
                SchoolFileInfo newFile =(SchoolFileInfo) method.invoke(RecruitFileUtil.class,schoolInfo);


                //比对是否一致，若不一致，则更新存储
                if(oldFile != null){
                    //文件码校验情况
                    if(StringUtils.isNotEmpty(newFile.getFileCode())){
                        if(StringUtils.equals(newFile.getFileCode(),oldFile.getFileCode())){
                            //文件md5码一致，不用更新
                            continue;
                        }
                    }else{
                        //文件名校验情况
                        if(StringUtils.equals(newFile.getFileName(),oldFile.getFileName())){
                            //文件名一致，不用更新
                            continue;
                        }
                    }
                }
                //其余情况均需要保存新文件，并发送邮件通知
                if(newFile != null){
                    Date now = new Date();
                    newFile.setCreatedAt(now);
                    newFile.setUpdatedAt(now);
                    schoolFileInfoService.saveSchoolFileInfo(newFile);
                    String text = schoolInfo.getSchoolName()+"招生简章已更新;地址"+schoolInfo.getHomepageUrl()+schoolInfo.getRecruitStudentsUrl();
                    MailUtil.sendText("招生简章更新通知","2874290468@qq.com","824717045@qq.com",text);
                }else{
                    MailUtil.sendText("招生简章获取出错","2874290468@qq.com","824717045@qq.com","");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
