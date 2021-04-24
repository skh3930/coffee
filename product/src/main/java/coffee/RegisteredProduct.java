package coffee;

public class RegisteredProduct extends AbstractEvent {

    private Long id;
    private String productStatus;

    public RegisteredProduct(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
