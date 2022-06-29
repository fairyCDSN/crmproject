package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * gg_read
 * @author
 */
@Data
public class GgRead implements Serializable {
    private Integer read_id;

    private Integer staff_id;

    private Integer gonggao_id;

    private String state;

    private static final long serialVersionUID = 1L;
}
