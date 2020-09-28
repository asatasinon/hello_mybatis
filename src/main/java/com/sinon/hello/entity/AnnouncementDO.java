package com.sinon.hello.entity;

import lombok.Data;

import java.util.Date;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementDO
 * @CreateDate 2020/9/23
 */
@Data
public class AnnouncementDO {
    private int id;
    private String title;
    private String content;
    private boolean is_show;
    private int level;
    private int post_user_id;
    private int post_department_id;
    private Date post_time;
    private Date expired_time;
    private boolean is_remove;
    private int enterprise_id;
    private Date update_time;
}