package com.example.springbootdemo.statemachine;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/3/6
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 功能:状态机
 * 2019年6月22日  v0.1
 *
 * @author 陆杰
 * @since 0.1
 */
@WithStateMachine
public class StateMachineEventConfig {

    Logger logger = LoggerFactory.getLogger(StateMachineEventConfig.class);


    @OnTransition(source = "UNCONNECTED", target = "START")
    public void connect() {

        //login

        logger.info("连接事件, 未连接 -> 已连接");
    }

    @OnTransition(source = "START", target = "UPDATE")
    public void update() throws InterruptedException {

        logger.info("UpdateIncrease----");
//        iSqliteService.insertLogViewWithStartTime(iSeverUtil.timeLtoS(System.currentTimeMillis()));
//        infoService.UpdateTheFailMessage();
//        infoService.UpdateFromRemoteDB();
        Thread.sleep(2000);
    }

    @OnTransition(source = "START", target = "UPDATE_EXPER")
    public void upExperson() throws InterruptedException {

        logger.info("UpdateEx----");
       // infoService.UpdateExPerson();
        Thread.sleep(2000);
    }

    @OnTransition(source = "UPDATE", target = "END")
    public void updateSuccess() {
        logger.info("update success!");

    }

    @OnTransition(source = "END", target = "UNCONNECTED")
    public void unConnectSuccess() {
        logger.info("connect cancel");
    }

}
