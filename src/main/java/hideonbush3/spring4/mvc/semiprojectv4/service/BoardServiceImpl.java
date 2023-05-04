package hideonbush3.spring4.mvc.semiprojectv4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hideonbush3.spring4.mvc.semiprojectv4.dao.BoardDAO;
import hideonbush3.spring4.mvc.semiprojectv4.model.Board;

import java.util.List;

@Service("bdsrv")
public class BoardServiceImpl implements BoardService {

    @Autowired private BoardDAO bddao;

    @Override
    public List<Board> readBoard() {
        return bddao.selectBoard();
    }
}