/*
 * Copyright 2023 Datastrato.
 * This software is licensed under the Apache License version 2.
 */
package com.datastrato.graviton.server.web;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class TestObjectMapperProvider {

  @Test
  public void testGetContext() {
    ObjectMapperProvider provider = new ObjectMapperProvider();
    Class<Object> someClass = Object.class;

    ObjectMapper objectMapper = provider.getContext(someClass);

    assertNotNull(objectMapper);
    assertEquals(
        JsonInclude.Include.NON_NULL,
        objectMapper.getSerializationConfig().getDefaultPropertyInclusion().getValueInclusion());
  }
}
