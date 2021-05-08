package com.xmlstubs.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xmlstubs.parser.XmlParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.xmlstubs.XmlStubsApplication.logger;

@RestController
@RequestMapping("/api/v1/xmlparser")
@JsonIgnoreProperties(ignoreUnknown = true)

public class XmlController {
    @PostMapping(consumes = {MediaType.TEXT_XML_VALUE},
            produces = {MediaType.TEXT_XML_VALUE})

    @ResponseStatus(HttpStatus.OK)
    public Object apiresponder(@RequestBody byte[] xml) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:sssss z");
        String dateString = sdf.format(date);
        Map demo = (Map) XmlParser.parsexml(xml);
		/*List<Object> keys1 = (List<Object>) demo.keySet().stream()
				.collect(Collectors.toList());

		 */
        List<Object> values1 = (List<Object>) demo.values().stream()
                .collect(Collectors.toList());
        Map elements = (Map) values1.get(1);
        List<Object> element1 = (List<Object>) elements.values().stream()
                .collect(Collectors.toList());
        String s = (String) ((Map) element1.get(0)).getOrDefault("original_title", "Null");
        logger.info(dateString + ";" + s);

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" + "<Movie>" + s + "</Movie>\n" + "<RequestTimestamp>" + dateString + "</RequestTimestamp>\n" +
                "</root>";
    }


}
