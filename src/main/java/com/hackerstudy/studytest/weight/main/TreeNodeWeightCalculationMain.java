package com.hackerstudy.studytest.weight.main;

import com.alibaba.fastjson.JSON;
import com.hackerstudy.studytest.weight.TreeNode;
import com.hackerstudy.studytest.weight.TreeNodeWeightCalculation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @class: NodeWeightCalculation
 * @description:
 * @author: 17911
 * @date: 2023-08-07 22:00
 */
@Slf4j
public class TreeNodeWeightCalculationMain {

    /**
     * 父子节点权重计算
     * @param args
     */
    public static void main(String[] args) {

        //calculateWeight1();

        calculateWeight2();

    }

    private static void calculateWeight1() {
        //初始化节点树
        TreeNode root = TreeNodeWeightCalculation.initTreeNode();
        log.info("start - root={}", JSON.toJSONString(root));

        //递归计算节点树的权重
        TreeNodeWeightCalculation.calculateWeight(root);
        log.info("end - root={}", JSON.toJSONString(root));
    }

    private static void calculateWeight2() {
        //获取节点list
        List<TreeNode> treeNodeList = TreeNodeWeightCalculation.getTreeNodeList();
        log.info("getTreeNodeList={}", JSON.toJSONString(treeNodeList));

        //赋值权重
        TreeNodeWeightCalculation.setTreeNodeListWeight(treeNodeList);

        TreeNode treeNode = treeNodeList.stream().filter(s -> s.getId().equals(0)).findFirst().get();
        //构建成树结构
        TreeNode root = TreeNodeWeightCalculation.buildTree(treeNodeList, treeNode);

        //递归计算节点树的权重
        TreeNodeWeightCalculation.calculateWeight(root);
        log.info("end - root={}", JSON.toJSONString(root));
    }
}
