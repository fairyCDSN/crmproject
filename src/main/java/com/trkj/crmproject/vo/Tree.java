package com.trkj.crmproject.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class Tree {
    private int id;
    private String label;
    private List<Tree> tree;
}
