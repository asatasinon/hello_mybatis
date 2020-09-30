package com.sinon.hello.service;

import com.sinon.hello.annotation.MasterDataSource;
import com.sinon.hello.annotation.SlaveDataSource;
import com.sinon.hello.entity.AnnouncementDO;
import com.sinon.hello.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementService
 * @CreateDate 2020/9/23
 */

@Service
public class AnnouncementService  {
    private final AnnouncementMapper announcementMapper;

    public AnnouncementService(AnnouncementMapper announcementMapper) {
        this.announcementMapper = announcementMapper;
    }

    public AnnouncementDO selectTest(int id) {
        return announcementMapper.selectTest(id);
    }

    public AnnouncementDO selectOne(int id) {
        return announcementMapper.selectOne(id);
    }


//    @Scheduled(cron = "*/1 * * * * ?")
//    public void test(){
//        System.out.println(new Date());
//    }

}
