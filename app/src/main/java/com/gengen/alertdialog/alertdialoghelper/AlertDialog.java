/**
 * 系统  综合办公开发平台-核心业务系统
 * 项目  ioop-c-android
 * 创建时间  2014-9-22 下午6:11:54
 * Copyright (c) 2014, 公司 All rights reserved.
 * 公司 专有/保密源代码,未经许可禁止任何人通过任何* 渠道使用、修改源代码.
 */

package com.gengen.alertdialog.alertdialoghelper;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * 类名: AlertDialog <br/>
 * 功能: 自定义AlertDialog类. <br/>
 * 创建日期: 2014-9-22 下午6:11:54 <br/>
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.6
 * @see
 */
public class AlertDialog {
	/** 上下文参数 */
	private Context mContext;
	/** 标题旁边显示图标的ImageView */
	private ImageView mIconIV;
	/** 显示标题的TextView */
	private TextView mTitleTV;
	/** 显示内容的TextView */
	private TextView mContentTV;
	/** 默认显示内容的布局LinearLayout */
	private LinearLayout mDefaultLL;
	/** 显示自定义布局的FrameLayout */
	private FrameLayout mCustomFL;
	/** 最左边的按钮Button */
	private Button mLeftBtn;
	/** 中间的按钮Button */
	private Button mMiddleBtn;
	/** 最右边的按钮Button */
	private Button mRightBtn;
	/** 全局的对话框变量 */
	private android.app.AlertDialog mDialog;

	public AlertDialog(Context context){
		mContext = context;
		mDialog = new android.app.AlertDialog.Builder(mContext).create();
		mDialog.setView(View.inflate(context, R.layout.alert_dialog_new, null));
		mDialog.show();
		//替换整个对话框的布局
		Window window = mDialog.getWindow();
		window.setContentView(R.layout.alert_dialog_new);

		//获取自定义布局的控件
		mIconIV = (ImageView)window.findViewById(R.id.alert_dialog_icon_iv);
		mTitleTV = (TextView)window.findViewById(R.id.alert_dialog_title_tv);
		mDefaultLL = (LinearLayout)window.findViewById(R.id.alert_dialog_content_ll);
		mContentTV = (TextView)window.findViewById(R.id.alert_dialog_content_tv);
		mCustomFL = (FrameLayout)window.findViewById(R.id.alert_dialog_custom_fl);
		mLeftBtn = (Button)window.findViewById(R.id.alert_dialog_left_btn);
		mMiddleBtn = (Button)window.findViewById(R.id.alert_dialog_middle_btn);
		mRightBtn = (Button)window.findViewById(R.id.alert_dialog_right_btn);
	}
	/**
	 * setIcon:设置标题左边图标的资源ID. <br/>
	 * @author wchhuangya
	 * @param resId	-	图标的图片资源ID
	 */
	public AlertDialog setIcon(int resId){
		mIconIV.setVisibility(View.VISIBLE);
		mIconIV.setBackgroundResource(resId);
		return this;
	}
	/**
	 * setIcon:设置标题左边图标的资源ID. <br/>
	 * @author wchhuangya
	 * @param title	-	标题
	 */
	public AlertDialog setTitle(String title){
		mTitleTV.setText(title);
		return this;
	}
	/**
	 * setIcon:设置标题. <br/>
	 * @author wchhuangya
	 * @param msg	-	内容
	 */
	public AlertDialog setMsg(String msg){
		mContentTV.setText(msg);
		return this;
	}
	/**
	 * setCustomView:设置自定义布局. <br/>
	 * @author wchhuangya
	 * @param resId	-	自定义布局的ID
	 */
	public AlertDialog setCustomView(int resId){
		View view = View.inflate(mContext, resId, null);
		if(mCustomFL.getChildCount() > 0)
			mCustomFL.removeAllViews();
		mDefaultLL.setVisibility(View.GONE);
		mCustomFL.addView(view);

		return this;
	}
	/**
	 * setCustomView:设置自定义布局. <br/>
	 * @author wchhuangya
	 * @param resId	-	自定义布局的ID
	 */
	public AlertDialog setCustomView1(Context context,int resId){
		View view = View.inflate(mContext, resId, null);
		mContext = context;
		mDialog = new android.app.AlertDialog.Builder(mContext).create();
		mDialog.setView(View.inflate(context, resId, null));
		mDialog.show();
		//替换整个对话框的布局
		Window window = mDialog.getWindow();
		window.setContentView(R.layout.alert_dialog_new);

		return this;
	}


	/**
	 * getSingleView:(获取自定义布局里的某一控件). <br/>
	 * @author wuhr
	 * @param resId
	 * @return
	 */
	public View getSingleView(int resId){
		if(mCustomFL.getChildCount() > 0){
			return mCustomFL.findViewById(resId);
		} else {
			return null;
		}
	}
	/**
	 * setLeftBtnText:设置左边按钮的文字. <br/>
	 * @author wchhuangya	-	按钮的文字
	 */
	public AlertDialog setLeftBtnText(String text){
		mLeftBtn.setVisibility(View.VISIBLE);
		mLeftBtn.setText(text);
		return this;
	}
	/**
	 * setLeftBtnText:设置中间按钮的文字. <br/>
	 * @author wchhuangya	-	按钮的文字
	 */
	public AlertDialog setMiddleBtnText(String text){
		mMiddleBtn.setVisibility(View.VISIBLE);
		mMiddleBtn.setText(text);
		return this;
	}
	/**
	 * setLeftBtnText:设置右边按钮的文字. <br/>
	 * @author wchhuangya	-	按钮的文字
	 */
	public AlertDialog setRightBtnText(String text){
		mRightBtn.setVisibility(View.VISIBLE);
		mRightBtn.setText(text);
		return this;
	}
	/**
	 * setLeftBtnListener:设置左边按钮的事件监听. <br/>
	 * @author wchhuangya
	 * @param listener	-	事件监听
	 */
	public AlertDialog setLeftBtnListener(final View.OnClickListener listener){
		mLeftBtn.setOnClickListener(listener);
		return this;
	}
	/**
	 * setLeftBtnListener:设置中间按钮的事件监听. <br/>
	 * @author wchhuangya
	 * @param listener	-	事件监听
	 */
	public AlertDialog setMiddleBtnListener(final View.OnClickListener listener){
		mMiddleBtn.setOnClickListener(listener);
		return this;
	}
	/**
	 * setLeftBtnListener:设置右边按钮的事件监听. <br/>
	 * @author wchhuangya
	 * @param listener	-	事件监听
	 */
	public AlertDialog setRightBtnListener(final View.OnClickListener listener){
		mRightBtn.setOnClickListener(listener);
		return this;
	}
	/**
	 * isCancelable:是否可以取消对话框. <br/>
	 * @author wchhuangya
	 * @param isCancelable	-	true：可以取消；false：不能取消；
	 * @return
	 */
	public AlertDialog isCancelable(boolean isCancelable){
		mDialog.setCancelable(isCancelable);
		return this;
	}
	/**
	 * isCancelable:点击对话框外的区域是否可以取消对话框. <br/>
	 * @author wchhuangya
	 * @param isCancelableOnTouchOutside	-	true：可以取消；false：不能取消；
	 * @return
	 */
	public AlertDialog isCancelableOnTouchOutside(boolean isCancelableOnTouchOutside){
		mDialog.setCanceledOnTouchOutside(isCancelableOnTouchOutside);
		return this;
	}
	/**
	 * dismiss:让对话框消失的方法. <br/>
	 * @author wchhuangya
	 */
	public void dismiss(){
		mDialog.dismiss();
	}
}
