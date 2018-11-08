package bean;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Person {
    @NotNull
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
