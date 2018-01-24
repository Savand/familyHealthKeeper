package com.savand.util;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeAttributeConverterTest {

    @Test
    public void testConvertToDatabaseColumn() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertEquals(null,  new LocalDateTimeAttributeConverter().convertToDatabaseColumn(null));
        assertEquals(Timestamp.valueOf(localDateTime),  new LocalDateTimeAttributeConverter().convertToDatabaseColumn(localDateTime));
    }

    @Test
    public void testConvertToEntityAttribute() {
        Timestamp timestamp = new Timestamp(10000);
        assertEquals(null, new LocalDateTimeAttributeConverter().convertToEntityAttribute(null));
        assertEquals(timestamp.toLocalDateTime(), new LocalDateTimeAttributeConverter().convertToEntityAttribute(timestamp));
    }
}