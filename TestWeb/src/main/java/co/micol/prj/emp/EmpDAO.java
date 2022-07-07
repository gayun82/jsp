package co.micol.prj.emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {// 기본뼈대 외우기
	// JOBs 전체 조회
	public ArrayList<JobsVO> selectJobs() {
		ArrayList<JobsVO> list = new ArrayList<JobsVO>();

		String sql = "select * from jobs order by job_id";
		try {
			getConnect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();//result set  
			while (rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// disconnect();
		}
		return list;

	}

	// 전체조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			getConnect();
			// 2.sql 구문 준비
			String sql = "select * from employees ";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += "where department_id = ? ";
			}
			sql += "order by employee_id ";

			psmt = conn.prepareStatement(sql);
			// PreparedStatement stmt = conn.prepareStatement(sql);
			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}

			// 실행
			rs = psmt.executeQuery();

			// 조회결과 list 담기
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// .연결해제
			disconnect();

		}
		return list;

	}

	// 단건조회
	public EmpVO selectOne(String employeeId) {
		EmpVO vo = new EmpVO();

		getConnect();
		String sql = "select * from employees where employee_id = ?";//?는 외부에서 전달하는값
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 등록
	public int insert(EmpVO vo) {// void 관계없음
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into employees(employee_id,last_name,email,hire_date,job_id) values((select max(employee_id)+ from emloyees),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());

			cnt = psmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return cnt;

	}

// 수정
	public int update(EmpVO vo) {
		int cnt = 0;
		String sql= "";
		try {
			psmt= conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

// 삭제
	public int delete(String employeeId) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "delete from employees where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeId);
			cnt= psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}
}