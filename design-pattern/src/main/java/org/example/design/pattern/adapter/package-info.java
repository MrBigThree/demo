/**
 * 适配器模式
 * <p>
 * Convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
 * (将一个类的接口变换成客户 端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。)
 * </p>
 * <p>
 * 代码示例是最通俗，最常用的适配器模式，
 * 其实我们经常见到另外一种适配器模式，接口适配器模式（也叫缺省适配器模式），
 * 当我们不想实现某个接口的全部方法时，可以先设计一个抽象类实现该接口，
 * 并实现接口中的所有方法（但是在方法中不做任何操作），那么当我们继承这个抽象类时，就可以只重写部分方法，从而达到我们的目的
 *
 * </p>
 */
package org.example.design.pattern.adapter;