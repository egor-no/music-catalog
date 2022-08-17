package com.testproject.learningspring.web;

import com.testproject.learningspring.business.domain.AlbumDAO;
import com.testproject.learningspring.business.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumWebController {

    private final AlbumService albumService;

    @Autowired
    public AlbumWebController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String getAlbum(@RequestParam(value="albumId", required = false)Long albumId, Model model) {
        List<AlbumDAO> albums = albumService.getAlbums(albumId);
        model.addAttribute("albums", albums);
        return "albums";
    }
}
