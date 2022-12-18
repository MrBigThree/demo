package com.example.springbootdemo.statemachine;

public enum EventEnum {
    //未连接
    UNCONNECTED,
    // 连接
    CONNECT,
    // 更新
    UPDATE,
    // 更新成功
    UPDATE_SUCCESS,
    // 更新过期人员
    UPDATE_EXPER,
    // 更新失败
    UPDATE_FAILED,
    // 注销
    END;
}
