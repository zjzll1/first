package cn.yunhe.entity;

import lombok.Data;

@Data
public class Orders {

    private Integer id;
    private Integer uid;
    private String ordertime;
    private double money;
    private User user;
}
