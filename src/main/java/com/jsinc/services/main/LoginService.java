package com.jsinc.services.main;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MemberDAO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class LoginService implements ServiceIf {
	private final int CHK_OK = 0;
	private final int CHK_NO = 1;
	
	@Autowired
	MemberDAO dao;

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDTO dto = dao.list(request.getParameter("empNo"));
		if(dto != null) {
			if(request.getParameter("password").equals(dto.getPassword())) {
				HttpSession session = request.getSession();
				ServletContext application = session.getServletContext();
				application.setAttribute("user", dto);
				return CHK_OK;
			}
		}
		return CHK_NO;
	}

	@Override
	public int empNoChk(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userEmailChk(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
