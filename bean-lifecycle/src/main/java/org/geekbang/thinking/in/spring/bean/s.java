package org.geekbang.thinking.in.spring.bean;

public class s {
}

//使用有状态 Command 样式的类执行某些处理的类
public class CommandManager implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Object process(Map commandState) {        //获取适当命令的新实例
        Command command = createCommand();        /// 在（希望是全新的）Command 实例上设置状态
        command.setState(commandState);
        return command.execute();
    }

    protected Command createCommand() {        //注意 Spring API 的依赖！
        return this.applicationContext.getBean("command", Command.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}