package org.example.item;

public class ItemDB {

    private ItemCLI icli = new ItemCLI();

    public void insert(){
        System.out.println("상품 등록 기능 만들계획");
        Item item = icli.inputItem();
    }

}
