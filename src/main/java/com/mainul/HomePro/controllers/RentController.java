package com.mainul.HomePro.controllers;

import com.lowagie.text.DocumentException;
import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.RentService;
import com.mainul.HomePro.service.RoomService;
import com.mainul.HomePro.springSecurity.service.UserService;
import com.mainul.HomePro.utils.ExpensePDFExporter;
import com.mainul.HomePro.utils.RentMonthWisePDFExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RentController {

    @Autowired private RoomService roomService;

    @Autowired private RentService rentService;

    @Autowired private UserService userService;

    @GetMapping("/addRent")
    public String getRentForm(Model model, Principal principal) {
        model.addAttribute("rooms", roomService.roomList(userService.findByUsername(principal.getName())));
        model.addAttribute("rent", new Rent());
        return "addRent";
    }

    @PostMapping("/addRent")
    public String saveRent(@ModelAttribute Rent rent, Principal principal) {
        rentService.saveRent(rent, userService.findByUsername(principal.getName()));
        return "redirect:/rentList";
    }

    @GetMapping("/rentList")
    public String rentListTable(Model model,Principal principal) {
        model.addAttribute("roomList", roomService.roomList(userService.findByUsername(principal.getName())));
        model.addAttribute("rentList", rentService.getAllRent(userService.findByUsername(principal.getName())));
        return "rentList";
    }


    @GetMapping("/updateRentInfo/{id}")
    public String updateRentForm(@PathVariable(value = "id") Long id, Model model, Principal principal) {
        model.addAttribute("roomList", roomService.roomList(userService.findByUsername(principal.getName())));
        model.addAttribute("rent", rentService.getRentById(id));
        return "updateRentInfo";
    }


    @GetMapping("/thisMonthRentDetails")
    public String thisMonthRentInfo(Model model,Principal principal) {
        model.addAttribute("thisMonthRentDetails", rentService.currentMonthRentList(userService.findByUsername(principal.getName())));
        return "thisMonthRentDetails";
    }

    @GetMapping("/thisYearRentList")
    public String thisYearRentDetails(Model model, Principal principal) {
        model.addAttribute("thisYearRentDetails", rentService.currentYearRentList(userService.findByUsername(principal.getName())));
        return "thisYearRentList";
    }

    @GetMapping("/deleteRent/{id}")
    public String deleteRent(@PathVariable(value = "id") Long id) {
        rentService.deleteRentById(id);
        return "redirect:/rentList";

    }

    @GetMapping("/rentDetails/{id}")
    public String rentDetails(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("rent",rentService.getRentById(id));
        return "rentDetails";
    }

    @GetMapping("/rent/export/pdf")
    public void exportToPDF(HttpServletResponse response,Principal principal) throws DocumentException, IOException, ParseException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=expenses_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Rent> listRents = rentService.currentMonthRentList(userService.findByUsername(principal.getName()));

        RentMonthWisePDFExporter exporter = new RentMonthWisePDFExporter(listRents);
        exporter.export(response);

    }

}
