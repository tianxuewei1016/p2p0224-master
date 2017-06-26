package com.atguigu.p2p0224.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.p2p0224.R;
import com.atguigu.p2p0224.base.BaseActivity;
import com.atguigu.p2p0224.bean.LoginBean;
import com.atguigu.p2p0224.common.AppManager;
import com.atguigu.p2p0224.common.AppNetConfig;
import com.atguigu.p2p0224.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.tv_login_number)
    TextView tvLoginNumber;
    @Bind(R.id.et_login_number)
    EditText etLoginNumber;
    @Bind(R.id.rl_login)
    RelativeLayout rlLogin;
    @Bind(R.id.tv_login_pwd)
    TextView tvLoginPwd;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.regitster_tv)
    TextView regitsterTv;

    @Override
    public void initTitle() {
        super.initTitle();
        baseTitle.setText("登录");
    }

    /**
     * 面试题:
     * sp里面可以存哪些类型的数据?
     * sp可以存的数据最大是多少?
     */
    @Override
    public void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入的账号和密码
                String number = etLoginNumber.getText().toString().trim();
                String pwd = etLoginPwd.getText().toString().trim();
                //校验
                if (TextUtils.isEmpty(number)) {
                    showToast("账号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
//                    if(pwd.length()>6) {
//                        if() { 有没有非法字符
//
//                        }
//                    }
                    showToast("密码不能为空");
                    return;
                }
                //登录
                Map<String, String> map = new HashMap<String, String>();
                map.put("phone", number);
                map.put("password", pwd);
                HttpUtils.getInstance().post(AppNetConfig.LOGIN, map, new HttpUtils.OnHttpClientListener() {
                    @Override
                    public void onSuccess(String json) {
                        Log.d("json", "onSuccess: "+json);
                        //手动解析
                        try {
                            JSONObject object = new JSONObject(json);
                            boolean isOK = object.getBoolean("succes");
                            if (isOK) {
                                //登录成功
                                LoginBean loginBean = com.alibaba.fastjson.JSONObject.parseObject(json, LoginBean.class);

                                //存储数据
                                saveUser(loginBean);
                                //跳转
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                //结束当前页面
                                finish();
                            } else {
                                //登录失败,账号或者密码不正确
                                showToast("账号或者密码不正确");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(String message) {
                        Log.e("TAG", "success: " + message);
                    }
                });
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
