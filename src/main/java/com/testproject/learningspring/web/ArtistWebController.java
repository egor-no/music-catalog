package com.testproject.learningspring.web;

import com.testproject.learningspring.business.domain.ArtistDAO;
import com.testproject.learningspring.business.domain.CatalogItem;
import com.testproject.learningspring.business.service.ArtistService;
import com.testproject.learningspring.business.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistWebController {

    private final ArtistService artistService;
    private final CatalogService catalogService;

    @Autowired
    public ArtistWebController(ArtistService artistService, CatalogService catalogService) {
        this.artistService = artistService;
        this.catalogService = catalogService;
    }

    @GetMapping
    public String getArtists(@RequestParam(value="artistId", required = false)Long artistId, Model model) {
        List<ArtistDAO> artists = artistService.getArtistsInfo(artistId);
        model.addAttribute("artists" , artists);
        List<CatalogItem> items = catalogService.getCatalog(artistId, null, null);
        model.addAttribute("items", items);
        return "artists";
    }
}
