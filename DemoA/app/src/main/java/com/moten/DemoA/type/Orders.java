package com.moten.DemoA.type;

public class Orders {
    // 订单类
    // 订单号、订单类型、订单生成日期
    private String OrderId;
    private String OrderType;
    private String OrderDate;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public Orders(String OrderId,String OrderType,String OrderDate){
        this.OrderId = OrderId;
        this.OrderType = OrderType;
        this.OrderDate = OrderDate;
    }
}
