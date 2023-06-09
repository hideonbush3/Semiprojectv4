package hideonbush3.spring4.mvc.semiprojectv4.dao;

import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import hideonbush3.spring4.mvc.semiprojectv4.model.Zipcode;

import java.util.List;

public interface JoinDao {
    List<Zipcode> selectZipcode(String dong);

    int insertMember(Member m);

    int selectOneUserid(String uid);

    int selectOneMember(Member m);
}
