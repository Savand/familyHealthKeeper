package com.savand.util;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class LocalDateAttributeConverterTest {

    @Test
    public void testConvertToDatabaseColumn() {
        LocalDate localDate = LocalDate.now();
        assertEquals(Date.valueOf(localDate), new LocalDateAttributeConverter().convertToDatabaseColumn(localDate));
        assertEquals(null, new LocalDateAttributeConverter().convertToDatabaseColumn(null));

    }

    @Test
    public void testConvertToEntityAttribute() {
        Date sqlDate = new Date(10000);
        assertEquals(null, new LocalDateAttributeConverter().convertToEntityAttribute(null));
        assertEquals(sqlDate.toLocalDate(), new LocalDateAttributeConverter().convertToEntityAttribute(sqlDate));

    }
}