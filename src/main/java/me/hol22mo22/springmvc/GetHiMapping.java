package me.hol22mo22.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented // 문서화
@Target({ElementType.METHOD})   // 사용처
@Retention(RetentionPolicy.RUNTIME) // 애노테이션 유지 단계
@RequestMapping(method = RequestMethod.GET,value = "/hi")
public @interface GetHiMapping
{
}
