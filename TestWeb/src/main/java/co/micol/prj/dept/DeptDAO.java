package co.micol.prj.dept;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class DeptDAO extends DAO {

	// 전체조회
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from departments";
		try {
			getConnect();
			psmt = conn.prepareStatement(sql);
		
			rs=psmt.executeQuery();
			
			while (rs.next()) { // 다음레코드로 이동
				DeptVO vo = new DeptVO();
				vo.setDepartmentName(rs.getString("Department_Name"));
				vo.setDepartmentId(rs.getString("Department_id"));
				vo.setManatgerId(rs.getString("manager_id"));
				vo.setLocationId(rs.getString("location_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//disconnect();
		}
		return list;
	}
	// 단건조회
	public DeptVO selectOne(String department_id) {
		DeptVO vo = new DeptVO();
		try {
			getConnect();
			String sql = "select * from departments where department_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, department_id);
			rs=psmt.executeQuery();
			if(rs.next()) { // 다음레코드로 이동
				
				vo.setDepartmentName(rs.getString("Department_Name"));
				vo.setDepartmentId(rs.getString("Department_id"));
				vo.setManatgerId(rs.getString("manager_id"));
				vo.setLocationId(rs.getString("location_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//disconnect();
		}
		return vo;
	}

	// 등록
	public int deptInsert(DeptVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into " + "departments(department_id, department_name) " + "values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getDepartmentName());
			cnt = psmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return cnt;
	}

	// 수정
	public int update(DeptVO vo) {
		int r = 0;
		return r;
	}
	// 삭제
	//pubic in
}
