package com.xpx.tableview.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xpx on 2017/2/14.
 */

public class TableDataModel {

    private List<Map<String, String>> mTableData = new ArrayList<Map<String, String>> () ;
    private List<String> mTableDataJson = new ArrayList< String> () ;
    private List<String> mTableDataRecordID = new ArrayList< String> () ;
    private ArrayList<TableModel> mTableHead = new ArrayList<TableModel>();
    private String mTableHeadJson = "";

    public List<String> getmTableDataRecordID() {
        return mTableDataRecordID;
    }

    public void setmTableDataRecordID(List<String> mTableDataRecordID) {
        this.mTableDataRecordID = mTableDataRecordID;
    }

    public List<Map<String, String>> getmTableData() {
        return mTableData;
    }

    public void setmTableData(List<Map<String, String>> mTableData) {
        this.mTableData = mTableData;
    }

    public ArrayList<TableModel> getmTableHead() {
        return mTableHead;
    }

    public void setmTableHead(ArrayList<TableModel> mTableHead) {
        this.mTableHead = mTableHead;
    }

    public String getmTableHeadJson() {
        return mTableHeadJson;
    }

    public void setmTableHeadJson(String mTableHeadJson) {
        this.mTableHeadJson = mTableHeadJson;
    }


    public List<String> getmTableDataJson() {
        return mTableDataJson;
    }

    public void setmTableDataJson(List<String> mTableDataJson) {
        this.mTableDataJson = mTableDataJson;
    }
}
