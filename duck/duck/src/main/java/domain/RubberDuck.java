package domain;

public class RubberDuck extends Duck{
	//ί������ʵ�ֽкͷɵľ�����Ϊ��������Ĺ��췽���ж���кͷɵľ��巽��
	public RubberDuck(){
		quackBehavior=new Squeak();
		flyBehavior=new FlyNoway();
	}
}
