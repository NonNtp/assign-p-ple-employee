package com.non.employee.assignment.services;

import com.non.employee.assignment.dto.EmployeeDto;
import com.non.employee.assignment.entities.Employee;
import com.non.employee.assignment.exceptions.NotFoundException;
import com.non.employee.assignment.mappers.EmployeeMapper;
import com.non.employee.assignment.repositories.EmployeeRepository;
import com.non.employee.assignment.utils.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository ;

    private final EmployeeMapper employeeMapper ;
    @Override
    public EmployeeDto createEmployee(EmployeeDto requestDto) {
        String firstName = requestDto.getFirstName() ;
        String lastName = requestDto.getLastName();

        if(employeeRepository.existsByFirstNameAndLastName(firstName,lastName)) {
            throw new RuntimeException("Firstname and Lastname must be unique") ;
        }

        return employeeMapper.employeeDto(employeeRepository.save(employeeMapper.employee(requestDto))) ;
    }

    @Override
    public List<EmployeeDto> getAllEmployees(String employeeName) {
        List<Employee> employeeList ;

        if(StringUtils.hasText(employeeName)) {
            employeeList = listEmployeeByEmployeeName(employeeName) ;
        } else {
            employeeList = employeeRepository.findAll() ;
        }
        return employeeList.stream().map(employeeMapper :: employeeDto).collect(Collectors.toList());
    }

    public List<Employee> listEmployeeByEmployeeName(String employeeName){
        return employeeRepository.findAllByEmployeeNameIsLikeIgnoreCase("%" + employeeName + "%") ;
    }
    @Override
    public EmployeeDto uploadImage(String employeeCode, MultipartFile file) {
       try {
           Employee employeeUploadImage = employeeRepository.findByEmployeeCode(employeeCode).orElseThrow() ;

           byte[] imageData = ImageUtil.compressImage(file.getBytes()) ;
           employeeUploadImage.setImage(imageData);
           employeeUploadImage.setImageType(file.getContentType());
           employeeUploadImage.setImageName(file.getOriginalFilename());

           Employee employeeSave = employeeRepository.save(employeeUploadImage) ;

           return employeeMapper.employeeDto(employeeSave) ;
       } catch (Exception e) {
           throw new RuntimeException("Failed to upload image", e);
       }
    }

    @Override
    public Optional<EmployeeDto> getEmployeeByEmployeeCode(String employeeCode) {
        return Optional.ofNullable(employeeMapper.employeeDto(employeeRepository.findByEmployeeCode(employeeCode).orElseThrow())) ;
    }


    @Override
    public byte[] downloadImage(String fileName) {
        Optional<Employee> dbImageData = employeeRepository.findByImageName(fileName);
        byte[] images=ImageUtil.decompressImage(dbImageData.get().getImage());
        return images;
    }

    @Override
    public Optional<EmployeeDto> updateEmployeeByEmployeeCode(String employeeCode, EmployeeDto requestDto) {
        AtomicReference<Optional<EmployeeDto>> atomicReference = new AtomicReference<>();

        employeeRepository.findByEmployeeCode(employeeCode).ifPresentOrElse(foundEmployee -> {
            foundEmployee.setFirstName(requestDto.getFirstName());
            foundEmployee.setLastName(requestDto.getLastName());

            foundEmployee.setEmployeeName(requestDto.getFirstName().substring(0, 1).toUpperCase() +
                    requestDto.getFirstName().substring(1).toLowerCase() + " " +
                    requestDto.getLastName().substring(0, 1).toUpperCase() +
                    requestDto.getLastName().substring(1).toLowerCase());
            foundEmployee.setCompany(requestDto.getCompany());

            String[] companyEmailArr = requestDto.getCompany().split(" ") ;
            String companyEmail = companyEmailArr[0].toLowerCase() ;

            foundEmployee.setEmail(requestDto.getFirstName().toLowerCase() + "." + requestDto.getLastName().toLowerCase().charAt(0) + "@" + companyEmail + ".co.th");
            foundEmployee.setUserLogin(requestDto.getFirstName().toLowerCase() + "." + requestDto.getLastName().toLowerCase().charAt(0));

            foundEmployee.setContactNumber(requestDto.getContactNumber());
            foundEmployee.setSalary(requestDto.getSalary());
            foundEmployee.setDepartment(requestDto.getDepartment());
            foundEmployee.setPosition(requestDto.getPosition());
            foundEmployee.setResignedDate(requestDto.getResignedDate());
            foundEmployee.setStatus(requestDto.getStatus());

            atomicReference.set(Optional.of(employeeMapper.employeeDto(employeeRepository.save(foundEmployee))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Boolean deleteEmployeeById(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }


}
