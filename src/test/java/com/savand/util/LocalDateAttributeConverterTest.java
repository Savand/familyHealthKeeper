package com.savand.util;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class LocalDateAttributeConverterTest {

    @Test
    public void testConvertToDatabaseColumn_ReturnSQLDateOfLocalDate() {
        LocalDate localDate = LocalDate.now();
        assertEquals(Date.valueOf(localDate), new LocalDateAttributeConverter().convertToDatabaseColumn(localDate));

    }

    @Test
    public void testConvertToDatabaseColumn_ReturnNullWhenArgIsNull() {
        assertEquals(null, new LocalDateAttributeConverter().convertToDatabaseColumn(null));

    }

    @Test
    public void testConvertToEntityAttribute_ReturnLocalDateOfSQLDate() {
        Date sqlDate = new Date(10000);
        assertEquals(sqlDate.toLocalDate(), new LocalDateAttributeConverter().convertToEntityAttribute(sqlDate));

    }

    @Test
    public void testConvertToEntityAttribute_ReturnNullWhenArgIsNull() {
        assertEquals(null, new LocalDateAttributeConverter().convertToEntityAttribute(null));

    }
}