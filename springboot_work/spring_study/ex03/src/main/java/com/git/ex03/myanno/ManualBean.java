package com.git.ex03.myanno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 실행중에 사용되는 어노테이션
@Target(ElementType.TYPE)           // 클래스 위에다가 붙일수 있다.
public @interface ManualBean {
}
