package com.example.gateway.ApiGatewayservice;

import java.util.Date;

/*
@FeignClient(name = "pharmacy-service")
interface PharmacyRestClient {

	@RequestMapping(value = "/pharmacy/all", method = RequestMethod.GET)
	Collection<Pharmacy> getPharmacyData();

	@GetMapping("/pharmacy/findByExpirationDate/{data}")
	Collection<Pharmacy> getPharmacyByExpirationDate(@PathVariable("data") String expirationDate);
}
*/

/*
 * @Component class PharmacyIntegration {
 * 
 * @Autowired private PharmacyRestClient pharmacyRestClient;
 * 
 * public Collection<String> getPharmacyNamesFallback() { return
 * Collections.emptyList(); }
 * 
 * @HystrixCommand(fallbackMethod = "getPharmacyNamesFallback") public
 * Collection<String> getPharmacyNames() { return
 * pharmacyRestClient.getPharmacyData().stream().map(Pharmacy::getName).collect(
 * Collectors.toList()); }
 * 
 * public Collection<Pharmacy> getPharmacyByExpirationDate(String
 * expirationDate) { return
 * pharmacyRestClient.getPharmacyByExpirationDate(expirationDate).stream().
 * collect(Collectors.toList()); } }
 * 
 * @RestController
 * 
 * @RequestMapping("/pharmacy") public class PharmacyRestController {
 * 
 * @Autowired private PharmacyIntegration pharmacyIntegration;
 * 
 * @RequestMapping("/names") Collection<String> rs() { return
 * this.pharmacyIntegration.getPharmacyNames(); }
 * 
 * @RequestMapping("/byExpirationDate/{date}") Collection<Pharmacy>
 * getPharmacyByExpirationDate(@PathVariable("date") String date) { return
 * this.pharmacyIntegration.getPharmacyByExpirationDate(date); }
 * 
 * }
 */
class Pharmacy {

	private Long NPID;

	private String name;

	private Date effectiveDate;

	private Date expirationDate;

	public Pharmacy() {
		super();
	}

	public Pharmacy(Long nPID, String name, Date effectiveDate, Date expirationDate) {
		super();
		NPID = nPID;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
