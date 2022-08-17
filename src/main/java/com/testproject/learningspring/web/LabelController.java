package com.testproject.learningspring.web;

import com.testproject.learningspring.business.domain.CatalogItem;
import com.testproject.learningspring.business.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/labels")
public class LabelController {
    private final CatalogService catalogService;

    @Autowired
    public LabelController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String getLabel(@RequestParam(value="label", required = false)String label, Model model) {
        List<CatalogItem> items = catalogService.getCatalog(null, label, null);
        model.addAttribute("items", items);
        model.addAttribute("label", label);
        return "label";
    }

}
