package kr.re.kitri.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by danawacomputer on 2017-06-12.
 */
@Controller
public class AmigoController {

    @RequestMapping(value = "/amigo/regist", method = RequestMethod.GET)
    public String regist(){
        return "amigo/regist";
    }

    @RequestMapping("/amigo/regist/{friend_name}")
    public ModelAndView viewFreind(@PathVariable("friend_name")String friendname)


    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("amigo/view_friend");
        mav.addObject("friend_name",friendname);
        return mav;
    }

    @RequestMapping(value="/amigo/regist/go",method = RequestMethod.POST)
    public ModelAndView regist_go(
            @RequestParam("friend_name") String friendname,
            @RequestParam("phone_number") String phonenumber,
            @RequestParam String email){

        System.out.println(friendname);
        System.out.println(phonenumber);
        System.out.println(email);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("amigo/regist_go");
        mav.addObject("friend_name",friendname);
        mav.addObject("phone_number",phonenumber);
        mav.addObject("email",email);

        return mav;
    }




}


