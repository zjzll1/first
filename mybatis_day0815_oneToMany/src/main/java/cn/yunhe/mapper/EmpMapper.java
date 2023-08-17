package cn.yunhe.mapper;

import cn.yunhe.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> findEmp(Integer deptno);
}
