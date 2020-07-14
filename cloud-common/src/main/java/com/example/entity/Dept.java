package com.example.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xue
 * @date 2020-05-28 11:20
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Accessors
@Setter
@Getter
public class Dept implements Serializable {
    private Long deptNo;//主键
    private String deptName;//部门名称
    private String db_source; //所属数据库名称
}
