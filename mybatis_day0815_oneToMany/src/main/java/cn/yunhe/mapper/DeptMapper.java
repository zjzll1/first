package cn.yunhe.mapper;

import cn.yunhe.entity.Dept;
import cn.yunhe.entity.Emp;

import java.util.List;

public interface DeptMapper {

    Dept findEmpDept(String dname);

    Dept findDept(String dname);
}
