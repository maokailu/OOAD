package test;

import domain.Duck;
import domain.MallardDuck;
import domain.Squeak;

public class DuckSimular {
	public static void main(String[] args){
		//委托子类定义野鸭叫的方式，选择new相应的接口实现
		Duck mallard=new MallardDuck();
		mallard.performQuack();
		//动态注入橡胶鸭子叫的方式
		mallard.setQuackBehavior(new Squeak());
	    mallard.performQuack();
	}
}
