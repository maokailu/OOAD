package domain;

public class RubberDuck extends Duck{
	//委托子类实现叫和飞的具体行为，在子类的构造方法中定义叫和飞的具体方法
	public RubberDuck(){
		quackBehavior=new Squeak();
		flyBehavior=new FlyNoway();
	}
}
