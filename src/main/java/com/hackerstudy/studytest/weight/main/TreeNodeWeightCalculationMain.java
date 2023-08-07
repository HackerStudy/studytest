package com.hackerstudy.studytest.weight.main;

import com.alibaba.fastjson.JSON;
import com.hackerstudy.studytest.weight.TreeNode;
import com.hackerstudy.studytest.weight.TreeNodeWeightCalculation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        log.info("setTreeNodeListWeight={}", JSON.toJSONString(treeNodeList));

        //筛选出顶层节点
        List<TreeNode> rootNodeList = treeNodeList.stream().filter(s -> Objects.isNull(s.getParentId())).collect(Collectors.toList());
        log.info("start - rootNodeList={}", JSON.toJSONString(treeNodeList));

        for (TreeNode treeNode : rootNodeList) {
            //构建成树结构
            TreeNodeWeightCalculation.buildTree(treeNodeList, treeNode);
            log.info("treeNode={}", JSON.toJSONString(treeNode));

            //递归计算节点树的权重
            TreeNodeWeightCalculation.calculateWeight(treeNode);
            log.info("calculateWeight={}", JSON.toJSONString(treeNode));
        }
        log.info("end - rootNodeList={}", JSON.toJSONString(rootNodeList));
    }
}
