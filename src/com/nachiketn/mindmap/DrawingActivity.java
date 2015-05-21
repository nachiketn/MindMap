package com.nachiketn.mindmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class DrawingActivity extends Activity {

  private ScalableTextView textView;
  private ScalableTextView anotherTextView;

  final static float SCALE_STEP = 200;
  final static float MAX_SCALE = 64.0f;
  float ratio = 1.0f;
  int baseDistance;
  float baseRatio;
  final static float FONT_SIZE = 14;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    textView = (ScalableTextView) findViewById(R.id.textView);
    anotherTextView = (ScalableTextView) findViewById(R.id.anotherTextView);
  }

  public boolean onTouchEvent(MotionEvent event) {

    if (event.getPointerCount() == 2) {
      int action = event.getAction();
      int pureaction = action & MotionEvent.ACTION_MASK;

      if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
        baseDistance = getDistance(event);
        baseRatio = ratio;
      } else {
        float delta = (getDistance(event) - baseDistance) / SCALE_STEP;
        float multi = (float) Math.pow(2, delta);
        ratio = Math.min(MAX_SCALE, Math.max(0.1f, baseRatio * multi));
        textView.scale(ratio);
        anotherTextView.scale(ratio);
      }
    }

    return true;
  }

  int getDistance(MotionEvent event) {
    int dx = (int) (event.getX(0) - event.getX(1));
    int dy = (int) (event.getY(0) - event.getY(1));
    return (int) (Math.sqrt(dx * dx + dy * dy));
  }
}
