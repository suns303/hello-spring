package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.common.MockAmigo;
import kr.re.kitri.hello.model.Amigo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by danawacomputer on 2017-06-09.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "redirect:bbs/";
    }

    @RequestMapping("/bs_sample")
    public ModelAndView bsSample(){
        MockAmigo mock = new MockAmigo();
        List<Amigo> list = mock.getAmigo();

        return new ModelAndView("bbs/bs_sample")
                .addObject("list", list);
    }

    @RequestMapping(value ="/bs_sample_detail", method = RequestMethod.POST)
    public ModelAndView bs_sample_detail(Amigo amigo){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("bbs/bs_sample_detail");
        mav.addObject("amigo",amigo);

        return mav;
    }

}