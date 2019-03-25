package com.example.gateway.ApiGatewayservice;

import java.util.Date;

/*
@FeignClient(name = "drug-service")
interface DrugRestClient {

	@RequestMapping(value = "/drug/all", method = RequestMethod.GET)
	Collection<Drug> getDrugData();

	@GetMapping("/drug/findByExpirationDate/{data}")
	Collection<Drug> getDrugByExpirationDate(@PathVariable("data") String expirationDate);
}
*/

/*
 * @Component class DrugIntegration {
 * 
 * @Autowired private DrugRestClient drugRestClient;
 * 
 * public Collection<String> getDrugNamesFallback() { return
 * Collections.emptyList(); }
 * 
 * @HystrixCommand(fallbackMethod = "getDrugNamesFallback") public
 * Collection<String> getDrugNames() { return
 * drugRestClient.getDrugData().stream().map(Drug::getName).collect(Collectors.
 * toList()); }
 * 
 * public Collection<Drug> getPharmacyByExpirationDate(String expirationDate) {
 * return
 * drugRestClient.getDrugByExpirationDate(expirationDate).stream().collect(
 * Collectors.toList()); } }
 * 
 * @RestController
 * 
 * @RequestMapping("/drug") public class DrugRestController {
 * 
 * @Autowired private DrugIntegration drugIntegration;
 * 
 * @RequestMapping("/names") Collection<String> rs() { return
 * this.drugIntegration.getDrugNames(); }
 * 
 * @RequestMapping("/byExpirationDate/{date}") Collection<Drug>
 * getPharmacyByExpirationDate(@PathVariable("date") String date) { return
 * this.drugIntegration.getPharmacyByExpirationDate(date); }
 * 
 * }
 */

class Drug {

	private Long NDCID;

	private String name;

	private Date effectiveDate;

	private Date expirationDate;

	public Drug() {
		super();
	}

	public Drug(Long nDCID, String name, Date effectiveDate, Date expirationDate) {
		super();
		NDCID = nDCID;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public Long getNDCID() {
		return NDCID;
	}

	public void setNDCID(Long nDCID) {
		NDCID = nDCID;
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