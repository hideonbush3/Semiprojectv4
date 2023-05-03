import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class memberDAOTest {

    @Autowired
    SqlSession sqlSession;

    @Test
    public void selectLogin(){
        Member m = new Member();
        m.setUserid("a");
        m.setPasswd("a");

        assertEquals(1, (int)sqlSession.selectOne("member.selectLogin", m));

        m.setUserid("aa");
        m.setPasswd("aa");

        assertEquals(0, (int)sqlSession.selectOne("member.selectLogin", m));
    }
}
