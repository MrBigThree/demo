package org.example.jfinal.demo;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/13
 */
public class Gen {

    public static void main(String[] args) {

        // base model 所使用的包名
        String baseModelPkg = "org.example.jfinal.demo.model.base";
        // base model 文件保存路径
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/org/example/jfinal/demo/model/base";

        // model 所使用的包名
        String modelPkg = "org.example.jfinal.demo.model";
        // model 文件保存路径
        String modelDir = baseModelDir + "/..";
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/demo", "root", "123456789");
        dp.start();
        DataSource dataSource = dp.getDataSource();
        Generator gernerator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
        // 在 getter、setter 方法上生成字段备注内容
        gernerator.setGenerateRemarks(true);
        gernerator.generate();
    }
}
