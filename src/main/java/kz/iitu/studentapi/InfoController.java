package kz.iitu.studentapi;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${app.student.name:Nurassyl}")
    private String name;

    @Value("${app.student.surname:Aitkul}")
    private String surname;

    @Value("${app.student.group:IT2-2307}")
    private String group;

    @Value("${app.student.id:37375}")
    private String studentId;

    @Value("${app.version:1.0.0}")
    private String version;

    @GetMapping("/api/info")
    public Map<String, String> info() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("application", "Aitkul Nurassyl Student API");
        info.put("name", name);
        info.put("surname", surname);
        info.put("group", group);
        info.put("studentId", studentId);
        info.put("version", version);
        return info;
    }
}
