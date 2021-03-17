package org.example.design.pattern.zhss.adapter;


/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class AdapterDesignPattenDemo {

    public static void main(String[] args) {
        NewInterface newInterfaceAdapter = new NewInterfaceAdapter(new OldInterfaceImpl());

        newInterfaceAdapter.newRequest();
    }

}

interface OldInterface {
    void oldRequest();
}

class OldInterfaceImpl implements OldInterface {

    @Override
    public void oldRequest() {
        System.out.println("旧接口");
    }
}

interface NewInterface {
    void newRequest();
}

class NewInterfaceAdapter implements NewInterface {

    private OldInterface oldInterface;

    public NewInterfaceAdapter(OldInterface oldInterface) {
        this.oldInterface = oldInterface;
    }

    @Override
    public void newRequest() {
        this.oldInterface.oldRequest();
    }
}
