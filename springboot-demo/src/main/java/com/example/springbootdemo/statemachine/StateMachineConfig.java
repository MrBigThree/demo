package com.example.springbootdemo.statemachine;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/3/6
 */


import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;


import java.util.EnumSet;

/**
 * @author 陆杰
 * @since 0.1
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StatusEnum, EventEnum> {

    /**
     * 初始化状态机状态
     */
    @Override
    public void configure(StateMachineStateConfigurer<StatusEnum, EventEnum> states) throws Exception {
        states.withStates()
                // 定义初始状态
                .initial(StatusEnum.UNCONNECTED)
                // 定义状态机状态
                .states(EnumSet.allOf(StatusEnum.class));
    }

    /**
     * 初始化状态迁移事件
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<StatusEnum, EventEnum> transitions)
            throws Exception {
        transitions
                // 1.连接事件
                // 未连接 -> 已连接
                .withExternal()
                .source(StatusEnum.UNCONNECTED)
                .target(StatusEnum.START)
                .event(EventEnum.CONNECT)
                .and()

                // 2.更新事件
                // 已连接 -> 更新中
                .withExternal()
                .source(StatusEnum.START)
                .target(StatusEnum.UPDATE)
                .event(EventEnum.UPDATE)
                .and()
                // 更新过期人员
                .withExternal()
                .source(StatusEnum.START)
                .target(StatusEnum.UPDATE_EXPER)
                .event(EventEnum.UPDATE_EXPER)
                .and()
                .withExternal()
                .source(StatusEnum.UPDATE_EXPER)
                .target(StatusEnum.END)
                .event(EventEnum.UPDATE_SUCCESS)
                .and()
                // 3.更新成功事件
                //更新中 -> 已完成
                .withExternal()
                .source(StatusEnum.UPDATE)
                .target(StatusEnum.END)
                .event(EventEnum.UPDATE_SUCCESS)
                .and()

                // 5.结束事件
                // 已完成 -> 未连接
                .withExternal()
                .source(StatusEnum.END)
                .target(StatusEnum.UNCONNECTED)
                .event(EventEnum.END)
        ;
    }
}
