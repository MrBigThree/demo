package org.example.jfinal.demo;

import com.jfinal.core.Controller;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/6
 */
public class HelloController extends Controller {

    public void index() {
        renderText("hello world");
        renderNull();
    }

}
