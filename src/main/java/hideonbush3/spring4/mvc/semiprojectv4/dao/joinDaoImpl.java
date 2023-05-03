package hideonbush3.spring4.mvc.semiprojectv4.dao;

import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import hideonbush3.spring4.mvc.semiprojectv4.model.Zipcode;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jndao")
public class joinDaoImpl implements JoinDao{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Zipcode> selectZipcode(String dong) {
        return sqlSession.selectList("join.findZipcode", dong);
    }

    @Override
    public int insertMember(Member m) {
        return sqlSession.insert("join.insertMember", m);
    }

    @Override
    public int selectOneUserid(String uid) {
        return sqlSession.selectOne("join.selectOneUid", uid);
    }

    @Override
    public int selectOneMember(Member m) {
        return 0;
    }
}
