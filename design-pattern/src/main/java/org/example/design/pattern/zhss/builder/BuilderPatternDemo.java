package org.example.design.pattern.zhss.builder;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        ComplexObject build = ComplexObject.builder().field1("field1").field2("field2").build();
    }
}

class ComplexObject {

    private String filed1;

    private String filed2;

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public String getFiled2() {
        return filed2;
    }

    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String filed1;

        private String filed2;

        public Builder field1(String filed1) {
            System.out.println("进行一些操作，转换");
            this.filed1 = filed1;
            return this;
        }

        public Builder field2(String filed2) {
            System.out.println("进行一些操作，转换");
            this.filed2 = filed2;
            return this;
        }

        public ComplexObject build() {
            ComplexObject complexObject = new ComplexObject();
            complexObject.setFiled1(filed1);
            complexObject.setFiled2(filed2);
            return complexObject;
        }

    }

}
