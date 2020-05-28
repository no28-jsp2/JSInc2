package com.jsinc.jsincDAO;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MemberDTO;

@Repository
public class MemberDAO {

	private static final String namespace = "com.jsinc.mybatis.Member";
	@Autowired
	private SqlSession sqlSession;

	public MemberDTO list(String empNo) {
		return sqlSession.selectOne(namespace + ".list", empNo);
	}

	// 아이디 중복체크
	public int empNoChk(MemberDTO dto) throws Exception {
		System.out.println("dao : " + dto.getEmpNo());
		int result = sqlSession.selectOne(namespace + ".empNoChk", dto.getEmpNo());
		return result;
	}
	
	// 이메일 중복체크
		public int userEmailChk(String userEmail) throws Exception {
			System.out.println("dao : " + userEmail);
			int result = sqlSession.selectOne(namespace + ".userEmailChk", userEmail);
			return result;
		}
	//회원가입
		public void memReg(MemberDTO dto)throws Exception {
			sqlSession.insert(namespace+".regMem",dto);
		}
		//임시 비밀번호
				public void sentPw(MemberDTO dto)throws Exception{
				
					System.out.println("dao의useremail:"+dto.getUserEmail());
					System.out.println("dao의pw:"+dto.getPassword());
					sqlSession.update(namespace+".newPw",dto);
				
		}
		

	
	
}
