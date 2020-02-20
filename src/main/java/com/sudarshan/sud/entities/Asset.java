package com.sudarshan.sud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="TBL_ASSETS")
public class Asset {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
//    @NotEmpty(message = "Asset Id is mandatory field")
//	@Pattern(regexp = "[0-9]*", message = "Asset Id should be alpha numeric")
    private String assetId;
    
//    @NotEmpty(message = "Product field is mandatory")
//	@Pattern(regexp = "[a-zA-Z]*", message = "Product should be alpha numeric")
    private String productName;
	
//    @NotEmpty(message = "Model field is mandatory")
//	@Pattern(regexp = "[a-zA-Z0-9]*", message = "Model should be alpha numeric")
    private String modelName;
    
//    @NotEmpty(message = "Color field is mandatory")
    private String productColor;
    
   
    private String inUse;
    
    
    private String employeeId;
    
//    @NotEmpty(message = "Condition field is mandatory. ")
//   	@Pattern(regexp = "[a-zA-Z]*", message = " Condition should be alphabets only")
    private String productCondition;
    
    public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	
    
    public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	
	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}