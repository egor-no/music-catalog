package com.testproject.learningspring.web;

import com.testproject.learningspring.business.domain.CatalogItem;
import com.testproject.learningspring.business.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/catalog", "/"})
public class CatalogWebController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogWebController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String getCatalog(Model model){
        List<CatalogItem> catalog = this.catalogService.getCatalog(null, null, null);
        model.addAttribute("catalog", catalog);
        return "catalog";
    }

}
