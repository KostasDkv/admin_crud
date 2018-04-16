package controllers;

import entities.Category;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.MyService;

@RequestMapping("/admin")
@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/insert_product_form", method = RequestMethod.GET)
    public String insertProductForm(@ModelAttribute("product") Product product) {
        return "product_form";
    }

    @RequestMapping(value = "/insert_product", method = RequestMethod.POST)
    public String insertProduct(@ModelAttribute("product") Product product) {

        if (myService.insert(product)) {

            return "product_form_success";
        } else {
            return "product_form";
        }
    }

    @RequestMapping(value = "/insert_category_form", method = RequestMethod.GET)
    public String insertCategoryForm(@ModelAttribute("category") Category category) {
        return "category_form";
    }

    @RequestMapping(value = "/insert_category", method = RequestMethod.POST)
    public String insertCategory(@ModelAttribute("category") Category category) {

        if (myService.insert(category)) {

            return "category_form_success";
        } else {
            return "category_form";
        }
    }

}
