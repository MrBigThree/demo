package com.example.springbootdemo.statemachine;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/3/6
 */
public enum StatusEnum {

    // 未连接
    UNCONNECTED,
    //开始
    START,
    // 更新中
    UPDATE,
    // 更新过期人员
    UPDATE_EXPER,
    // 结束
    END,
}
