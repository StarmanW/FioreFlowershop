/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.ADT;

import fioreflowershop.Models.Product;

/**
 *
 * @author ChongJH
 * @param <T>
 */
public class PromotionCatalogue<T>{

    private String promotionName;
    private int promotionDiscount;
    private int promotionMonth;
    private ListInterface<Product> productList;

    public PromotionCatalogue() {
        this("", 0, 1, null);
        ListInterface<Product> newProductList = new LList<>();
        this.setProductList(newProductList);
    }

    public PromotionCatalogue(String promotionName, int promotionDiscount, int promotionMonth, ListInterface<Product> productList) {
        this.promotionName = promotionName;
        this.promotionDiscount = promotionDiscount;
        this.promotionMonth = promotionMonth;
        this.productList = productList;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public int getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(int promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public int getPromotionMonth() {
        return promotionMonth;
    }

    public void setPromotionMonth(int promotionMonth) {
        this.promotionMonth = promotionMonth;
    }

    public ListInterface<Product> getProductList() {
        return productList;
    }

    public void setProductList(ListInterface<Product> productList) {
        this.productList = productList;
    }
    
    public void addPromoProduct(Product product) {
        this.productList.add(product);
    }
    
    public void removePromoProduct(int selectedIndex) {
        this.productList.remove(selectedIndex);
    }

}
