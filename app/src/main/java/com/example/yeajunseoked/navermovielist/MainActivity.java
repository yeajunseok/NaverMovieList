package com.example.yeajunseoked.navermovielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button  likebutton, dislikebutton, writeButton, allseeButton;
    TextView liketextView, dislikeView;
    boolean likeState = false;
    boolean dislikeStake = false;
    int likeCount =1;
    int dislikeCount =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likebutton = (Button) findViewById(R.id.likebutton);
        dislikebutton = (Button) findViewById(R.id.dislikebutton);
        liketextView = (TextView) findViewById(R.id.liketextView);
        dislikeView = (TextView) findViewById(R.id.dislikeView);
        writeButton = (Button) findViewById(R.id.writeButton);
        allseeButton = (Button) findViewById(R.id.allseeButton);

        likebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dislikeStake){
                    incrLikeCount();
                    decrdisLikeCount();
                    dislikeStake =! dislikeStake;
                }else if(likeState){
                    decrLikeCount();
                }else {
                    incrLikeCount();
                }
                likeState = !likeState;
            }
        });

        dislikebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){//좋아요 버튼이 눌려져있으면
                    decrLikeCount();
                    incrdisLikeCount();
                    likeState = !likeState;
                }else if(dislikeStake){
                    decrdisLikeCount();
                }
                else {
                    incrdisLikeCount();
                }
                dislikeStake =! dislikeStake;
            }
        });

        allseeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommentAllSeeActivity.class);
                startActivityForResult(intent, 102);
            }
        });

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
                //intent.putExtra(CommentWriteActivity.INTENT_KEY ,)
                startActivityForResult(intent, 101); //응답받기 위해서 forresult
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym**","10분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", "추천 0"));
        adapter.addItem(new CommentItem("aaa**","20분전", "웃긴 내용보다는 좀 더 진지한 영화", "추천 1"));
        adapter.addItem(new CommentItem("bbb**","30분전", "연기가 부족한 느낌이 드는 배우도 있다. 그래도 전체적으로는 재밌다.", "추천 0"));
        adapter.addItem(new CommentItem("ccc**","40분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", "추천 0"));
        adapter.addItem(new CommentItem("ddd**","50분전", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", "추천 0"));

        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter { //데이터 관리 & 아이템 뷰 생성
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() { //몇개의 아이템이 있는지
            return items.size();
        }

        public void addItem(CommentItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) { //필요한 데이터를 넘겨준다.
            return items.get(position);
        }

        @Override
        public long getItemId(int position) { //Id값이 넘겨준다.
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = new CommentItemView(getApplicationContext());//어떤 뷰던 context객체를 받는다.
            CommentItem item = items.get(position);
            view.setName(item.getName());
            view.setTime(item.getTime());
            view.setComment(item.getComment());
            view.setSelect(item.getSelect());

            return view;
        }
    }

    public void incrLikeCount(){
        likeCount += 1;
        liketextView.setText(String.valueOf(likeCount)); //likeCount라는 숫자를 바꿔서 설정해준다.
        likebutton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount(){
        likeCount -= 1;
        liketextView.setText(String.valueOf(likeCount)); //likeCount라는 숫자를 바꿔서 설정해준다.
        likebutton.setBackgroundResource(R.drawable.thumb_up_selector);
    }

    public void incrdisLikeCount(){
        dislikeCount += 1;
        dislikeView.setText(String.valueOf(dislikeCount));
        dislikebutton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrdisLikeCount() {
        dislikeCount -= 1;
        dislikeView.setText(String.valueOf(dislikeCount));
        dislikebutton.setBackgroundResource(R.drawable.thumb_down_selector);
    }
}
