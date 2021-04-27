package com.example.demo.web;


import com.example.demo.utils.MemberXml;
import com.example.demo.utils.MemberXmlList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {


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

}
