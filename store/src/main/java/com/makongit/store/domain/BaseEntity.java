package com.makongit.store.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 实体类的基类 */

@Data
public class BaseEntity implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
