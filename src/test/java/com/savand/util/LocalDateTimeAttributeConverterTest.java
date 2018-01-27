package com.savand.util;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeAttributeConverterTest {

    @Test
    public void testConvertToDatabaseColumn_ReturnSQLDateTimeValueOfLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertEquals(Timestamp.valueOf(localDateTime), new LocalDateTimeAttributeConverter().convertToDatabaseColumn(localDateTime));
    }

    @Test
    public void testConvertToDatabaseColumn_ReturnNullWhenArgIsNull() {
        assertEquals(null, new LocalDateTimeAttributeConverter().convertToDatabaseColumn(null));
    }


    @Test
    public void testConvertToEntityAttribute_ReturnLocalDateTimeValueOfSQLDateTime() {
        Timestamp timestamp = new Timestamp(10000);
        assertEquals(timestamp.toLocalDateTime(), new LocalDateTimeAttributeConverter().convertToEntityAttribute(timestamp));
    }

    @Test
    public void testConvertToEntityAttribute_ReturnNullWhenArgIsNull() {
        assertEquals(null, new LocalDateTimeAttributeConverter().convertToEntityAttribute(null));
    }
}