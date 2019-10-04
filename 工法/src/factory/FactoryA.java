package factory;
import product.*;
public class  FactoryA extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}