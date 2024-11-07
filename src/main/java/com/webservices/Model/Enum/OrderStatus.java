package com.webservices.Model.Enum;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static OrderStatus valueOf(Integer code) {
        for(OrderStatus value : values()) {
            if(value.getCode() == code) {
                return value ;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }
}
