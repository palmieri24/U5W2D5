package alessiapalmieri.U5W2D5.controllers;

import alessiapalmieri.U5W2D5.DTO.NewEmployeeDTO;
import alessiapalmieri.U5W2D5.entities.Employee;
import alessiapalmieri.U5W2D5.exceptions.BadRequestException;
import alessiapalmieri.U5W2D5.exceptions.NotFoundException;
import alessiapalmieri.U5W2D5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployee(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderBy) {
        return employeeService.getEmployees(page, size, orderBy);
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody @Validated NewEmployeeDTO body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return employeeService.save(body);
        }
    }

    @PutMapping("/{id}")
    public Employee findByIdAndUpdate(@PathVariable long id, @RequestBody  Employee body ){
        return employeeService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) throws NotFoundException {
        employeeService.findByIdAndDelete(id);
    }


}
