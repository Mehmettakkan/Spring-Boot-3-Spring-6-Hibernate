package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // revolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) { // bu metod controller'dan gelen her web isteği için çağırılacaktır.
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // Spring API'nin bir parçasıdır constructor değerini true olarak geçiyorum,
        // yani tamamen beyaz boşluk varsa, null olarak kırpın.

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        //
    }

    @GetMapping("/")
    public String showForm(Model theModel) {
        // Model, controller ve view sayfaları arasında bilgi paylaşımı yapar
        theModel.addAttribute("customer", new Customer());
        // ilk öğre ad ve ikinci öğe değeri.
        // isim vermek önemlidir çünkü bu ismi HTML formlarımız gibi görünüm sayfalarımızda kullanacağız.
        // ve ayrıca buradaki değer boş bir müşteri örneği ile başlıyor.
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        // @Valid ek açıklaması Spring MVC'ye verilen bu form verileri için doğrulama yapmasını söyler.
        // @ModelAttribute("customer") form verilerini customer'dan okuyun der,
        // HTML formu tarafından gönderilen customer'dır.
        // BindingResult doğrulama sonuçlarını tutuyor.
        System.out.println("Last Name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: " + theBindingResult.toString());

        System.out.println("\n\n\n\n");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
