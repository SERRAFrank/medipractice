package org.medipractice.clientui.proxy;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@FeignClient(name = "gateway-server")
@RibbonClient(name = "datafile-service")
@RequestMapping("api/datafile")
public interface DataProxy {

    @GetMapping(value = "{id}")
    DataFileBean getDataFile( @PathVariable(name = "id") UUID id);

    @PostMapping(value = "/")
    DataFileBean postDataFile( @RequestBody DataFileBean dataFile);

}