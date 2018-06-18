# loanpaymentplan

Provides APIs for Loan Payment Scheduling.
It is packed as a JAR. It Requires Maven & JDK 1.8. 
You can use it by adding it to your dependencies in your POM file:
<dependency>
	<groupId>com.lendico</groupId>
	<artifactId>com.lendico.plangenerator</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>

It also provides a REST API:
http://localhost:8080/generate-plan (POST)	
Payload:
{
	"loanAmount": "5000",
	"nominalRate": "5.0",
	"duration": 24,
	"startDate": "2018-01-01T00:00:00Z"
}

#install
To install tool run: mvn clean install
#Run
To start tool run: mvn spring-boot:run

#test
To run tests: mvn test


#Design Guidelines:
- Only the monthly scheduling payment is currently implemented.
- If any further scheduling you have to implement The corresponding interfaces:
	- com.lendico.plangenerator.api.IRepaymentPlanGenerator: Which represents type of scheduling/number of payments per year I.e monthly or quarterly
	- com.lendico.plangenerator.api.IPMTCalculator: To provides corresponding logic to calculate borrower payment amount according to schedule.
	- com.lendico.plangenerator.api.IInstallmentInterestCalculator: To provides corresponding logic to calculate interest of initial outstanding principal of installment.
	- com.lendico.plangenerator.api.IInstallmentGenerator: To provides corresponding logic to calculate fields of installments.
	
#Illustrative example for Monthly Plan:

IPMTCalculator pmtCalculator = new MonthlyPMTCalculator();
IInstallmentInterestCalculator interestCalculator = new SimpleInstallmentInterestCalculator();
IRepaymentPlanGenerator planGenerator = new MonthlyRepaymentPlanGenerator(pmtCalculator, interestCalculator);
