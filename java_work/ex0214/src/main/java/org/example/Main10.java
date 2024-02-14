package org.example;

import java.util.Optional;

public class Main10 {

    public static void main(String[] args) {
        Friend friend = new Friend("홍길동",
                new Company("AA",null));

        Optional<Friend> optionalFriend = Optional.of(friend);

        String addr = optionalFriend.map( Friend::getCom )
                                    .map( Company::getContInfo )
                                    .map( ContInfo::getAddr )
                                    .orElse("주소가 없음");

        System.out.println(addr);
    }
}
