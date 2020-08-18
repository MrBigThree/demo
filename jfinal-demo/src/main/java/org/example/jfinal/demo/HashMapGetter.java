package org.example.jfinal.demo;

import com.jfinal.core.Action;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.ParaGetter;

import java.util.HashMap;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/18
 */
public class HashMapGetter extends ParaGetter<HashMap> {

    public HashMapGetter(String parameterName, String defaultValue) {
        super(parameterName, defaultValue);
    }

    @Override
    protected HashMap<String, String> to(String v) {
        return null;
    }

    @Override
    public HashMap<String, String> get(Action action, Controller c) {
        return null;
    }
}
