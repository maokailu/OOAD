package domain;

public class MallardDuck extends Duck{
	//ί������ʵ�ֽкͷɵľ�����Ϊ��������Ĺ��췽���ж���кͷɵľ��巽��
	public MallardDuck(){
		quackBehavior=new Quack();
		flyBehavior=new FlyWithWings();
	}
}
