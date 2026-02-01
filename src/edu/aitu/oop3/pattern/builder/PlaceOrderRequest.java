package edu.aitu.oop3.pattern.builder;

public class PlaceOrderRequest {
    private final int customerId;
    private final int menuItemId;
    private final int quantity;
    private final String deliveryType;
    private final String address;

    private PlaceOrderRequest(Builder b) {
        this.customerId = b.customerId;
        this.menuItemId = b.menuItemId;
        this.quantity = b.quantity;
        this.deliveryType = b.deliveryType;
        this.address = b.address;
    }

    public int getCustomerId() { return customerId; }
    public int getMenuItemId() { return menuItemId; }
    public int getQuantity() { return quantity; }
    public String getDeliveryType() { return deliveryType; }
    public String getAddress() { return address; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int customerId;
        private int menuItemId;
        private int quantity;
        private String deliveryType = "PICKUP";
        private String address = null;

        public Builder customerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder menuItemId(int menuItemId) {
            this.menuItemId = menuItemId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder deliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public PlaceOrderRequest build() {
            if (customerId <= 0) throw new IllegalArgumentException("customerId must be > 0");
            if (menuItemId <= 0) throw new IllegalArgumentException("menuItemId must be > 0");
            if (quantity <= 0) throw new IllegalArgumentException("quantity must be > 0");
            if ("DELIVERY".equalsIgnoreCase(deliveryType) && (address == null || address.isBlank())) {
                throw new IllegalArgumentException("address required for DELIVERY");
            }
            return new PlaceOrderRequest(this);
        }
    }
}
