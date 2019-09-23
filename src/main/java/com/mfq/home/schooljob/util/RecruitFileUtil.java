package com.mfq.home.schooljob.util;

import com.mfq.home.schooljob.domain.generation.SchoolFileInfo;
import com.mfq.home.schooljob.domain.generation.SchoolInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RecruitFileUtil {


    private static String httpPrefix="https://peda.smu.ac.kr";

    private static String pageUrl ="/grad/admission/student.do";




    public static SchoolFileInfo SmuRecruitFile(SchoolInfo schoolInfo){
        //请求页面地址，获取html页面
        Document doc = null;
        try {
            SchoolFileInfo fileInfo = new SchoolFileInfo();
            fileInfo.setSchoolId(schoolInfo.getId());

            doc = Jsoup.connect(schoolInfo.getHomepageUrl()+schoolInfo.getRecruitStudentsUrl()).get();
            Elements elementsByClass = doc.getElementsByClass("lnk-btn02 bg-lightblue");
            String href = elementsByClass.attr("href");

            String fileUrl = schoolInfo.getHomepageUrl() + href;
            fileInfo.setFileUrl(fileUrl);
            log.info("成功找到文件，地址为："+fileUrl);

            HttpResponse httpResponse = HttpUtil.getHttpResponse(fileUrl, "get");
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            //String header = Jsoup.connect(fileUrl).execute().header("Content-Disposition");//attachment; filename="2019_fall2_admission_foreigner_CN.pdf"

            Pattern pattern = Pattern.compile("filename=\"(.*?)\"");// 匹配的模式
            Matcher m = pattern.matcher(headers[0].getValue());
            while(m.find()){
                String fileName =  m.group(1);
                fileInfo.setFileName(fileName);
                log.info("获取文件名为："+fileName);
            }
            return fileInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static SchoolFileInfo DankookRecruitFile(SchoolInfo schoolInfo){
        //请求页面地址，获取html页面
        Document doc = null;
        try {
            SchoolFileInfo fileInfo = new SchoolFileInfo();
            fileInfo.setSchoolId(schoolInfo.getId());

            doc = Jsoup.connect(schoolInfo.getHomepageUrl()+schoolInfo.getRecruitStudentsUrl()).get();
            Elements iframe = doc.select("iframe[src]"); //带有src属性的iframe元素
            String src = iframe.attr("src");
            //获取地址，需要解析 尾缀推测为md5码，通过md5码来判断是否有更新
            // src=/html/pdfjs/web/viewer.html?file=/documents/2801066/0/2019+%E6%8B%9B%E7%94%9F%E7%AE%80%E7%AB%A0.pdf/db7a8692-aa7e-40ee-be60-11319c28927c

            String[] urlParts = src.split("\\?");
            if (urlParts.length == 1) {
                //解析失败，规则改变
                return null;
            }
            //解析成功
            String[] params = urlParts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if(StringUtils.equals(keyValue[0],"file")){
                    //获取file参数，需要匹配md5码，判断是否更新过
                    String fileSrc = keyValue[1];
                    // fileSrc=/documents/2801066/0/2019+%E6%8B%9B%E7%94%9F%E7%AE%80%E7%AB%A0.pdf/db7a8692-aa7e-40ee-be60-11319c28927c
                    String[] links = fileSrc.split("/");
                    StringBuilder fileUrl = new StringBuilder();
                    for (String link : links) {
                        if(link.endsWith(".pdf")){
                            fileInfo.setFileUrl(schoolInfo.getHomepageUrl() + fileUrl.append(link).toString());
                            log.info("成功找到文件，地址为："+fileInfo.getFileUrl());
                            //解析文件名，url解码
                            String fileName = URLDecoder.decode(link, "UTF-8");
                            fileName = fileName.replace(" ","+");
                            fileInfo.setFileName(fileName);
                            log.info("获取文件名为："+fileName);

                            String fileCode = fileSrc.replace(fileUrl.append("/").toString(),"");
                            fileInfo.setFileCode(fileCode);
                            log.info("解析到文件MD5值为:"+fileCode);
                        }else{
                            fileUrl.append(link).append("/");
                        }
                    }
                }
            }
            return fileInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
/*        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setId("624253231643758592");
        schoolInfo.setHomepageUrl("https://peda.smu.ac.kr");
        schoolInfo.setRecruitStudentsUrl("/grad/admission/student.do");

        SchoolFileInfo schoolFileInfo = SmuRecruitFile(schoolInfo);
        System.out.println("schoolFileInfo.toString()");*/

        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.setId("625716191994056704");
        schoolInfo.setHomepageUrl("http://graduate.dankook.ac.kr");
        schoolInfo.setRecruitStudentsUrl("/web/graduate/guidec");

        SchoolFileInfo schoolFileInfo = DankookRecruitFile(schoolInfo);
        System.out.println(schoolFileInfo.toString());
    }

}
