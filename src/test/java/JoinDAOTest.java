import hideonbush3.spring4.mvc.semiprojectv4.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class JoinDAOTest {

    @Autowired
    SqlSession sqlSession;

    @Test
    public void findZipcode(){
        String dong = "%구로%";
        assertNotNull( sqlSession.selectList("join.findZipcode", dong));
        System.out.println("여기 테스트 결과!!!!!!!!!!!!!!!" +
                sqlSession.selectList("join.findZipcode", dong)
        + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Test
    public void checkUserid(){
        String uid = "ㅁ";
        assertEquals(1, (int)sqlSession.selectOne("join.selectOneUid", uid));

    }

    @Test
    public void newMember(){
        Member m = new Member();
        m.setName("a");
        m.setJumin1("a");
        m.setJumin2("a");
        m.setUserid("a");
        m.setPasswd("a");
        m.setZipcode("a");
        m.setAddr1("a");
        m.setAddr2("a");
        m.setEmail("a");
        m.setPhone("a");
        assertEquals(1, sqlSession.insert("join.insertMember", m));

    }
}
