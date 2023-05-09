package hideonbush3.spring4.mvc.semiprojectv4.controller;

import hideonbush3.spring4.mvc.semiprojectv4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import hideonbush3.spring4.mvc.semiprojectv4.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService bdsrv;

    @GetMapping("/list")
    public ModelAndView list(int cpg) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("board/list.tiles");
        mv.addObject("bdlist", bdsrv.readBoard(cpg));   // 현재페이지에 출력할 게시글리스트
        mv.addObject("cpg", cpg);   // 현재페이지 번호
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard());  // 총페이지수

        return mv;
    }

    @GetMapping("/find")    // 검색처리
    public ModelAndView find(int cpg, String ftype, String fkey){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("board/list.tiles");
        mv.addObject("bdlist", bdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);   // 현재페이지 번호
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard(ftype, fkey));  // 총페이지수
        return mv;
    }

    @GetMapping("/write")
    public String write() {
        return "board/write.tiles";
    }

    @PostMapping("/write")
    public String writeok(Board bd) {
        String viewPage = "error.tiles";
        if(bdsrv.newBoard(bd)){
            viewPage = "redirect:/board/list?cpg=1";
        }
        return viewPage;
    }
    @GetMapping("/view")
    public ModelAndView view(String bno) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("bd", bdsrv.readOneBoard(bno));
        mv.setViewName("board/view.tiles");

        return mv;
    }
}