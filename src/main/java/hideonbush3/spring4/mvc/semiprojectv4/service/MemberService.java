package hideonbush3.spring4.mvc.semiprojectv4.service;

import hideonbush3.spring4.mvc.semiprojectv4.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {

    boolean checkLogin(Member m, HttpSession sess);


}
