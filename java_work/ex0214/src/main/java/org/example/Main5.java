package org.example;

class Friend{
    String name;
    Company com;
    public Friend(String name, Company com) {
        this.name = name;
        this.com = com;
    }
    public String getName() {
        return name;
    }
    public Company getCom() {
        return com;
    }
}
class Company {
    String cName;
    ContInfo contInfo;
    public Company(String cName, ContInfo contInfo) {
        this.cName = cName;
        this.contInfo = contInfo;
    }
    public String getcName() {
        return cName;
    }
    public ContInfo getContInfo() {
        return contInfo;
    }
}
class ContInfo {
    String addr;
    String phone;
    public ContInfo(String addr, String phone) {
        this.addr = addr;
        this.phone = phone;
    }
    public String getAddr() {
        return addr;
    }
    public String getPhone() {
        return phone;
    }
}

public class Main5 {
    public static void main(String[] args) {
        // 홍길동친구가 다니는 회사에 주소를 출력할려고....
        Friend friend = new Friend("홍길동",
                                  new Company("AA",null));
        Company com = friend.getCom();
        ContInfo contInfo = com.getContInfo();
//        if( contInfo != null) {
//            String addr = contInfo.getAddr();
//            System.out.println("addr = " + addr);
//        }
    }
}
