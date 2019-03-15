package com.hackerstudy.studytest.interview.service;

import com.hackerstudy.studytest.interview.dao.InterviewDao;
import com.hackerstudy.studytest.interview.entity.Level;
import com.hackerstudy.studytest.interview.entity.Unit;
import com.hackerstudy.studytest.interview.vo.InterViewDataVo;
import com.hackerstudy.studytest.interview.vo.TableDataVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @class: InterviewService
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:32
 */
public class InterviewService {
    public List<Unit> units = new ArrayList<Unit>();
    public List<Level> levels = new ArrayList<Level>();
    public InterviewDao interviewDao = new InterviewDao();

    public List<TableDataVo> getTableData(){
        List<InterViewDataVo> pTableDataList = interviewDao.getTableData();
        List<TableDataVo> tableDataVoList = initTable();
        for(InterViewDataVo interViewDataVo:pTableDataList){
            for(TableDataVo tableDataVo:tableDataVoList){
                if(interViewDataVo.getLevel_name().equals(tableDataVo.getUser_level()) &&
                        interViewDataVo.getUnit_name().equals(tableDataVo.getUnit_name())){
                    tableDataVo.setNum(tableDataVo.getNum()+1);
                }
            }
        }
        return tableDataVoList;
    }

    /**
     * 输出表格
     */
    public void printTable(List<TableDataVo> tableDataVoList){
        StringBuffer column = new StringBuffer("    ");
        for(Unit unit:units){
            column.append(unit.getUnit_name()+" ");
        }
        System.out.println(column.toString());
        List<StringBuffer> rows = new ArrayList<StringBuffer>();
        for(Level level:levels) {
            StringBuffer row = new StringBuffer(level.getLevel_name()+" ");
            for (TableDataVo tableDataVo : tableDataVoList) {
                if(level.getLevel_name().equals(tableDataVo.getUser_level())){
                    row.append("  "+tableDataVo.getNum()+"   ");
                }
            }
            rows.add(row);
        }
        for(StringBuffer row:rows){
            System.out.println(row.toString());
        }
    }

    /**
     * 输出表格中应有的数据
     */
    public void printTableData(List<TableDataVo> tableDataVoList){
        for(TableDataVo tableDataVo:tableDataVoList){
            System.out.println(tableDataVo.toString());
        }
    }

    public List<TableDataVo> initTable(){
        units = interviewDao.getUnits();
        levels = interviewDao.getLevels();
        List<TableDataVo> tableDataVoList = new ArrayList<TableDataVo>();
        int i = 0;
        for(Level level:levels){
            for(Unit unit:units){
                TableDataVo tableDataVo = new TableDataVo();
                tableDataVo.setId(i);
                tableDataVo.setUser_level(level.getLevel_name());
                tableDataVo.setUnit_name(unit.getUnit_name());
                tableDataVo.setNum(0);
                tableDataVoList.add(tableDataVo);
                i++;
            }
        }
        return tableDataVoList;
    }

    public static void main(String[] args) {
        InterviewService interviewService = new InterviewService();
        List<TableDataVo> tableDataVoList = interviewService.getTableData();
        //输出表格样式到控制台
        interviewService.printTable(tableDataVoList);
        //输出表格数据到控制台
        interviewService.printTableData(tableDataVoList);
    }
}
