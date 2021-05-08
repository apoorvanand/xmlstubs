package com.xmlstubs.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.Map;

public class XmlParser {
    private static XmlMapper xmlMapper =getDefaultObjectMapper();
    private static XmlMapper getDefaultObjectMapper(){
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper;
    }
    public static Object parsexml(byte[] src) throws IOException {
        //Object src=new Object();
        //   return xmlMapper.readValue(new File("F:\\capit\\JacksonLearning\\src\\main\\java\\xmlparser\\text.xml"), Object.class);
        return xmlMapper.readValue( src,Map.class);
    }
}
