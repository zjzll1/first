package cn.yunhe.entity;

import lombok.Data;

@Data
public class Orders {
    private Integer id;
    private Integer uid;
    private String ordertime;
    private double money;

    /*
     * 来表示 1对1的关系
     * */
    private User user;
}
