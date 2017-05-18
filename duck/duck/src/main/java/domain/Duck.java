package domain;

public abstract class Duck {
	//声明鸭子叫的接口和飞的接口；
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	//每种鸭子都公用的方法
	public void swim(){
	}
	public void display(){
	}
	//定义鸭子叫和飞的方法，调用接口中叫和飞的方法；
	public void performQuack(){
		quackBehavior.quack();
	}
	public void performFly(){
		flyBehavior.ﬂy();
	}
	//动态设定鸭子的行为
	public void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
}
