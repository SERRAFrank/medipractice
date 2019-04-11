package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
public class AjaxController extends AbstractController {


    @PostMapping(value = "/page")
    public ResponseEntity<?> postIndex(@RequestBody PageBean page) {
        return this.serviceManager.getPageService().postPage(page);
    }


    @PostMapping("/page/{module}/{name}/submission")
    public DataFileDto postDataFile(@Valid @RequestBody DataFileDto datafile) {
        return this.serviceManager.getDataService().postDatas(datafile);
    }

    @GetMapping(value = "/setDatafile")
    public void setDatafiles(@ModelAttribute("datafile") String value) {
       //return this.serviceManager.getDataService().setDatafile(value);
    }

    @GetMapping(value = "/getDatafiles", produces = "application/json")
    public List<Map<String, Object>> getDatafiles(@RequestParam String value) {

        String[] fields = {"prenom", "nom_de_famille"};
        List<DataFileBean> dataFileBeanList = this.serviceManager.getDataService().getDatafiles(fields, value);

        Map<UUID, Map<String, String>> selected = new HashMap<>();

        dataFileBeanList.forEach(d -> {
            if (!selected.containsKey((d.getId())))
                selected.put(d.getId(), new HashMap<>());
            selected.get(d.getId()).put(d.getType(), d.getValue());
        });

        List<Map<String, Object>> returnedList = new ArrayList<>();
        selected.forEach((k, v) -> {
                    String val = "";
                    if (v.containsKey("prenom"))
                        val += v.get("prenom") + " ";
                    if (v.containsKey("nom_de_famille"))
                        val += v.get("nom_de_famille").toUpperCase();
                    if (v.containsKey("nom_de_naissance"))
                        val += " né(e) " + v.get("nom_de_naissance");
                    Map<String, Object> data = new HashMap<>();
                    data.put("id", k);
                    data.put("value", val);
                    returnedList.add(data);
                }
        );
        return returnedList;
    }


}
