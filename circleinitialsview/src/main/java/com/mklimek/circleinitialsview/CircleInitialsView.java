package com.mklimek.circleinitialsview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CircleInitialsView extends FrameLayout {

    private int backgroundColor;
    private int textColor;
    private String text;
    private float textSize;
    private int avatar = -1;

    private GradientDrawable gradientDrawable;
    private TextView tv;

    public CircleInitialsView(Context context, int avatarResourceId) {
        super(context);
        avatar = avatarResourceId;
        addChildren(context);
    }

    public CircleInitialsView(Context context, int backgroundColor, float textSize, int textColor, String text) {
        super(context);
        this.backgroundColor = backgroundColor;
        this.textSize = textSize;
        this.textColor = textColor;
        this.text = changeTextToInitials(text);
        addChildren(context);
    }

    public CircleInitialsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttrs(context, attrs);
        addChildren(context);
    }

    public void setBackgroundColor(int backgroundColor){
        this.backgroundColor = backgroundColor;
        gradientDrawable.setColor(this.backgroundColor);
        makeTextViewVisible();
    }

    public void setText(String text){
        this.text = changeTextToInitials(text);
        tv.setText(this.text);
        makeTextViewVisible();
    }

    public void setTextSize(float textSize){
        this.textSize = textSize;
        tv.setTextSize(this.textSize);
        makeTextViewVisible();
    }

    public void setTextColor(int color){
        this.textColor = color;
        tv.setTextColor(this.textColor);
        makeTextViewVisible();
    }

    public void setAvatar(int avatar){
        this.avatar = avatar;
        makeAvatarVisible();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getText() {
        return text;
    }

    public float getTextSize() {
        return textSize;
    }

    private void makeTextViewVisible() {
        setBackgroundResource(0);
        setBackground(gradientDrawable);
        tv.setVisibility(View.VISIBLE);
    }

    private void makeAvatarVisible() {
        tv.setVisibility(View.GONE);
        setBackgroundResource(this.avatar);
    }

    private void applyAttrs(Context context, AttributeSet attrs){
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.circleInitialsView_attrs, 0, 0);
        try {
            backgroundColor = a.getColor(R.styleable.circleInitialsView_attrs_circleInitialsView_backgroundColor, Color.WHITE);
            textColor = a.getColor(R.styleable.circleInitialsView_attrs_circleInitialsView_textColor, Color.BLACK);
            avatar = a.getResourceId(R.styleable.circleInitialsView_attrs_circleInitialsView_avatar, -1);
            text = a.getString(R.styleable.circleInitialsView_attrs_circleInitialsView_text);
            String textSizeString = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "textSize");
            if(textSizeString != null) {
                String split1 = textSizeString.split("sp")[0];
                this.textSize = Float.valueOf(split1);
            } else{
                this.textSize = 15;
            }
            text = changeTextToInitials(text);
        } catch (Exception e){
            e.printStackTrace();

        }finally {
            a.recycle();
        }
    }

    private String changeTextToInitials(String text) {
        if(text != null && text.length() > 0){
            if(text.length() <=2){
                return text;
            }
            String[] split = text.split(" ");
            String result = String.valueOf(split[0].charAt(0));
            if(split.length >= 2){
                result += String.valueOf(split[1].charAt(0));
            }
            return result;
        } else{
            return null;
        }
    }

    private void addChildren(Context context){
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(backgroundColor);
        setBackground(gradientDrawable);
        tv = new TextView(context);
        tv.setText(text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tv.setTextColor(textColor);
        tv.setGravity(Gravity.CENTER);
        addView(tv);
        FrameLayout.LayoutParams params = (LayoutParams) tv.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        tv.setLayoutParams(params);

        if(avatar == -1) {
            makeTextViewVisible();
        } else{
            makeAvatarVisible();
        }
    }


}
