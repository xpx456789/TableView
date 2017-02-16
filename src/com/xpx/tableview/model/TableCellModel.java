package com.xpx.tableview.model;



/**
 * Created by xpx on 2017/2/14.
 */

public class TableCellModel {

    public int mType;
    public String cloumName;
    public String lineName;
    public String textValue;
    public String lineJson;
    public String lineRecordid = "" ;

    public TableCellModel(String cloumName, String lineName, String textValue,int mType,String lineJson,String lineRecordid)
    {
        this.cloumName = cloumName;
        this.lineName = lineName;
        this.textValue = textValue;
        this.mType = mType;
        this.lineJson = lineJson;
        this.lineRecordid = lineRecordid;
    }

}
