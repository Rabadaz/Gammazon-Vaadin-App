package at.scheuchi.Gammazon.UI.Components;

import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.Review;
import at.scheuchi.Gammazon.Repository.CustomerRepository;
import at.scheuchi.Gammazon.Repository.ProductRepository;
import at.scheuchi.Gammazon.Repository.ReviewRepository;
import at.scheuchi.Gammazon.Util.UserUtils;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("./styles/Review/ReviewInputComponent.css")
public class ReviewInputComponent extends VerticalLayout {
    private final TextField title = new TextField();
    private final TextArea text  = new TextArea();
    private final Button submitButton = new Button("Submit Review");
    private final Notification submitFailedNotification = new Notification("The Submit failed", 3000);
    private final NumberField rating = new NumberField();


    private final ProductRepository productRepository;

    private CustomerRepository customerRepository;
    private ReviewRepository reviewRepository;
    private final Product product;

    private final Div maindiv = new Div();


    public ReviewInputComponent(ProductRepository productRepository, CustomerRepository customerRepository, ReviewRepository reviewRepository, Product product){
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.reviewRepository = reviewRepository;
        this.product = product;

        title.setLabel("Title");
        text.setLabel("Comment");
        rating.setLabel("Raiting");
        text.setClassName("comment-area");

        rating.setValue(1d);
        rating.setHasControls(true);
        rating.setMin(1);
        rating.setMax(5);

        maindiv.setClassName("bordered");




        submitButton.addClickListener(this::onReviewSubmitted);

        maindiv.add(new H2("Write a Review" ), new VerticalLayout(new HorizontalLayout(title, rating), text) , submitButton);
        add(maindiv);
    }

    private void onReviewSubmitted(ClickEvent<Button> buttonClickEvent) {
        if(title.isEmpty() || text.isEmpty()){
            submitFailedNotification.open();
        }


        var customer = UserUtils.getUserPrinciple().getUser().getCustomer();
        var product_entity = productRepository.findById(product.getId()).orElseThrow();
        Review r = new Review(rating.getValue().intValue(), title.getValue(), text.getValue(), customer );
        reviewRepository.save(r);
        product_entity.getReviews().add(r);
        productRepository.save(product_entity);

    }

    public void addChangeListener(ComponentEventListener<ClickEvent<Button>> listener){
        submitButton.addClickListener(listener);
    }

}
