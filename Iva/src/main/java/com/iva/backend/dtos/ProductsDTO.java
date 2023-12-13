package com.iva.backend.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
	@NotBlank(message = "productId khong duoc de trong")
	@Size(min=3, max=200, message = "product name chi trong khoan 3 den 200 ky tu")
	public String  name;
	@Min(value = 0,message = "price phai lon hon   0")
	@Max(value = 100000000, message = "price khong duoc qua 100000000")
	public float  price;
	
	public String  thumbnail;
	
	public String  description;
	
	//mapping voi data column categories_id nhung ko muon thay doi categoriesId nen dung @JsonProperty("categories_id")
	@JsonProperty("categories_id")
	public int   categoriesId;
	public MultipartFile file;
	@Override
	public String toString() {
		return "ProductsDTO [name=" + name + ", price=" + price + ", thumbnail=" + thumbnail + ", description="
				+ description + ", categoriesId=" + categoriesId + "]";
	}
	
	
}
