package com.xpx.tableview.model;



import android.os.Parcel;
import android.os.Parcelable;

public class TableModel implements Parcelable{
	
	private String mCatpion = "";
	private String mFeild = "";
	private String mType = "";
	private int dataType = 0;
	private int mWidth = 240;
	private int mHeight = 0;
	private boolean isReadonly = false;
	private boolean isVisiable = true;
	private boolean isAlignment = false;
	private boolean isFill = false;
	private String mDefault = "";
	private String mAttributes = "";
	private String mValues = "";
	private boolean mLinkage = false;
	private String mLinkageFields = "";
	private String mToLinkageFields = "";
	private boolean gridVisiable = true;

	public TableModel(String mCatpion,String mName)
	{
		this.mCatpion = mCatpion;
		this.mFeild = mName;
	}
	
	public TableModel(String mCatpion,String mName,boolean isReadonly,boolean isVisiable,String mType)
	{
		this.mCatpion = mCatpion;
		this.mFeild = mName;
		this.mType = mType;
		this.isReadonly = isReadonly;
		this.isVisiable = isVisiable;
	}
	
	public TableModel(String mCatpion,String mFeild,String mType,int dataType,int mWidth,int mHeight,boolean isReadonly,boolean isVisiable
			,boolean isAlignment,boolean isFill,String mDefault,String mAttributes,String mValues,boolean mLinkage,String mLinkageFields,String mToLinkageFields)
	{
		this.mCatpion = mCatpion;
		this.mFeild = mFeild;
		this.mType = mType;
		this.dataType = dataType;
		this.mWidth = mWidth;
		this.mHeight =mHeight;
		this.isReadonly = isReadonly;
		this.isVisiable = isVisiable;
		this.isAlignment = isAlignment;
		this.isFill = isFill;
		this.mDefault = mDefault;
		this.mAttributes = mAttributes;
		this.mValues = mValues;
		this.mLinkage = mLinkage;
		this.mLinkageFields = mLinkageFields;
		this.mToLinkageFields = mToLinkageFields;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(mCatpion);
		dest.writeString(mFeild);
		dest.writeString(mType);
		dest.writeInt(dataType);
		dest.writeInt(mWidth);
		dest.writeInt(mHeight);
		dest.writeString(String.valueOf(isReadonly));
		dest.writeString(String.valueOf(isVisiable));
		dest.writeString(String.valueOf(isAlignment));
		dest.writeString(String.valueOf(isFill));
		dest.writeString(mDefault);
		dest.writeString(mAttributes);
		dest.writeString(mValues);
		dest.writeString(String.valueOf(mLinkage));
		dest.writeString(mLinkageFields);
		dest.writeString(mToLinkageFields);
	}

	public static final Creator<TableModel> CREATOR = new Creator<TableModel>()
	{
		public TableModel createFromParcel( Parcel in )
		{
			return new TableModel(
					in.readString(), in.readString(),
					in.readString(), in.readInt(),in.readInt(),in.readInt(),Boolean.valueOf(in.readString())
					,Boolean.valueOf(in.readString()),Boolean.valueOf(in.readString()),Boolean.valueOf(in.readString())
					,in.readString(), in.readString(),in.readString(), Boolean.valueOf(in.readString()),in.readString(),in.readString());
		}

		public TableModel[] newArray( int size )
		{
			return new TableModel[size];
		}
	};
	
	public String getmCatpion() {
		return mCatpion;
	}

	public void setmCatpion(String mCatpion) {
		this.mCatpion = mCatpion;
	}



	public String getmFeild() {
		return mFeild;
	}

	public void setmFeild(String mFeild) {
		this.mFeild = mFeild;
	}

	public int getmWidth() {
		return mWidth;
	}

	public void setmWidth(int mWidth) {
		this.mWidth = mWidth;
	}

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public boolean isReadonly() {
		return isReadonly;
	}

	public void setReadonly(boolean isReadonly) {
		this.isReadonly = isReadonly;
	}

	public boolean isVisiable() {
		return isVisiable;
	}

	public void setVisiable(boolean isVisiable) {
		this.isVisiable = isVisiable;
	}

	public boolean isAlignment() {
		return isAlignment;
	}

	public void setAlignment(boolean isAlignment) {
		this.isAlignment = isAlignment;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public boolean isFill() {
		return isFill;
	}

	public void setFill(boolean isFill) {
		this.isFill = isFill;
	}

	public String getmDefault() {
		return mDefault;
	}

	public void setmDefault(String mDefault) {
		this.mDefault = mDefault;
	}

	public String getmAttributes() {
		return mAttributes;
	}

	public void setmAttributes(
			String mAttributes) {
		this.mAttributes = mAttributes;
	}

	public String getmValues() {
		return mValues;
	}

	public void setmValues(String mValues) {
		this.mValues = mValues;
	}

	public boolean ismLinkage() {
		return mLinkage;
	}

	public void setmLinkage(boolean mLinkage) {
		this.mLinkage = mLinkage;
	}

	public String getmLinkageFields() {
		return mLinkageFields;
	}

	public void setmLinkageFields(
			String mLinkageFields) {
		this.mLinkageFields = mLinkageFields;
	}

	public String getmToLinkageFields() {
		return mToLinkageFields;
	}

	public void setmToLinkageFields(
			String mToLinkageFields) {
		this.mToLinkageFields = mToLinkageFields;
	}


	public boolean isGridVisiable() {
		return gridVisiable;
	}

	public void setGridVisiable(boolean gridVisiable) {
		this.gridVisiable = gridVisiable;
	}
}
