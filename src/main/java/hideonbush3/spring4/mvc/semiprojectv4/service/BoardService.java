package hideonbush3.spring4.mvc.semiprojectv4.service;

import hideonbush3.spring4.mvc.semiprojectv4.model.Board;

import java.util.List;

public interface BoardService {

    List<Board> readBoard(int cpage);

}
