package test;

import domain.Duck;
import domain.MallardDuck;
import domain.Squeak;

public class DuckSimular {
	public static void main(String[] args){
		//ί�����ඨ��ҰѼ�еķ�ʽ��ѡ��new��Ӧ�Ľӿ�ʵ��
		Duck mallard=new MallardDuck();
		mallard.performQuack();
		//��̬ע����Ѽ�ӽеķ�ʽ
		mallard.setQuackBehavior(new Squeak());
	    mallard.performQuack();
	}
}
