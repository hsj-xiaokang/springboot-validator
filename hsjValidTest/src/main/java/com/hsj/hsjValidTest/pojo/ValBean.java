package com.hsj.hsjValidTest.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 * 必须设置getset
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月14日 下午1:35:32
 */
public class ValBean {
    
    
    /**
    @Validated与@Valid注解区别（都是用在javaBean对象上）
	①，所属的包不同
	@Valid属于javax.validation包下,是jdk给提供的
	@Validated是org.springframework.validation.annotation包下的,是spring提供的
	②，@Validated要比@Valid更加强大

	@Validated在@Valid之上提供了分组功能和验证排序功能
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
     
     
     实际例子：
	@size (min=3, max=20, message="用户名长度只能在3-20之间")
	@size (min=6, max=20, message="密码长度只能在6-20之间")
	@pattern (regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="邮件格式错误")
	@Length(min = 5, max = 20, message = "用户名长度必须位于5到20之间")  
	@Email(message = "比如输入正确的邮箱")  
	@NotNull(message = "用户名称不能为空")
	@Max(value = 100, message = "年龄不能大于100岁")
	@Min(value= 18 ,message= "必须年满18岁！" )  
	@AssertTrue(message = "bln4 must is true")
	@AssertFalse(message = "blnf must is falase")
	@DecimalMax(value="100",message="decim最大值是100")
	@DecimalMin(value="100",message="decim最小值是100")
	@NotNull(message = "身份证不能为空")
	@Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")
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
