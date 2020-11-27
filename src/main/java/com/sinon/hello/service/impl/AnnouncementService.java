package com.sinon.hello.service.impl;

import com.sinon.hello.annotation.MasterDataSource;
import com.sinon.hello.annotation.SlaveDataSource;
import com.sinon.hello.entity.AnnouncementDO;
import com.sinon.hello.mapper.AnnouncementMapper;
import com.sinon.hello.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementService
 * @CreateDate 2020/9/23
 */

@Service
@CacheConfig(cacheNames = "announcement")
@SlaveDataSource
public class AnnouncementService implements IAnnouncementService {
    private final AnnouncementMapper announcementMapper;

    @Autowired
    private AnnouncementService announcementService;

    public AnnouncementService(AnnouncementMapper announcementMapper) {
        this.announcementMapper = announcementMapper;
    }

    @SlaveDataSource
    @Override
    public AnnouncementDO selectTest(int id) {
        return announcementMapper.selectTest(id);
    }

    //@SlaveDataSource(balanceType = BalanceTypeEnum.ROUND_ROBIN)
    @MasterDataSource
    @Override
    public AnnouncementDO selectOne(int id) {
        AnnouncementDO announcementDO2 = announcementService.selectTest(id);
        AnnouncementDO announcementDO1 = announcementMapper.selectOne(id);
        System.out.println(announcementDO2);
        System.out.println(announcementDO1);
        return  announcementDO1;
    }


//    @Scheduled(cron = "*/1 * * * * ?")
//    public void test(){
//        System.out.println(new Date());
//    }

}
