package com.converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//自定义转换器
public class BooleanAndIntConverter extends BaseTypeHandler {
    /*
    * java(boolean)->DB(number)
    * preparedStatement对象
    * i,preparedStatement对象操作参数的位置
    * o,java值
    * jdbcType,操作的数据库类型*/
    @Override
//    将传过来的true或false变成1或0
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        if(o.equals("true")){
            preparedStatement.setInt(i,1);
        } else {
            preparedStatement.setInt(i,0);
        }
    }

//    DB(number)->Java(boolean)
    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        return sex==1?true:false;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return sex==1?true:false;
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        return sex==1?true:false;
    }
}
