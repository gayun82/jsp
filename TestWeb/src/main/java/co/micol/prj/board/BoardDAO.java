package co.micol.prj.board;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{
	public ArrayList<BoardVO> selectBorad(){
		ArrayList<BoardVO> list= new ArrayList<BoardVO>();
		String sql = "select * from board order by id desc";
		
		try {
			getConnect();
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
				
		
	}

}
