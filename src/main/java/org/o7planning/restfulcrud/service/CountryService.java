package org.o7planning.restfulcrud.service;
import java.sql.SQLException;
// http://o7planning.org/en/11207/simple-crud-example-with-java-restful-web-service
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;

import com.pritam.DAO.CountryDAO;
import com.pritam.POJO.Country;

@Path("/country")
public class CountryService {

// URI:
// /contextPath/servletPath/country
@GET
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public List<Country> getcountry_JSON() throws SQLException {
	CountryDAO CountryDAO = new CountryDAO();	
List<Country> listOfCountries = CountryDAO.listAllCountrys();
return listOfCountries;
}

// URI:
// /contextPath/servletPath/country/{empNo}
@GET
@Path("/{empNo}")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public Employee getEmployee(@PathParam("empNo") String empNo) {
return EmployeeDAO.getEmployee(empNo);
}

// URI:
// /contextPath/servletPath/country
@POST
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public Employee addEmployee(Employee emp) {
return EmployeeDAO.addEmployee(emp);
}

// URI:
// /contextPath/servletPath/country
@PUT
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public Employee updateEmployee(Employee emp) {
return EmployeeDAO.updateEmployee(emp);
}

@DELETE
@Path("/{empNo}")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public void deleteEmployee(@PathParam("empNo") String empNo) {
EmployeeDAO.deleteEmployee(empNo);
}

}