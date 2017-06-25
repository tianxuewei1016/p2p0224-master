package com.atguigu.p2p0224.fragment;

import com.atguigu.p2p0224.R;
import com.atguigu.p2p0224.base.BaseFragment;
import com.atguigu.p2p0224.view.randomLayout.StellarMap;

import butterknife.Bind;

/**
 * 作者：田学伟 on 2017/6/24 14:18
 * QQ：93226539
 * 作用：
 */

public class InvestReFragment extends BaseFragment {
    @Bind(R.id.invest_rec_sm)
    StellarMap investRecSm;

    @Override
    protected String getChildUrl() {
        return null;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
