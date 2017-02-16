package com.xpx.tableview.widget;



import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;










import java.util.List;
import java.util.Map;

import com.xpx.tableview.R;
import com.xpx.tableview.model.TableCellModel;
import com.xpx.tableview.model.TableDataModel;
import com.xpx.tableview.model.TableModel;
import com.xpx.tableview.utils.Resource;
import com.xpx.tableview.utils.ScrollHViewListener;
import com.xpx.tableview.utils.ScrollViewListener;

/**
 * Created by xpx on 2017/2/14.
 */

public class TableView extends RelativeLayout implements ScrollViewListener, ScrollHViewListener{

    public static final int OPEN_TYPE_MAIL = 201;
    public static final int OPEN_TYPE_PHONE = 202;
    public static final int OPEN_TYPE_MAP = 203;
    public static final int OPEN_TYPE_NOMAL = 0;
    private ObservableScrollView mVScrollView;
    private ObservableScrollView mVScrollViewl;
    private ObservableHScrollView mHScrollView;
    private ObservableHScrollView mHScrollViewr;
    private PullToRefreshExView mPullToRefreshView;
    private View mTable;
    private RelativeLayout mBaseLayer;
    private LinearLayout mTopLine;
    private LinearLayout mLeftLine;
    private LinearLayout mMain;
    private TableDataModel mTableData;
    private OnClickListener setTextClickListener;

    public TableView(Context context) {
        super(context);
    }

