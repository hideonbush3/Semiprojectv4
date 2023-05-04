package hideonbush3.spring4.mvc.semiprojectv4.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hideonbush3.spring4.mvc.semiprojectv4.model.Board;

import java.util.List;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public List<Board> selectBoard() {
        return sqlSession.selectList("board.selectBoard");
    }

}