package com.sinon.hello.mapper;

import com.sinon.hello.annotation.MasterDataSource;
import com.sinon.hello.annotation.SlaveDataSource;
import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.entity.AnnouncementDO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementMapper
 * @CreateDate 2020/9/23
 */
@Repository
public interface AnnouncementMapper {

    @Cacheable(cacheNames = "announcement", key = "#id")
    @MasterDataSource()
    AnnouncementDO selectTest(int id);

    //@SlaveDataSource(balanceType = BalanceTypeEnum.ROUND_ROBIN)
    @MasterDataSource()
    AnnouncementDO selectOne(int id);
}

