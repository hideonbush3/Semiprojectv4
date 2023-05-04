package hideonbush3.spring4.mvc.semiprojectv4.dao;

import hideonbush3.spring4.mvc.semiprojectv4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard();
}