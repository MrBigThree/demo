package org.example.design.pattern.zhss.factory.simple;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        Product product = Factory.getProduct();
        product.operation();
    }
}

interface Product {
    void operation();
}

class ProductImpl implements Product {

    @Override
    public void operation() {
        System.out.println("实现接口");
    }
}

class Factory {
    public static Product getProduct() {
        return new ProductImpl();
    }
}
