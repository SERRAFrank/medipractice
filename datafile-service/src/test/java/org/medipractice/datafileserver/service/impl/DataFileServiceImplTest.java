package org.medipractice.datafileserver.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.model.DataObject;
import org.medipractice.datafileserver.model.DataValue;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataFileServiceImplTest {

    private DataFile dataFile ;

    @Autowired
    private DataFileService dataFileService;

    @Before
    public void setUp() throws Exception {
        dataFile = new DataFile();
        dataFile.getDatas().add( new DataObject("lastname",  Arrays.asList( new DataValue("Martin"), new DataValue("Marc") ) ) );
        dataFile.getDatas().add( new DataObject("firstname", Arrays.asList(new DataValue("Jean")) ));
        dataFileService.save(dataFile);

    }

    @Test
    public void findById() {
        DataFile df = dataFileService.findById(dataFile.getId());
        Assert.assertNotNull(df);
    }



    @Test
    public void updateById() {
        UUID id = dataFile.getDataType("firstname").getValues().get(0).getId();
        dataFile.getDataType("firstname").getValue(id).setValue("Ducobut");

        dataFileService.save(dataFile);

        dataFile = dataFileService.findById(dataFile.getId());


        Assert.assertNotNull(dataFile.getDataType("firstname").getValue(id).getArchivedBy());
    }

    @Test
    public void updateByValue() {
        DataValue dataValue = dataFile.getDataType("lastname").getValues().get(0);
        dataValue.setValue("Ducobut");
        UUID id = dataValue.getId();

        dataFile.setDataType("lastname", dataValue);
        dataFileService.save(dataFile);

        dataFile = dataFileService.findById(dataFile.getId());

        Assert.assertNotNull(dataFile.getDataType("lastname").getValue(id).getArchivedBy());
    }


    @Test
    public void findAllByDataTypesAndValue(){
        List<DataFile> dataFileList = dataFileService.findAllByDataTypesAndValue( Arrays.asList("firstname", "lastname"), "marc");
        Assert.assertEquals(dataFileList.size(), 1);
    }
}