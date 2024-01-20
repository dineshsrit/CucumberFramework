package Cucumber.customtype;

import Objects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name)
    {
        return new Product(name.replaceAll("\"",""));
    }
}
