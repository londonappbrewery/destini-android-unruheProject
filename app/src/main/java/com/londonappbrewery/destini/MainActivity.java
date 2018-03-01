package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        } else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        updateView();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    updateView();
                }
                else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                    updateView();
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                    updateView();
                }
                else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                    updateView();
                }
                else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                    updateView();
                }
            }
        });
    }

    private void updateView() {
        if (mStoryIndex == 1) {
            mStoryTextView.setText(getResources().getString(R.string.T1_Story));
            mButtonTop.setText(getResources().getString(R.string.T1_Ans1));
            mButtonBottom.setText(getResources().getString(R.string.T1_Ans2));
        }
        else if (mStoryIndex == 2) {
            mStoryTextView.setText(getResources().getString(R.string.T2_Story));
            mButtonTop.setText(getResources().getString(R.string.T2_Ans1));
            mButtonBottom.setText(getResources().getString(R.string.T2_Ans2));
        }
        else if (mStoryIndex == 3) {
            mStoryTextView.setText(getResources().getString(R.string.T3_Story));
            mButtonTop.setText(getResources().getString(R.string.T3_Ans1));
            mButtonBottom.setText(getResources().getString(R.string.T3_Ans2));
        }
        else if (mStoryIndex == 4) {
            mStoryTextView.setText(getResources().getString(R.string.T4_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
        else if (mStoryIndex == 5) {
            mStoryTextView.setText(getResources().getString(R.string.T5_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
        else if (mStoryIndex == 6) {
            mStoryTextView.setText(getResources().getString(R.string.T6_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndexKey", mStoryIndex);
    }
}
