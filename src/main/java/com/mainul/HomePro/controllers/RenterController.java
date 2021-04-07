package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.service.RenterService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


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
    private RenterService renterService;

    @GetMapping("/addRenter")
    public String showAddInfoForm(Model model) {
        model.addAttribute("renter", new Renter());
        return "addRenterInfo";
    }

    @PostMapping("/addRenter")
    public String addRenter(@ModelAttribute(name = "renter") Renter renter, Model model, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        // 1. get original file name
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //2. set filename to the object
        renter.setRenterImage(fileName);
        //3. create object to find id
        Renter savedRenter = renterService.saveRenter(renter);
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

       // renterService.saveRenter(renter);
        return "redirect:/addRenter";

    }

    @GetMapping("/renterList")
    public String showRenterList(Model model) {
        model.addAttribute("renterList", renterService.renterList());
        return "renterListTable";
    }

    @GetMapping("/updateRenter/{id}")
    public String updateRenterForm(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("renter", renterService.getRenterById(id));
        return "updateRenterInfo";
    }

    @GetMapping("/renter/delete/{id}")
    public String deleteRenter(@PathVariable(value = "id") Long id){
        renterService.deleteRenterById(id);
        return "redirect:/renterList";
    }

}
