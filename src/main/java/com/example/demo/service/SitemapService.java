package com.example.demo.service;

import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.Map;

@Service
public class SitemapService  extends AbstractView {
    private static final String BASE_URL = "https://example.com";

    /**
     * @return
     * @throws MalformedURLException
     */
    public String createSitemap() throws MalformedURLException {
        WebSitemapGenerator sitemap = new WebSitemapGenerator(BASE_URL);

        sitemap.addUrl(BASE_URL + "/blog/" + 1);
        sitemap.addUrl(BASE_URL + "/blog/" + 2);
        sitemap.addUrl(BASE_URL + "/blog/" + 3);
        sitemap.addUrl(BASE_URL + "/blog/" + 4);

        return String.join("", sitemap.writeAsStrings());
    }

    /**
     * @param model
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_XML_VALUE);
        try (Writer writer = response.getWriter()) {
            writer.append(createSitemap());
        }
    }
}
