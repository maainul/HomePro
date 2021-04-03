# HomePro

# 1. Display One to Many RelationShip in a Table

https://blog.nazrulkabir.com/2018/07/show-data-from-two-jpa-entity-on-same-page-using-spring-boot-and-thymeleaf/

# 2. Form One-to-Many Relationship with Project


https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

# Or One-To-Many which approach is Best

https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/


# 3. Upload Image

https://www.pixeltrice.com/image-gallery-spring-boot-application-using-mysql-and-thymeleaf/

# 4. Send SMS to the phone

https://www.pixeltrice.com/send-an-sms-or-message-from-spring-boot-application-to-mobile-phone/


# 5. Send Email 

https://www.pixeltrice.com/how-to-send-email-using-spring-boot-application/



# IMAGE UPLOADE Steps:

# 1. Update Application.properties
```java
uploadDir=/resources

#Enable multipart uploads
spring.servlet.multipart.enabled=true
# Threshold after which files are written to disk.
spring.servlet.multipart.file-size-threshold=2KB
# Max file size.
spring.servlet.multipart.max-file-size=200MB
# Max Request Size
spring.servlet.multipart.max-request-size=215MB
```

# 2. Create field inside a Model
```java
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
```

#3. Update Controller
```java

package com.pixeltrice.springbootimagegalleryapp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pixeltrice.springbootimagegalleryapp.entity.Renter;
import com.pixeltrice.springbootimagegalleryapp.service.RenterService;


@Controller
public class RenterController {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private RenterService renterService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = {"/", "/home"})
	public String addRenterPage() {
		return "index";
	}

	@PostMapping("/image/saveImageDetails")
	public @ResponseBody ResponseEntity<?> createRenter(
								@RequestParam("name") String name,
								@RequestParam("price") double price, 
								@RequestParam("description") String description, 
								Model model, 
								HttpServletRequest request,
								final @RequestParam("image") MultipartFile file){
		
		try {
			
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = name.split(",");
			String[] descriptions = description.split(",");
			Date createDate = new Date();
			log.info("Name: " + names[0]+" "+filePath);
			log.info("description: " + descriptions[0]);
			log.info("price: " + price);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			Renter renter = new Renter();
			// save to the database
			renter.setName(names[0]);
			renter.setImage(imageData);
			renter.setPrice(price);
			renter.setDescription(descriptions[0]);
			renter.setCreateDate(createDate);
			renterService.saveImage(renter);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Renter Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/image/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Renter> renter)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		renter = renterService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(renter.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/image/imageDetails")
	String showRenterDetails(@RequestParam("id") Long id, Optional<Renter> renter, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				renter = renterService.getImageById(id);
			
				log.info("products :: " + renter);
				if (renter.isPresent()) {
					model.addAttribute("id", renter.get().getId());
					model.addAttribute("description", renter.get().getDescription());
					model.addAttribute("name", renter.get().getName());
					model.addAttribute("price", renter.get().getPrice());
					return "imagedetails";
				}
				return "redirect:/home";
			}
		return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home";
		}	
	}

	@GetMapping("/image/show")
	String show(Model map) {
		List<Renter> images = renterService.getAllActiveImages();
		map.addAttribute("images", images);
		return "images";
	}
}	





```