package cn.yunhe.entity;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String birthday;
    private String sex;
    private String address;
    private List<Role> roleList;
}
