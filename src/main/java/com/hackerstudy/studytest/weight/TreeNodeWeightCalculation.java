package com.hackerstudy.studytest.weight;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @class: NodeWeightCalculation
 * @description:
 * @author: 17911
 * @date: 2023-08-07 22:00
 */
@Slf4j
public class TreeNodeWeightCalculation {

    /**
     * 初始化树节点
     * @return
     */
    public static TreeNode initTreeNode() {
        TreeNode root = new TreeNode();
        root.setId(0);
        root.setWeight(1);

        TreeNode chird1 = new TreeNode();
        chird1.setId(1);
        chird1.setWeight(1);
        chird1.setParentId(0);

        TreeNode chird2 = new TreeNode();
        chird2.setId(2);
        chird2.setWeight(1);
        chird2.setParentId(0);

        TreeNode chird3 = new TreeNode();
        chird3.setId(3);
        chird3.setWeight(2);
        chird3.setParentId(1);

        TreeNode chird4 = new TreeNode();
        chird4.setId(4);
        chird4.setWeight(4);
        chird4.setParentId(1);

        chird1.setChildList(new ArrayList<>(Arrays.asList(chird3,chird4)));
        root.setChildList(new ArrayList<>(Arrays.asList(chird1,chird2)));
        return root;
    }

    /**
     * 获取树节点的list
     * @return
     */
    public static List<TreeNode> getTreeNodeList() {
        TreeNode root = new TreeNode();
        root.setId(0);
        //root.setWeight(1);
        //root.setParentId(0);

        TreeNode chird1 = new TreeNode();
        chird1.setId(1);
        //chird1.setWeight(1);
        chird1.setParentId(0);

        TreeNode chird2 = new TreeNode();
        chird2.setId(2);
        //chird2.setWeight(1);
        chird2.setParentId(0);

        TreeNode chird3 = new TreeNode();
        chird3.setId(3);
        //chird3.setWeight(2);
        chird3.setParentId(1);

        TreeNode chird4 = new TreeNode();
        chird4.setId(4);
        //chird4.setWeight(4);
        chird4.setParentId(1);

        //chird1.setChildList(new ArrayList<>(Arrays.asList(chird3,chird4)));
        //root.setChildList(new ArrayList<>(Arrays.asList(chird1,chird2)));
        return new ArrayList<>(Arrays.asList(root,chird1,chird2,chird3,chird4));
    }

    /**
     * 获取树节点的list
     * @return
     */
    public static void setTreeNodeListWeight(List<TreeNode> nodeList) {
        nodeList.forEach(node ->{
            if(node.getId() == 0 ){
                node.setWeight(1);
            }else if(node.getId() == 1 ){
                node.setWeight(2);
            }else if(node.getId() == 2 ){
                node.setWeight(2);
            }else if(node.getId() == 3 ){
                node.setWeight(4);
            }else if(node.getId() == 4 ){
                node.setWeight(4);
            }
        });
    }

    /**
     * 获取树节点的list
     * @return
     */
    public static TreeNode buildTree(List<TreeNode> nodeList,TreeNode parent) {
        TreeNode rootNode = null;
        List<TreeNode> childList = !CollectionUtils.isEmpty(parent.getChildList())?parent.getChildList():new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (Objects.equals(node.getParentId(), parent.getId())) {
                TreeNode childNode = buildTree(nodeList, node);
                childList.add(childNode);
            }
        }
        rootNode = parent;
        return rootNode;
    }



    /**
     * 递归计算树节点的权重
     * @return
     */
    public static void calculateWeight(TreeNode treeNode) {
        log.info("id={},weight={},parentId={}",treeNode.getId(),treeNode.getWeight(),treeNode.getParentId());
        AtomicInteger sum = new AtomicInteger(Objects.nonNull(treeNode.getWeight())?treeNode.getWeight():0);
        Optional.ofNullable(treeNode.getChildList()).ifPresent(childList ->{
            childList.forEach(childTreeNode -> {
                calculateWeight(childTreeNode);
                sum.addAndGet(Objects.nonNull(childTreeNode.getWeight())?childTreeNode.getWeight():0);
            });
        });
        treeNode.setWeight(sum.get());
    }
}
