package hideonbush3.spring4.mvc.semiprojectv4.service;

import hideonbush3.spring4.mvc.semiprojectv4.dao.MemberDao;
import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("msrv")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao mdao;

    @Override
    public boolean checkLogin(Member m, HttpSession sess) {
        boolean isLogin = false;
        if (mdao.selectLogin(m) > 0){
            // 로그인 가능하면 세션변수에 아이디를 저장
            sess.setAttribute("UID", m.getUserid());
            isLogin = true;
        }

        return isLogin;
    }
}
