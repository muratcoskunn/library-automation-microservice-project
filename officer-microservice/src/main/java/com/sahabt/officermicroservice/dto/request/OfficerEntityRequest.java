package com.sahabt.officermicroservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OfficerEntityRequest  {
    private String id;
    private String name;
    private String fullname;
    private String department;
}
