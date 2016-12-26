package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Created by LulzimG on 24/12/16.
 */
@ControllerAdvice(annotations = Controller.class)
public class Advice {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model) {
        model.addAttribute("message", "Something went wrong please try again ! ");
        return "index";
    }
}
