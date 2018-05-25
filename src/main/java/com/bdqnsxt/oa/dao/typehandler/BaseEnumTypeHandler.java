package com.bdqnsxt.oa.dao.typehandler;


import com.bdqnsxt.oa.enums.GenderEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import com.bdqnsxt.oa.model.User;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

@MappedTypes({GenderEnum.class,User.StatusEnum.class})
public class BaseEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E>{

    private Class<E> type;

    public BaseEnumTypeHandler() {}

    public BaseEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            String codeOrName = parameter.toString();
            if(StringUtils.isNumeric(codeOrName)){
                ps.setInt(i,Integer.valueOf(codeOrName));
            }else{
                ps.setString(i,codeOrName);
            }
        } else {
            ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getString(columnIndex));
    }

    private E get(String v) {
        if (StringUtils.isEmpty(v)) return null;
        if (StringUtils.isNumeric(v)) {
            return getEnum(type,Integer.valueOf(v));
        } else {
            return Enum.valueOf(type,v);
        }
    }

    private <E extends Enum<E>> E getEnum(Class<E> type, int v) {
        Method method = null;
        E result = null;
        try {
            method = type.getMethod("getEnum", int.class);
            result = (E)method.invoke(type, v);
        } catch (NoSuchMethodException e) {
            result = Enum.valueOf(type, String.valueOf(v));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }
}
