package domain;

public class RedheadDuck extends Duck{
	//ί������ʵ�ֽкͷɵľ�����Ϊ��������Ĺ��췽���ж���кͷɵľ��巽��
	public RedheadDuck(){
		quackBehavior=new MuteQuack();
		flyBehavior=new FlyWithRocket();
	}
}
