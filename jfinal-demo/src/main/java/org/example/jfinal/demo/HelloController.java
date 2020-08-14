package org.example.jfinal.demo;

import com.jfinal.core.Controller;
import org.example.jfinal.demo.model.User;

import java.util.Map;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/6
 */
public class HelloController extends Controller {

    public void index(User user) {
        Map<String, String[]> paraMap = this.getParaMap();
        System.out.println(paraMap);
        user.removeNullValueAttrs().update();
        renderText("hello world");
        renderNull();
    }


}
