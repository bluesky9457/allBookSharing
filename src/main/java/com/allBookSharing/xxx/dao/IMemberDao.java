package com.allBookSharing.xxx.dao;


import java.security.Principal;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import com.allBookSharing.xxx.dto.Loan;
import com.allBookSharing.xxx.dto.Member;
import com.allBookSharing.xxx.dto.PointList;
@Service
public interface IMemberDao {
	
	@Select("SELECT * FROM VIEW_MEMBER WHERE MB_ID=#{id}")
	Member getMyPage(String id);
	@Select("SELECT COUNT(*) FROM BORROWLIST WHERE BO_ID=#{id}")
	int getBorrowCnt(String id);

	//연체횟수
	@Select("SELECT COUNT(BD_RETURN_DATE-BD_REAL_RETURN_DATE) FROM VEIW_BRROW WHERE BO_ID=#{id} AND (BD_RETURN_DATE-BD_REAL_RETURN_DATE)<0")
	int getArrearsCnt(String id);

	
	//리뷰횟수(독서횟수)
	@Select("SELECT COUNT(*) FROM REVIEW WHERE RV_ID=#{id}")
	int getReviewcntCnt(String id);
	
	@Select("SELECT SUM(BD_RETURN_DATE-BD_REAL_RETURN_DATE) FROM VEIW_BRROW WHERE BO_ID=#{id} AND (BD_RETURN_DATE-BD_REAL_RETURN_DATE)<0")
	int getArrearsDay(String id);
	
	@Select("SELECT bo_num,bk_name,bd_date,bd_return_date FROM BORROWLIST \r\n" + 
			"JOIN BORROWDETAIL ON BO_NUM=BD_BO_NUM \r\n" + 
			"JOIN BOOKS ON BD_BCODE=BK_CODE WHERE BO_ID=#{id}")
	List<Loan> getLoanList(String id);
	
	@Select("SELECT bo_num,bk_name,bd_date,bd_real_return_date,bd_date-bd_real_return_date as arrearsday  FROM BORROWLIST \r\n" + 
			"JOIN BORROWDETAIL ON BO_NUM=BD_BO_NUM \r\n" + 
			"JOIN BOOKS ON BD_BCODE=BK_CODE WHERE BO_ID=#{id}")
	List<Loan> getArrearsList(String id);
	
	@Update("update member set mb_pw=#{pw} where mb_id=#{id}")
	boolean updatePassword(@org.apache.ibatis.annotations.Param("id") String id,@org.apache.ibatis.annotations.Param("pw") String pw);
	
	
	void updateprofileUs(Member mb1);

	void updateprofileMb(Member mb1);
	//포인트 충전
	@Update("update users set us_point=#{us_point}+us_point where us_id=#{id}")
	boolean updateOkPoint(@Param("us_point") int us_point,@Param("id") String id);
	//포인트 충전내역
	@Insert("INSERT INTO POINTLIST VALUES(SEQ_POINT.NEXTVAL,#{id},#{us_point},'충전',DEFAULT)")
	PointList insertPointList(@Param("us_point") int us_point, @Param("id") String id);
	@Select("SELECT * FROM POINTLIST WHERE pl_id=#{id} ORDER by pl_date desc")
	
	List<PointList> getPointList(String id);
	
	
	
	
	

}



