abstract class Product{
    public abstract void Show();
}
//�����Ʒ��A
class  ProductA extends  Product{

    @Override
    public void Show() {
        System.out.println("�������˲�ƷA");
    }
}
//�����Ʒ��B
class  ProductB extends  Product{

    @Override
    public void Show() {
        System.out.println("�������˲�ƷB");
    }
}
//�����Ʒ��C
class  ProductC extends  Product{

    @Override
    public void Show() {
        System.out.println("�������˲�ƷC");
    }
}
class  Factory {
    public static Product Manufacture(String ProductName){
//����������switch����������������Ʒ��
//ʹ����ֻ��Ҫ���ù�����ľ�̬�����Ϳ���ʵ�ֲ�Ʒ���ʵ������
        switch (ProductName){
            case "A":
                return new ProductA();

            case "B":
                return new ProductB();

            case "C":
                return new ProductC();

            default:
                return null;

        }
    }
}
//������Ʒ��������
public class SimpleFactoryPattern {
    public static void main(String[] args){
        Factory mFactory = new Factory();

        //�ͻ�Ҫ��ƷA
        try {
//���ù�����ľ�̬���� & ���벻ͬ�����Ӷ�������Ʒʵ��
            mFactory.Manufacture("A").Show();
        }catch (NullPointerException e){
            System.out.println("û����һ���Ʒ");
        }

        //�ͻ�Ҫ��ƷB
        try {
            mFactory.Manufacture("B").Show();
        }catch (NullPointerException e){
            System.out.println("û����һ���Ʒ");
        }

        //�ͻ�Ҫ��ƷC
        try {
            mFactory.Manufacture("C").Show();
        }catch (NullPointerException e){
            System.out.println("û����һ���Ʒ");
        }

        //�ͻ�Ҫ��ƷD
        try {
            mFactory.Manufacture("D").Show();
        }catch (NullPointerException e){
            System.out.println("û����һ���Ʒ");
        }
    }
}

