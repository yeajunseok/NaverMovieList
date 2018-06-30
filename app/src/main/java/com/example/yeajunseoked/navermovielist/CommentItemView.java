package com.example.yeajunseoked.navermovielist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentItemView extends LinearLayout { //LinearLayout 상속한 이유는 comment item view의 최상위 레이아웃이 LinearLayout 때문이다.
    TextView textView, textView2, textView3, textView4;

    public CommentItemView(Context context) { //view를 정의할 때는 필수 생성자가 두개이다.
        super(context);
        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) { //view를 정의할 때는 필수 생성자가 두개이다.
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //시스템 서비스중 LayoutInflater가 실행되어 있는데 그러 사용하겠다는 의미이다.
        inflater.inflate(R.layout.comment_item_view, this, true); //this인 이유는 comment item view의 최상위 레이아웃이 LinearLayout 때문이다.

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
    }

    public void  setName(String name) {
        textView.setText(name);
    }
    public void  setTime(String time) {
        textView2.setText(time);
    }
    public void  setComment(String comment) {
        textView3.setText(comment);
    }
    public void  setSelect(String select) {
        textView4.setText(select);
    }

}
