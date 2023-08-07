package com.hackerstudy.studytest.weight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @class: TreeNode
 * @description: 节点树
 * @author: 17911
 * @date: 2023-08-07 22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreeNode implements Serializable {

    /** 节点ID*/
    private Integer id;

    /** 权重 */
    private Integer weight;

    /** 父节点ID */
    private Integer parentId;

    /** 子节点 */
    private List<TreeNode> childList;
}
