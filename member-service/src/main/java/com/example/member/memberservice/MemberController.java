package com.example.member.memberservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@GetMapping("/all")
	public List<Members> getAll() {
		return memberRepository.findAll();
	}

	@GetMapping("/findByExpirationDate/{data}")
	public ResponseEntity<List<Members>> findByExpirationDate(@PathVariable("data") String expirationDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println(sdf.parse(expirationDate));
			List<Members> members = memberRepository.findByExpirationDateBefore(sdf.parse(expirationDate));
			if (members.size() <= 0) {
				throw new MemberDataNotFoundException();
			}
			return new ResponseEntity<List<Members>>(members, HttpStatus.OK);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}