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


    private static String httpPrefix="https://peda.smu.ac.kr";

    private static String pageUrl ="/grad/admission/student.do";

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

    public static void main(String[] args) {
        //请求页面地址，获取html页面
        Document doc = null;
        try {
            doc = Jsoup.connect(httpPrefix+pageUrl).get();
            Elements elementsByClass = doc.getElementsByClass("lnk-btn02 bg-lightblue");
            String href = elementsByClass.attr("href");

            String fileUrl = httpPrefix + href;
            System.out.println(fileUrl);

            HttpResponse httpResponse = HttpUtil.getHttpResponse(fileUrl, "get");
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            //String header = Jsoup.connect(fileUrl).execute().header("Content-Disposition");//attachment; filename="2019_fall2_admission_foreigner_CN.pdf"

            Pattern pattern = Pattern.compile("filename=\"(.*?)\"");// 匹配的模式
            Matcher m = pattern.matcher(headers[0].getValue());
            while(m.find()){
                String fileName =  m.group(1);
                System.out.println(fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
