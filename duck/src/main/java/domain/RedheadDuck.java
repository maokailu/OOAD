package domain;

public class RedheadDuck extends Duck{
	//委托子类实现叫和飞的具体行为，在子类的构造方法中定义叫和飞的具体方法
	public RedheadDuck(){
		quackBehavior=new MuteQuack();
		flyBehavior=new FlyWithRocket();
	}
}
