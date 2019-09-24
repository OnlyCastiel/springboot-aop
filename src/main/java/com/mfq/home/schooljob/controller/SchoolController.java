package com.mfq.home.schooljob.controller;

import com.mfq.home.schooljob.domain.generation.SchoolInfo;
import com.mfq.home.schooljob.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public SchoolInfo findOneCity(@PathVariable("id") String id) {
        return schoolService.findSchoolById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<SchoolInfo> findAllCity() {
        return schoolService.findAllSchool();
    }

    @RequestMapping(value = "/api/saveSchoolInfo", method = RequestMethod.POST)
    public void saveSchoolInfo(@RequestBody SchoolInfo schoolInfo) {
        schoolService.saveSchoolInfo(schoolInfo);
    }

    @RequestMapping(value = "/api/invokeSchoolInfo", method = RequestMethod.GET)
    public void invokeSchoolInfo() {
        schoolService.invokeSchoolInfo();
    }
}
