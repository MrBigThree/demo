package org.example.jfinal.demo;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/6
 */
public class HelloController extends Controller {

    public void index(HashMap<String, String> user) {

        ServiceB.me.doSomething();
        com.mysql.cj.jdbc.Driver s;
        renderNull();
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        ParameterizedTypeImpl genericSuperclass = (ParameterizedTypeImpl) map1.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            TypeVariableImpl actualType = (TypeVariableImpl) actualTypeArguments[i];
            System.out.println(actualType.getName());
        }
    }
}
