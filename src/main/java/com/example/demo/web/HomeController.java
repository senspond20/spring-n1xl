package com.example.demo.web;


import com.example.demo.utils.MemberXml;
import com.example.demo.utils.MemberXmlList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final RequestMappingHandlerMapping re;

    @GetMapping("/hello")
    public String hello(){
        return "Add4ffd4";
    }

    @GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public MemberXmlList getAllMembersXML() {
        List<MemberXml> list = new ArrayList<MemberXml>();
        list.add(new MemberXml(1, "AAA", 22, "it"));
        list.add(new MemberXml(2, "BBB", 24, "ia"));
        list.add(new MemberXml(3, "CCC", 25, "ix"));
        list.add(new MemberXml(4, "DDD", 26, "iv"));

        MemberXmlList res = new MemberXmlList();
        res.setMembers(list);

        return res;
    }

    @GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllMembersJson() {
        List<MemberXml> list = new ArrayList<>();
        list.add(new MemberXml(1, "AAA", 22, "it"));
        list.add(new MemberXml(2, "BBB", 24, "ia"));
        list.add(new MemberXml(3, "CCC", 25, "ix"));
        list.add(new MemberXml(4, "DDD", 26, "iv"));

        return list;
    }

    @GetMapping("/sitemap2.xml")
    public Object getSitemap() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = re.getHandlerMethods();
        List<String> list = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            list.addAll((entry.getKey().getPatternsCondition().getPatterns()));
        }

        System.out.println(list);

        // Construct XML response from urls and return it
        return list;
    }


}
