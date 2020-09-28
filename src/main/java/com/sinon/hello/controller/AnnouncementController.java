package com.sinon.hello.controller;

import com.sinon.hello.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementController
 * @CreateDate 2020/9/23
 */
@RestController
@RequestMapping("/test")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("getMaster/{id}")
    public String GetTest(@PathVariable int id) {
        return announcementService.selectTest(id).toString();
    }

    @RequestMapping("getSlave/{id}")
    public String GetTest2(@PathVariable int id) {
        return announcementService.selectOne(id).toString();
    }

}
