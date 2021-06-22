package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	@Autowired
	private CountryService countryService;

	@Autowired
	private StockService stockService;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private SkillService skillService;

	private static final Logger logger = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		logger.info("inside main");

	}

	@Bean
	CommandLineRunner getAllCountries() {
		return args -> {
			logger.info("START...");
			List<Country> countries = countryService.getAllCountries();
			logger.debug("countries = {}", countries);
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner addCountry() {
		return args -> {
			logger.info("STARTED ADD COUNTRY");
			countryService.addCountry(new Country("HA", "Harshitha"));
			logger.info("ENDED ADD COUNTRY");
		};
	}

	@Bean
	CommandLineRunner findCountryByCode() {
		return args -> {
			logger.info("STARTED COUNTRY BY CODE");
			Country country = countryService.findCountryByCode("HA");
			logger.debug("Country : {}", country);
			logger.info("ENDED COUNTRY BY CODE");
		};
	}
	@Bean
	CommandLineRunner testUpdateCountry() {
		return args -> {
			logger.info("STARTED Update Country");
			Country country = countryService.updateCountry("HA","Haryana");
			logger.debug("Country : {}", country);
			logger.info("ENDED Update Country");
		};
	}

	@Bean
	CommandLineRunner deleteCountryByCode() {
		return args -> {
			logger.info("STARTED DELETE COUNTRY...");
			countryService.deleteCountry("HA");
			logger.info("END DELETE COUNTRY...");
		};
	}

	@Bean
	CommandLineRunner findCountryByCharacters() {
		return args -> {
			logger.info("STARTED COUNTRY BY CHARACTERS");
			countryService.findCountryByCharacter("ou").forEach(c -> logger.info("{}", c));
			logger.info("ENDED COUNTRY BY CHARACTERSS");
		};
	}


	@Bean
	CommandLineRunner findByAlphabet() {
		return args -> {
			logger.info("START BY ALPHABET");
			countryService.findCountryByAlphabet("Z").forEach(c -> logger.info("{}", c));
			logger.info("END BY ALPHABET");
		};
	}


	@Bean
	CommandLineRunner testGetAllStockDetails() {
		return args -> {
			logger.info("START getAllStockDetails");
			stockService.getAllStockDetails().forEach(c -> logger.info("{}", c));
			
			logger.info("END getAllStockDetails");
		};
	}
	
	@Bean
	CommandLineRunner testGetFBStockInSep19() {
		return args -> {
			logger.info("START GetFBStock");
			List<Stock> stocks = stockService.getFBStockInSep19("FB",
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01"),
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-30"));
			stocks.forEach(stock -> logger.info("{}", stock));
			
			logger.info("END GetFBStock");
		};
	}
	@Bean
	CommandLineRunner testGetAllGoogleStocksGreaterThan1250() {
		return args -> {
			logger.info("START GET GOOGL STOCKS");
			stockService.getGoogleStockGreaterThan1250("GOOGL", 1250).forEach(c -> logger.info("{}", c));
			logger.info("END GOOGL STOCKS");
		};
	}
	@Bean
	CommandLineRunner testTop3DatesByVolumeStock() {
		return args -> {
			logger.info("START Top3DatesByVolumeStock");
			stockService.findTop3DatesByVolumeStock().forEach(c -> logger.info("{}", c));
			logger.info("END Top3DatesByVolumeStock");
		};
	}
	@Bean
	CommandLineRunner testFind3LowNetflixStocks() {
		return args -> {
			logger.info("START Find3LowNetflixStocks");
			stockService.find3LowNetflixStocks("NFLX").forEach(c -> logger.info("{}", c));
			logger.info("END Find3LowNetflixStocks");
		};
	}
	@Bean
	CommandLineRunner testGetEmployeeById() {
		return args -> {
			logger.info("START GET Employee By Id");
			Employee employee = employeeService.getEmployeeById(3);
			logger.info("Employee Details -> {}", employee);
			logger.info("END GET Employee By Id");
		};
	}
	@Bean
	CommandLineRunner testGetDepartmentById() {
		return args -> {
			logger.info("START GET Department By Id");
			Department department = departmentService.getDepartmentById(3);
			logger.info("Department Details -> {}", department);
			logger.info("END GET Department By Id");
		};
	}
	@Bean
	CommandLineRunner testGetSkillById() {
		return args -> {
			logger.info("START GET Skill By Id");
			Skill skill = skillService.getSkillById(3);
			logger.info("Skill Details -> {}", skill);
			logger.info("END GET Skill By Id");
		};
	}
	@Bean
	CommandLineRunner testGetEmployee() {
		return args -> {
			logger.info("START Get Employee");
			Employee employee = employeeService.getEmployeeById(1);
			logger.debug("Employee -> {}", employee);
			logger.debug("Department -> {}", employee.getDepartment());
			logger.debug("Skills -> {}", employee.getSkillList());
			logger.info("END Get Employee");
		};
	}
	@Bean
	CommandLineRunner testAddEmployee() {
		return args -> {
			logger.info("START  Add Employee");
			/*Employee employee=Employee.builder().name("Harshitha").salary(90000.00).permanent(true)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-31")).build();
			Department department = departmentService.getDepartmentById(3);
			employee.setDepartment(department);*/
			Department department = departmentService.getDepartmentById(3);
			Employee employee = Employee.builder().name("Harshitha").salary(700000.00).permanent(true)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1999-10-31")).department(department).build();
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END Add Employee");
		};
	}
	@Bean
	CommandLineRunner testUpdateEmployee() {
		return args -> {
			logger.info("START Update Employee");
			Employee employee = employeeService.getEmployeeById(5);
			Department department = departmentService.getDepartmentById(1);
			employee.setDepartment(department);
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END Update Employee");
		};
	}
	@Bean
	CommandLineRunner testGetDepartment() {
		return args -> {
			logger.info("START Get Department");
			Department department = departmentService.getDepartmentById(1);
			logger.info("Department -> {}", department);
			logger.info("Employee List -> {}", department.getEmployeeList());
			logger.info("END Get Department");
		};
	}
	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return args -> {
			logger.info("START Add Skill To Employee");
			Employee employee = employeeService.getEmployeeById(1);
			Skill skill = skillService.getSkillById(3);
			employee.getSkillList().add(skill);
			employeeService.saveEmployee(employee);
			logger.info("END Add Skill To Employee");
		};
	}
	@Bean
	CommandLineRunner testGetAllPermanentEmployees() {
		return args -> {
			logger.info("START Get All Permanent Employees");
			List<Employee> employees = employeeService.findAllPermanentEmployees();
			logger.debug("Permanent Employees -> {}", employees);
			employees.forEach(e -> logger.debug("Skills -> {}", e.getSkillList()));
			logger.info("END Get All Permanent Employees");
		};
	}
	@Bean
	CommandLineRunner testGetAverageSalary() {
		return args -> {
			logger.info("START Get Average Salary ");
			double salary = employeeService.getAverageSalaryofEmployees();
			logger.info("Average Salary : {}", salary);
			logger.info("END Get Average Salary ");
		};
	}
	@Bean
	CommandLineRunner testGetAverageSalaryBasedOnDeptId() {
		return args -> {
			logger.info("START Get Average Salary based on Dept id");
			double salary = employeeService.getAverageSalaryBasedOnDeptId(3);
			logger.info("Average Salary : {}", salary);
			logger.info("END Get Average Salary based on Dept id");
		};
	}
	@Bean
	CommandLineRunner testGetAllEmployeesUsingNativeQuery() {
		return args -> {
			logger.info("START All Employees Using Native Query");
			employeeService.getAllEmployeesUsingNativeQuery().forEach(e -> logger.info("Employees -> {}", e));
			logger.info("END  All Employees Using Native Query");
		};
	}
}
	

	