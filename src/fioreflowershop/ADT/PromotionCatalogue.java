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
    private Product productArray[];

    public PromotionCatalogue() {
        this("", 0, 0, null);
    }

    public PromotionCatalogue(String promotionName, int promotionDiscount, int promotionMonth, Product[] productArray) {
        this.promotionName = promotionName;
        this.promotionDiscount = promotionDiscount;
        this.promotionMonth = promotionMonth;
        this.productArray = productArray;
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

    public Product[] getProductArray() {
        return productArray;
    }

    public void setProductArray(Product[] productArray) {
        this.productArray = productArray;
    }

}
