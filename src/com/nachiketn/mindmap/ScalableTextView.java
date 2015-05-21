package com.nachiketn.mindmap;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScalableTextView extends TextView {

  private int fontSize = 14;
  
  public ScalableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public ScalableTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ScalableTextView(Context context) {
    super(context);
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  public void scale(float ratio) {
    this.setTextSize(ratio + this.fontSize);
  }

}
