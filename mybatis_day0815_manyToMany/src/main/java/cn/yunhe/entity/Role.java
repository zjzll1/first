package cn.yunhe.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<User> userList;
}
