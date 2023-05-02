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
}
