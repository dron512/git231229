package org.example;

public class Main8 {

    public static void main(String[] args) {
        ContInfo ci =
                new ContInfo(null,
                        "Republic of Korea");

        String phone;
        String addr;

        if(ci.getPhone() != null){
            phone = ci.getPhone();
        }
        else{
            phone = "There is no Phone Number";
        }
        if(ci.getAddr() != null){
            addr = ci.getAddr();
        }
        else{
            addr = "There is no address";
        }
        System.out.println(phone);
        System.out.println(addr);
    }
}
