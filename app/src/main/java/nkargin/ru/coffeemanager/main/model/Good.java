package nkargin.ru.coffeemanager.main.model;

/**
 * Created by hei on 19.02.2018.
 */

public class Good {

    private String title;
    private int price;
    private int size;

    private Good(String title, int price, int size) {
        this.title = title;
        this.price = price;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private int price;
        private int size;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Good build() {
            return new Good(title, price, size);
        }
    }
}
