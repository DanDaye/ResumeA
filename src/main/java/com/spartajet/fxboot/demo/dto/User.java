package com.spartajet.fxboot.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    //姓名
    private String username;
    //联系方式
    private String phone;
    //邮箱
    private String mail;
    //特征点
    private String feature;
    //工作经历
    private String workExperience;
    //学历
    private String qualifications;
    //学校
    private String school;

}
