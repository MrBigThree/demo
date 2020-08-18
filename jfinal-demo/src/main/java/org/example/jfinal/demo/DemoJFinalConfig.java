package org.example.jfinal.demo;

import com.jfinal.config.*;
import com.jfinal.core.paragetter.ParaProcessorBuilder;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import org.example.jfinal.demo.model._MappingKit;

import java.util.HashMap;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/6
 */
public class DemoJFinalConfig extends JFinalConfig {

    private static ParaProcessorBuilder builder;

    @Override
    public void configConstant(Constants constants) {
        constants.setJsonFactory(MixedJsonFactory.me());
        ClassLoader classLoader1 = ParaProcessorBuilder.me.getClass().getClassLoader();
        ParaProcessorBuilder.me.regist(HashMap.class, HashMapGetter.class, null);
        System.out.println(classLoader1.getClass().getName());
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/demo", "root", "123456789");
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        _MappingKit.mapping(arp);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }

    @Override
    public void onStart() {

    }

    public static void main(String[] args) {
        UndertowServer.start(DemoJFinalConfig.class, 8080, true);
        ClassLoader classLoader1 = ParaProcessorBuilder.me.getClass().getClassLoader();
        System.out.println(classLoader1.getClass().getName());
    }
}
