package com.sinon.hello.mapper;

import com.sinon.hello.annotation.MasterDataSource;
import com.sinon.hello.annotation.SlaveDataSource;
import com.sinon.hello.config.datasource.BalanceTypeEnum;
import com.sinon.hello.entity.AnnouncementDO;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementMapper
 * @CreateDate 2020/9/23
 */
@Repository
public interface AnnouncementMapper {

    @MasterDataSource()
    AnnouncementDO selectTest(int id);

    @SlaveDataSource(balanceType = BalanceTypeEnum.RANDOM)
    AnnouncementDO selectOne(int id);
}

