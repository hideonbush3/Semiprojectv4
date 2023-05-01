package hideonbush3.spring4.mvc.semiprojectv4.controller;

import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/join")
public class joinController {

    @GetMapping("/agree")
    public String agree(){
        return "join/agree.tiles";
    }

    @GetMapping("/checkme")
    public String checkme(){
        return "join/checkme.tiles";
    }

    @PostMapping("/joinme")
    public ModelAndView joinmeok(Member mb){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mb", mb);
        mv.setViewName("join/joinme.tiles");
        return mv;
    }

    @GetMapping("/joinok")
    public String joinok(){
        return "join/joinok.tiles";
    }
}
