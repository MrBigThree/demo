package org.example.jfinal.demo;

import com.jfinal.core.Action;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.ParaGetter;
import com.jfinal.kit.Kv;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/18
 */
public class KvGetter extends ParaGetter<Kv> {

    public KvGetter(String parameterName, String defaultValue) {
        super(parameterName, defaultValue);
    }

    @Override
    protected Kv to(String v) {
        return null;
    }

    @Override
    public Kv get(Action action, Controller c) {
        return c.getKv();
    }
}
