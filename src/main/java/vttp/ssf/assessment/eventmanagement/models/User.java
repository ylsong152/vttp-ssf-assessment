package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

    @NotNull(message = "this is a required field")
    @Size(min=5, max=25)
    private String name;

    @NotNull (message = "please select your date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotEmpty
    @Size(max=50)
    @Email(message = "email is in invalid format")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=(?:[8-9]){1})(?=[0-9]{8}).*", message = "Mobile number must start with 8/9 and have 8 numbers")
    private String number;

    @Max(3)
    @Min(1)
    private Integer tixnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTixnum() {
        return tixnum;
    }

    public void setTixnum(Integer tixnum) {
        this.tixnum = tixnum;
    }

    
}
