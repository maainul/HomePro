package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.service.RenterService;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;


@Controller
public class RenterController {

/*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
*/


    @Autowired
    private JavaMailSender mailSenderObj;


    @Autowired
    private RenterService renterService;

    @Autowired private UserService userService;

    @GetMapping("/addRenter")
    public String showAddInfoForm(Model model) {
        model.addAttribute("renter", new Renter());
        return "addRenterInfo";
    }

    @PostMapping("/addRenter")
    public String addRenter(@ModelAttribute(name = "renter") Renter renter, Principal principal,Model model, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        // 1. get original file name
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //2. set filename to the object
        renter.setRenterImage(fileName);
        //3. create object to find id
        Renter savedRenter = renterService.saveRenter(renter, userService.findByUsername(principal.getName()));
        //4. create image upload directory
        String uploadDir = "./renter-images/" + savedRenter.getId();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploade file : " + fileName);
        }
        return "redirect:/addRenter";

    }

    @GetMapping("/renterList")
    public String showRenterList(Model model,Principal principal) {
        model.addAttribute("renterList", renterService.renterList(userService.findByUsername(principal.getName())));
        return "renterListTable";
    }

    @GetMapping("/updateRenter/{id}")
    public String updateRenterForm(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("renter", renterService.getRenterById(id));
        return "updateRenterInfo";
    }

    @GetMapping("/renterDelete/{id}")
    public String deleteRenter(@PathVariable(value = "id") Long id) {
        renterService.deleteRenterById(id);
        return "redirect:/renterList";
    }


    @GetMapping("/renterDetails/{id}")
    public String renterDetails(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("renter", renterService.getRenterById(id));
        return "renterDetails";
    }

    @GetMapping("/sendMail/{id}")
    public ResponseEntity<Renter> renterMail(@PathVariable(value = "id") Long id) {
        Renter renter = renterService.getRenterById(id);
        sendEmail(renter);
        return new ResponseEntity<Renter>(HttpStatus.OK);
    }

    private void sendEmail(Renter renter) {
        final String emailToRecipient = renter.getEmail();
        final String emailSubject = "Your Information is Successfully Added in the database";

        final String emailMessage1 = "<html> <body> <p>Dear Sir/Madam,</p><p>You have successfully Registered In this House"
                + "<br><br>"
                + "<table border='1' width='300px' style='text-align:center;font-size:20px;'><tr> <td colspan='2'>"
                + "</td></tr><tr><td>Name</td><td>" + renter.getFirstName() + renter.getMiddleName() + renter.getLastName() + "</td></tr><tr><td>Address</td><td>"
                + renter.getPermanentAddress() + "</td></tr><tr><td>Email</td><td>" + renter.getPhoneNumber1()
                + "</td></tr></table> </body></html>";


        mailSenderObj.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelperObj.setTo(emailToRecipient);
                mimeMessageHelperObj.setText(emailMessage1, true);
                mimeMessageHelperObj.setSubject(emailSubject);
                FileSystemResource resource = new FileSystemResource(new File("/home/onik/Pictures/picture.jpg"));
                mimeMessageHelperObj.addInline("homeImage", resource);

            }
        });
    }

}
