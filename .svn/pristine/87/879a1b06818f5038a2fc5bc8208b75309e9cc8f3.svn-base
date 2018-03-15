package com.hgicreate.rno.repository.io;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2016/12/29.
 */
public class ClassReader {
    public Map<String, Object> getClassInfo(Object obj){
        return this.getClassInfo(obj,obj.getClass());
    }
    public Map<String, Object> getFatherClassInfo(Object obj){
        Map<String, Object> result= this.getClassInfo(obj,obj.getClass().getSuperclass());
        result.remove("class");
        return result;
    }
    private Map<String, Object> getClassInfo(Object obj, Class classFields){
        Map<String, Object> result = new HashMap<>();
        BeanInfo info = null;
        try {
            info = Introspector.getBeanInfo(classFields);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        assert info != null;
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            Method reader = pd.getReadMethod();
            if (reader != null)
                try {
                    result.put(pd.getName(), reader.invoke(obj));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }
}
