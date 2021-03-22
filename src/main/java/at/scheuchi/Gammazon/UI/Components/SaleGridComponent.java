package at.scheuchi.Gammazon.UI.Components;

import at.scheuchi.Gammazon.Model.ProductSale;
import at.scheuchi.Gammazon.Model.Sale;
import at.scheuchi.Gammazon.Util.ApplicationUnifiedDateFormat;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SaleGridComponent extends VerticalLayout {
    public SaleGridComponent(Collection<Sale> saleCollection) {
        add(prepareGrid(saleCollection));
    }

    private Grid<GridViewModel> prepareGrid(Collection<Sale> sales){
        List<GridViewModel> vm = new LinkedList<>();
        int i = 0;
        for(Sale sale: sales){
            for(ProductSale ps: sale.getProducts()){
                vm.add(new GridViewModel(i, ps.getProduct().getTitle(), sale.getSaleDate(), ps.getCount(), ps.getCount()*ps.getProduct().getPrice(),sale.getCustomer().createFullName()));
                i++;
            }
        }


        Grid<GridViewModel> saleGrid  = new Grid<>();
        saleGrid.setItems(vm);
        saleGrid.addColumn(GridViewModel::getDateFormated).setHeader("Date");
        saleGrid.addColumn(GridViewModel::getProductName).setHeader("Product");
        saleGrid.addColumn(GridViewModel::getAmmout).setHeader("Ammout");
        saleGrid.addColumn(GridViewModel::getPrizeFormated).setHeader("Total Prize");
        saleGrid.addColumn(GridViewModel::getCustomerName).setHeader("Customer");

        saleGrid.setWidth("100%");
        return saleGrid;


    }



    @Data
    @AllArgsConstructor
    private class GridViewModel{
        private int id;
        private String productName;
        private Date date;
        private int ammout;
        private int prize;
        private String customerName;


        public String getPrizeFormated(){
            return "€ %.2f".formatted( (prize/100.0));
        }

        public String getDateFormated(){
            return ApplicationUnifiedDateFormat.getInstance().getPrimaryDateFormat().format(date);
        }

    }
}
