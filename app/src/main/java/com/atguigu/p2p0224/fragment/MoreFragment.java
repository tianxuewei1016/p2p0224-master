package com.atguigu.p2p0224.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.atguigu.p2p0224.R;
import com.atguigu.p2p0224.activity.GestureEditActivity;
import com.atguigu.p2p0224.activity.MainActivity;
import com.atguigu.p2p0224.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/6/20.
 */

public class MoreFragment extends BaseFragment {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.tv_more_regist)
    TextView tvMoreRegist;
    @Bind(R.id.toggle_more)
    ToggleButton toggleMore;
    @Bind(R.id.tv_more_reset)
    TextView tvMoreReset;
    @Bind(R.id.tv_more_phone)
    TextView tvMorePhone;
    @Bind(R.id.rl_more_contact)
    RelativeLayout rlMoreContact;
    @Bind(R.id.tv_more_fankui)
    TextView tvMoreFankui;
    @Bind(R.id.tv_more_share)
    TextView tvMoreShare;
    @Bind(R.id.tv_more_about)
    TextView tvMoreAbout;
    private MainActivity activity;

    @Override
    public String getChildUrl() {
        return "";
    }

    @Override
    public void setContent(String json) {
        //设置toggle状态

    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initListener() {
        super.initListener();
        toggleMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleMore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        //判断当前的开关
                        if(isChecked) {
                            //开
                            if(activity.get("settings")) {
                                //设置过密码
                                activity.save("toggle", isChecked);
                            }else{
                                //设置密码
                                activity.save("settings", true);
                                //没有设置密码
                                startActivity(new Intent(getActivity(), GestureEditActivity.class));
                            }
                        }else{
                            //关
                            activity.save("toggle", isChecked);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void initData() {
        activity = (MainActivity) getActivity();
        toggleMore.setChecked(activity.get("toggle"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_more;
    }
}
