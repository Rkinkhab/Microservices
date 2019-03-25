package com.example.gateway.ApiGatewayservice;

import java.util.Date;

/*
@FeignClient(name = "member-service")
interface MembersRestClient {

	@GetMapping("/member/all")
	Collection<Member> getMembers();

	@GetMapping("/member/findByExpirationDate/{data}")
	Collection<Member> getMembersByExpirationDate(@PathVariable("data") String expirationDate);
}

*/
/*
 * @Component class MemberIntegration {
 * 
 * @Autowired private MembersRestClient membersRestClient;
 * 
 * public Collection<String> getMemberNamesFallback() { return
 * Collections.emptyList(); }
 * 
 * @HystrixCommand(fallbackMethod = "getMemberNamesFallback") public
 * Collection<String> getMemberNames() { return
 * membersRestClient.getMembers().stream().map(Member::getName).collect(
 * Collectors.toList()); }
 * 
 * public Collection<Member> getMemberByExpirationDate(String expirationDate) {
 * return
 * membersRestClient.getMembersByExpirationDate(expirationDate).stream().collect
 * (Collectors.toList()); } }
 * 
 * @RestController
 * 
 * @RequestMapping("/members") class MemberRestController {
 * 
 * @Autowired private MemberIntegration memberIntegration;
 * 
 * @RequestMapping("/names") Collection<String> rs() { return
 * this.memberIntegration.getMemberNames(); }
 * 
 * @RequestMapping("/byExpirationDate/{date}") Collection<Member>
 * getMemberByExpirationDate(@PathVariable("date") String date) { return
 * this.memberIntegration.getMemberByExpirationDate(date); }
 * 
 * }
 */
class Member {

	private Long id;
	private String name;
	private Date effectiveDate;
	private Date expirationDate;

	public Member() {
		super();
	}

	public Member(Long id, String name, Date effectiveDate, Date expirationDate) {
		super();
		this.id = id;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + "]";
	}

}
