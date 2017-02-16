package com.xpx.tableview.widget;




import com.xpx.tableview.utils.ScrollHViewListener;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;



public class ObservableHScrollView extends HorizontalScrollView
{

	private ScrollHViewListener scrollViewListener = null;


	public ObservableHScrollView(Context context)
	{

		super(context);

	}

	public ObservableHScrollView(Context context, AttributeSet attrs,

	int defStyle)
	{

		super(context, attrs, defStyle);

	}

	public ObservableHScrollView(Context context, AttributeSet attrs)
	{

		super(context, attrs);

	}

	public void setOnScrollViewListener(ScrollHViewListener scrollViewListener)
	{

		this.scrollViewListener = scrollViewListener;

	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy)
	{

		super.onScrollChanged(x, y, oldx, oldy);

		if (scrollViewListener != null)
		{

			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);

		}

	}

}
