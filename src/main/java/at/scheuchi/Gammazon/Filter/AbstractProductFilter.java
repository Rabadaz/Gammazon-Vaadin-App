package at.scheuchi.Gammazon.Filter;

import at.scheuchi.Gammazon.Model.Product;

public abstract class AbstractProductFilter implements IFilter<Product> {

    protected IFilter<Product> child;

    protected AbstractProductFilter(IFilter<Product> child){
        this.child = child;
    }

    public IFilter<Product> getChild(){
        return child;
    }



}

