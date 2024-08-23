package employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }

	    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
	        return employeeRepository.findByDepartmentId(departmentId);
	    }

	    public List<Employee> findByName(String name) {
	        return employeeRepository.findByName(name);
	    }

	    public List<Employee> findByEmail(String email) {
	        return employeeRepository.findByEmail(email);
	    }

	    public List<Employee> findByEmailJPQL(String email) {
	        return employeeRepository.findByEmailJPQL(email);
	    }

	    public List<Employee> findByEmailNative(String email) {
	        return employeeRepository.findByEmailNative(email);
	    }

	    public List<Employee> findByNameNamedQuery(String name) {
	        return employeeRepository.findByNameNamedQuery(name);
	    }

	    public List<Employee> findByEmailNamedQuery(String email) {
	        return employeeRepository.findByEmailNamedQuery(email);
	    }


         public Page<Employee> getAllEmployees(int page, int size, String sortBy, String sortDir) {
             Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }
}
