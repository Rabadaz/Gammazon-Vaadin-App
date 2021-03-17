package at.scheuchi.Gammazon.UI.View;

import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Repository.CustomerRepository;
import at.scheuchi.Gammazon.Repository.ProductRepository;
import at.scheuchi.Gammazon.Repository.ReviewRepository;
import at.scheuchi.Gammazon.Service.BuyService;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import at.scheuchi.Gammazon.UI.View.Components.ProductTile;
import at.scheuchi.Gammazon.UI.View.Components.ReviewComponent;
import at.scheuchi.Gammazon.UI.View.Components.ReviewInputComponent;
import at.scheuchi.Gammazon.Util.ApplicationUnifiedDateFormat;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Route(value = "product", layout = MainLayout.class)
public class ProductView extends VerticalLayout implements HasUrlParameter<Integer> {

    //Repositories
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private ReviewRepository reviewRepository;
    private BuyService buyService;

    private Product product;

    private final HorizontalLayout mainLayout = new HorizontalLayout();
    private final VerticalLayout ratingLayout = new VerticalLayout();
    private final VerticalLayout reviews = new VerticalLayout();
    private final H1 heading = new H1();
    private final Image image = new Image();
    private final Paragraph description = new Paragraph();
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final VerticalLayout sellingLayout = new VerticalLayout();
    private final Paragraph prizeDescription = new Paragraph();
    private final H3 prize = new H3();
    private final Button buyButton = new Button("Buy Now");
    private final NumberField quantity = new NumberField();
    private final Paragraph inStock = new Paragraph();
    private final Paragraph delivery = new Paragraph();


    public ProductView(ProductRepository productRepository, CustomerRepository customerRepository, ReviewRepository reviewRepository, BuyService buyService){
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.reviewRepository = reviewRepository;
        this.buyService = buyService;
        //Styling
        mainLayout.getStyle().set("margin", "auto");
        mainLayout.getStyle().set("margin-top", "5vh");

        image.setWidth("25vw");
        image.getStyle().set("margin-left", "5vw");
        image.getStyle().set("margin-right", "5vw");
        sellingLayout.setClassName("bordered");
        sellingLayout.getStyle().set("margin-right", "10vw");
        sellingLayout.getStyle().set("margin-left", "5vw");
        sellingLayout.setSpacing(false);
        ratingLayout.setClassName("raiting-area");

        prize.getStyle().set("color", "#fc9803");

        inStock.getStyle().set("font-weight", "bold");


        quantity.setValue(1d);
        quantity.setHasControls(true);
        quantity.setMin(1);
        quantity.setMax(10);

        buyButton.addClickListener(this::buyClicked);


        verticalLayout.add(heading, description);
        sellingLayout.add(prize, prizeDescription, inStock, delivery, new HorizontalLayout(quantity,buyButton));
        mainLayout.add(image, verticalLayout, sellingLayout);
        add(mainLayout,ratingLayout);

    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer integer) {
        Product product = productRepository.findById(integer).orElseThrow();
        heading.setText(product.getTitle());
        description.setText(product.getDescription());
        prize.setText("€ "+product.getPrice()/100f + " including Taxes");
        image.setSrc(product.getPictureUrl());
        prizeDescription.setText("Delivery at no extra cost for Ɣzon Prime member ");
        inStock.setText(product.isInStock()? "The Product is currently is currently in Stock" : "Unfortunately the Product is not in Stock");
        inStock.getStyle().set("color",(product.isInStock()? "green" : "red"));




        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, product.getDeliveryDays());

        delivery.setText("The Prodct could be delivered until: "+ ApplicationUnifiedDateFormat.getInstance().getPrimaryDateFormat().format(calendar.getTime()));


        var reviewComponent = new ReviewInputComponent(productRepository, customerRepository, reviewRepository, product);
        reviewComponent.addChangeListener(this::reviewAdded);
        ratingLayout.add(reviewComponent);


        this.product = product;
        product.getReviews().forEach(r -> reviews.add(new ReviewComponent(r)));

        ratingLayout.add(reviews);

    }


    private void reviewAdded(ClickEvent<Button> buttonClickEvent) {

        this.product = productRepository.findById(product.getId()).orElse(product);
        UI.getCurrent().getPage().reload();
        reviews.removeAll();

    }

    private void buyClicked(ClickEvent<Button> buttonClickEvent) {
        buyService.buyProduct(this.product, this.quantity.getValue().intValue());
    }


}