    public TableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater mInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mTable = mInflater.inflate(Resource.getIdByName(context, "layout", "baseform"), null);
        mLeftLine = (LinearLayout) mTable.findViewById(Resource.getIdByName(context, "id", "tableLayoutleft"));
        mTopLine = (LinearLayout) mTable.findViewById(Resource.getIdByName(context, "id", "tableLayouttop"));
        mMain = (LinearLayout) mTable.findViewById(Resource.getIdByName(context, "id", "tableLayout"));
        mVScrollView = (ObservableScrollView) mTable.findViewById(Resource.getIdByName(context, "id", "vScrollView"));
        mVScrollViewl = (ObservableScrollView) mTable.findViewById(Resource.getIdByName(context, "id", "vScrollViewl"));
        mHScrollView = (ObservableHScrollView) mTable.findViewById(Resource.getIdByName(context, "id", "hScrollView"));
        mHScrollViewr = (ObservableHScrollView) mTable.findViewById(Resource.getIdByName(context, "id", "hScrollViewr"));
        mVScrollView.setOnScrollViewListener(this);
        mVScrollViewl.setOnScrollViewListener(this);
        mHScrollView.setOnScrollViewListener(this);
        mHScrollViewr.setOnScrollViewListener(this);
        mBaseLayer = (RelativeLayout) mTable.findViewById(Resource.getIdByName(context, "id", "gride_base_layer"));
        mPullToRefreshView = (PullToRefreshExView) mTable.findViewById(Resource.getIdByName(context, "id", "mail_pull_refresh_view"));
        mPullToRefreshView.setVisibility(View.INVISIBLE);
        mPullToRefreshView.getmFooterView().setVisibility(View.INVISIBLE);
        this.addView(mTable);
    }

    public  TableDataModel getTableDataModel()
    {
        return this.mTableData;
    }

    public void setData(TableDataModel mData) {
        this.mTableData = mData;
        cleanDataViews();
        upDateView();
    }

    public void upDateView() {

        if(mTableData != null)
        {
            List<Map<String, String>> udata = (List<Map<String, String>>) mTableData.getmTableData();

            LayoutInflater mInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (mTopLine.getChildCount() == 0) {
                boolean first = true;
                for (int i = 0; i < mTableData.getmTableHead().size(); i++) {
                    TableModel temp = mTableData.getmTableHead().get(i);
                    if (temp.isGridVisiable()) {
                        if (temp.isVisiable() == true) {

                            if (first == true) {
                                first = false;
                                View textitem = mInflater.inflate(Resource.getIdByName(this.getContext(), "layout", "grid_text_item"), null);
                                TextView tv = (TextView) textitem.findViewById(Resource.getIdByName(this.getContext(), "id", "gride_text"));
                                tv.setWidth(temp.getmWidth());
                                textitem.setBackgroundResource(Resource.getIdByName(this.getContext(), "drawable", "grid_cell_shape"));
                                tv.setText(temp.getmCatpion());
                                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                TextPaint p = tv.getPaint();
                                p.setFakeBoldText(true);
                                tv.setMaxWidth(temp.getmWidth());
                                if (temp.isVisiable() == false) {
                                    tv.setVisibility(View.GONE);
                                }
                                mBaseLayer.addView(textitem);
                                mBaseLayer.setVisibility(View.VISIBLE);
                            } else {

                                View textitem = mInflater.inflate(Resource.getIdByName(this.getContext(), "layout", "grid_text_item"), null);
                                TextView tv = (TextView) textitem.findViewById(Resource.getIdByName(this.getContext(), "id", "gride_text"));
                                tv.setWidth(temp.getmWidth());
                                textitem.setBackgroundResource(Resource.getIdByName(this.getContext(), "drawable", "grid_cell_shape"));
                                tv.setText(temp.getmCatpion());
                                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                TextPaint p = tv.getPaint();
                                p.setFakeBoldText(true);
                                tv.setMaxWidth(temp.getmWidth());
                                tv.setMinWidth(temp.getmWidth());

                                mTopLine.addView(textitem);
                            }
                        }
                    }

                }
            }

            for (int i = mMain.getChildCount(); i < udata.size(); i++) {
                Map<String, String> tmp = udata.get(i);
                LinearLayout line = (LinearLayout) mInflater.inflate(Resource.getIdByName(this.getContext(), "layout", "grid_cell"), null);
                boolean isfirst = true;
                for (TableModel headData : mTableData.getmTableHead()) {
                    if (headData.isGridVisiable()) {
                        if (headData.isVisiable() == true) {

                            {
                                View textitem = mInflater.inflate(Resource.getIdByName(this.getContext(), "layout", "grid_text_item"), null);
                                TextView tv = (TextView) textitem.findViewById(Resource.getIdByName(this.getContext(), "id", "gride_text"));
                                tv.setTag(headData.getmFeild());
                                tv.setMaxWidth(headData.getmWidth());
                                if ((i) % 2 == 0) {
                                    textitem.setBackgroundResource(Resource.getIdByName(this.getContext(), "drawable", "grid_cell_shape2"));
                                } else {
                                    textitem.setBackgroundResource(Resource.getIdByName(this.getContext(), "drawable", "grid_cell_shape"));
                                }
                                tv.setWidth(headData.getmWidth());
                                tv.setMaxWidth(headData.getmWidth());
                                tv.setMinWidth(headData.getmWidth());
                                TableCellModel mTableCellModel = null;
                                if (headData.getmType().length() != 0) {
                                    if (headData.getmType().toLowerCase().equals("email")) {
                                        mTableCellModel = new TableCellModel(headData.getmCatpion(),tmp.get(mTableData.getmTableHead().get(0).getmFeild()),String.valueOf(tmp.get(headData.getmFeild()))
                                                , OPEN_TYPE_MAIL,mTableData.getmTableDataJson().get(i),mTableData.getmTableDataRecordID().get(i));
                                        tv.setText(Html.fromHtml("<u>" + tmp.get(headData.getmFeild()) + "</u>"));
                                        tv.setTextColor(Color.rgb(79, 191, 232));
                                        tv.setVisibility(View.VISIBLE);
                                    } else if (headData.getmType().toLowerCase().equals("phone")) {
                                        mTableCellModel = new TableCellModel(headData.getmCatpion(),tmp.get(mTableData.getmTableHead().get(0).getmFeild()),String.valueOf(tmp.get(headData.getmFeild()))
                                                , OPEN_TYPE_PHONE,mTableData.getmTableDataJson().get(i),mTableData.getmTableDataRecordID().get(i));
                                        tv.setText(Html.fromHtml("<u>" + tmp.get(headData.getmFeild()) + "</u>"));
                                        tv.setTextColor(Color.rgb(79, 191, 232));
                                        tv.setVisibility(View.VISIBLE);
                                    } else if (headData.getmType().toLowerCase().equals("address")) {
                                        mTableCellModel = new TableCellModel(headData.getmCatpion(),tmp.get(mTableData.getmTableHead().get(0).getmFeild()),String.valueOf(tmp.get(headData.getmFeild()))
                                                , OPEN_TYPE_MAP,mTableData.getmTableDataJson().get(i),mTableData.getmTableDataRecordID().get(i));
                                        tv.setText(Html.fromHtml("<u>" + tmp.get(headData.getmFeild()) + "</u>"));
                                        tv.setTextColor(Color.rgb(79, 191, 232));
                                        tv.setVisibility(View.VISIBLE);
                                    } else {
                                        mTableCellModel = new TableCellModel(headData.getmCatpion(),tmp.get(mTableData.getmTableHead().get(0).getmFeild()),String.valueOf(tmp.get(headData.getmFeild()))
                                                , OPEN_TYPE_NOMAL,mTableData.getmTableDataJson().get(i),mTableData.getmTableDataRecordID().get(i));
                                        if (tmp.get(headData.getmFeild()).equals("false") || tmp.get(headData.getmFeild()).equals("true")) {
                                            if (tmp.get(headData.getmFeild()).equals("false")) {
                                                tv.setText(getContext().getString(Resource.getIdByName(this.getContext(), "string", "keyword_no")));
                                                tv.setTag(0);
                                            } else {
                                                tv.setText(getContext().getString(Resource.getIdByName(this.getContext(), "string", "keyword_yes")));
                                                tv.setTag(0);
                                            }
                                        } else {
                                            tv.setText(String.valueOf(tmp.get(headData.getmFeild())));
                                            tv.setTag(0);
                                        }
                                    }
                                }
                                else
                                {
                                    tv.setText(String.valueOf(tmp.get(headData.getmFeild())));
                                    tv.setTag(0);
                                }
                                tv.setTag(mTableCellModel);
                                if(setTextClickListener != null)
                                {
                                    tv.setOnClickListener(setTextClickListener);
                                }

                                if (isfirst == true) {
                                    isfirst = false;
                                    mLeftLine.addView(textitem);

                                } else {
                                    line.addView(textitem);

                                }
                            }

                        }

                    }
                }
                mMain.addView(line);
            }
            if (mMain.getChildCount() != 0)
                mPullToRefreshView.setVisibility(View.VISIBLE);

        }
    }

    public void cleanDataViews()
    {
        mBaseLayer.removeAllViews();
        mTopLine.removeAllViews();
        mLeftLine.removeAllViews();
        mMain.removeAllViews();
        mBaseLayer.setVisibility(View.INVISIBLE);
    }

    public void cleanTableViews()
    {
        mLeftLine.removeAllViews();
        mMain.removeAllViews();
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy)
    {
        // TODO Auto-generated method stub
        if (scrollView == mVScrollViewl)
        {

            mVScrollView.scrollTo(x, y);

        }
        else if (scrollView == mVScrollView)
        {

            mVScrollViewl.scrollTo(x, y);

        }

    }

    @Override
    public void onScrollChanged(ObservableHScrollView scrollView, int x, int y, int oldx, int oldy)
    {
        // TODO Auto-generated method stub
        if (scrollView == mHScrollView)
        {

            mHScrollViewr.scrollTo(x, y);

        }
        else if (scrollView == mHScrollViewr)
        {

            mHScrollView.scrollTo(x, y);

        }

    }

    public void setOnFooterRefreshListener(PullToRefreshExView.OnFooterRefreshListener mOnFooterRefreshListener)
    {
        mPullToRefreshView.setOnFooterRefreshListener(mOnFooterRefreshListener);
    }

    public void setOnHeaderRefreshListener(PullToRefreshExView.OnHeaderRefreshListener mOnHeaderRefreshListener)
    {
        mPullToRefreshView.setOnHeaderRefreshListener(mOnHeaderRefreshListener);
    }

    public void setOnTextClickListener(View.OnClickListener mTextClickListener)
    {
        setTextClickListener = mTextClickListener;
    }

    public PullToRefreshExView getmPullToRefreshView() {
        return mPullToRefreshView;
    }

    public ObservableScrollView getmVScrollView() {
        return mVScrollView;
    }

    public ObservableScrollView getmVScrollViewl() {
        return mVScrollViewl;
    }

    public ObservableHScrollView getmHScrollView() {
        return mHScrollView;
    }

    public ObservableHScrollView getmHScrollViewr() {
        return mHScrollViewr;
    }
}