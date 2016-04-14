package com.mySSH.web.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HqlUtils {
	private Object object;  
    private boolean likeSel;  
    public boolean isLikeSel() {  
        return likeSel;  
    }    
    public void setLikeSel(boolean likeSel) {  
        this.likeSel = likeSel;  
    }   
    public Object getObject() {  
        return object;  
    }  
    public void setObject(Object object) {  
        this.object = object;  
    }  
    private HqlUtils() {  
    }   
    public static HqlUtils newInstanceByObj(Object object,boolean likeSel) {  
        HqlUtils hqlUtils = new HqlUtils();  
        hqlUtils.setObject(object);  
        hqlUtils.setLikeSel(likeSel);
        return hqlUtils;  
    }  
    /**
     * 生成hql多条件组合查询语句
     * @return
     * @throws Exception
     */
    public String getHql() throws Exception {  
        StringBuffer sbf = new StringBuffer("from Object where ");    
        Class<?> theClass = this.getObject().getClass();  
        sbf.replace(5, 11, theClass.getSimpleName());  
        Field[] fields = object.getClass().getDeclaredFields();  
        //遍历所有属性
        for (Field field : fields) {  
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),  
                    theClass);  
            Method getMethod = pd.getReadMethod();  
            Object objTemp = getMethod.invoke(object);  
            if (objTemp == null||objTemp.toString().equals("0")) {  
                continue;  
            }  
            if (isLikeSel()) {  
                sbf.append(field.getName() + " like '%" + objTemp + "%'");  
                sbf.append(" and ");  
            }
            else {  
                sbf.append(field.getName() + "='" + objTemp + "'");  
                sbf.append(" and ");  
            }  
        }  
        if (sbf.toString().endsWith("and ")) {  
            sbf.delete(sbf.length() - "and".length() - 1, sbf.length());  
        }  
        if (sbf.toString().endsWith("where ")) {  
            sbf.delete(sbf.length() - "where".length() - 1, sbf.length());  
        }  
        return sbf.toString();  
    }  
  
}
