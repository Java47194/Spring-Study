package Hi.coretest.singleton;

import net.minidev.json.JSONUtil;

public class StateFulService {

 //  private int price;


    public int order(String name , int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price=price;
        return price;
    }

  /*  public int getPrice(){
        return price;
    }*/



}
