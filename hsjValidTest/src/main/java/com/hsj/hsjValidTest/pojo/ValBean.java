package com.hsj.hsjValidTest.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 必须设置getset
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月14日 下午1:35:32
 */
public class ValBean {
    
    
    /**
     * Bean Validation 中内置的 constraint       
     * @Null   被注释的元素必须为 null       
     * @NotNull    被注释的元素必须不为 null       
     * @AssertTrue     被注释的元素必须为 true       
     * @AssertFalse    被注释的元素必须为 false       
     * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值       
     * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值       
     * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值       
     * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值       
     * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内       
     * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内       
     * @Past   被注释的元素必须是一个过去的日期       
     * @Future     被注释的元素必须是一个将来的日期       
     * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式       
     * Hibernate Validator 附加的 constraint       
     * @NotBlank(message =)   验证字符串非null，且长度必须大于0       
     * @Email  被注释的元素必须是电子邮箱地址       
     * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内       
     * @NotEmpty   被注释的字符串的必须非空       
     * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内 
     */
    private Long id;

    @Max(value=20, message="最大年龄20")   
    private Integer age;
    
    @NotBlank(message="username不能为空")
    @Length(max=6, min=3, message="username最小3位，最大6位")
    private String username;

    @NotBlank(message="密码不能为空")
    @Pattern(regexp="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", message="密码必须是8~10位数字和字母的组合")
    private String password;
    
    @Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message="手机号格式不正确")
    private String phone;

    @Email(message="邮箱格式不正确")
    @Pattern(regexp="^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message="邮箱格式不正确")
    private String email;

	public Long getId() {
		return id;
	}

	public Integer getAge() {
		return age;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ValBean(Long id, Integer age, String username, String password, String phone, String email) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public ValBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ValBean [id=" + id + ", age=" + age + ", username=" + username + ", password=" + password + ", phone="
				+ phone + ", email=" + email + "]";
	}
    
    
    
}
