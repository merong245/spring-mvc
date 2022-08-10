package me.hol22mo22.springmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

// 모든 컨트로롤러 전반에 걸쳐 적용하고 싶은 경우에 사용
// assignableTypes 범위 지정
@ControllerAdvice(assignableTypes = {SampleController.class,EventApi.class})
public class BaseController {
    @ExceptionHandler
    public String eventErrorHandler(EventException exception, Model model){
        model.addAttribute("message", "event error");
        return "/error";
    }

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }

}
