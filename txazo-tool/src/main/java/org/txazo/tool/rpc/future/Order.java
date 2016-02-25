package org.txazo.tool.rpc.future;

public class Order {

    private String type;

    private boolean exists;

    public Order(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    @Override
    public String toString() {
        return "Order{" + "type='" + type + '\'' + ", exists=" + exists + '}';
    }

}
