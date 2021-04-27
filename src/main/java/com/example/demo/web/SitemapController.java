package com.example.demo.web;
import com.example.demo.service.SitemapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
@RequiredArgsConstructor
public class SitemapController{

    private final SitemapService service;

    @RequestMapping(path = "/sitemap.xml", produces = APPLICATION_XML_VALUE)
    public SitemapService create() {
        return this.service;
    }
}
