abstract class Factory{
    public abstract Product Manufacture();
}
abstract class Product{
    public abstract void Show();
}
class  ProductA extends  Product{
    @Override
    public void Show() {
        System.out.println("�������˲�ƷA");
    }
}
class  ProductB extends  Product{
 
    @Override
    public void Show() {
        System.out.println("�������˲�ƷB");
}
}
class  FactoryA extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}
class  FactoryB extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
public class FactoryPattern {
    public static void main(String[] args){
        //�ͻ�Ҫ��ƷA
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.Manufacture().Show();
 
        //�ͻ�Ҫ��ƷB
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.Manufacture().Show();
    }
}

