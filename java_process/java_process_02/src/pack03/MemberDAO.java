package pack03;

public class MemberDAO {
	// DAO: Data Access Object
	// CRUD
	// 회원가입(Create)
	public void create(MemberVO vo) {
		System.out.println("dao에서 전달받은 값: "+vo);
		String id2 = vo.getId();
		String pw2 = vo.getPw();
		String name2 = vo.getName();
		String tel2 = vo.getTel();
		
		System.out.println("전달받은 id는 "+id2);
		System.out.println("전달받은 pw는 "+pw2);
		System.out.println("전달받은 name은 "+name2);
		System.out.println("전달받은 tel은 "+tel2);
		System.out.println("회원가입 처리 요청됨.");
	}
	// 회원정보검색, 로그인(Read)
	public void login(MemberVO vo) {
		System.out.println("회원 로그인 처리 요청됨.");
	}
	public void read(MemberVO vo) {
		System.out.println("회원정보 검색 처리 요청됨.");
	}
	// 회원정보수정(Update)
	public void update(MemberVO vo) {
		System.out.println("회원수정 처리 요청됨.");
	}
	// 회원탈퇴(Delete)
	public void delete(MemberVO vo) {
		System.out.println("회원탈퇴 처리 요청됨.");
	}
}
