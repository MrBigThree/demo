package org.example.design.pattern.zhss.facade;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        SystemFacade systemFacade = new SystemFacade();
        systemFacade.operate();
    }

}

class SystemFacade {

    public void operate() {
        SystemA systemA = new SystemA();
        systemA.operate();
        SystemB systemB = new SystemB();
        systemB.operate();
        SystemC systemC = new SystemC();
        systemC.operate();
    }
}

class SystemA {

    public void operate() {
        System.out.println("A系统操作");
    }
}

class SystemB {
    public void operate() {
        System.out.println("B系统操作");
    }

}

class SystemC {
    public void operate() {
        System.out.println("C系统操作");
    }

}
