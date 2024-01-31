package org.example;

// clonable -> clone
// comparable -> compareTo

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class INum implements Comparable {
    private int num;

    public INum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return 101023;
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((INum) obj).num;
    }

    // Arrays.sort 호출하면... 기본형(int,double) 타입...정렬이 됩니다..
    // 객체형타입(Inum,Person)을 정렬할려고
    // Comparable 상속받아서 compareTo 재정의해야합니다.

    // 오름차순... this.num - o.num
    // 내림차순... o.num - this.num

    @Override
    public int compareTo(Object o) {
        return ((INum) o).num - this.num;
    }
}
