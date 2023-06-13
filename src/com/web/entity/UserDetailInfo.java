package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailInfo {
    private Integer id;
    private String nickName;
    private String name;
    private Integer sex;
    private String tel;
    private String province;
    private String city;
    private String district;
    private String address;
    private Integer status;
}
