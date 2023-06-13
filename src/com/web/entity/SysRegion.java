package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRegion {
    private String regionId;
    private String regionName;
    private String regionShortName;
    private String regionCode;
    private String regionParentId;
    private Integer regionLevel;
}
