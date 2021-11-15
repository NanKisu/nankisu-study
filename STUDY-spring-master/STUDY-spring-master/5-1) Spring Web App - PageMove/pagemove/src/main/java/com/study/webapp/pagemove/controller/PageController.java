package com.study.webapp.pagemove.controller;

import java.net.Authenticator.RequestorType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.study.webapp.pagemove.vo.MyData;

@Controller
@RequestMapping(path = {"/page"}, method = {RequestMethod.GET})
public class PageController {
  @ModelAttribute
  public MyData myData(@RequestParam(name = "data") String data) {
    MyData myData = new MyData();
    myData.setData(data);
    return myData;
  }
  
  @GetMapping(path = "/redirect")
  public String redirect() {
    return "redirect:/page/redirected";
  }
  
  @GetMapping(path = {"/redirectattribute"})
  public String redirectAttribute(RedirectAttributes redirectAttribute) {
    redirectAttribute.addAttribute("var", "from /redirectattribute");
    return "redirect:/page/redirected";
  }
  
  @GetMapping(path = {"/redirected"})
  public String redirected() {
    return "redirected";
  }
  
  @GetMapping(path = {"/forward"})
  public String forward() {
    return "forward:/page/forwarded";
  }
  
  @GetMapping(path = {"/forwarded"})
  public String forwarded() {
    return "forwarded";
  }
  
  @GetMapping(path = {"/modelattribute"})
  public String  modelAttribute() {
    return "modelattribute";
  }
}
