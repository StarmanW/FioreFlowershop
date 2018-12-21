/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.Models;

import fioreflowershop.ADT.LList;
import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Product;
import java.time.Month;

/**
 *
 * @author ChongJH
 */
public class PromotionCatalogue
{

    private String promotionName;
    private int promotionDiscount;
    private Month promotionMonth;
    private ListInterface<Product> promotionProductList;
    private boolean isInitialized;

    public PromotionCatalogue() {
        this("", 0, Month.JANUARY, null, false);
        ListInterface<Product> newProductList = new LList<>();
        this.setPromotionProductList(newProductList);
    }

    public PromotionCatalogue(String promotionName, int promotionDiscount, Month promotionMonth, ListInterface<Product> productList, boolean isInitialized) {
        this.promotionName = promotionName;
        this.promotionDiscount = promotionDiscount;
        this.promotionMonth = promotionMonth;
        this.promotionProductList = productList;
        this.isInitialized = isInitialized;
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

    public Month getPromotionMonth() {
        return promotionMonth;
    }

    public void setPromotionMonth(Month promotionMonth) {
        this.promotionMonth = promotionMonth;
    }

    public ListInterface<Product> getPromotionProductList() {
        return promotionProductList;
    }

    public void setPromotionProductList(ListInterface<Product> promotionProductList) {
        this.promotionProductList = promotionProductList;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setIsInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }
    
    public void addPromoProduct(Product product) {
        this.promotionProductList.add(product);
    }
    
    public void removePromoProduct(int selectedIndex) {
        this.promotionProductList.remove(selectedIndex);
    }

    public double calcDiscountPrice (double originalPrice) {
        return originalPrice * (100 - this.promotionDiscount) / 100;
    }
}
