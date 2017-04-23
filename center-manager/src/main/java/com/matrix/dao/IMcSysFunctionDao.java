package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.McSysFunction;

public interface IMcSysFunctionDao extends IBaseDao<McSysFunction, Integer>{ 
    public List<McSysFunction> getSysFuncList(McSysFunction e);  
}