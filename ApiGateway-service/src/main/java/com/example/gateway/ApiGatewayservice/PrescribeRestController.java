package com.example.gateway.ApiGatewayservice;

import java.util.Date;

/*
@FeignClient(name = "prescribe-service")
interface PrescribeRestClient {

	@RequestMapping(value = "/prescribe/all", method = RequestMethod.GET)
	Collection<Prescribe> getPrescribeData();

	@GetMapping("/prescribe/findByExpirationDate/{data}")
	Collection<Prescribe> getPrescribeByExpirationDate(@PathVariable("data") String expirationDate);
}

*/
/*
 * @Component class PrescribeIntegration {
 * 
 * @Autowired private PrescribeRestClient prescribeRestClient;
 * 
 * public Collection<String> getPrescribeNamesFallback() { return
 * Collections.emptyList(); }
 * 
 * @HystrixCommand(fallbackMethod = "getPrescribeNamesFallback") public
 * Collection<String> getPrescribeNames() { return
 * prescribeRestClient.getPrescribeData().stream().map(Prescribe::getStringId).
 * collect(Collectors.toList()); }
 * 
 * public Collection<Prescribe> getPrescribeByExpirationDate(String
 * expirationDate) { return
 * prescribeRestClient.getPrescribeByExpirationDate(expirationDate).stream().
 * collect(Collectors.toList()); } }
 * 
 * @RestController
 * 
 * @RequestMapping("/prescribe") public class PrescribeRestController {
 * 
 * @Autowired private PrescribeIntegration prescribeIntegration;
 * 
 * @RequestMapping("/names") Collection<String> rs() { return
 * this.prescribeIntegration.getPrescribeNames(); }
 * 
 * @RequestMapping("/byExpirationDate/{date}") Collection<Prescribe>
 * getPrescribeByExpirationDate(@PathVariable("date") String date) { return
 * this.prescribeIntegration.getPrescribeByExpirationDate(date); }
 * 
 * }
 */
class Prescribe {

	Long NPID;

	Date effectiveDate;

	Date expirationDate;

	public Prescribe() {
		super();
	}

	public Prescribe(Long nPID, Date effectiveDate, Date expirationDate) {
		super();
		NPID = nPID;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public Long getNPID() {
		return NPID;
	}

	public void setNPID(Long nPID) {
		NPID = nPID;
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

}