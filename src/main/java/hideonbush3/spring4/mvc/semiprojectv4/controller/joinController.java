package hideonbush3.spring4.mvc.semiprojectv4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/joinme")
    public String joinme(){
        return "join/joinme.tiles";
    }

    @GetMapping("/joinok")
    public String joinok(){
        return "join/joinok.tiles";
    }
}
