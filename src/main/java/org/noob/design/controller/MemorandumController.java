package org.noob.design.controller;

import org.noob.design.pojo.Memorandum;
import org.noob.design.pojo.User;
import org.noob.design.Utils.MyDate ;
import org.noob.design.service.MemorandumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.noob.design.Utils.MyDate.getDay;

@Controller
@SessionAttributes("user")
public class MemorandumController {
    @Autowired
    private MemorandumService memorandumService;
    @RequestMapping("/memorandum/edit")
    public String edit(Model model, RedirectAttributes redirectAttributes) {
        if(model.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute("error","请先登录") ;
            return "redirect:/login";
        }


        return "edit" ;
    }
    @PostMapping("/memorandum/update")
    public String update(Model model, RedirectAttributes redirectAttributes,
                        String title ,   String all_text ,
                       String year,   String month,
                       String day, String hour ,
                      String minute ) throws ParseException {

        if(model.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute("error","请先登录") ;
            return "redirect:/login";
        }
        if(title.isEmpty()){
            redirectAttributes.addFlashAttribute("error","标题不能为空") ;
            return "redirect:/memorandum/edit" ;
        }else if(all_text.isEmpty()){
            redirectAttributes.addFlashAttribute("error","内容不能为空") ;
            return "redirect:/memorandum/edit";
        }else if(!(year.matches("^\\d+$")
                && Integer.parseInt(year) >=2000
                && Integer.parseInt(year) <= 2050) ){
            redirectAttributes.addFlashAttribute("error","年份有问题") ;
            return "redirect:/memorandum/edit";

        }else if(!(month.matches("^\\d+$")
                && Integer.parseInt(month) >=1
                && Integer.parseInt(month) <= 12)){
            redirectAttributes.addFlashAttribute("error","月份有问题 1-12") ;
            return "redirect:/memorandum/edit";
        }else if(!(day.matches("^\\d+$")
                && Integer.parseInt(day) >= 1)
                && Integer.parseInt(day) <= getDay(Integer.parseInt(year),Integer.parseInt(month))){
            redirectAttributes.addFlashAttribute("error","天数有问题") ;
            return "redirect:/memorandum/edit";
        }else if(!(hour.matches("^\\d+$")&& Integer.parseInt(hour) >=0
                && Integer.parseInt(hour) <= 23)){
            redirectAttributes.addFlashAttribute("error","小时有问题 0-23") ;
            return "redirect:/memorandum/edit";
        }else if(!(minute.matches("^\\d+$") && Integer.parseInt(minute) >=0  && Integer.parseInt(minute) <= 59)){
            redirectAttributes.addFlashAttribute("error","分钟有问题 0-59") ;
            return "redirect:/memorandum/edit";
        }
        Memorandum memorandum = new Memorandum() ;
        memorandum.setTitle(title);
        memorandum.setAll_text(all_text);
        memorandum.setUser_id(((User) Objects.requireNonNull(model.getAttribute("user"))).getId());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = dateFormat.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute);
        memorandum.setTime(parse);
        memorandumService.Insert(memorandum);
        redirectAttributes.addFlashAttribute("success", "插入成功");
        return "redirect:/memorandum/show";
    }
    @RequestMapping("/memorandum/show")
    public String show(Model model, RedirectAttributes redirectAttributes) {
        if(model.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute("error","请先登录") ;
            return "redirect:/login";
        }
        System.out.println("???");
        List<Memorandum> userList = memorandumService.SelectAll((User) Objects.requireNonNull(model.getAttribute("user")));
        model.addAttribute("userList",userList) ;
        return "show" ;
    }
    @PostMapping("/memorandum/delete")
    public String delete(Model model, RedirectAttributes redirectAttributes,String id) {
        if(model.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute("error","请先登录") ;
            return "redirect:/login";
        }
        Integer Id = Integer.parseInt(id);
        memorandumService.deleteById(Id) ;
            return "redirect:/memorandum/show" ;
    }
}
