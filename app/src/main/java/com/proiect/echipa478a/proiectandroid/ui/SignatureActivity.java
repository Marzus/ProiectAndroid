package com.proiect.echipa478a.proiectandroid.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.proiect.echipa478a.proiectandroid.R;
import com.proiect.echipa478a.proiectandroid.custom.datapojo.BidItemManager;


public class SignatureActivity extends AppCompatActivity {

    private Paint mPaint;
    private DrawingClass dc;
    private Bitmap myBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dc = new DrawingClass(this);
        setContentView(dc);
        setTitle("Draw Signature");
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(12f);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.finish_signature, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.finish_signature:
                Intent intenty = new Intent(SignatureActivity.this, MainActivity.class);
                /*Bundle bundle = new Bundle();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                bundle.putByteArray("ITEM_SIGNATURE", stream.toByteArray());
                intenty.putExtras(bundle);*/
                // put the signature on the item
                BidItemManager.getLastBidItemAdded().setOwnerSignature(myBitmap);
                startActivity(intenty);
        }
        return true;
    }



    class DrawingClass extends View {

        private Paint mBitmapPaint;
        private Paint circlePaint;
        private Path myPath;
        private Path circlePath;
        private Canvas mCanvas;

        private Context context;

        public DrawingClass(Context context) {
            super(context);
            this.context = context;
            myPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();

            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.RED);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeWidth(4f);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(myBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath(myPath, mPaint);
            canvas.drawPath(circlePath, circlePaint);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            myBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(myBitmap);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchDown(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchMove(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touchUp(x, y);
                    invalidate();
                    break;
            }
            return true;
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 3;

        private void touchUp(float x, float y) {
            myPath.lineTo(mX, mY);
            circlePath.reset();
            mCanvas.drawPath(myPath, mPaint);
            myPath.reset();
        }

        private void touchMove(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if(dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                myPath.quadTo(mX, mY, (x + mX)/2, (y+mY)/2);
                mX = x;
                mY = y;

                circlePath.reset();
                circlePath.addCircle(mX, mY, 10f, Path.Direction.CW);
            }
        }

        private void touchDown(float x, float y) {
            myPath.reset();
            myPath.moveTo(x, y);
            mX = x;
            mY = y;
        }
    }
}
