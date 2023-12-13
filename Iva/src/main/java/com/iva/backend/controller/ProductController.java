package com.iva.backend.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.iva.backend.dtos.ProductsDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@GetMapping("")
	public ResponseEntity<String> getAllProducts() {
		return ResponseEntity.ok("api get Product ");
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getProductById(@PathVariable("id") String  productId) {
		return ResponseEntity.ok("api get ProductId " + productId.toString());
		
	}
	//de check thumbnail 
	@PostMapping(value = "", consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
	
 	public ResponseEntity<?> createProducts(@Valid @ModelAttribute ProductsDTO productsDTO, 
// 			@RequestPart("file") MultipartFile file 
 			BindingResult result) {
			try {
				//hien loi mess
				if(result.hasErrors()) {
					//list loi lay tu mess ProductDTO
					List<String> errors =  result.getFieldErrors()
					.stream()
					.map(fieldErrors -> fieldErrors.getDefaultMessage()).toList();
					return ResponseEntity.badRequest().body(errors);
				}
				MultipartFile file = productsDTO.getFile();
				//neu nhu file bo trong thi bo qua
				if(file != null) {
					//neu file khac null thi chay vao
					if(file.getSize() > 10 * 1024 * 1024) {
						
						return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
								.body("File img is to large 10Mb !!!");
					}
					//de lay ra dinh dang file
					String contentTypeFile = file.getContentType();
					if(contentTypeFile ==null || !contentTypeFile.startsWith("image/")) {
						return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
								.body("File must be a image!");
					}
					//luu file va cap nhap thumbnail trong prductDTO
					String filesave = storeFile(file);
					//productsDTO.setThumbnail(filesave);
					//luu vao db
				}
				
				return ResponseEntity.ok("produt create success! "+productsDTO  );
			}catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}
	private String storeFile(MultipartFile file) throws IOException {
		//lay ten file goc
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		//them UUID vao truoc ten file de dam bao ten file la duy nhat
		String UniqueFilename = UUID.randomUUID().toString() + "_"+filename; 
		//va tao ra 1 file path la uploads de luu anh lai
		Path uloadDir = Paths.get("Uploads");
		//tiep theo la kiem tra thu muc file ton tai hay chua
		//neu thuc muc do chua ton tai
		if(!Files.exists(uloadDir)) {
			//thi se tao file dir
			Files.createDirectories(uloadDir);
		}
		//lay ra duong dan day du den file
		Path destination = Paths.get(uloadDir.toString(),UniqueFilename);
		//sau do sao chep file vao thuc muc Uploads
		Files.copy(file.getInputStream(),destination,StandardCopyOption.REPLACE_EXISTING);//REPLACE_EXISTING tuc la neu co no se thay the
		return UniqueFilename;
	}
}

