package com.sinon.hello.service;

import com.sinon.hello.entity.AnnouncementDO;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description IAnnouncementService
 * @CreateDate 2020/11/27
 */
public interface IAnnouncementService {

    AnnouncementDO selectTest(int id);

    AnnouncementDO selectOne(int id);
}
